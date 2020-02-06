package com.ymedialabs.statefarmopenid;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.model.GetParametersRequest;
import com.amazonaws.services.simplesystemsmanagement.model.GetParametersResult;


@Configuration
public class AWSSystemManager{
	
	@Inject
	private ConfigurableEnvironment environment;
	
	private static final String DB_USER = "db-username";
	private static final String DB_CREDENTIALS = "db-password";
	private static final String SERVER_PORT = "server-port";
	private static final String CORS_ALLOWED = "cors-allowed";
	
	private static final String ACTIVE_PROFILE = "spring.profiles.active";

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		
		if(!(environment.getProperty(ACTIVE_PROFILE).equals("test"))
				&& !(environment.getProperty(ACTIVE_PROFILE).equals("local"))){
			mapEnvironmentProperties();
		}
		
		return DataSourceBuilder
		        .create()
		        .build();
	}
	
	/**
	 * Instantiate AWS client using account credentials for local testing in development environment
	 * For any environment other than development, instantiate client without explicitly providing credentials to the builder, 
	 * by using the default credential provider  
	 */
	public AWSSimpleSystemsManagement awsClient() {
		
		AWSSimpleSystemsManagement awsClient = null;
		
		if(environment.getProperty(ACTIVE_PROFILE).equals("development")){
			BasicAWSCredentials awsCreds = new BasicAWSCredentials(environment.getProperty("accessKey"), environment.getProperty("secretKey"));
			awsClient =  AWSSimpleSystemsManagementClientBuilder.standard()
	                .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion(Regions.US_WEST_2)
	                .build();
		}else{
			awsClient = AWSSimpleSystemsManagementClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
		}
		
		return awsClient;
	}
	
	public void mapEnvironmentProperties(){
		
		AWSSimpleSystemsManagement awsClient = awsClient();
		
		Map<String, Object> props = new HashMap<>();
				
		GetParametersRequest paramRequest = new GetParametersRequest()
				.withNames(getParamKey(DB_USER), getParamKey(DB_CREDENTIALS),
						getParamKey(SERVER_PORT), getParamKey(CORS_ALLOWED))
                .withWithDecryption(true);
		
		GetParametersResult parameters = awsClient.getParameters(paramRequest);
        parameters.getParameters().forEach(parameter -> 
        	props.put(parameter.getName(),  parameter.getValue())
        );
        
	    MapPropertySource mapSource = new MapPropertySource("aws-ssm", props);
	    environment.getPropertySources().addFirst(mapSource);
	}
	
	private String getParamKey(String param){
		return String.format(environment.getProperty("aws.ssm.env.hierarchy"), param);
	}
}


