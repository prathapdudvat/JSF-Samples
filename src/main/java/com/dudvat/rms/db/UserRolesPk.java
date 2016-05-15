package com.dudvat.rms.db;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserRolesPk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String uid;
	
	private String rname;
	
	public UserRolesPk() {
		super();
	}

	public UserRolesPk(String uid, String rname) {
		super();
		this.uid = uid;
		this.rname = rname;
	}

	

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	@Override
	public String toString() {
		return "UserRolesPk [uid=" + uid + ", rname=" + rname + "]";
	}
	
	

}
