package com.dudvat.rms.test;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;

import com.dudvat.rms.dao.TransEntryDao;
import com.dudvat.rms.db.RmsSessionFactory;
import com.dudvat.rms.db.TransEntry;
import com.dudvat.rms.db.Users;
import com.dudvat.rms.utils.RmsDbException;
import com.dudvat.rms.utils.RmsUtils;

public class TransEntryTest {

	public static void main(String[] args) throws RmsDbException {
		//save();
		//findAll();
		search();
	}

	private static void search() throws RmsDbException {
		TransEntryDao teDao=new TransEntryDao();
		TransEntry te=new TransEntry();
		//te.setItem("Soaps");
		te.setTransDate(RmsUtils.getToday());
		List<TransEntry> telist=teDao.findTsBySearch(te);
		for(TransEntry te1:telist){
			System.out.println("te:"+te1);
		}}

	public static void save(){
		TransEntry te=new TransEntry();
		te.setTransDate(RmsUtils.getToday());
		te.setAmount(50d);
		te.setItem("Soaps");
		Users cusr=new Users();
		cusr.setUid("prathapd");
		te.setCreatedBy(cusr);
		te.setCreatedDate(RmsUtils.getToday());
		
		Session session=RmsSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		BigInteger id=(BigInteger) session.save(te);
		session.getTransaction().commit();
		System.out.println("id:"+id);
	}
	
	public static void findAll() throws RmsDbException{
		TransEntryDao teDao=new TransEntryDao();
		List<TransEntry> telist=teDao.findAllTransEntry();
		for(TransEntry te:telist){
			System.out.println("te:"+te);
		}
	}
	
	
}
