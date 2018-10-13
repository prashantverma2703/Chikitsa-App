package com.test.restdata;

public class User {

	private String aadhar;
	private String password;
	private String name;
	private String dob;
	private String gender;
	private String address;
	private String contact;
	private String usertype;

	
	public User() {
		super();
	}

	public User(String aadhar, String password, String name, String dob, String gender, String address, String contact,
			String usertype) {
		super();
		this.aadhar = aadhar;
		this.password = password;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.contact = contact;
		this.usertype = usertype;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}	

}
