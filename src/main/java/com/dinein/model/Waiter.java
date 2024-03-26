package com.dinein.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Waiter")
public class Waiter {
	
	@Id
	String id;
	String employeeId;
	String employeeName;
	String address;
	String phone;
	String emailId;
	String gender;
	double salary;
	String password;
	
	
	public Waiter() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Waiter(String id, String employeeId, String employeeName, String address, String phone, String emailId,
			String gender, double salary, String password) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.address = address;
		this.phone = phone;
		this.emailId = emailId;
		this.gender = gender;
		this.salary = salary;
		this.password = password;
	}


	@Override
	public String toString() {
		return "Waiter [id=" + id + ", employeeId=" + employeeId + ", employeeName=" + employeeName + ", address="
				+ address + ", phone=" + phone + ", emailId=" + emailId + ", gender=" + gender + ", salary=" + salary
				+ ", password=" + password + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


}
