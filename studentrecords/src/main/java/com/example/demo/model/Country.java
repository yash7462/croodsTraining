package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "countryid")
	private long countryid;

	@Column(name = "countryname")
	private String CountryName;

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(long countryid, String countryName) {
		super();
		this.countryid = countryid;
		CountryName = countryName;
	}

	public long getCountryid() {
		return countryid;
	}

	public void setCountryid(long countryid) {
		this.countryid = countryid;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	@Override
	public String toString() {
		return "Country [countryid=" + countryid + ", CountryName=" + CountryName + "]";
	}

}
