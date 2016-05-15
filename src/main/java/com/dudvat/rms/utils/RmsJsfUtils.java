package com.dudvat.rms.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class RmsJsfUtils {

	public static void addInfoErrorMessage(String clientId,String message){
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
		FacesContext.getCurrentInstance().addMessage(clientId, msg);
	}
	
	public static void addErrorMessage(String clientId,String message){
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
		FacesContext.getCurrentInstance().addMessage(clientId, msg);
	}
	
	public static void addWarnMessage(String clientId,String message){
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_WARN, message, message);
		FacesContext.getCurrentInstance().addMessage(clientId, msg);
	}
	
	
}
