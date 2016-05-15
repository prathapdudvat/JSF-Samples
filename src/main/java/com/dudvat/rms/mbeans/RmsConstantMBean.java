package com.dudvat.rms.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="rmsConstantMBean",eager=true)
@ApplicationScoped
public class RmsConstantMBean {

	private String appDateFormat="dd-MMM-yyyy";
	
	public String getAppDateFormat(){
		return appDateFormat;
	}
}
