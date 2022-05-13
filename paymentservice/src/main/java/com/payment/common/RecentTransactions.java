package com.payment.common;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RecentTransactions {
	private int id;
	private double amountPaid;
	private String transactionId;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone="IST")
	private Date transactionDate;
	private String paymentPurpose;
	private String guestId;
	private int buildingId ;

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getAmountPaid() {
		return amountPaid;
	}


	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}


	public String getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	

	public Date getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}


	public String getPaymentPurpose() {
		return paymentPurpose;
	}


	public void setPaymentPurpose(String paymentPurpose) {
		this.paymentPurpose = paymentPurpose;
	}


	public String getGuestId() {
		return guestId;
	}


	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}


	public int getBuildingId() {
		return buildingId;
	}


	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}


	public RecentTransactions(int id, double amountPaid, String transactionId, Date transactionDate,
			String paymentPurpose, String guestId, int buildingId) {
		super();
		this.id = id;
		this.amountPaid = amountPaid;
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.paymentPurpose = paymentPurpose;
		this.guestId = guestId;
		this.buildingId = buildingId;
	}


	public RecentTransactions() {
// TODO Auto-generated constructor stub
	}
}
