package com.studentrecord.studentprojection.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "studentview")
@Data
public class StudentView {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	@Column(name = "studentviewid")
	private long studentViewId;

	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "branch")
	private String branch;

	public StudentView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentView(long studentViewId, String name, int age, String email, String gender, String branch) {
		super();
		this.studentViewId = studentViewId;
		this.name = name;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.branch = branch;
	}
	
	
}
