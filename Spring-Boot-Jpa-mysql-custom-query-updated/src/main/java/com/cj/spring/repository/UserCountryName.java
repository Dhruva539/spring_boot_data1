package com.cj.spring.repository;

import java.io.Serializable;

public class UserCountryName implements Serializable{
	private String country, name;
	public UserCountryName(String country, String name)
	{
		this.country = country;
		this.name = name;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getCountry() {return country;}
	public String getName() {return name; }
}
