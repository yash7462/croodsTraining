package com.springbatchwithjpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="user")
public class User {
	@Id
	private long id;
	private String firstName;
	private String lastName;
	

}
