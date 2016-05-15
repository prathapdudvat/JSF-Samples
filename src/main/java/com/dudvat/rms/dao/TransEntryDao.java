package com.dudvat.rms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dudvat.rms.db.RmsSessionFactory;
import com.dudvat.rms.db.TransEntry;
import com.dudvat.rms.utils.RmsDbException;
import com.dudvat.rms.utils.RmsUtils;

public class TransEntryDao {
	/**
	 * Method finds and returns all transEntries
	 * @return
	 * @throws RmsDbException
	 */
	@SuppressWarnings("unchecked")
	public List<TransEntry> findAllTransEntry() throws RmsDbException{
		Session session=null;
		List<TransEntry> tsList=null;
		try{
			session=RmsSessionFactory.getSessionFactory().openSession();
			Query tsFindAllQuery=session.getNamedQuery("ts.findAll");
			tsList=tsFindAllQuery.list();
		}catch(HibernateException se){
			throw new RmsDbException(se);
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return tsList;
	}
	
	/**
	 * Method finds and returns transEntry By Id
	 * @param transEntry
	 * @return
	 * @throws RmsDbException
	 */
	@SuppressWarnings("unchecked")
	public List<TransEntry> findTransEntryById(TransEntry transEntry) throws RmsDbException{
		Session session=null;
		List<TransEntry> tsList=null;
		try{
			session=RmsSessionFactory.getSessionFactory().openSession();
			Query tsFindByIdQuery=session.getNamedQuery("ts.findByTsId");
			tsFindByIdQuery.setParameter("transId", transEntry.getTransId());
			tsList=tsFindByIdQuery.list();
		}catch(HibernateException se){
			throw new RmsDbException(se);
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return tsList;
	}
	
	/**
	 * Methods finds trans entries by search criteria
	 * @param transEntry
	 * @return
	 * @throws RmsDbException
	 */
	@SuppressWarnings("unchecked")
	public List<TransEntry> findTsBySearch(TransEntry te) throws RmsDbException{
		Session session=null;
		List<TransEntry> tsList=null;
		try{
			session=RmsSessionFactory.getSessionFactory().openSession();
			if(te!=null){
				StringBuffer querySb=new StringBuffer();
				querySb.append("select ts from TransEntry ts where 1=1 ");
				if(te.getTransId()!=null){
					querySb.append(" and ts.transId=:transId");
				}
				if(te.getTransDate()!=null){
					querySb.append(" and ts.transDate between :transDate and :today");
				}
				if(te.getAmount()!=null&&te.getAmount()>0){
					querySb.append(" and ts.amount=:amount");
				}
				if(te.getItem()!=null &&!te.getItem().trim().isEmpty()){
					querySb.append(" and ts.item like :item");
				}
				if(te.getCreatedBy()!=null && te.getCreatedBy().getUid()!=null &&!te.getCreatedBy().getUid().isEmpty()){
					querySb.append(" and ts.createdBy.uid=:createdBy");
				}
				if(te.getModifiedBy()!=null && te.getModifiedBy().getUid()!=null &&!te.getModifiedBy().getUid().isEmpty()){
					querySb.append(" and ts.modifiedBy.uid=:modifiedBy");
				}
				System.out.println("Trans Search Query: "+querySb.toString());
				
				
				Query tsSearchQuery=session.createQuery(querySb.toString());
				if(te.getTransId()!=null){
					tsSearchQuery.setParameter("transId", te.getTransId());
				}
				if(te.getTransDate()!=null){
					tsSearchQuery.setParameter("transDate",te.getTransDate());
					tsSearchQuery.setParameter("today", RmsUtils.getToday());
				}
				if(te.getAmount()!=null){
					tsSearchQuery.setParameter("amount", te.getAmount());
				}
				if(te.getItem()!=null &&!te.getItem().trim().isEmpty()){
					tsSearchQuery.setParameter("item", te.getItem());
				}
				if(te.getCreatedBy()!=null && te.getCreatedBy().getUid()!=null &&!te.getCreatedBy().getUid().isEmpty()){
					tsSearchQuery.setParameter("createdBy", te.getCreatedBy().getUid());
				}
				if(te.getModifiedBy()!=null && te.getModifiedBy().getUid()!=null &&!te.getModifiedBy().getUid().isEmpty()){
					tsSearchQuery.setParameter("modifiedBy", te.getModifiedBy().getUid());
				}
				tsList=tsSearchQuery.list();
			}
		}catch(HibernateException se){
			throw new RmsDbException(se);
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return tsList;
	}
	
}
