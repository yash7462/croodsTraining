package com.studentrecord.studentprojection.model;

import lombok.Data;

@Data
public class StudentViewDTO {

	private String name;
	private int age;
	private String branch;
	

	public StudentViewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudentViewDTO(String name, int age, String branch) {
		super();
		this.name = name;
		this.age = age;
		this.branch = branch;
	}

	

}
