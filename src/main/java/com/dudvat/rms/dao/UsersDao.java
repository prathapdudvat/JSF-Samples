package com.dudvat.rms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dudvat.rms.db.RmsSessionFactory;
import com.dudvat.rms.db.Users;
import com.dudvat.rms.utils.RmsDbException;

public class UsersDao {

	/*
	 * 
	  Session session=null;
		try{
			session=RmsSessionFactory.getSessionFactory().openSession();
		}catch(HibernateException se){
			throw new RmsDbException(se);
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	 */
	
	/**
	 * Methods finds and returns all users record
	 * @return List of users
	 * @throws RmsDbException
	 */
	@SuppressWarnings("unchecked")
	public List<Users> findAllUsers() throws RmsDbException{
		List<Users> usersList=null;
		Session session=null;
		try{
			session=RmsSessionFactory.getSessionFactory().openSession();
			Query findAllUsersQuery=session.getNamedQuery("users.findAll");
			usersList=findAllUsersQuery.list();
		}catch(HibernateException se){
			throw new RmsDbException(se);
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return usersList;
	}
	
	/**
	 * Methods finds and returns users record by Id and Password Match
	 * @return List of users
	 * @throws RmsDbException
	 */
	@SuppressWarnings("unchecked")
	public List<Users> findUserByIdAndPwd(Users users) throws RmsDbException{
		List<Users> usersList=null;
		Session session=null;
		try{
			session=RmsSessionFactory.getSessionFactory().openSession();
			Query findUsersByIdPwdQuery=session.getNamedQuery("users.findByIdAndPwd");
			findUsersByIdPwdQuery.setParameter("uid", users.getUid());
			findUsersByIdPwdQuery.setParameter("pwd", users.getPwd());
			usersList=findUsersByIdPwdQuery.list();
		}catch(HibernateException se){
			throw new RmsDbException(se);
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return usersList;
	}
	
}
