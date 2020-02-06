package com.ymedialabs.statefarmopenid.model;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "userclientdetails")
@Data
public class UserClientDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "client_id")
    private Integer clientid;

    @ManyToOne
	@JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "is_deactivated")
    private boolean isDeactivated;
    
    @CreationTimestamp
    @Temporal(TIMESTAMP)
    @Column(name="created_on", updatable = false)
    private Date createdOn;
	
    @UpdateTimestamp
	@Temporal(TIMESTAMP)
    @Column(name="deactivated_on", updatable = false)
    private Date deactivatedOn;
}
