package com.roomfinder.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tenant {
	private String name;
	private String number;
	private String email;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Tenant [name=" + name + ", number=" + number + ", email=" + email + ", password=" + password + "]";
	}

}
