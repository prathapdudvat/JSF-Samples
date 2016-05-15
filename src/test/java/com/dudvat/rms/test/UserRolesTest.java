package com.dudvat.rms.test;

import java.util.List;

import com.dudvat.rms.dao.UserRolesDao;
import com.dudvat.rms.db.UserRoles;
import com.dudvat.rms.db.Users;
import com.dudvat.rms.utils.RmsDbException;

public class UserRolesTest {

	public static void main(String[] args) throws RmsDbException {
			UserRolesDao dao=new UserRolesDao();
			Users user=new Users();
			user.setUid("prathapd");
			List<UserRoles> urlist=dao.findUserRolesByUid(user);
			
			//List<UserRoles> urlist=dao.findAllUserRoles();
			for(UserRoles ur:urlist){
				System.out.println("UserRoles:"+ur);
			}
			
	}

}
