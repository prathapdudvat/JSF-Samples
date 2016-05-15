package com.dudvat.rms.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="users")
@NamedQueries(value={@NamedQuery(name="users.findAll",query="select u from Users u"),
					 @NamedQuery(name="users.findByIdAndPwd",query="select u from Users u where u.uid=:uid and u.pwd=:pwd")
					})
public class Users implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String uid;
	private String pwd;
	
	public Users() {
		
	}
	
	public Users(String uid, String pwd) {
		this.uid=uid;
		this.pwd=pwd;
	}
	@Id
	@Column(name="uid",nullable=false,length=20,unique=true)
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	@Column(name="pwd",nullable=false,length=16)
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", pwd=" + pwd + "]";
	}
	
	
}
