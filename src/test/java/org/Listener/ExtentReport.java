package org.Listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReport {
	public static ExtentReports extent;
	public static ExtentSparkReporter report;
	public static  ExtentTest test;
	
	
	
	
	
	
	

	//public static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
	public static ExtentReports getInstance() {
		if (extent==null) {
			synchronized (ExtentReport.class) {
			setExtent();
			
			
		}	
		}
	return extent;	
	}
	 public static  ExtentReports setExtent() {
		     extent=new ExtentReports();
			report=new ExtentSparkReporter("./CRMAdmission.html");
			extent.attachReporter(report);
			report.config().setReportName("CRM AND ADMISSION MODULE");
			report.config().setTheme(Theme.STANDARD);
			report.config().setDocumentTitle("Automation Report ");
			report.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			report.config().setTimelineEnabled(true);
           
			  extent.setSystemInfo("HostName", "https://uatsea.creatrixcampus.net/auth/login");
			  extent.setSystemInfo("ProjectName", "CRM And Admission  MODULE");
			  extent.setSystemInfo("Tester", "satheesh");
			  extent.setSystemInfo("Browser", "Chrome");
			  extent.setSystemInfo("OS", "Windows11");
			  extent.setSystemInfo("Chrome Version", " 127.0.6533.120");
			  report.viewConfigurer()
			    .viewOrder()
			    .as(new ViewName[] { 
				   ViewName.DASHBOARD, 
				   ViewName.TEST, 
				   ViewName.AUTHOR, 
				   ViewName.DEVICE, 
				   ViewName.EXCEPTION, 
				   ViewName.CATEGORY,
				   ViewName.LOG 
				})
			  .apply();
			  
			 
			  
			  return extent;
			  
			
			  
			 }
	 
			 public static   void endReport() {
			  extent.flush();
			 
}
			 
			
			    
	 
			 
			 
			 
			 
			 
			 
			 
}
