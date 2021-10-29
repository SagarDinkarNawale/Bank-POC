package com.xoriant.banking.poc.model;

public class Branch {

	private int branchId;
	
	private String branchName; 
	
	private String ifscCode; 
	
	private String micrCode;
	private String userName;
	  private String pass;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	  
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Branch(int branchId, String branchName, String ifscCode, String micrCode) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.ifscCode = ifscCode;
		this.micrCode = micrCode;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getMicrCode() {
		return micrCode;
	}

	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}

	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", ifscCode=" + ifscCode + ", micrCode="
				+ micrCode + "]";
	} 
	
	
}
