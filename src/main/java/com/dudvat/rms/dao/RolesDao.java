package com.dudvat.rms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dudvat.rms.db.RmsSessionFactory;
import com.dudvat.rms.db.Roles;
import com.dudvat.rms.utils.RmsDbException;

public class RolesDao {

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
	 * Methods finds and returns all roles record
	 * @return List of Roles
	 * @throws RmsDbException
	 */
	@SuppressWarnings("unchecked")
	public List<Roles> findAllRoles() throws RmsDbException{
		List<Roles> rolesList=null;
		Session session=null;
		try{
			session=RmsSessionFactory.getSessionFactory().openSession();
			Query findAllRolesQuery=session.getNamedQuery("roles.findAll");
			rolesList=findAllRolesQuery.list();
		}catch(HibernateException se){
			throw new RmsDbException(se);
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return rolesList;
	}
	
	/**
	 * Methods finds and returns Roles record by Id and Password Match
	 * @return List of Roles
	 * @throws RmsDbException
	 */
	@SuppressWarnings("unchecked")
	public List<Roles> findRoleByRname(Roles roles) throws RmsDbException{
		List<Roles> rolesList=null;
		Session session=null;
		try{
			session=RmsSessionFactory.getSessionFactory().openSession();
			Query findRoleByRnameQuery=session.getNamedQuery("Roles.findByRName");
			findRoleByRnameQuery.setParameter("rname", roles.getRname());
			rolesList=findRoleByRnameQuery.list();
		}catch(HibernateException se){
			throw new RmsDbException(se);
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return rolesList;
	}
	
}
