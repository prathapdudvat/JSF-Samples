package com.dudvat.rms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dudvat.rms.db.RmsSessionFactory;
import com.dudvat.rms.db.UserRoles;
import com.dudvat.rms.db.Users;
import com.dudvat.rms.utils.RmsDbException;

public class UserRolesDao {
	
	/**
	 * Method finds and returns all users and roles
	 * @return
	 * @throws RmsDbException
	 */
	@SuppressWarnings("unchecked")
	public List<UserRoles> findAllUserRoles() throws RmsDbException{
		Session session=null;
		List<UserRoles> urList=null;
		try{
			session=RmsSessionFactory.getSessionFactory().openSession();
			Query urQuery=session.getNamedQuery("userroles.findAll");
			urList=urQuery.list();
		}catch(HibernateException se){
			throw new RmsDbException(se);
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return urList;
	}
	
	/**
	 * Method finds and returns  users and roles by user
	 * @return
	 * @throws RmsDbException
	 */
	@SuppressWarnings("unchecked")
	public List<UserRoles> findUserRolesByUid(Users user) throws RmsDbException{
		Session session=null;
		List<UserRoles> urList=null;
		try{
			session=RmsSessionFactory.getSessionFactory().openSession();
			Query urQuery=session.getNamedQuery("userroles.findByUid");
			urQuery.setParameter("uid", user.getUid());
			urList=urQuery.list();
		}catch(HibernateException se){
			throw new RmsDbException(se);
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return urList;
	}

}
