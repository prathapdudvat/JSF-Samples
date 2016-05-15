package com.dudvat.rms.rest;

import java.util.Date;

public class TransEntryRequest {

	private Date transDate;
	private String item;
	private Double amount;
	private String createdBy;
	
	public TransEntryRequest(){
		
	}
	
	public TransEntryRequest(Date transDate, String item, Double amount,String createdBy) {
		super();
		this.transDate = transDate;
		this.item = item;
		this.amount = amount;
		this.createdBy=createdBy;
	}
	
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "TransEntryRequest [transDate=" + transDate + ", item=" + item + ", amount=" + amount + ", createdBy="
				+ createdBy + "]";
	}
	
	
}
