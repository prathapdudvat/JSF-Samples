package com.dudvat.rms.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dudvat.rms.db.TransEntry;
import com.dudvat.rms.facade.TransEntryFacade;
import com.dudvat.rms.utils.RmsException;


@Path(value="/purchase")
public class TransEntryService {

	
	
	
	@POST
	@Path(value="/save")
	@Consumes(value=MediaType.APPLICATION_JSON)
	public Response savePurchase(TransEntryRequest teRequest){
		System.out.println(teRequest);
		return Response.status(Response.Status.OK).entity("Saved Successfully").build();
	}
	
	@POST
	@Path(value="/search")
	@Consumes(value=MediaType.APPLICATION_JSON)
	@Produces(value=MediaType.APPLICATION_JSON)
	public Response searchPurchase(TransEntryRequest teRequest){
		System.out.println(teRequest);
		try{
			TransEntryFacade tsFacade=new TransEntryFacade(teRequest);
			List<TransEntry> teList=tsFacade.searchPurchase();
			return Response.status(Response.Status.OK).entity(teList.toString()).build();
		}catch(RmsException re){
			re.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Technical Exception: Internal Server Error Occured").build();
		}
	}
	
}
