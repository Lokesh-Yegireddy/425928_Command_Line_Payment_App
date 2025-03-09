package com.entity;

public class BankAccountDetails {
private static int bankAccountId=2001;
private long accountNumber;
private String ifscCode;
private String accountStatus;
private String bankName;
private String bankBranchLocation;
private UserDetails user;




public BankAccountDetails() {
	super();
	// TODO Auto-generated constructor stub
}


public BankAccountDetails( long accountNumber, String ifscCode, String accountStatus, String bankName,
		String bankBranchLocation, UserDetails user) {
	
	bankAccountId++;
	this.accountNumber = accountNumber;
	this.ifscCode = ifscCode;
	this.accountStatus = accountStatus;
	this.bankName = bankName;
	this.bankBranchLocation = bankBranchLocation;
	this.user = user;
}
public int getBankAccountId() {
	return bankAccountId;
}
public void setBankAccountId(int bankAccountId) {
	this.bankAccountId = bankAccountId;
}
public long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(long accountNumber) {
	this.accountNumber = accountNumber;
}
public String getIfscCode() {
	return ifscCode;
}
public void setIfscCode(String ifscCode) {
	this.ifscCode = ifscCode;
}
public String getAccountStatus() {
	return accountStatus;
}
public void setAccountStatus(String accountStatus) {
	this.accountStatus = accountStatus;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public UserDetails getUser() {
	return user;
}


public void setUser(UserDetails user) {
	this.user = user;
}


public String getBankBranchLocation() {
	return bankBranchLocation;
}
public void setBankBranchLocation(String bankBranchLocation) {
	this.bankBranchLocation = bankBranchLocation;
}


@Override
public String toString() {
	return "BankAccountDetails [bankAccountId="+bankAccountId +" accountNumber=" + accountNumber + ", ifscCode=" + ifscCode + ", accountStatus="
			+ accountStatus + ", bankName=" + bankName + ", bankBranchLocation=" + bankBranchLocation + "]";
}


}
