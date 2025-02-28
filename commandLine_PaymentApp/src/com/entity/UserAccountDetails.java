package com.entity;
import java.util.Date;
public class UserAccountDetails {
private int userAccountId;
private Date accountOpenDate;
private double currentWalletBalance;
private int linkedBankAccountCount;
private int walletPin;
private UserDetails user;

public UserAccountDetails(int userAccountId, Date accountOpenDate, double currentWalletBalance,
		int linkedBankAccountCount, int walletPin, UserDetails user)
{

	this.userAccountId = userAccountId;
	this.accountOpenDate = accountOpenDate;
	this.currentWalletBalance = currentWalletBalance;
	this.linkedBankAccountCount = linkedBankAccountCount;
	this.walletPin = walletPin;
	this.user = user;
}

public int getUserAccountId() {
	return userAccountId;
}
public void setUserAccountId(int userAccountId) {
	this.userAccountId = userAccountId;
}
public Date getAccountOpenDate() {
	return accountOpenDate;
}
public void setAccountOpenDate(Date accountOpenDate) {
	this.accountOpenDate = accountOpenDate;
}
public double getCurrentWalletBalance() {
	return currentWalletBalance;
}
public void setCurrentWalletBalance(double currentWalletBalance) {
	this.currentWalletBalance = currentWalletBalance;
}
public int getLinkedBankAccountCount() {
	return linkedBankAccountCount;
}
public void setLinkedBankAccountCount(int linkedBankAccountCount) {
	this.linkedBankAccountCount = linkedBankAccountCount;
}
public int getWalletPin() {
	return walletPin;
}
public void setWalletPin(int walletPin) {
	this.walletPin = walletPin;
}



}
