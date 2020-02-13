package com.ymedialabs.ci.cd.sample.model;

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
@Table(name = "usersessions")
@Data
public class UserSession {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "client_id")
    private Integer clientid;

    @ManyToOne
	@JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "token")
    private String token;
    
    @CreationTimestamp
    @Temporal(TIMESTAMP)
    @Column(name="created_at", updatable = false)
    private Date createdAt;
	
    @UpdateTimestamp
	@Temporal(TIMESTAMP)
    @Column(name="updated_at")
    private Date updatedAt;
    
    @Column(name="is_deleted ")
    private boolean isDeleted;
}
