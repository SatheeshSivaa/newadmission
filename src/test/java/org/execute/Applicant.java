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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ListenerClass.class)
public class Applicant extends BaseClass {

	Pojoclass p;

	@BeforeMethod
	private void startbrowser() throws AWTException {
		startupbrowser();
		p = new Pojoclass();
		r=new Robot();

	}

	@AfterMethod
	private void close() {

		closebrowser();
	}

	@Test(priority = 0)
	private void UserCreateTheLeadFormWebuserPage() throws IOException, InterruptedException, AWTException {
		ExtentReport.test.createNode("Validate User can able to create lead form with all valid test data");
		launhurl("https://uatggi.creatrixcampus.net/public/lead/add");

		ExtentReport.test.info("First Name entered in textbox");
		sendkey(excelread("Testdata", 5, 5), p.getEnterFirstname());

		sendkey(excelread("Testdata", 6, 5), p.getEnterLastName());
		ExtentReport.test.info("Last Name entered in textbox");

		// email code
		ExtentReport.test.info("Primary Email Id entered in textbox");
		WebElement enteremail = p.getEnteremail();
		//String[] emailsToValidate = { "testexample.com" };
		List<String>  emailsToValidate = Arrays.asList(excelread("Testdata", 7, 5).split(","));
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
		List<String>  Allcountry = Arrays.asList(excelread("Testdata", 59, 5).split(","));
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
		List<String> phoneNumbers  = Arrays.asList(excelread("Testdata", 8, 5).split(","));
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
		String admission = excelread("Testdata", 15, 5);
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
		String program = excelread("Testdata", 16, 5);
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
			if (p.getLeadsdisplay().isDisplayed()) {
				String text = p.getLeadsdisplay().getText();
				Thread.sleep(2000);
				ExtentReport.test.info(" User " + text);
			}
		} catch (Exception e) {
		}

		Assert.assertTrue(p.getLeadsdisplay().isDisplayed());

	}
	
	@Test(priority = 1)
	private void UserCreateTheLeadFormWithOutEnterdata() {
		ExtentReport.test.createNode("Validate User can able to create the lead form with out enter data");
		launhurl("https://uatggi.creatrixcampus.net/public/lead/add");
		ExtentReport.test.info("user leaves the all field  and click the submit Button");
		clickjava(p.getClicksubmitbutton());
        ExtentReport.test.info("user see an error message on the ");
        String text = p.getAllfieldleaderror().getText();
		String[] lines = text.split("\\n");
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
		}
		
		Assert.assertTrue(p.getErrormessagelead().isDisplayed());

	}
	@Test(priority = 2)
	private void UserCreateTheLeadWithAlreadyExistsEmailIdWithInTheSameCycleAndTheSameProgram() throws InterruptedException, IOException {
		ExtentReport.test.createNode("Validate User can able to Create the Lead With already Exists Emailid in The Same cycle And The Same Program");
		launhurl("https://uatggi.creatrixcampus.net/public/lead/add"); 

		ExtentReport.test.info("First Name entered in textbox");
		sendkey(excelread("Testdata", 5, 5), p.getEnterFirstname());

		sendkey(excelread("Testdata", 6, 5), p.getEnterLastName());
		ExtentReport.test.info("Last Name entered in textbox");

		
		
		// email code
		ExtentReport.test.info("Primary Email Id entered in textbox");
		WebElement enteremail = p.getEnteremail();
		//String[] emailsToValidate = { "testexample.com" };
		List<String> emailsToValidate  = Arrays.asList(excelread("Testdata", 7, 5).split(","));
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
		//String Allcountry = excelread("Testdata", 59, 5);
		
		 List<String>  Allcountry = Arrays.asList(excelread("Testdata", 59, 5).split(","));
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
		List<String>  phoneNumbers = Arrays.asList(excelread("Testdata", 8, 5).split(","));
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
		String admission = excelread("Testdata", 15, 5);
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
		Thread.sleep(2000);

		ExtentReport.test.info("Program Interested In selected from dropdown");
		// program interest code
		clickjava(p.getClickprograminterestfield());
		List<WebElement> selectprogram1 = p.getSelectprogram1();
		int interest = 0;
		String program = excelread("Testdata", 16, 5);
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
		 ExtentReport.test.info("user see an error message on the ");
		 String text = p.getErrorleadpage().getText();
		 
		 String[] lines = text.split("\\n");
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
			}
			
		   Assert.assertTrue(p.getErrorleadpage().isDisplayed());
	}
	
	
	@Test(enabled = false)
	private void UserCreateTheLeadWithAlreadyExistsEmailIdWithInTheSameCycleAndTheDifferentProgram() throws InterruptedException, IOException {
		ExtentReport.test.createNode("Validate User can able to Create the Lead With already Exists Emailid in The Same cycle And The different Program");
		launhurl("https://uatggi.creatrixcampus.net/public/lead/add"); 

		ExtentReport.test.info("First Name entered in textbox");
		sendkey(excelread("Testdata", 5, 5), p.getEnterFirstname());

		sendkey(excelread("Testdata", 6, 5), p.getEnterLastName());
		ExtentReport.test.info("Last Name entered in textbox");

		// email code
		ExtentReport.test.info("Primary Email Id entered in textbox");
		WebElement enteremail = p.getEnteremail();
		String[] emailsToValidate = { "testexample.com" };
		for (String email : emailsToValidate) {
			Thread.sleep(2000);
			enteremail.clear();
			enteremail.sendKeys(email);
		}
		clear(enteremail);
		Thread.sleep(1000);
		sendkey(excelread("Testdata", 7, 5), enteremail);
		scrollpagedown(enteremail);
		Thread.sleep(1000);

		// country code
		ExtentReport.test.info("Country selected from dropdown and contact number entered in textbox");
		clickjava(p.getClickcountryflag());
		String[] Allcountry = { "India (भारत)", "Afghanistan " };
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
		String[] phoneNumbers = { "1223", "3535636673" };
		for (String number : phoneNumbers) {
			Thread.sleep(2000);
			clicknum.clear();
			clicknum.sendKeys(number);
		}
		clear(clicknum);
		Thread.sleep(1000);
		sendkey(excelread("Testdata", 8, 5), clicknum);

		// admission code
		ExtentReport.test.info("Admission Cycle selected from dropdown");
		clickjava(p.getClicktadmissionfield());
		Thread.sleep(2000);
		List<WebElement> selectadmission = p.getSelectadmission();
		int i = 0;
		String admission = excelread("Testdata", 15, 5);
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
		Thread.sleep(2000);

		ExtentReport.test.info("Program Interested In selected from dropdown");
		// program interest code
		clickjava(p.getClickprograminterestfield());
		List<WebElement> selectprogram1 = p.getSelectprogram1();
		int interest = 0;
		String program = excelread("Testdata", 16, 5);
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
		
		
	}	
		
		
		
		
}
