# Statefarm-OpenId-Backend
An authentication and user management service for authenticating several statefarm application users.

## Getting Started

### Prerequisites
* Git
* JDK 8 or later
* Maven 3.0 or later
* Postgres
* H2 DB
* Spring Boot DevTools 1.5.8
* Springfox Swagger UI 2.6.1
* Swagger Annotations 1.5.6
* lombok 1.16.18

## Application Build & Deployment
This application is packaged as a self-contained jar and it can be run using the ```java -jar``` command.

Before you begin, be sure to have the following installed on your build machine:

  * Java JDK 1.8 
    * Run the `java -version` command to determine if the correct Java JDK is installed
  * Maven 3 
    * Run the `mvn -version` command to determine if the correct version of Maven 3 is installed
    
    
* Clone this repository 
* You can build the project by running ```mvn package -Dmaven.test.skip=true```

* Once successfully built, you can run the service by one of these two methods:
```
        java -jar -Dspring.profiles.active=<Profile> <jar>
```

By default, the application is configured to run on port 8080. To change the port, add the ```server.port``` parameter.
E.g.: ```java -jar -Dspring.profiles.active=<Profile>  -Dserver.port=<PORT> <jar> ``` 
   
## About the Service

Here is what this application demonstrates: 

* Development and Deployment should be simple. 
This implies the application can be run with `java appname.jar` should be enough to run all services at the same time deployable to a standalone or embedded container.   
* Feature code should be separated from core code and considered for sharable code packaging.
* Simple and easy to use Maven 3 or Gradle 3.x configurations complete with environment specific profiles for Development and Testing.
* Database Support via H2 for local development/testing and MySQL for a development environment.
* Dependency Injection with Spring
* *Spring Data* Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations. 
* Automatic CRUD functionality against the data source using Spring *Repository* pattern
* Testable JPA Unit/Integration Tests using an in-Memory and/or Database implementation with post-execution database cleanup
* Demonstrates MockMVC test framework with associated libraries
* All APIs are "self-documented" by Swagger2 using annotations 


### Swagger 2 API docs

Run the server and browse to ```localhost:PORT/swagger-ui.html```  
[More about Springfox Swagger](https://github.com/springfox/springfox)

### H2 in-memory datbase
H2 as a memory database for Spring-based applications is lightweight, easy to use, and emulates other RDBMS with the help of JPA and Hibernate.  
The 'test' profile runs on H2 in-memory database. To view and query the database you can browse to ```http://localhost:PORT/h2```. Make sure this is disabled in your production profiles.

## Environments

This project uses an in-memory database so that you don't have to install a database in order to run it. However, converting it to run with another relational database such as MySQL or PostgreSQL is very easy. Since the project uses Spring Data and the Repository pattern, it's even fairly easy to back the same service with any other database. 

Here is what you would do to back the services with MySQL, for example: 

### Profiles
* The application can be run in the development profile as follows

```
        java -jar -Dspring.profiles.active=development <target JAR>
or
        mvn spring-boot:run -Drun.arguments="--spring.profiles.active=development" 
```

* Similarly for a test profile...
```
        java -jar -Dspring.profiles.active=development <target JAR>
or
        mvn spring-boot:run --spring.profiles.active=test"
```

### Testing in an IDE
If you'd wish to run a test case in an IDE, use the VM options:

   
