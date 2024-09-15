package org.Listener;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.BaseClass.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ListenerClass  extends ExtentReport  implements ITestListener{
	
	//private static ExtentReports extent ;
   // private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	//private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    //private String startTime;
   // private String endTime;
	
	
	long startTime;
    long endTime;

	
	@Override
	public void onTestStart(ITestResult result) {
		 //test = extent.createTest(result.getMethod().gett());
		  test = extent.createTest(result.getName());
		  test.assignAuthor("satheesh");
		  test.assignDevice("Windows"); 
		  test.assignCategory("Regression Testing");
		
		  
		//  test.createNode(result.());
		 // test.createNode(result.g)
		  //test = extentReports.createTest(method.getName(), description);
		 
			//test.getModel().getLogContext().get(testNumber).setTimestamp(getTime(result.getEndMillis()));
		  
		
		  
		 
		//  test.getModel().setStartTime(test.getStartTime());
		//	test.getModel().setEndTime(test.getEndTime());
		 // test.getModel().setStartTime("hh:mm:ss");
		/*
		 * ExtentTest extentTest= extent.createTest(result.getName());
		 * test.set(extentTest); test.get().assignAuthor("satheesh");
		 * test.get().assignDevice("Windows");
		 * test.get().assignCategory("Smoke Testing");
		 */
	     
	}

	

	@Override
	public void onTestSuccess(ITestResult result) {
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			  // test.log(Status.PASS, "<b><span style='font-size:10px;'>Pass The Test Case is \" + result.getName() + \"</span></b>\";
			test.log(Status.PASS, "<b><span style='font-size:13px;'>Pass The Test Case is: " + result.getName() + "</span></b>");
			// test.log(Status.PASS, MarkupHelper.createLabel(" Pass The  Test Case is  "+result.getName(), ExtentColor.GREEN));
			
			//test.log(Status.PASS, MarkupHelper.createLabel(" Pass The Test Case is <b>" + result.getName() + "</b>", ExtentColor.GREEN));
			//test.log(Status.PASS, MarkupHelper.createLabel(
				 //   "<b><span style='font-size:10px;'>Pass The Test Case is " + result.getName() + "</span></b>", 
				   // ExtentColor.GREEN
			//	));
		/*
		 * 
		 * 
		 * if (test.get() != null) { test.get().log(Status.PASS, "Pass Test case is: " +
		 * result.getName()); } else {
		 * System.err.println("ExtentTest is null in onTestSuccess.");
		 */
		  
		  
		 
		 
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
		
			
			   test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			   test.log(Status.FAIL,
			     MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		
		    // Handle the case where 'test' is null
		    // You may want to log an error message or perform other error handling here
		

			   String pathString = null;
			try {
				pathString = BaseClass.screenShot(BaseClass.driver, result.getName());
			} catch (AWTException | IOException e) {
				
				e.printStackTrace();
			}
			   test.addScreenCaptureFromPath(pathString);
			  }
			
		/*
		 * if (test.get() != null) { test.get().log(Status.FAIL,
		 * MarkupHelper.createLabel(result.getName() + " - Test Case Failed",
		 * ExtentColor.RED)); test.get().log(Status.FAIL,
		 * MarkupHelper.createLabel(result.getThrowable().toString(), ExtentColor.RED));
		 * 
		 * String pathString = null; try { pathString =
		 * BaseClass.screenShot(BaseClass.driver, result.getName()); } catch
		 * (AWTException | IOException e) { e.printStackTrace(); } if (pathString !=
		 * null) { test.get().addScreenCaptureFromPath(pathString); } } else {
		 * System.err.println("ExtentTest is null in onTestFailure."); }
		 */
			
			
			 
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		
		if (result.getStatus() == ITestResult.SKIP) {
			   test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
			  test.log(Status.SKIP, "error  message  is "+result.getThrowable());
			  }
			 
		
				
		/*
		 * if (test.get() != null) { test.get().log(Status.SKIP,
		 * "Skipped Test case is: " + result.getName()); test.get().log(Status.SKIP,
		 * "error message is " + result.getThrowable()); } else {
		 * System.err.println("ExtentTest is null in onTestSkipped."); }
		 */
				 
    }

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		startTime = System.currentTimeMillis();
	}

	@Override
	public void onFinish(ITestContext context) {
		
		  endTime = System.currentTimeMillis();
	        long totalTime = endTime - startTime;

	        // Convert time to a more readable format (hours, minutes, seconds)
	        long hours = (totalTime / (1000 * 60 * 60)) % 24;
	        long minutes = (totalTime / (1000 * 60)) % 60;
	        long seconds = (totalTime / 1000) % 60;

	        // Add total time to Extent Report dashboard
	        ExtentReport.getInstance().setSystemInfo("Total Execution Time", 
	            String.format("%d hours, %d minutes, %d seconds", hours, minutes, seconds));

	        // Finalize and flush the report
	        ExtentReport.getInstance().flush();
		ExtentReport.extent.flush();
		
	}
	 

	    
	        
	        
	       
	    

	}
	
	


