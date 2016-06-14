package com.taxpayer.model;


public class Taxpayer {
	String userName;
	String address;
	String pan;
	String dob;
	String aYear;
	Double income;
	Double tds;
	Double taxDeducted;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getaYear() {
		return aYear;
	}

	public void setaYear(String aYear) {
		this.aYear = aYear;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Double getTds() {
		return tds;
	}

	public void setTds(Double tds) {
		this.tds = tds;
	}

	public Double getTaxDeducted() {
		return taxDeducted;
	}

	public void setTaxDeducted(Double taxDeducted) {
		this.taxDeducted = taxDeducted;
	}

}
