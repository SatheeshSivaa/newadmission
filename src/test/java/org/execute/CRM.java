package org.execute;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.BaseClass.BaseClass;
import org.Listener.ExtentReport;
import org.Listener.ListenerClass;
import org.Pojoclass.Pojoclass;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.retry.RetryAnalayzer;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerClass.class)
public class CRM extends BaseClass {
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
	 private void UserCreateTheLeadFormCRMmodule() throws IOException, InterruptedException {
		ExtentReport.test.createNode("Validate User can able to create lead form with all valid test data");
		ExtentReport.test.info("user Enter User Name");
		passtext(excelread("Testdata2", 1, 5), p.getEnterusername());
		ExtentReport.test.info("user Enter Password");
		passtext(excelread("Testdata2", 2, 5), p.getEnterpassword());
		ExtentReport.test.info("user click login button");
		clickbtn(p.getLogin());
		Thread.sleep(1000);
		ExtentReport.test.info("user click on Apps Icon ");
		clickbtn(p.getClickMenuicon());
		try {
			ExtentReport.test.info("user select CRM in Apps");
			clickAction(p.getClickCrm());
			
		} catch (StaleElementReferenceException e) {
			
		}
		Thread.sleep(2000);
		ExtentReport.test.info("user Click on Leads");
		clickjava(p.getClickLeads());
		Thread.sleep(2000);
		ExtentReport.test.info("User click on +add button");
		clickjava(p.getClickadd());
		ExtentReport.test.info("First Name entered in textbox");
		sendkey(excelread("Testdata2", 5, 5), p.getEnterFirstname());

		sendkey(excelread("Testdata2", 6, 5), p.getEnterLastName());
		ExtentReport.test.info("Last Name entered in textbox");

		// email code
		ExtentReport.test.info("Primary Email Id entered in textbox");
		WebElement enteremail = p.getEnteremail();
		//String[] emailsToValidate = { "testexample.com" };
		List<String> emailsToValidate  = Arrays.asList(excelread("Testdata2", 7, 5).split(","));
		for (String email : emailsToValidate) {
			Thread.sleep(2000);
			enteremail.clear();
			enteremail.sendKeys(email);
		}
		scrollpagedown(enteremail);
		Thread.sleep(1000);
		// country code
		ExtentReport.test.info("Country selected from dropdown and contact number entered in textbox");
		clickjava(p.getClickcountryflag());
	//	String[] Allcountry = { "India (भारत)", "Afghanistan " };
		List<String> Allcountry  = Arrays.asList(excelread("Testdata", 59, 5).split(","));
		
		WebElement serachcountryflag = p.getSerachcountryflag();
		outerLoop: for (String country : Allcountry) {
			serachcountryflag.clear();
			passtext(country, serachcountryflag);
			Thread.sleep(1000);
			List<WebElement> selectcountry = p.getSelectcountry();
			for (WebElement result : selectcountry) {
				if (result.getText().contains(country)) {
					clickjava(result);
					break outerLoop;
				}
			}
		}

		// phonenumber code
		WebElement clicknum = p.getEnterphonenum();
		//String[] phoneNumbers = { "1223", "3535636673" };
		List<String> phoneNumbers  = Arrays.asList(excelread("Testdata2", 8, 5).split(","));
		for (String number : phoneNumbers) {
			Thread.sleep(2000);
			clicknum.clear();
			clicknum.sendKeys(number);
		}

		// admission code
		ExtentReport.test.info("Admission Cycle selected from dropdown");
		clickjava(p.getClicktadmissionfield());
		Thread.sleep(2000);
		List<WebElement> selectadmission = p.getSelectadmission();
		int i = 0;
		String admission = excelread("Testdata2", 15, 5);
		while (i < selectadmission.size()) {
			if (selectadmission.get(i).getText().contains(admission)) {
				clickjava(selectadmission.get(i));
				break;
			}
			i++;
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
		}
		//
		Thread.sleep(3000);

		ExtentReport.test.info("Program Interested In selected from dropdown");
		// program interest code
		clickjava(p.getClickprograminterestfield());
		List<WebElement> selectprogram1 = p.getSelectprogram1();
		int interest = 0;
		String program = excelread("Testdata2", 16, 5);
		while (interest < selectprogram1.size()) {
			if (selectprogram1.get(interest).getText().contains(program)) {
				clickjava(selectprogram1.get(interest));
				break;
			}
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			interest++;
		}

		Thread.sleep(3000);
		scrollpagedown(p.getClicksubmitbutton());
		ExtentReport.test.info("User click the submit  button");
		clickjava(p.getClicksubmitbutton());
		try {
			if (p.getSuccesfuulycreated().isDisplayed()) {
				String text = p.getSuccesfuulycreated().getText();
				Thread.sleep(2000);
				ExtentReport.test.info(" User displayed message on " + text);
			}
		} catch (Exception e) {
		}

		Assert.assertTrue(p.getSuccesfuulycreated().isDisplayed());
		
	}

	@Test(priority = 1)
	private void UserCreateTheLeadFormWithOutEnterdataInTheCRMmodule() throws IOException, InterruptedException {

		ExtentReport.test.createNode("Validate User can able to create the lead form with out enter data");
		ExtentReport.test.info("user Enter User Name");
		passtext(excelread("Testdata2", 1, 5), p.getEnterusername());
		ExtentReport.test.info("user Enter Password");
		passtext(excelread("Testdata2", 2, 5), p.getEnterpassword());
		ExtentReport.test.info("user click login button");
		clickbtn(p.getLogin());
		Thread.sleep(1000);
		ExtentReport.test.info("user click on Apps Icon ");
		clickbtn(p.getClickMenuicon());
		try {
			ExtentReport.test.info("user select CRM in Apps");
			clickAction(p.getClickCrm());
			
		} catch (StaleElementReferenceException e) {
			
		}
		Thread.sleep(2000);
		ExtentReport.test.info("user Click on Leads");
		clickjava(p.getClickLeads());
		Thread.sleep(2000);
		ExtentReport.test.info("User click on +add button");
		clickjava(p.getClickadd());
		ExtentReport.test.info("user leaves the all field  and click the submit Button");
		clickjava(p.getClicksubmitbutton());

		try {
			if (p.getErrormessagelead().isDisplayed()) {
				String text1 = p.getErrormessagelead().getText();
			  String text = p.getAllfieldleaderror().getText();
				ExtentReport.test.info(" user see an  error message on  " + text1  +" "  + text);
			}
		} catch (Exception e) {
		}

		Assert.assertTrue(p.getErrormessagelead().isDisplayed());
	}
	@Test(priority = 2)
	private void UserCreateTheLeadWithAlreadyExistsEmailIdWithInTheSameCycleAndTheSameProgramInTheCRMmodule() throws InterruptedException, IOException {
		ExtentReport.test.createNode("Validate User can able to Create the Lead With already Exists Emailid in The Same cycle And The Same Program");
		ExtentReport.test.info("user Enter User Name");
		passtext(excelread("Testdata2", 1, 5), p.getEnterusername());
		ExtentReport.test.info("user Enter Password");
		passtext(excelread("Testdata2", 2, 5), p.getEnterpassword());
		ExtentReport.test.info("user click login button");
		clickbtn(p.getLogin());
		Thread.sleep(1000);
		ExtentReport.test.info("user click on Apps Icon ");
		clickbtn(p.getClickMenuicon());
		try {
			ExtentReport.test.info("user select CRM in Apps");
			clickAction(p.getClickCrm());
			
		} catch (StaleElementReferenceException e) {
			
		}
		Thread.sleep(2000);
		ExtentReport.test.info("user Click on Leads");
		clickjava(p.getClickLeads());
		Thread.sleep(2000);
		ExtentReport.test.info("User click on +add button");
		clickjava(p.getClickadd());
		ExtentReport.test.info("First Name entered in textbox");
		sendkey(excelread("Testdata2", 5, 5), p.getEnterFirstname());

		sendkey(excelread("Testdata2", 6, 5), p.getEnterLastName());
		ExtentReport.test.info("Last Name entered in textbox");

		// email code
		ExtentReport.test.info("Primary Email Id entered in textbox");
		WebElement enteremail = p.getEnteremail();
		//String[] emailsToValidate = { "testexample.com" };
		List<String> emailsToValidate  = Arrays.asList(excelread("Testdata2", 7, 5).split(","));

		for (String email : emailsToValidate) {
			Thread.sleep(2000);
			enteremail.clear();
			enteremail.sendKeys(email);
		}
		scrollpagedown(enteremail);
		Thread.sleep(1000);

		// country code
		ExtentReport.test.info("Country selected from dropdown and contact number entered in textbox");
		clickjava(p.getClickcountryflag());
		//String[] Allcountry = { "India (भारत)", "Afghanistan " };
		List<String> Allcountry  = Arrays.asList(excelread("Testdata", 59, 5).split(","));
		WebElement serachcountryflag = p.getSerachcountryflag();
		outerLoop: for (String country : Allcountry) {
			serachcountryflag.clear();
			passtext(country, serachcountryflag);
			Thread.sleep(1000);
			List<WebElement> selectcountry = p.getSelectcountry();
			for (WebElement result : selectcountry) {
				if (result.getText().contains(country)) {
					clickjava(result);
					break outerLoop;
				}
			}
		}

		// phonenumber code
		WebElement clicknum = p.getEnterphonenum();
	//	String[] phoneNumbers = { "1223", "3535636673" };
		List<String> phoneNumbers  = Arrays.asList(excelread("Testdata2", 8, 5).split(","));
		for (String number : phoneNumbers) {
			Thread.sleep(2000);
			clicknum.clear();
			clicknum.sendKeys(number);
		}
		// admission code
		ExtentReport.test.info("Admission Cycle selected from dropdown");
		clickjava(p.getClicktadmissionfield());
		Thread.sleep(2000);
		List<WebElement> selectadmission = p.getSelectadmission();
		int i = 0;
		String admission = excelread("Testdata2", 15, 5);
		while (i < selectadmission.size()) {
			if (selectadmission.get(i).getText().contains(admission)) {
				clickjava(selectadmission.get(i));
				break;
			}
			i++;
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
		}
		//
		Thread.sleep(3000);

		ExtentReport.test.info("Program Interested In selected from dropdown");
		// program interest code
		clickjava(p.getClickprograminterestfield());
		List<WebElement> selectprogram1 = p.getSelectprogram1();
		int interest = 0;
		String program = excelread("Testdata2", 16, 5);
		while (interest < selectprogram1.size()) {
			if (selectprogram1.get(interest).getText().contains(program)) {
				clickjava(selectprogram1.get(interest));
				break;
			}
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			interest++;
		}

		Thread.sleep(3000);
		scrollpagedown(p.getClicksubmitbutton());
		ExtentReport.test.info("User click the submit  button");
		clickjava(p.getClicksubmitbutton());
		try {
			if (p.getErrorleadpage().isDisplayed()) {
				String text = p.getErrorleadpage().getText();
				Thread.sleep(2000);
				ExtentReport.test.info(" User see an  error message on " + text);
			}
		} catch (Exception e) {
		}

		Assert.assertTrue(p.getErrorleadpage().isDisplayed());
	}
		
	@Test(priority = 3)
	private void UserEdit_TheLead_FormCRM_Module() throws IOException, InterruptedException, AWTException {
		ExtentReport.test.createNode("Validate User can able to Edit lead with all valid test data");
		ExtentReport.test.info("user Enter User Name");
		passtext(excelread("Testdata2", 1, 5), p.getEnterusername());
		ExtentReport.test.info("user Enter Password");
		passtext(excelread("Testdata2", 2, 5), p.getEnterpassword());
		ExtentReport.test.info("user click login button");
		clickbtn(p.getLogin());
		Thread.sleep(1000);
		ExtentReport.test.info("user click on Apps Icon ");
		clickbtn(p.getClickMenuicon());
		try {
			ExtentReport.test.info("user select CRM in Apps");
			clickAction(p.getClickCrm());
			
		} catch (StaleElementReferenceException e) {
			
		}
		Thread.sleep(2000);
		ExtentReport.test.info("user Click on Leads");
		clickjava(p.getClickLeads());
		Thread.sleep(2000);
		ExtentReport.test.info("User Search the Lead  Name ");
		WebElement leadssearchbar = p.getLeadssearchbar();
		passtext(excelread("Testdata3", 7, 5), leadssearchbar);
		enter();
		Thread.sleep(2000);
		ExtentReport.test.info("User click on Edit Icon");
		clickjava(p.getClickediticon());
		ExtentReport.test.info("User Edit the phonenumber");
		clear(p.getEnterphonenum());
		Thread.sleep(1000);
		sendkey(excelread("Testdata3", 8, 5), p.getEnterphonenum());

		ExtentReport.test.info("User Edit the Program Interested In selected from dropdown");
		// program interest code
		scrollpagedown(p.getClickeditprogramapply());
		clickjava(p.getClickeditprogramapply());
		List<WebElement> selectprogram1 = p.getSelectprogram1();
		int interest = 0;
		String program = excelread("Testdata3", 16, 5);
		while (interest < selectprogram1.size()) {
			if (selectprogram1.get(interest).getText().contains(program)) {
				clickjava(selectprogram1.get(interest));
				break;
			}
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			interest++;
		}
		ExtentReport.test.info("User Click on Submit button");
		clickjava(p.getClicksubmitbutton());

		try {
			if (p.getSuccessfullyupdatedmessage().isDisplayed()) {
				String text1 = p.getSuccessfullyupdatedmessage().getText();
				ExtentReport.test.info(" user displayed message on  " + text1);
			}
		} catch (Exception e) {
		}

		Assert.assertTrue(p.getSuccessfullyupdatedmessage().isDisplayed());
		
		
		
		
		
	}
	
	@Test(priority = 4)
	private void Userview_TheLead_FormCRM_Module() throws IOException, InterruptedException, AWTException {
		
		ExtentReport.test.createNode("Validate the user can able to Viwe the Lead Deatils ");
		ExtentReport.test.info("user Enter User Name");
		passtext(excelread("Testdata2", 1, 5), p.getEnterusername());
		ExtentReport.test.info("user Enter Password");
		passtext(excelread("Testdata2", 2, 5), p.getEnterpassword());
		ExtentReport.test.info("user click login button");
		clickbtn(p.getLogin());
		Thread.sleep(1000);
		ExtentReport.test.info("user click on Apps Icon ");
		clickbtn(p.getClickMenuicon());
		try {
			ExtentReport.test.info("user select CRM in Apps");
			clickAction(p.getClickCrm());
			
		} catch (StaleElementReferenceException e) {
			
		}
		Thread.sleep(2000);
		ExtentReport.test.info("user Click on Leads");
		clickjava(p.getClickLeads());
		Thread.sleep(2000);
		ExtentReport.test.info("User Search the Lead  Name ");
		WebElement leadssearchbar = p.getLeadssearchbar();
		passtext(excelread("Testdata", 7, 5), leadssearchbar);
		enter();
		Thread.sleep(2000);
		ExtentReport.test.info("User click on View Icon");
		clickjava(p.getClickview());
		ExtentReport.test.info("User View the Lead Deatils ");
		Assert.assertTrue(p.getAllviewdetailsviwed().isDisplayed());
		/*String text = p.getAllviewdetailsviwed().getText();
		 String[] lines = text.split("\\n");
		 String currentLabel = null;
         for (String line : lines) {
             if (currentLabel == null) {
                 // Assume the first line is the label
                 currentLabel = line.trim();
             } else {
                 // Print label and value in the desired format
                 ExtentReport.test.info(currentLabel + "  " + line.trim());
                 currentLabel = null; // Reset for next pair
             }
         }*/
		
		clickjava(p.getViewleadclose());
	}
	
	@Test(priority = 5)
	private void  UserEdited_TheLeadDetails_And_updated_TheactivityLog_on_the_ViewDetailspage () throws IOException, InterruptedException, AWTException {
		ExtentReport.test.createNode("Validate user can able to see updated activity logs in Lead");
		ExtentReport.test.info("user Enter User Name");
		passtext(excelread("Testdata2", 1, 5), p.getEnterusername());
		ExtentReport.test.info("user Enter Password");
		passtext(excelread("Testdata2", 2, 5), p.getEnterpassword());
		ExtentReport.test.info("user click login button");
		clickbtn(p.getLogin());
		Thread.sleep(1000);
		ExtentReport.test.info("user click on Apps Icon ");
		clickbtn(p.getClickMenuicon());
		try {
			ExtentReport.test.info("user select CRM in Apps");
			clickAction(p.getClickCrm());
			
		} catch (StaleElementReferenceException e) {
			
		}
		Thread.sleep(2000);
		ExtentReport.test.info("user Click on Leads");
		clickjava(p.getClickLeads());
		Thread.sleep(2000);
		ExtentReport.test.info("User Search the Edit Lead  Name ");
		WebElement leadssearchbar = p.getLeadssearchbar();
		passtext(excelread("Testdata3", 7, 5), leadssearchbar);
		enter();
		Thread.sleep(2000);
		ExtentReport.test.info("User click on Deatils View icon");
		clickjava(p.getClicksettingicon());
		ExtentReport.test.info("User view on  updated the Acticity Log Details");
		Assert.assertTrue(p.getActivityupdateddisplay().get(0).isDisplayed());
		
		
		
	}
	@Test(priority = 6)
	private void User_ViewThePreviewAndDownloadLeadDetailsInCRM_Module() throws IOException, InterruptedException, AWTException {
		ExtentReport.test.createNode("Validate user can able to preview and Download Lead Deatils");
		ExtentReport.test.info("user Enter User Name");
		passtext(excelread("Testdata2", 1, 5), p.getEnterusername());
		ExtentReport.test.info("user Enter Password");
		passtext(excelread("Testdata2", 2, 5), p.getEnterpassword());
		ExtentReport.test.info("user click login button");
		clickbtn(p.getLogin());
		Thread.sleep(1000);
		ExtentReport.test.info("user click on Apps Icon ");
		clickbtn(p.getClickMenuicon());
		try {
			ExtentReport.test.info("user select CRM in Apps");
			clickAction(p.getClickCrm());

		} catch (StaleElementReferenceException e) {

		}
		Thread.sleep(2000);
		ExtentReport.test.info("user Click on Leads");
		clickjava(p.getClickLeads());
		Thread.sleep(2000);
		ExtentReport.test.info("User Search the Lead  Name ");
		WebElement leadssearchbar = p.getLeadssearchbar();
		passtext(excelread("Testdata", 7, 5), leadssearchbar);
		enter();
		Thread.sleep(2000);
		ExtentReport.test.info("User click on Details view Icon");
		clickjava(p.getClicksettingicon());
		ExtentReport.test.info("User click on preview button");
		clickjava(p.getClickpreview());
		//String text = p.getBasicdeatilsdisplay().getText();
		Assert.assertTrue(p.getBasicdeatilsdisplay().isDisplayed());
		ExtentReport.test.info("user view on Basic Deatils ");
		/*String[] lines = text.split("\\n");
		String currentLabel = null;
		for (String line : lines) {
			if (currentLabel == null) {
				// Assume the first line is the label
				currentLabel = line.trim();
			} else {
				// Print label and value in the desired format
				ExtentReport.test.info(currentLabel + "  " + line.trim());
				currentLabel = null;
			}
		}*/

		ExtentReport.test.info("Click on download icon");
		clickjava(p.getClickdownload());
		ExtentReport.test.info("File Download Sucessfully");
		download("Admissionregistration_view_144");
		ExtentReport.test.info("Click on close icon");
		clickjava(p.getClosepreview());
		Assert.assertTrue(p.getLeadprocess().isDisplayed());
		
	}   
	

	@Test(priority = 7)
	private void User_changeTheStatusTo_Eligible_In_CRM_Module() throws IOException, InterruptedException, AWTException {
		ExtentReport.test.createNode("Validate User able to  Change Status to  Eligble in Detail View Icon in Actions section of CRM Module");
		ExtentReport.test.info("user Enter User Name");
		passtext(excelread("Testdata2", 1, 5), p.getEnterusername());
		ExtentReport.test.info("user Enter Password");
		passtext(excelread("Testdata2", 2, 5), p.getEnterpassword());
		ExtentReport.test.info("user click login button");
		clickbtn(p.getLogin());
		Thread.sleep(1000);
		ExtentReport.test.info("user click on Apps Icon ");
		clickbtn(p.getClickMenuicon());
		try {
			ExtentReport.test.info("user select CRM in Apps");
			clickAction(p.getClickCrm());

		} catch (StaleElementReferenceException e) {

		}
		Thread.sleep(2000);
		ExtentReport.test.info("user Click on Leads");
		clickjava(p.getClickLeads());
		Thread.sleep(2000);
		ExtentReport.test.info("User Search the Lead  Name ");
		WebElement leadssearchbar = p.getLeadssearchbar();
		passtext(excelread("Testdata", 7, 5), leadssearchbar);
		enter();
		Thread.sleep(2000);
		ExtentReport.test.info("User click on Details view Icon");
		clickjava(p.getClicksettingicon());
		ExtentReport.test.info("user click on change status button");
		clickjava(p.getClickchangestatus());
		Thread.sleep(2000);
		ExtentReport.test.info("user enter the comments");
		List<WebElement> enterleadcomments = p.getEnterleadcomments();
		sendkey(excelread("Testdata", 17, 6), enterleadcomments.get(1));
		Thread.sleep(3000);
		ExtentReport.test.info("user change status selected from dropdown");
		clickjava(p.getClickstatusfield());
		Thread.sleep(3000);
		List<WebElement> selectstatus = p.getSelectstatus();
		int status = 0;
		String status1 = excelread("Testdata", 17, 5);
		while (status < selectstatus.size()) {
			if (selectstatus.get(status).getText().contains(status1)) {
				clickAction(selectstatus.get(status));
				break;}
			status++;
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);}
		    ExtentReport.test.info("user click on update button");
		    clickjava(p.getLeadupdate());
		    if ( p.getStatusdisplay().isDisplayed()) {	
		    String text1 = p.getStatusdisplay().getText();
		    ExtentReport.test.info("User successfully change the status on  "+ text1);
		    } 
		     p.getDisplayiukl().isDisplayed();
		    Assert.assertTrue(p.getStatusdisplay().isDisplayed());
		    
		    
		
         }
	
	@Test(priority = 8)
	
	private void User_ChangeTheStatuswithoutAnyDeatilsInCRMmodule() throws IOException, InterruptedException, AWTException {
		ExtentReport.test.createNode("Validate User able to click on Change Status button and click on update with out any details in Detail View Icon in"
				+ " Actions section of CRM Module");
		ExtentReport.test.info("user Enter User Name");
		passtext(excelread("Testdata2", 1, 5), p.getEnterusername());
		ExtentReport.test.info("user Enter Password");
		passtext(excelread("Testdata2", 2, 5), p.getEnterpassword());
		ExtentReport.test.info("user click login button");
		clickbtn(p.getLogin());
		Thread.sleep(1000);
		ExtentReport.test.info("user click on Apps Icon ");
		clickbtn(p.getClickMenuicon());
		try {
			ExtentReport.test.info("user select CRM in Apps");
			clickAction(p.getClickCrm());

		} catch (StaleElementReferenceException e) {

		}
		Thread.sleep(2000);
		ExtentReport.test.info("user Click on Leads");
		clickjava(p.getClickLeads());
		Thread.sleep(2000);
		ExtentReport.test.info("User Search the Lead  Name ");
		WebElement leadssearchbar = p.getLeadssearchbar();
		passtext(excelread("Testdata", 7, 5), leadssearchbar);
		enter();
		Thread.sleep(2000);
		ExtentReport.test.info("User click on Details view Icon");
		clickjava(p.getClicksettingicon());
		ExtentReport.test.info("user click on change status button");
		clickjava(p.getClickchangestatus());
		Thread.sleep(2000);
		ExtentReport.test.info("User leaves the changes status and update the button");
		clickjava(p.getLeadupdate());
		ExtentReport.test.info(" user see the Change Status border in red border");
	//	p.getCssclolor().isDisplayed();
		String actual = p.getCssclolor().getCssValue("color");
		String expectedColor = "rgba(0, 0, 0, 0.87)"; 
		Assert.assertEquals(actual, expectedColor);
		System.out.println(actual);
		
		
		
		
		
		

	}
	
	

	@Test(priority = 9)
private void User_ViewandtaketheCredential() throws IOException, InterruptedException, AWTException {
		
		ExtentReport.test.createNode("Validate the user can able to view and take the credntials");
		ExtentReport.test.info("user Enter User Name");
		passtext(excelread("Testdata", 1, 5), p.getEnterusername());
		ExtentReport.test.info("user Enter Password");
		passtext(excelread("Testdata", 2, 5), p.getEnterpassword());
		ExtentReport.test.info("user click on login button");
		Thread.sleep(1000);
		clickbtn(p.getLogin());
		ExtentReport.test.info("user click on Apps icon ");
		clickbtn(p.getClickMenuicon());
		ExtentReport.test.info("user Enter the emaillogs url");
		launhurl("https://uatggi.creatrixcampus.net/settings/emaillogs/list");
		ExtentReport.test.info("user search the applicant name  ");
		WebElement leadssearchbar = p.getLeadssearchbar();
		passtext(excelread("Testdata", 7, 5), leadssearchbar);
		enter();
		Thread.sleep(3000);
		ExtentReport.test.info("user view the credential ");
		clickjava(p.getClickviewcredential());
		scrollpagedown(p.getMouseoverusername());
		//String text = p.getMouseoverusername().getText();
		//ExtentReport.test.info("" + text);
        excelWrite("Testdata", p.getMouseoverusername().getText(), 0, 2);
       // String text1 = p.getMouseoverpassword().getText();
       // ExtentReport.test.info("" + text1);
        excelWrite("Testdata", p.getMouseoverpassword().getText(), 0, 3);
        ExtentReport.test.info("User successfully view and take a credential");
        Assert.assertTrue(p.getMouseoverusername().isDisplayed());
        Assert.assertTrue(p.getMouseoverpassword().isDisplayed());
		
		
		
		
		
	}
		
}	
		
		
		
		
		
		
		
		
		

	
		
		
	
	
	
	
	
	

	
