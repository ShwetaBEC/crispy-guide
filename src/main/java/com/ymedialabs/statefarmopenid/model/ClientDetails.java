package com.ymedialabs.statefarmopenid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "clientdetails")
@Data
public class ClientDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "resourceid")
    private String resourceid;

    @Column(name = "resourcename")
    private String resourcename;

}
