package org.execute;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import org.BaseClass.BaseClass;
import org.Listener.ExtentReport;
import org.Listener.ListenerClass;
import org.Pojoclass.Pojoclass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Scenario;

@Listeners(ListenerClass.class)
public class LoginPage extends BaseClass  {
	
	Pojoclass p;
	
	@BeforeMethod
	private void startbrowser() throws AWTException {
		startupbrowser();
		 p=new Pojoclass();
			r=new Robot();
	}
	
	@AfterMethod
	private void close() {
		
		closebrowser();
	}
	
	@Test(priority = 0)
	private void LoginTheApplication_With_validusername_And_ValidPassword() throws IOException {
		ExtentReport.test.createNode("<b><font color='blue'>Scenario Name:</font></b> Login with valid user name valid password");
		 ExtentTest node = ExtentReport.test.createNode("<b><font color='blue'>Test Steps:</font></b>");
		node.info("User enter the user name ");
		passtext(excelread("Testdata", 1, 5), p.getEnterusername());
		node.info("User enter the password");
		passtext(excelread("Testdata", 2, 5), p.getEnterpassword());
		node.info("User click the login  button");
		clickjava(p.getLogin());
		node.info("User Successfully  login the appliaction and Creatrix Dashboard displayed");
		Assert.assertTrue(p.getDashboard().isDisplayed());
		
		
		
	}
		@Test(priority = 1)
		private void LoginTheApplication_With_Invalidusername_And_InValidPassword() throws IOException, InterruptedException {
			ExtentReport.test.createNode("Login With invalid username inavalid password");
			ExtentReport.test.info("User enter the user name ");
			passtext(excelread("Testdata", 1, 6), p.getEnterusername());
			ExtentReport.test.info("User enter the password");
			passtext(excelread("Testdata", 2, 6), p.getEnterpassword());
			ExtentReport.test.info("User click the login  button");
			clickjava(p.getLogin());
			String text = p.getErrormessage().getText();
			ExtentReport.test.info("User not Succesffuly Login "+text);
			Assert.assertTrue(p.getErrormessage().isDisplayed());
			
			
			
			
	
			
			
		}
			
}
			
			
			
			
			
			

		
	   
			
		

		
		
		
		
		
		
		
		
		
	
		
	
		
			
		

		
		
		
		
		
	
			
		

			
		
		 
			
		
			    
					
					
				
				
				
			
				
					
				
				
			
			
			
			 
				
			
			
				
			
					 
					 
					
				
				 
				
			
			
			 
		

				  
	


