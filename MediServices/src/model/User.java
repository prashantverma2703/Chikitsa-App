package model;

public class User {

	private String name;
	private String dob;
	private String gender;
	private String address;
	private String contact;
	private String aadhar;

	public User() {
		super();
	}

	public User(String name, String dob, String gender, String address, String contact, String aadhar) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.contact = contact;
		this.aadhar = aadhar;
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

}
