package org.execute;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.List;

import org.BaseClass.BaseClass;
import org.Listener.ExtentReport;
import org.Listener.ListenerClass;
import org.Pojoclass.Pojoclass;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
@Listeners(ListenerClass.class)
public class Admission extends BaseClass {
	
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
	
	
	@Test
	private void User_ViewTheSubmittedApplicationFormInAdmissionModule() throws IOException, InterruptedException, AWTException {
		ExtentReport.test.createNode(
				"<b><font color='blue'>Scenario Name:</font></b>Validate college admin can access and preview the details submitted by the applicant via the Preview section in the detail view-actions section of the applications.  ");
		ExtentTest node = ExtentReport.test.createNode("<b><font color='blue'>Test Steps:</font></b>");
		node.info("Enter the user name");
		passtext(excelread("Testdata", 1, 5), p.getEnterusername());
		node.info("Enter the password");
		passtext(excelread("Testdata", 2, 5), p.getEnterpassword());
		Thread.sleep(3000);
		node.info("Click on Login button");
		clickbtn(p.getLogin());
		node.info("click on Apps icon");
		clickbtn(p.getClickMenuicon());
		try {
           node.info("User select Admission in Apps");
			clickAction(p.getClickadmission());

		} catch (StaleElementReferenceException e) {

		}
        node.info("Click on application Form the side menu");
		clickjava(p.getClickapplicationforms());
		Thread.sleep(1000);
		node.info("Search Applicant Name");
		passtext(excelread("Testdata", 7, 5), p.getLeadssearchbar());
		enter();
		Thread.sleep(3000);
		node.info("User click on Details View icon");
		clickjava(p.getClicksettingicon());
		Thread.sleep(4000);
		node.info("click on preview");
		clickjava(p.getClickpreview());
		Thread.sleep(2000);
		node.info("Applicant Details displayed on preview page");
		Assert.assertTrue(p.getAdmissionpreview().isDisplayed());
		node.info("Click on close icon");
		clickjava(p.getClosepreview());
		Thread.sleep(2000);
		node.info("Click on the Program Apply Tab Expand Arrow down Icon");
		node.info("user see on program apply deatils displayed");
		node.info("Click on the Personal Details Tab Expand Arrow down Icon");
		node.info("user see onpersonal deatils displayed");
		node.info("Click on the Address Details Tab Expand Arrow down Icon");
		node.info("user see on Address deatils displayed");
		node.info("Click on the Parents details Tab Expand Arrow down Icon");
		node.info("user see on program apply deatils displayed");
		node.info("Click on the Education details Tab Expand Arrow down Icon");
		node.info("user see on Education deatils displayed");
		node.info("Click on the Documents Tab Expand Arrow down Icon");
		node.info("User see on document deatils  displayed");
		node.info("Click on the Disclaimer Tab Expand Arrow down Icon");
		node.info("user see on disclaimer deatils displayed");
		 List<WebElement> allvisible = p.getClickallarrow();
		 List<WebElement> viewalldeatilsadmission = p.getViewalldeatilsadmission();
		 clickjava(p.getClickallarrow().get(0));
		 for (int i = 0; i <allvisible.size(); i++) {
			 clickjava(allvisible.get(i));
			 Thread.sleep(1000);
			 Assert.assertTrue(viewalldeatilsadmission.get(i).isDisplayed()); 
		}
		
	}
	
	@Test
	 private void CollegeadminchangeTheadmisisonProcesstatusIsDocumentReupload() throws IOException, InterruptedException, AWTException {
		ExtentReport.test.createNode(
				"<b><font color='blue'>Scenario Name:</font></b> Validate college admin can update the application status to \"Documents Re-Upload\" on the View Applications page. ");
		ExtentTest node = ExtentReport.test.createNode("<b><font color='blue'>Test Steps:</font></b>");
		node.info("Enter the user name");
		passtext(excelread("Testdata", 1, 5), p.getEnterusername());
		node.info("Enter the password");
		passtext(excelread("Testdata", 2, 5), p.getEnterpassword());
		Thread.sleep(3000);
		node.info("Click on Login button");
		clickbtn(p.getLogin());
		node.info("click on Apps icon");
		clickbtn(p.getClickMenuicon());
		try {
           node.info("User select Admission in Apps");
			clickAction(p.getClickadmission());

		} catch (StaleElementReferenceException e) {

		}
        node.info("Click on application Form the side menu");
		clickjava(p.getClickapplicationforms());
		Thread.sleep(1000);
		node.info("Search Applicant Name");
		passtext(excelread("Testdata", 7, 5), p.getLeadssearchbar());
		enter();
		Thread.sleep(3000);
		node.info("User click on Details View icon");
		clickjava(p.getClicksettingicon());
		node.info("click on document tab ");
		clickjava(p.getClicktabdocuments());
		node.info("user view the all document");
		Thread.sleep(1000);
		List<WebElement> documentviewadmission = p.getDocumentviewadmission();
		 for (int i = 0; i <documentviewadmission.size(); i++) {
			 clickjava(documentviewadmission.get(i));
			 Thread.sleep(1000);
			 clickjava(p.getClickcloseicon());
		 }
		 node.info("user Reject the particular ineligble Document");
		 
		 
		
		//clickAction(p.getClickadmissionstatus());
		//clickjava(p.getClickdocumentuploadstatus());
		//Thread.sleep(3000);
		//clickjava(p.getClickupdate());
		//clickbtn(p.getClickonyes());
		//scrollpagedown(p.getClickupdate());
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
