package com.first.hibernate.crud;

public class hibernateEntity {
	private long empId;
	private String empName;
	private String email;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "hibernateEntity [empId=" + empId + ", empName=" + empName + ", email=" + email + "]";
	}

}

