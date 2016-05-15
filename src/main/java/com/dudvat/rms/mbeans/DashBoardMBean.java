package com.dudvat.rms.mbeans;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.chart.bar.BarChart;
/*import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;*/
import org.primefaces.model.chart.ChartSeries;

import com.dudvat.rms.db.TransEntry;
import com.dudvat.rms.facade.TransEntryFacade;
import com.dudvat.rms.rest.TransEntryRequest;
import com.dudvat.rms.utils.RmsException;
import com.dudvat.rms.utils.RmsJsfUtils;
import com.dudvat.rms.utils.RmsUtils;


@ManagedBean(name="dashBoardMBean")
@ViewScoped
public class DashBoardMBean  implements Serializable {

	private static final long serialVersionUID = -7787856147485251484L;
	
	private List<TransEntry> transEntryList=new ArrayList<TransEntry>();
	
	private BarChart barModel;
	
	@PostConstruct
	public void postConstruct(){
		System.out.println("post construct invoked");
		loadCurrentMonthData();
		createBarModel();
	}

	 private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Montly Report Bar Chart");
        barModel.setLegendPosition("ne");
         /*
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Users");*/
         
        barModel.setXaxisLabel("Users");
        
        barModel.setYaxisLabel("Amount");
        
       /* Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Amount");
        yAxis.setMin(0);
        yAxis.setMax(4000);*/
    }
	private BarChart initBarModel() {
		BarChart model = new BarChart();
        Map<String,List<TransEntry>> usersTeMap=new LinkedHashMap<String,List<TransEntry>>();
        
        for(TransEntry te:getTransEntryList()){
        	List<TransEntry> telist=usersTeMap.get(te.getCreatedBy().getUid());
        	if(telist!=null){
        		telist.add(te);
        	}else{
        		telist=new ArrayList<TransEntry>();
        		telist.add(te);
        	}
        	usersTeMap.put(te.getCreatedBy().getUid(), telist);
        }
        
        ChartSeries reportChartSeries = new ChartSeries();
        reportChartSeries.setLabel("Monthly Report");
        for(Entry<String, List<TransEntry>> teEntOnj:usersTeMap.entrySet()){
        	Double total=0.0;
        	for(TransEntry dte:teEntOnj.getValue()){
        		total+=dte.getAmount();
        	}
        	reportChartSeries.set(teEntOnj.getKey(), total);
        }
 
        model.setValue(reportChartSeries);
        return model;
       }

	private void loadCurrentMonthData() {
		try{
			TransEntryRequest teRequest=new TransEntryRequest();
			teRequest.setTransDate(RmsUtils.getStartDateOfCurrMonth());
			TransEntryFacade tsFacade=new TransEntryFacade(teRequest);
			transEntryList=tsFacade.searchPurchase();
			System.out.println("transEntryList: "+transEntryList.size());
		}catch(RmsException re){
			RmsJsfUtils.addErrorMessage(null, "Technical error occurred,please report to administration.");
			re.printStackTrace();
		}
		
	}

	public List<TransEntry> getTransEntryList() {
		loadCurrentMonthData();
		return transEntryList;
	}

	public void setTransEntryList(List<TransEntry> transEntryList) {
		this.transEntryList = transEntryList;
	}

	public BarChart getBarModel() {
		return barModel;
	}

	public void setBarModel(BarChart barModel) {
		this.barModel = barModel;
	}

}
