package com.entity;

import java.util.Date;

public class TransactionDetails {
private int txnId;
private Date txnDateTime;
private int sourceId;
private int targetId;
private int sourceTypeId;
private int destinationTypeId;
private double txnAmount;


public TransactionDetails() {
	super();
	// TODO Auto-generated constructor stub
}


public TransactionDetails(int txnId, Date txnDateTime, int sourceId, int targetId, int sourceTypeId,
		int destinationTypeId, double txnAmount) {
	super();
	this.txnId = txnId;
	this.txnDateTime = txnDateTime;
	this.sourceId = sourceId;
	this.targetId = targetId;
	this.sourceTypeId = sourceTypeId;
	this.destinationTypeId = destinationTypeId;
	this.txnAmount = txnAmount;
}


public int getTxnId() {
	return txnId;
}
public void setTxnId(int txnId) {
	this.txnId = txnId;
}
public Date getTxnDateTime() {
	return txnDateTime;
}
public void setTxnDateTime(Date txnDateTime) {
	this.txnDateTime = txnDateTime;
}
public int getSourceId() {
	return sourceId;
}
public void setSourceId(int sourceId) {
	this.sourceId = sourceId;
}
public int getTargetId() {
	return targetId;
}
public void setTargetId(int targetId) {
	this.targetId = targetId;
}
public int getSourceTypeId() {
	return sourceTypeId;
}
public void setSourceTypeId(int sourceTypeId) {
	this.sourceTypeId = sourceTypeId;
}
public int getDestinationTypeId() {
	return destinationTypeId;
}
public void setDestinationTypeId(int destinationTypeId) {
	this.destinationTypeId = destinationTypeId;
}
public double getTxnAmount() {
	return txnAmount;
}
public void setTxnAmount(double txnAmount) {
	this.txnAmount = txnAmount;
}




}
