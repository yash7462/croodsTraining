package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "studentprofile")
@Getter
@Setter
public class StudentRecords {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	@Column(name = "id")
	private long id;

	@Column(name = "firstname")
	private String FirstName;

	@Column(name = "lastname")
	private String LastName;

	@Column(name = "mobileno")
	private long MobileNo;

	@Column(name = "email")
	private String email;

	@Column(name = "dateofbirth")
	@Temporal(TemporalType.DATE)
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date DateOfBirth;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "countryid", referencedColumnName = "countryid")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Country country;

	public StudentRecords() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentRecords(long id, String firstName, String lastName, long mobileNo, String email, Date dateOfBirth,
			Country country) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		MobileNo = mobileNo;
		this.email = email;
		DateOfBirth = dateOfBirth;
		this.country = country;
	}

	@Override
	public String toString() {
		return "StudentRecords [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", MobileNo="
				+ MobileNo + ", email=" + email + ", DateOfBirth=" + DateOfBirth + ", country=" + country + "]";
	}

}
