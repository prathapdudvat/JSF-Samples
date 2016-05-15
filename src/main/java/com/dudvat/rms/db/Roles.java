package com.dudvat.rms.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="roles")
@NamedQueries(value={@NamedQuery(name="roles.findAll",query="select r from Roles r"),
					 @NamedQuery(name="roles.findByRName",query="select r from Roles r where r.rname=:rname")
					})
public class Roles implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String rname;
	private String rdesc;
	
	@Id
	@Column(name="rname",nullable=false,length=15,unique=true)
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
	@Column(name="rdesc",nullable=false,length=150)
	public String getRdesc() {
		return rdesc;
	}
	public void setRdesc(String rdesc) {
		this.rdesc = rdesc;
	}
	
	
	@Override
	public String toString() {
		return "Roles [rname=" + rname + ", rdesc=" + rdesc + "]";
	}
	
	
	
	
}
