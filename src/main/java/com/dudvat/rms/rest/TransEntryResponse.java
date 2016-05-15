package com.dudvat.rms.rest;

import java.math.BigInteger;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.dudvat.rms.db.Users;

public class TransEntryResponse {
	
	private BigInteger transId;
	private Date transDate;
	private Double amount;
	private String item;
	private Users createdBy;
	private Users modifiedBy;
	private Date createdDate;
	private Date modifiedDate;
	public BigInteger getTransId() {
		return transId;
	}
	public void setTransId(BigInteger transId) {
		this.transId = transId;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Users getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}
	public Users getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Users modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	@Override
	public String toString() {
		try {
            // takes advantage of toString() implementation to format {"a":"b"}
			JSONObject responseObj=new JSONObject();
			responseObj.put("transId",transId );
			responseObj.put("transDate",transDate );
			responseObj.put("amount", amount);
			responseObj.put("item", item);
			responseObj.put("createdBy",createdBy );
			responseObj.put("modifiedBy", modifiedBy);
			responseObj.put("createdDate", createdDate);
			responseObj.put("modifiedDate", modifiedDate);
			return responseObj.toString();
        } catch (JSONException e) {
            return null;
        }
	}

}
