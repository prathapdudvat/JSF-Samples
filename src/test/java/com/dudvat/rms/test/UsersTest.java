package com.dudvat.rms.test;

import java.util.List;

import com.dudvat.rms.dao.UsersDao;
import com.dudvat.rms.db.Users;
import com.dudvat.rms.utils.RmsDbException;

public class UsersTest {

	public static void main(String[] args) throws RmsDbException {
			UsersDao dao=new UsersDao();
			List<Users> usersList=dao.findAllUsers();
			for(Users user:usersList){
				System.out.println("users:"+user);
			}
			
	}

}
