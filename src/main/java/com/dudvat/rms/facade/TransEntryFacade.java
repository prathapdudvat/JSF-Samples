package com.dudvat.rms.facade;

import java.util.List;

import com.dudvat.rms.dao.TransEntryDao;
import com.dudvat.rms.db.TransEntry;
import com.dudvat.rms.db.Users;
import com.dudvat.rms.rest.TransEntryRequest;
import com.dudvat.rms.utils.RmsDbException;
import com.dudvat.rms.utils.RmsException;

public class TransEntryFacade {

	TransEntryRequest teRequest=null;
	TransEntryDao transEntryDao=null;
	
	public TransEntryFacade(TransEntryRequest teRequest) {
		this.teRequest=teRequest;
		transEntryDao=new TransEntryDao();
	}

	public List<TransEntry> searchPurchase() throws RmsException {
		try{
			TransEntry te=new TransEntry();
			te.setTransDate(teRequest.getTransDate());
			te.setItem(teRequest.getItem());
			te.setAmount(teRequest.getAmount());
			te.setCreatedBy(new Users(teRequest.getCreatedBy(),null));
			return transEntryDao.findTsBySearch(te);
		}catch(RmsDbException rde){
			throw new RmsException(rde);
		}
	}

}
