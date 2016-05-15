package com.dudvat.rms.db;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="user_roles")
@NamedQueries(value={
		@NamedQuery(name="userroles.findAll",query="select ur from UserRoles ur"),
		@NamedQuery(name="userroles.findByUid",query="select ur from UserRoles ur where ur.userRolesPk.uid=:uid")
})
public class UserRoles implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserRolesPk userRolesPk;

	public UserRolesPk getUserRolesPk() {
		return userRolesPk;
	}

	public void setUserRolesPk(UserRolesPk userRolesPk) {
		this.userRolesPk = userRolesPk;
	}

	@Override
	public String toString() {
		return "UserRoles [userRolesPk=" + userRolesPk + "]";
	}
	
	
	

}
