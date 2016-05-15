package com.dudvat.rms.db;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Entity
@Table(name="trans_entry")
@NamedQueries(value={
		@NamedQuery(name="ts.findAll",query="select ts from TransEntry ts"),
		@NamedQuery(name="ts.findByTsId",query="select ts from TransEntry ts where ts.transId=:transId")
})
public class TransEntry implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BigInteger transId;
	private Date transDate;
	private Double amount;
	private String item;
	private Users createdBy;
	private Users modifiedBy;
	private Date createdDate;
	private Date modifiedDate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trans_id",nullable=false,unique=true)
	public BigInteger getTransId() {
		return transId;
	}
	public void setTransId(BigInteger transId) {
		this.transId = transId;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="trans_date",nullable=false)
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	
	@Column(name="amount",nullable=false)
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Column(name="item",nullable=false)
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	@ManyToOne
	@JoinColumn(name="created_by")
	public Users getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}
	
	@ManyToOne
	@JoinColumn(name="modified_by")
	public Users getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Users modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_date")
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
			responseObj.put("createdBy",(createdBy!=null?createdBy.getUid():null));
			responseObj.put("modifiedBy", (modifiedBy!=null?modifiedBy.getUid():null));
			responseObj.put("createdDate", createdDate);
			responseObj.put("modifiedDate", modifiedDate);
			return responseObj.toString();
        } catch (JSONException e) {
            return null;
        }
	}
	
	
	
	
	
}
