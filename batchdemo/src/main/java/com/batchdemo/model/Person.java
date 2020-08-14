package com.batchdemo.model;

import lombok.Data;

@Data
public class Person {

	private String firstName;
	private String lastName;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
