package com.ccengine.bean;

import java.time.LocalDate;

public class CCNumberBean {

	private String ccNumber;
	private LocalDate expiryDate;
	public CCNumberBean(String ccNumber, LocalDate expiryDate) {
		this.ccNumber=ccNumber;
		this.expiryDate=expiryDate;
	}
	public String getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
}
