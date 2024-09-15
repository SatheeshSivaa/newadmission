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

import com.aventstack.extentreports.ExtentTest;

@Listeners(ListenerClass.class)
public class ApplicationForm extends BaseClass {
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
	private void Applicant_SubmitTheApplicationFormWithoutEnteringData() throws IOException, AWTException, InterruptedException {
		
		ExtentReport.test.createNode("Validate Applicant can able to Submit the Application form with out entering data");
		ExtentReport.test.info("Enter the user name");
		passtext(excelread("Testdata", 0, 2), p.getEnterusername());
		removeuser();
		ExtentReport.test.info("Enter the password");
		passtext(excelread("Testdata", 0, 3), p.getEnterpassword());
		removepass();
		Thread.sleep(1000);
		ExtentReport.test.info("click on Login button");
		clickjava(p.getLogin());
		Thread.sleep(1000);
		ExtentReport.test.info("click on Edit icon");
		clickbtn(p.getClickeditapplicant());
		Thread.sleep(1000);
		ExtentReport.test.info(" Leave the  Program Apply section and click on the  Next button ");
		clickbtn(p.getClicknext());
		Thread.sleep(1000);
		ExtentReport.test.info(" Leave the personal deatils and click on the  Next button ");
		clickbtn(p.getClicknext());
		Thread.sleep(1000);
		ExtentReport.test.info("Leave the address deatils and click on the  next button ");
		clickbtn(p.getClicknext());
		Thread.sleep(1000);
		ExtentReport.test.info("Leave the parrent deatils and click on the next button");
		clickjava(p.getClicknext());
		Thread.sleep(1000);
		ExtentReport.test.info("Leave The Education Deatils and click on the next button ");
		clickjava(p.getClicknext());
		ExtentReport.test.info("Leave the Documents and click on the next button");
		clickjava(p.getClicknext());
		ExtentReport.test.info("Leave the Disclamier Checkbox and click on the submit button");
		clickjava(p.getClicksubmitbutton());
		String text = p.getApplicatioformerror().getText();
		ExtentReport.test.info("user see an error message on the ");
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
		ExtentReport.test.info("Applicant not Successfully submit the appliaction form");
		Assert.assertTrue(p.getApplicatioformerror().isDisplayed());
		
	}
	@Test(priority = 1)
	private void Applicant_SubmitTheApplicationFormUseingDraftModeAfterEnteringTheData() throws IOException, AWTException, InterruptedException {
		ExtentReport.test.createNode("<b><font color='blue'>Scenario Name:</font></b> Validate Applicant can able submit the Application Form to use draft mode after enter the data");
		 ExtentTest node = ExtentReport.test.createNode("<b><font color='blue'>Test Steps:</font></b>");
		node.info("Enter the user name");
		passtext(excelread("Testdata", 0, 2), p.getEnterusername());
		removeuser();
		node.info("Enter the password");
		passtext(excelread("Testdata", 0, 3), p.getEnterpassword());
		removepass();
		Thread.sleep(2000);
		node.info("click on Login button");
		clickjava(p.getLogin());
		Thread.sleep(1000);
		node.info("click on Edit icon  ");
		clickbtn(p.getClickeditapplicant());
		node.info("User enter  the program apply section page ");
		Assert.assertTrue(p.getProgramapplydisplay().isDisplayed());
		node.info("select a study level from the lookup");
		clear(p.getEnterstudylevel());
		clickjava(p.getEnterstudylevel());
		Thread.sleep(1000);
		List<WebElement> study = p.getSelectprogram1();
		int level = 0;
		String studylevel = excelread("Testdata", 20, 5);
		while (level < study.size()) {
			if (study.get(level).getText().contains(studylevel)) {
				clickjava(study.get(level));
				break;
			}
			level++;
			Thread.sleep(1000);
		}
		node.info("click on next button");
		Thread.sleep(1000);
		clickjava(p.getClicknext());
		node.info("User enter the personal deatils page");
		Assert.assertTrue(p.getPersonaldeatilsdisplayed().isDisplayed());
		node.info("Country selected from dropdown and contact number entered in textbox");
		// country and phonenumber
		clickjava(p.getClickcountryflag());
		// String[] Allcountry = { "India (भारत)", "Afghanistan " };
		List<String> Allcountry = Arrays.asList(excelread("Testdata", 59, 5).split(","));
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

		clear(p.getEnterphonenum());
		Thread.sleep(1000);
		sendkey(excelread("Testdata", 8, 5), p.getEnterphonenum());
		node.info("Select the date of birth from Calender");
		tab();
		clickjava(p.getApplicantdateofbirth());
		Thread.sleep(1000);
		clickjava(p.getSelectyear().get(1));
		Thread.sleep(1000);
		clickjava(p.getClickyear().get(0));
		Thread.sleep(1000);
		String birthyear = excelread("Testdata", 55, 5);
		List<WebElement> clickbirthyear = p.getClickbirthyear();
		for (WebElement select1 : clickbirthyear) {
			if (select1.getText().equalsIgnoreCase(birthyear)) {
				clickjava(select1);
				break;
			}
		}

		List<WebElement> selectmonth = p.getSelectmonth();

		String month = excelread("Testdata", 56, 5);

		for (WebElement select2 : selectmonth) {
			if (select2.getText().equalsIgnoreCase(month)) {
				clickjava(select2);
				break;
			}
		}
		List<WebElement> selectdate = p.getSelectdate();
		String Date = excelread("Testdata", 57, 5);
		for (WebElement select3 : selectdate) {
			if (select3.getText().equalsIgnoreCase(Date)) {
				clickjava(select3);
				break;
			}
		}

		Thread.sleep(1000);
		node.info("Select a Marital Status from dropdown");
		clickjava(p.getMartialstatus());
		List<WebElement> martialstatus = p.getSelectprogram1();
		for (int i = 0; i < martialstatus.size(); i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			if (martialstatus.get(i).getText().contains(excelread("Testdata", 21, 5))) {
				clickjava(martialstatus.get(i));
				break;
			}
		}

		node.info("Select a gender from dropdown");
		Thread.sleep(1000);
		clickjava(p.getClickgendervalue());
		List<WebElement> selectgender = p.getSelectgender();
		String genders = excelread("Testdata", 58, 5);
		for (WebElement select : selectgender) {
			if (select.getText().contains(genders)) {
				clickjava(select);
				break;
			}
		}
		Thread.sleep(1000);
		node.info("select a Physically Disabled from dropdown ");
		clickjava(p.getClickphysicaldisabled());
		List<WebElement> selectgender1 = p.getSelectgender();
		String genders1 = excelread("Testdata", 60, 5);
		for (WebElement select1 : selectgender1) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			if (select1.getText().equals(genders1)) {
				clickjava(select1);
				break;
			}
		}

		scrollpagedown(p.getClicknationality());
		node.info("select Nationality from lookup");
		tab();
		passtext(excelread("Testdata", 22, 5), p.getClicknationality());
		Thread.sleep(3000);
		List<WebElement> nationality = p.getSelectprogram1();
		for (int i = 0; i < nationality.size(); i++) {
			if (nationality.get(i).getText().contains(excelread("Testdata", 22, 5))) {
				Thread.sleep(3000);
				clickjava(nationality.get(i));
				break;
			}

		}
		node.info("Enter the  Aadhar No");
		clear(p.getAadharno());
		sendkey(excelread("Testdata", 23, 5), p.getAadharno());
		node.info("Select Hostel Required from dropdown");
		clickjava(p.getClickhostelreqired());
		List<WebElement> selectgender2 = p.getSelectgender();
		String genders2 = excelread("Testdata", 61, 5);
		for (WebElement select2 : selectgender2) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			if (select2.getText().equals(genders2)) {
				clickjava(select2);
				break;
			}
		}

		node.info("Country selected from dropdown and Alternate number entered in textbox");
		clickjava(p.getClickcountryflag2());
		// String[] Allcountry1 = { "India (भारत)", "Afghanistan " };
		List<String> Allcountry1 = Arrays.asList(excelread("Testdata", 59, 5).split(","));
		WebElement serachcountryflag1 = p.getSerachcountryflag2();
		outerLoop: for (String country12 : Allcountry1) {
			serachcountryflag1.clear();
			passtext(country12, serachcountryflag1);
			Thread.sleep(1000);
			List<WebElement> selectcountry1 = p.getSelectcountry();
			for (WebElement result1 : selectcountry1) {
				if (result1.getText().contains(country12)) {
					clickjava(result1);
					break outerLoop;
				}
			}
		}
		scrollpageup(p.getVisiblehome());
		// phonenumber code
		WebElement clicknum1 = p.getEnterhomecontact();
		// String[] phoneNumbers1 = { "1223", "abcdefghij", "8273636" };
		List<String> phoneNumbers1 = Arrays.asList(excelread("Testdata", 10, 5).split(","));
		for (String number1 : phoneNumbers1) {
			Thread.sleep(2000);
			clicknum1.clear();
			clicknum1.sendKeys(number1);
		}
		
		node.info("Country selected from the  Lookup");
		tab();
		sendkey(excelread("Testdata", 18, 5), p.getClickapplicantcountry());
		Thread.sleep(3000);
		List<WebElement> personaldeatils3 = p.getSelectprogram1();
		int country3 = 0;
		String data3 = excelread("Testdata", 18, 5);
		while (country3 < personaldeatils3.size()) {
			if (personaldeatils3.get(country3).getText().contains(data3)) {
				Thread.sleep(3000);
				clickjava(personaldeatils3.get(country3));
				break;
			}
			country3++;
			Thread.sleep(1000);
		}
		
		node.info("Enter the Blood group");
		
		Thread.sleep(2000);
		clear(p.getBloodgroup());
		sendkey(excelread("Testdata", 62, 5), p.getBloodgroup());
		node.info("Religion selected from the  Lookup");
		scrollpagedown(p.getClickreligion());
		tab();
		passtext(excelread("Testdata", 24, 5), p.getClickreligion());
		Thread.sleep(3000);
		List<WebElement> religion = p.getSelectprogram1();
		for (int i = 0; i <religion.size(); i++) {
			if (religion.get(i).getText().contains(excelread("Testdata", 24, 5))) {
				Thread.sleep(2000);
				clickjava(religion.get(i));	
				break;
			}
			
		}
		node.info("Catagory selected from the dropdown");
		clickjava(p.getCatagory());
		List<WebElement> catagory = p.getSelectprogram1();
		for (int i = 0; i <catagory.size(); i++) {
			if (catagory.get(i).getText().contains(excelread("Testdata", 25, 5))) {
				Thread.sleep(2000);
				clickjava(catagory.get(i));	
				break;
			}
		}
		node.info("Enter the passport number");
		clear(p.getEnterpassportno());
		passtext(excelread("Testdata", 9, 5), p.getEnterpassportno());
		scrollpagedown(p.getEnterpassportno());
		node.info("Select the date of issue from Calender");
		tab();
		clickjava(p.getClickdateofissue());
		Thread.sleep(1000);
		clickjava(p.getSelectyear().get(1));
		Thread.sleep(1000);
		//clickjava(p.getClickyear().get(0));
		Thread.sleep(1000);
		String birthyear1 = "2016";
		List<WebElement> clickbirthyear1 = p.getClickbirthyear();
		for (WebElement select11 : clickbirthyear1) {
			if (select11.getText().equalsIgnoreCase(birthyear1)) {
				clickjava(select11);
				break;
			}
		}

		List<WebElement> selectmonth1 = p.getSelectmonth();
		String month1 = "DEC";
		for (WebElement select21 : selectmonth1) {
			if (select21.getText().equalsIgnoreCase(month1)) {
				clickjava(select21);
				break;
			}
		}

		List<WebElement> selectdate1 = p.getSelectdate();
		String Date1 = "7";
		for (WebElement select31 : selectdate1) {
			if (select31.getText().equalsIgnoreCase(Date1)) {
				clickjava(select31);
				break;
			}
		}
		node.info("Select the date of Expiry from Calender");
		tab();
		clickjava(p.getDateofexpiry());

		Thread.sleep(1000);
		clickjava(p.getSelectyear().get(1));
		Thread.sleep(1000);
		//clickjava(p.getClickyear().get(0));
		Thread.sleep(1000);
		String birthyear12 = "2028";
		List<WebElement> clickbirthyear12 = p.getClickbirthyear();
		for (WebElement select112 : clickbirthyear12) {
			if (select112.getText().equalsIgnoreCase(birthyear12)) {
				clickjava(select112);
				break;
			}
		}

		List<WebElement> selectmonth12 = p.getSelectmonth();
		String month12 = "Jun";
		for (WebElement select212 : selectmonth12) {
			if (select212.getText().equalsIgnoreCase(month12)) {
				clickjava(select212);
				break;
			}
		}

		List<WebElement> selectdate12 = p.getSelectdate();
		String Date12 = "15";
		for (WebElement select312 : selectdate12) {
			if (select312.getText().equalsIgnoreCase(Date12)) {
				clickjava(select312);
				break;
			}
		}
		
		node.info("Select the Transport Required from the dropdown");
		clickjava(p.getClicktransport());
		List<WebElement> transport = p.getSelectprogram1();
		for (int i = 0; i <transport.size(); i++) {
			if (transport.get(i).getText().equals(excelread("Testdata", 63, 5))) {
				Thread.sleep(2000);
				clickjava(transport.get(i));	
				break;
			}
		}
		node.info("click on next button");
		clickjava(p.getClicknext());
		Thread.sleep(1000);
		node.info("User enter the Address deatils page");
		Assert.assertTrue(p.getAddressdeatilsdisplay().isDisplayed());
		node.info("click on Correspondence Address same as Permanent Address from checkbox ");
		clickjava(p.getCorrespondenceAddress().get(0));
		node.info("Enter the full Address");
		tab();
		clear(p.getEntertextarea1());
		sendkey(excelread("Testdata", 64, 5), p.getEntertextarea1());
		node.info("Enter the city name ");
		clear(p.getEntercityName());
		passtext(excelread("Testdata", 65, 5), p.getEntercityName());
		node.info("Enter the District name ");
		clear(p.getEnterdistrictname());
		passtext(excelread("Testdata", 66, 5), p.getEnterdistrictname());
		node.info("State selected from the Lookup");
		tab();
		passtext(excelread("Testdata", 19, 5), p.getApplicantstate());
		Thread.sleep(3000);
		List<WebElement> personaldeatils4 = p.getSelectprogram1();
		int country4 = 0;
		String data4 = excelread("Testdata", 19, 5);
		while (country4 < personaldeatils4.size()) {
			if (personaldeatils4.get(country4).getText().contains(data4)) {
				Thread.sleep(3000);
				clickjava(personaldeatils4.get(country4));
				break;
			}
			country4++;
			Thread.sleep(2000);
		}
		node.info("Counrty Name  selected from the Lookup");
		Thread.sleep(3000);
		scrollpagedown(p.getEntercountryname());
		tab();
		passtext(excelread("Testdata", 18, 5), p.getEntercountryname());
		Thread.sleep(3000);
		List<WebElement> countryname = p.getSelectprogram1();
		for (int i = 0; i < countryname.size(); i++) {
			if (countryname.get(i).getText().equals(excelread("Testdata", 18, 5))) {
				Thread.sleep(3000);
				clickjava(countryname.get(i));
				break;
			}
		}
		try {
			clickjava(p.getMandatorycloseicon());
			
		} catch (NoSuchElementException e) {
			
		}
		node.info("Enter the pincode ");
		clear(p.getEnterpincode());
		sendkey(excelread("Testdata", 14, 5), p.getEnterpincode());
		Thread.sleep(1000);
		node.info("click on next button");
		clickjava(p.getClicknext());
		node.info("user Enter the parent details page");
		Assert.assertTrue(p.getParentdeatilsdisplay().isDisplayed());
		node.info("select father title from dropdown");
		clickjava(p.getFathetitle());
		List<WebElement> fathertitle = p.getSelectprogram1();
		for (int i = 0; i < fathertitle.size(); i++) {
			if (fathertitle.get(i).getText().equals(excelread("Testdata", 3, 5))) {
				Thread.sleep(1000);
				clickjava(fathertitle.get(i));
				break;
			}
		}
		node.info("Enter Father Name");
		clear(p.getFathername());
		passtext(excelread("Testdata", 5, 7), p.getFathername());
		node.info("Enter Father Email address");
		clear(p.getFatheremail());
		passtext(excelread("Testdata", 6, 7), p.getFatheremail());
		node.info("Enter Father mobile number ");
		scrollpagedown(p.getParentcountryflag());
		Thread.sleep(2000);
		// phonenumber code
		WebElement clicknum3 = p.getEnterparentnumber();
		//String[] phoneNumbers3 = {"213232424242425" };
		List<String> phoneNumbers3 = Arrays.asList(excelread("Testdata", 7, 7).split(","));
		for (String number3 : phoneNumbers3) {
			Thread.sleep(1000);
			clicknum3.clear();
			clicknum3.sendKeys(number3);
		}
		node.info("Enter Father occupation");
		clear(p.getFatheroccupation());
		sendkey(excelread("Testdata", 8, 7), p.getFatheroccupation());
		node.info("Enter Father income");
		clear(p.getFatherincome());
		passtext(excelread("Testdata", 9, 7), p.getFatherincome());
		node.info("Mother title select from the  dropdown");
		clickjava(p.getMothertitle());
		List<WebElement> mothertitle = p.getSelectprogram1();
		for (int i = 0; i < mothertitle.size(); i++) {
			if (mothertitle.get(i).getText().equals(excelread("Testdata", 3, 6))) {
				Thread.sleep(1000);
				clickjava(mothertitle.get(i));
				break;
			}
		}
		
	
	node.info("Enter Mother Name");
	clear(p.getMothername());
	passtext(excelread("Testdata", 11, 7), p.getMothername());
	scrollpagedown(p.getMothercountryflag());
	node.info("Enter Mother number");
	WebElement clicknum4 = p.getMothernumber();
	//String[] phoneNumbers4 = {"213232424242425" };
	List<String> phoneNumbers4 = Arrays.asList(excelread("Testdata", 13, 7).split(","));
	for (String number4 : phoneNumbers4) {
		Thread.sleep(2000);
		clicknum4.clear();
		clicknum4.sendKeys(number4);
	}
	node.info("Enter Mother EmailAddress");
	clear(p.getMotheremailaddress());
	passtext(excelread("Testdata", 12, 7), p.getMotheremailaddress());
	node.info("Enter Mother occupation");
	clear(p.getMotheroccupation());
	passtext(excelread("Testdata", 14, 7), p.getMotheroccupation());
	node.info("click on next button");
	Thread.sleep(1000);
	clickjava(p.getClicknext());
	node.info("User Enter the educational Deatail page ");
	Assert.assertTrue(p.getEducationalpagedisplay().isDisplayed());
	node.info("Enter the 10th school name");
	clear(p.getEnterschoolname());
	sendkey(excelread("Testdata", 20, 7), p.getEnterschoolname());
	node.info("Enter the 10th board ");
	clear(p.getEnterboarduniversity());
	sendkey(excelread("Testdata", 21, 7), p.getEnterboarduniversity());
	node.info("Year of passing Select from calender ");
	tab();
	clickjava(p.getYearofpassing());
	Thread.sleep(1000);
	clickjava(p.getSelectyear().get(1));
	Thread.sleep(1000);
	String passing = "2020";
	List<WebElement> passingyear12 = p.getClickbirthyear();
	for (WebElement school : passingyear12) {
		if (school.getText().equalsIgnoreCase(passing)) {
			clickjava(school);
			break;
		}
	}

	List<WebElement> passingmonth12 = p.getSelectmonth();
	String passing12 = "Jun";
	for (WebElement school1 : passingmonth12) {
		if (school1.getText().equalsIgnoreCase(passing12)) {
			clickjava(school1);
			break;
		}
	}

	List<WebElement> passingdate12 = p.getSelectdate();
	String passing13 = "15";
	for (WebElement school2 : passingdate12) {
		if (school2.getText().equalsIgnoreCase(passing13)) {
			clickjava(school2);
			break;
		}
	}
	Thread.sleep(2000);
	node.info("10th Mraking Scheme Select from the dropdown");
	clickjava(p.getMarkingscheme());
	List<WebElement> markingschem = p.getSelectprogram1();
	for (int i = 0; i <markingschem.size(); i++) {
		if (markingschem.get(i).getText().equals(excelread("Testdata", 23, 7))) {
			Thread.sleep(1000);
			clickjava(markingschem.get(i));
			break;
		}
	}
	node.info("Enter 10th percentage/CGPA");
	Thread.sleep(2000);
	clear(p.getCgpg10());
	sendkey(excelread("Testdata", 24, 7), p.getCgpg10());
	node.info("10th Medium of study select from dropdown");
	clickjava(p.getMediumstudy10());
	
	List<WebElement> mediumofstudy = p.getSelectprogram1();
	for (int i = 0; i <mediumofstudy.size(); i++) {
		if (mediumofstudy.get(i).getText().contains(excelread("Testdata", 25, 7))) {
			Thread.sleep(1000);
			clickjava(mediumofstudy.get(i));
			break;
		}
	}
	node.info("10th Subject select from the dropdown");
	clickjava(p.getSubject10());
	List<WebElement> subject = p.getSelectprogram1();
	for (int i = 0; i <subject.size(); i++) {
		if (subject.get(i).getText().contains(excelread("Testdata", 26, 7))) {
			Thread.sleep(1000);
			clickjava(subject.get(i));
			break;
		}
	}
	
	scrollpagedown(p.getEnter12thcollegename());
	Thread.sleep(3000);
	node.info("Enter the 12th school name");
	clear(p.getEnter12thcollegename());
	sendkey(excelread("Testdata", 28, 7), p.getEnter12thcollegename());
	node.info("Enter the 12th board name");
	clear(p.getEnter12thboardname());
	sendkey(excelread("Testdata", 29, 7), p.getEnter12thboardname());
	node.info("12th year of passing select from the dropdown");
	tab();
	clickjava(p.getEnter12thpassing());
	Thread.sleep(1000);
	clickjava(p.getSelectyear().get(1));
	Thread.sleep(1000);
	String passing1 = "2022";
	List<WebElement> passingyear121 = p.getClickbirthyear();
	for (WebElement school1 : passingyear121) {
		if (school1.getText().equalsIgnoreCase(passing1)) {
			clickjava(school1);
			break;
		}
	}

	List<WebElement> passingmonth122 = p.getSelectmonth();
	String passing122 = "Jun";
	for (WebElement school12 : passingmonth122) {
		if (school12.getText().equalsIgnoreCase(passing122)) {
			clickjava(school12);
			break;
		}
	}

	List<WebElement> passingdate123 = p.getSelectdate();
	String passing133 = "15";
	for (WebElement school23 : passingdate123) {
		if (school23.getText().equalsIgnoreCase(passing133)) {
			clickjava(school23);
			break;
		}
	}
	node.info("12th marking scheme select from dropdown");
	Thread.sleep(2000);
	clickjava(p.getMarkingschem12());
	List<WebElement> markingschem12 = p.getSelectprogram1();
	for (int i = 0; i <markingschem12.size(); i++) {
		if (markingschem12.get(i).getText().equals(excelread("Testdata", 31, 7))) {
			Thread.sleep(1000);
			clickjava(markingschem12.get(i));
			break;
		}
	}
	Thread.sleep(2000);
	node.info("Enter the 12th percentage/CGPA");
	clear(p.getEnter12thggpa());
	sendkey(excelread("Testdata", 32, 7), p.getEnter12thggpa());
	Thread.sleep(3000);
	node.info("12th medium of study select from dropdown");
	clickjava(p.getMedium12());
	List<WebElement> mediumofstudy12 = p.getSelectprogram1();
	for (int i = 0; i <mediumofstudy12.size(); i++) {
		if (mediumofstudy12.get(i).getText().contains(excelread("Testdata", 33, 7))) {
			Thread.sleep(1000);
			clickjava(mediumofstudy12.get(i));
			break;
		}
	}
	
	node.info("12th Subject select from the dropdown");
	clickjava(p.getSubject12());
	List<WebElement> subject12 = p.getSelectprogram1();
	for (int i = 0; i <subject12.size(); i++) {
		if (subject12.get(i).getText().equals(excelread("Testdata", 34, 7))) {
			Thread.sleep(1000);
			clickjava(subject12.get(i));
			break;
		}
	}
	
	Thread.sleep(2000);
	node.info("Click on Next Button");
	clickjava(p.getClicknext());
	node.info("Enter the document page");
	Assert.assertTrue(p.getDocumentspagesdisplay().isDisplayed());
	node.info("Upload the all document");
	Thread.sleep(3000);
	try {
		// Retrieve the list of close upload file icons
		List<WebElement> closeUploadFileIcons = p.getCloseuploadfile();
		// Check if each element in the list is displayed
		boolean allDisplayed = true;
		for (WebElement closeIcon : closeUploadFileIcons) {
			if (!closeIcon.isDisplayed()) {
				allDisplayed = false;
				break;
			}
		}

		// If all close icons are displayed, perform actions
		if (allDisplayed) {
			for (WebElement closeIcon : closeUploadFileIcons) {
				Thread.sleep(1000);
				clickjava(closeIcon);
			}
		}
	} catch (NoSuchElementException | IndexOutOfBoundsException e) {
		// Handle cases where elements are not found
		//System.out.println("Close icon(s) not found.");
	}
	
	// upload the documents");
	List<WebElement> allattach = p.getClickattachfile();
	for (int i = 0; i < allattach.size(); i++) {
		clickjava(allattach.get(i));
		sendkey("document", p.getEnterdocumentname());
		Thread.sleep(1000);
		sendkey("testdocument", p.getEnterdocumentdescription());
		Thread.sleep(3000);
		clickjava(p.getClicktobrowse());
		Thread.sleep(1000);
		upload("C:\\Users\\Satheesh S\\Downloads\\file-sample_150kB.pdf");
		Thread.sleep(3000);
		clickjava(p.getClickupload());
		Thread.sleep(3000);

	}
	node.info("click on view and see an all document");
	List<WebElement> allvisible = p.getClickvisbile();
	for (int i = 0; i < allvisible.size(); i++) {
		clickjava(allvisible.get(i));
		Thread.sleep(3000);
		clickjava(p.getClickcloseicon());
		Thread.sleep(3000);

}
	 node.info("click on next button ");
	 Thread.sleep(3000);
	 clickjava(p.getClicknext());
	 node.info(" user Enter the disclaimer page");
	 Assert.assertTrue(p.getDisplaydiscaimerpage().isDisplayed());
	 node.info("click on checkbox from i agree ");
	 clickjava(p.getDiscalmier());
	 Thread.sleep(3000);
	 node.info("click on draft button");
	 clickjava(p.getClickdraft());
	 node.info("user see on message successfully updated");
	 Assert.assertTrue(p.getSuccessfullyupdatedmessage().isDisplayed());
	 node.info("click on view icon");
	  clickjava(p.getClickofferletterviewicon());
	 node.info("click on preview");
	 clickjava(p.getClickpreview());
	 node.pass("Details successfully saved and view the preview page");
	 Assert.assertTrue(p.getViewonapplicationdeatils().isDisplayed());
	 
	}
	
	@Test
	 private void Applicant_SubmittheApplicationForm() throws InterruptedException, IOException, AWTException {
		ExtentReport.test.createNode("<b><font color='blue'>Scenario Name:</font></b> Validate Applicant can able to Edit/Submit the Application form by using own credentials with valid all data. ");
		 ExtentTest node = ExtentReport.test.createNode("<b><font color='blue'>Test Steps:</font></b>");
		 node.info("Enter the user name");
			passtext(excelread("Testdata", 0, 2), p.getEnterusername());
			removeuser();
			node.info("Enter the password");
			passtext(excelread("Testdata", 0, 3), p.getEnterpassword());
			removepass();
			Thread.sleep(2000);
			node.info("click on Login button");
			clickjava(p.getLogin());
			Thread.sleep(1000);
			node.info("click on Edit icon  ");
			clickbtn(p.getClickeditapplicant());
			node.info("User enter  the program apply section page ");
			Assert.assertTrue(p.getProgramapplydisplay().isDisplayed());
			node.info("select a study level from the lookup");
			clear(p.getEnterstudylevel());
			clickjava(p.getEnterstudylevel());
			Thread.sleep(1000);
			List<WebElement> study = p.getSelectprogram1();
			int level = 0;
			String studylevel = excelread("Testdata", 20, 5);
			while (level < study.size()) {
				if (study.get(level).getText().contains(studylevel)) {
					clickjava(study.get(level));
					break;
				}
				level++;
				Thread.sleep(1000);
			}
			node.info("click on next button");
			Thread.sleep(1000);
			clickjava(p.getClicknext());
			node.info("User enter the personal deatils page");
			Assert.assertTrue(p.getPersonaldeatilsdisplayed().isDisplayed());
			node.info("Country selected from dropdown and contact number entered in textbox");
			// country and phonenumber
			clickjava(p.getClickcountryflag());
			// String[] Allcountry = { "India (भारत)", "Afghanistan " };
			List<String> Allcountry = Arrays.asList(excelread("Testdata", 59, 5).split(","));
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

			clear(p.getEnterphonenum());
			Thread.sleep(1000);
			sendkey(excelread("Testdata", 8, 5), p.getEnterphonenum());
			node.info("Select the date of birth from Calender");
			tab();
			clickjava(p.getApplicantdateofbirth());
			Thread.sleep(1000);
			clickjava(p.getSelectyear().get(1));
			Thread.sleep(1000);
			clickjava(p.getClickyear().get(0));
			Thread.sleep(1000);
			String birthyear = excelread("Testdata", 55, 5);
			List<WebElement> clickbirthyear = p.getClickbirthyear();
			for (WebElement select1 : clickbirthyear) {
				if (select1.getText().equalsIgnoreCase(birthyear)) {
					clickjava(select1);
					break;
				}
			}

			List<WebElement> selectmonth = p.getSelectmonth();

			String month = excelread("Testdata", 56, 5);

			for (WebElement select2 : selectmonth) {
				if (select2.getText().equalsIgnoreCase(month)) {
					clickjava(select2);
					break;
				}
			}
			List<WebElement> selectdate = p.getSelectdate();
			String Date = excelread("Testdata", 57, 5);
			for (WebElement select3 : selectdate) {
				if (select3.getText().equalsIgnoreCase(Date)) {
					clickjava(select3);
					break;
				}
			}

			Thread.sleep(1000);
			node.info("Select a Marital Status from dropdown");
			clickjava(p.getMartialstatus());
			List<WebElement> martialstatus = p.getSelectprogram1();
			for (int i = 0; i < martialstatus.size(); i++) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				Thread.sleep(1000);
				if (martialstatus.get(i).getText().contains(excelread("Testdata", 21, 5))) {
					clickjava(martialstatus.get(i));
					break;
				}
			}

			node.info("Select a gender from dropdown");
			Thread.sleep(1000);
			clickjava(p.getClickgendervalue());
			List<WebElement> selectgender = p.getSelectgender();
			String genders = excelread("Testdata", 58, 5);
			for (WebElement select : selectgender) {
				if (select.getText().contains(genders)) {
					clickjava(select);
					break;
				}
			}
			Thread.sleep(1000);
			node.info("select a Physically Disabled from dropdown ");
			clickjava(p.getClickphysicaldisabled());
			List<WebElement> selectgender1 = p.getSelectgender();
			String genders1 = excelread("Testdata", 60, 5);
			for (WebElement select1 : selectgender1) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				Thread.sleep(1000);
				if (select1.getText().equals(genders1)) {
					clickjava(select1);
					break;
				}
			}

			scrollpagedown(p.getClicknationality());
			node.info("select Nationality from lookup");
			tab();
			passtext(excelread("Testdata", 22, 5), p.getClicknationality());
			Thread.sleep(3000);
			List<WebElement> nationality = p.getSelectprogram1();
			for (int i = 0; i < nationality.size(); i++) {
				if (nationality.get(i).getText().contains(excelread("Testdata", 22, 5))) {
					Thread.sleep(3000);
					clickjava(nationality.get(i));
					break;
				}

			}
			node.info("Enter the  Aadhar No");
			clear(p.getAadharno());
			sendkey(excelread("Testdata", 23, 5), p.getAadharno());
			node.info("Select Hostel Required from dropdown");
			clickjava(p.getClickhostelreqired());
			List<WebElement> selectgender2 = p.getSelectgender();
			String genders2 = excelread("Testdata", 61, 5);
			for (WebElement select2 : selectgender2) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				Thread.sleep(1000);
				if (select2.getText().equals(genders2)) {
					clickjava(select2);
					break;
				}
			}

			node.info("Country selected from dropdown and Alternate number entered in textbox");
			clickjava(p.getClickcountryflag2());
			// String[] Allcountry1 = { "India (भारत)", "Afghanistan " };
			List<String> Allcountry1 = Arrays.asList(excelread("Testdata", 59, 5).split(","));
			WebElement serachcountryflag1 = p.getSerachcountryflag2();
			outerLoop: for (String country12 : Allcountry1) {
				serachcountryflag1.clear();
				passtext(country12, serachcountryflag1);
				Thread.sleep(1000);
				List<WebElement> selectcountry1 = p.getSelectcountry();
				for (WebElement result1 : selectcountry1) {
					if (result1.getText().contains(country12)) {
						clickjava(result1);
						break outerLoop;
					}
				}
			}
			scrollpageup(p.getVisiblehome());
			// phonenumber code
			WebElement clicknum1 = p.getEnterhomecontact();
			// String[] phoneNumbers1 = { "1223", "abcdefghij", "8273636" };
			List<String> phoneNumbers1 = Arrays.asList(excelread("Testdata", 10, 5).split(","));
			for (String number1 : phoneNumbers1) {
				Thread.sleep(2000);
				clicknum1.clear();
				clicknum1.sendKeys(number1);
			}
			
			node.info("Country selected from the  Lookup");
			tab();
			sendkey(excelread("Testdata", 18, 5), p.getClickapplicantcountry());
			Thread.sleep(3000);
			List<WebElement> personaldeatils3 = p.getSelectprogram1();
			int country3 = 0;
			String data3 = excelread("Testdata", 18, 5);
			while (country3 < personaldeatils3.size()) {
				if (personaldeatils3.get(country3).getText().contains(data3)) {
					Thread.sleep(3000);
					clickjava(personaldeatils3.get(country3));
					break;
				}
				country3++;
				Thread.sleep(1000);
			}
			
			node.info("Enter the Blood group");
			
			Thread.sleep(2000);
			clear(p.getBloodgroup());
			sendkey(excelread("Testdata", 62, 5), p.getBloodgroup());
			node.info("Religion selected from the  Lookup");
			scrollpagedown(p.getClickreligion());
			tab();
			passtext(excelread("Testdata", 24, 5), p.getClickreligion());
			Thread.sleep(3000);
			List<WebElement> religion = p.getSelectprogram1();
			for (int i = 0; i <religion.size(); i++) {
				if (religion.get(i).getText().contains(excelread("Testdata", 24, 5))) {
					Thread.sleep(2000);
					clickjava(religion.get(i));	
					break;
				}
				
			}
			node.info("Catagory selected from the dropdown");
			clickjava(p.getCatagory());
			List<WebElement> catagory = p.getSelectprogram1();
			for (int i = 0; i <catagory.size(); i++) {
				if (catagory.get(i).getText().contains(excelread("Testdata", 25, 5))) {
					Thread.sleep(2000);
					clickjava(catagory.get(i));	
					break;
				}
			}
			node.info("Enter the passport number");
			clear(p.getEnterpassportno());
			passtext(excelread("Testdata", 9, 5), p.getEnterpassportno());
			scrollpagedown(p.getEnterpassportno());
			node.info("Select the date of issue from Calender");
			tab();
			clickjava(p.getClickdateofissue());
			Thread.sleep(1000);
			clickjava(p.getSelectyear().get(1));
			Thread.sleep(1000);
			//clickjava(p.getClickyear().get(0));
			Thread.sleep(1000);
			String birthyear1 = "2016";
			List<WebElement> clickbirthyear1 = p.getClickbirthyear();
			for (WebElement select11 : clickbirthyear1) {
				if (select11.getText().equalsIgnoreCase(birthyear1)) {
					clickjava(select11);
					break;
				}
			}

			List<WebElement> selectmonth1 = p.getSelectmonth();
			String month1 = "DEC";
			for (WebElement select21 : selectmonth1) {
				if (select21.getText().equalsIgnoreCase(month1)) {
					clickjava(select21);
					break;
				}
			}

			List<WebElement> selectdate1 = p.getSelectdate();
			String Date1 = "7";
			for (WebElement select31 : selectdate1) {
				if (select31.getText().equalsIgnoreCase(Date1)) {
					clickjava(select31);
					break;
				}
			}
			node.info("Select the date of Expiry from Calender");
			tab();
			clickjava(p.getDateofexpiry());

			Thread.sleep(1000);
			clickjava(p.getSelectyear().get(1));
			Thread.sleep(1000);
			//clickjava(p.getClickyear().get(0));
			Thread.sleep(1000);
			String birthyear12 = "2028";
			List<WebElement> clickbirthyear12 = p.getClickbirthyear();
			for (WebElement select112 : clickbirthyear12) {
				if (select112.getText().equalsIgnoreCase(birthyear12)) {
					clickjava(select112);
					break;
				}
			}

			List<WebElement> selectmonth12 = p.getSelectmonth();
			String month12 = "Jun";
			for (WebElement select212 : selectmonth12) {
				if (select212.getText().equalsIgnoreCase(month12)) {
					clickjava(select212);
					break;
				}
			}

			List<WebElement> selectdate12 = p.getSelectdate();
			String Date12 = "15";
			for (WebElement select312 : selectdate12) {
				if (select312.getText().equalsIgnoreCase(Date12)) {
					clickjava(select312);
					break;
				}
			}
			
			node.info("Select the Transport Required from the dropdown");
			clickjava(p.getClicktransport());
			List<WebElement> transport = p.getSelectprogram1();
			for (int i = 0; i <transport.size(); i++) {
				if (transport.get(i).getText().equals(excelread("Testdata", 63, 5))) {
					Thread.sleep(2000);
					clickjava(transport.get(i));	
					break;
				}
			}
			node.info("click on next button");
			clickjava(p.getClicknext());
			Thread.sleep(1000);
			node.info("User enter the Address deatils page");
			Assert.assertTrue(p.getAddressdeatilsdisplay().isDisplayed());
			node.info("click on Correspondence Address same as Permanent Address from checkbox ");
			clickjava(p.getCorrespondenceAddress().get(0));
			node.info("Enter the full Address");
			tab();
			clear(p.getEntertextarea1());
			sendkey(excelread("Testdata", 64, 5), p.getEntertextarea1());
			node.info("Enter the city name ");
			clear(p.getEntercityName());
			passtext(excelread("Testdata", 65, 5), p.getEntercityName());
			node.info("Enter the District name ");
			clear(p.getEnterdistrictname());
			passtext(excelread("Testdata", 66, 5), p.getEnterdistrictname());
			node.info("State selected from the Lookup");
			tab();
			passtext(excelread("Testdata", 19, 5), p.getApplicantstate());
			Thread.sleep(3000);
			List<WebElement> personaldeatils4 = p.getSelectprogram1();
			int country4 = 0;
			String data4 = excelread("Testdata", 19, 5);
			while (country4 < personaldeatils4.size()) {
				if (personaldeatils4.get(country4).getText().contains(data4)) {
					Thread.sleep(3000);
					clickjava(personaldeatils4.get(country4));
					break;
				}
				country4++;
				Thread.sleep(2000);
			}
			node.info("Counrty Name  selected from the Lookup");
			Thread.sleep(3000);
			scrollpagedown(p.getEntercountryname());
			tab();
			passtext(excelread("Testdata", 18, 5), p.getEntercountryname());
			Thread.sleep(3000);
			List<WebElement> countryname = p.getSelectprogram1();
			for (int i = 0; i < countryname.size(); i++) {
				if (countryname.get(i).getText().equals(excelread("Testdata", 18, 5))) {
					Thread.sleep(3000);
					clickjava(countryname.get(i));
					break;
				}
			}
			try {
				clickjava(p.getMandatorycloseicon());
				
			} catch (NoSuchElementException e) {
				
			}
			node.info("Enter the pincode ");
			clear(p.getEnterpincode());
			sendkey(excelread("Testdata", 14, 5), p.getEnterpincode());
			Thread.sleep(1000);
			node.info("click on next button");
			clickjava(p.getClicknext());
			node.info("user Enter the parent details page");
			Assert.assertTrue(p.getParentdeatilsdisplay().isDisplayed());
			node.info("select father title from dropdown");
			clickjava(p.getFathetitle());
			List<WebElement> fathertitle = p.getSelectprogram1();
			for (int i = 0; i < fathertitle.size(); i++) {
				if (fathertitle.get(i).getText().equals(excelread("Testdata", 3, 5))) {
					Thread.sleep(1000);
					clickjava(fathertitle.get(i));
					break;
				}
			}
			node.info("Enter Father Name");
			clear(p.getFathername());
			passtext(excelread("Testdata", 5, 7), p.getFathername());
			node.info("Enter Father Email address");
			clear(p.getFatheremail());
			passtext(excelread("Testdata", 6, 7), p.getFatheremail());
			node.info("Enter Father mobile number ");
			scrollpagedown(p.getParentcountryflag());
			Thread.sleep(2000);
			// phonenumber code
			WebElement clicknum3 = p.getEnterparentnumber();
			//String[] phoneNumbers3 = {"213232424242425" };
			List<String> phoneNumbers3 = Arrays.asList(excelread("Testdata", 7, 7).split(","));
			for (String number3 : phoneNumbers3) {
				Thread.sleep(1000);
				clicknum3.clear();
				clicknum3.sendKeys(number3);
			}
			node.info("Enter Father occupation");
			clear(p.getFatheroccupation());
			sendkey(excelread("Testdata", 8, 7), p.getFatheroccupation());
			node.info("Enter Father income");
			clear(p.getFatherincome());
			passtext(excelread("Testdata", 9, 7), p.getFatherincome());
			node.info("Mother title select from the  dropdown");
			clickjava(p.getMothertitle());
			List<WebElement> mothertitle = p.getSelectprogram1();
			for (int i = 0; i < mothertitle.size(); i++) {
				if (mothertitle.get(i).getText().equals(excelread("Testdata", 3, 6))) {
					Thread.sleep(1000);
					clickjava(mothertitle.get(i));
					break;
				}
			}
			
		
		node.info("Enter Mother Name");
		clear(p.getMothername());
		passtext(excelread("Testdata", 11, 7), p.getMothername());
		scrollpagedown(p.getMothercountryflag());
		node.info("Enter Mother number");
		WebElement clicknum4 = p.getMothernumber();
		//String[] phoneNumbers4 = {"213232424242425" };
		List<String> phoneNumbers4 = Arrays.asList(excelread("Testdata", 13, 7).split(","));
		for (String number4 : phoneNumbers4) {
			Thread.sleep(2000);
			clicknum4.clear();
			clicknum4.sendKeys(number4);
		}
		node.info("Enter Mother EmailAddress");
		clear(p.getMotheremailaddress());
		passtext(excelread("Testdata", 12, 7), p.getMotheremailaddress());
		node.info("Enter Mother occupation");
		clear(p.getMotheroccupation());
		passtext(excelread("Testdata", 14, 7), p.getMotheroccupation());
		node.info("click on next button");
		Thread.sleep(1000);
		clickjava(p.getClicknext());
		node.info("User Enter the educational Deatail page ");
		Assert.assertTrue(p.getEducationalpagedisplay().isDisplayed());
		node.info("Enter the 10th school name");
		clear(p.getEnterschoolname());
		sendkey(excelread("Testdata", 20, 7), p.getEnterschoolname());
		node.info("Enter the 10th board ");
		clear(p.getEnterboarduniversity());
		sendkey(excelread("Testdata", 21, 7), p.getEnterboarduniversity());
		node.info("Year of passing Select from calender ");
		tab();
		clickjava(p.getYearofpassing());
		Thread.sleep(1000);
		clickjava(p.getSelectyear().get(1));
		Thread.sleep(1000);
		String passing = "2020";
		List<WebElement> passingyear12 = p.getClickbirthyear();
		for (WebElement school : passingyear12) {
			if (school.getText().equalsIgnoreCase(passing)) {
				clickjava(school);
				break;
			}
		}

		List<WebElement> passingmonth12 = p.getSelectmonth();
		String passing12 = "Jun";
		for (WebElement school1 : passingmonth12) {
			if (school1.getText().equalsIgnoreCase(passing12)) {
				clickjava(school1);
				break;
			}
		}

		List<WebElement> passingdate12 = p.getSelectdate();
		String passing13 = "15";
		for (WebElement school2 : passingdate12) {
			if (school2.getText().equalsIgnoreCase(passing13)) {
				clickjava(school2);
				break;
			}
		}
		Thread.sleep(2000);
		node.info("10th Mraking Scheme Select from the dropdown");
		clickjava(p.getMarkingscheme());
		List<WebElement> markingschem = p.getSelectprogram1();
		for (int i = 0; i <markingschem.size(); i++) {
			if (markingschem.get(i).getText().equals(excelread("Testdata", 23, 7))) {
				Thread.sleep(1000);
				clickjava(markingschem.get(i));
				break;
			}
		}
		node.info("Enter 10th percentage/CGPA");
		Thread.sleep(2000);
		clear(p.getCgpg10());
		sendkey(excelread("Testdata", 24, 7), p.getCgpg10());
		node.info("10th Medium of study select from dropdown");
		clickjava(p.getMediumstudy10());
		
		List<WebElement> mediumofstudy = p.getSelectprogram1();
		for (int i = 0; i <mediumofstudy.size(); i++) {
			if (mediumofstudy.get(i).getText().contains(excelread("Testdata", 25, 7))) {
				Thread.sleep(1000);
				clickjava(mediumofstudy.get(i));
				break;
			}
		}
		node.info("10th Subject select from the dropdown");
		clickjava(p.getSubject10());
		List<WebElement> subject = p.getSelectprogram1();
		for (int i = 0; i <subject.size(); i++) {
			if (subject.get(i).getText().contains(excelread("Testdata", 26, 7))) {
				Thread.sleep(1000);
				clickjava(subject.get(i));
				break;
			}
		}
		
		scrollpagedown(p.getEnter12thcollegename());
		Thread.sleep(3000);
		node.info("Enter the 12th school name");
		clear(p.getEnter12thcollegename());
		sendkey(excelread("Testdata", 28, 7), p.getEnter12thcollegename());
		node.info("Enter the 12th board name");
		clear(p.getEnter12thboardname());
		sendkey(excelread("Testdata", 29, 7), p.getEnter12thboardname());
		node.info("12th year of passing select from the dropdown");
		tab();
		clickjava(p.getEnter12thpassing());
		Thread.sleep(1000);
		clickjava(p.getSelectyear().get(1));
		Thread.sleep(1000);
		String passing1 = "2022";
		List<WebElement> passingyear121 = p.getClickbirthyear();
		for (WebElement school1 : passingyear121) {
			if (school1.getText().equalsIgnoreCase(passing1)) {
				clickjava(school1);
				break;
			}
		}

		List<WebElement> passingmonth122 = p.getSelectmonth();
		String passing122 = "Jun";
		for (WebElement school12 : passingmonth122) {
			if (school12.getText().equalsIgnoreCase(passing122)) {
				clickjava(school12);
				break;
			}
		}

		List<WebElement> passingdate123 = p.getSelectdate();
		String passing133 = "15";
		for (WebElement school23 : passingdate123) {
			if (school23.getText().equalsIgnoreCase(passing133)) {
				clickjava(school23);
				break;
			}
		}
		node.info("12th marking scheme select from dropdown");
		Thread.sleep(2000);
		clickjava(p.getMarkingschem12());
		List<WebElement> markingschem12 = p.getSelectprogram1();
		for (int i = 0; i <markingschem12.size(); i++) {
			if (markingschem12.get(i).getText().equals(excelread("Testdata", 31, 7))) {
				Thread.sleep(1000);
				clickjava(markingschem12.get(i));
				break;
			}
		}
		Thread.sleep(2000);
		node.info("Enter the 12th percentage/CGPA");
		clear(p.getEnter12thggpa());
		sendkey(excelread("Testdata", 32, 7), p.getEnter12thggpa());
		Thread.sleep(3000);
		node.info("12th medium of study select from dropdown");
		clickjava(p.getMedium12());
		List<WebElement> mediumofstudy12 = p.getSelectprogram1();
		for (int i = 0; i <mediumofstudy12.size(); i++) {
			if (mediumofstudy12.get(i).getText().contains(excelread("Testdata", 33, 7))) {
				Thread.sleep(1000);
				clickjava(mediumofstudy12.get(i));
				break;
			}
		}
		
		node.info("12th Subject select from the dropdown");
		clickjava(p.getSubject12());
		List<WebElement> subject12 = p.getSelectprogram1();
		for (int i = 0; i <subject12.size(); i++) {
			if (subject12.get(i).getText().equals(excelread("Testdata", 34, 7))) {
				Thread.sleep(1000);
				clickjava(subject12.get(i));
				break;
			}
		}
		
		Thread.sleep(2000);
		node.info("Click on Next Button");
		clickjava(p.getClicknext());
		node.info("Enter the document page");
		Assert.assertTrue(p.getDocumentspagesdisplay().isDisplayed());
		node.info("Upload the all document");
		Thread.sleep(3000);
		try {
			// Retrieve the list of close upload file icons
			List<WebElement> closeUploadFileIcons = p.getCloseuploadfile();
			// Check if each element in the list is displayed
			boolean allDisplayed = true;
			for (WebElement closeIcon : closeUploadFileIcons) {
				if (!closeIcon.isDisplayed()) {
					allDisplayed = false;
					break;
				}
			}

			// If all close icons are displayed, perform actions
			if (allDisplayed) {
				for (WebElement closeIcon : closeUploadFileIcons) {
					Thread.sleep(1000);
					clickjava(closeIcon);
				}
			}
		} catch (NoSuchElementException | IndexOutOfBoundsException e) {
			// Handle cases where elements are not found
			//System.out.println("Close icon(s) not found.");
		}
		
		// upload the documents");
		List<WebElement> allattach = p.getClickattachfile();
		for (int i = 0; i < allattach.size(); i++) {
			clickjava(allattach.get(i));
			sendkey("document", p.getEnterdocumentname());
			Thread.sleep(1000);
			sendkey("testdocument", p.getEnterdocumentdescription());
			Thread.sleep(3000);
			clickjava(p.getClicktobrowse());
			Thread.sleep(1000);
			upload("C:\\Users\\Satheesh S\\Downloads\\file-sample_150kB.pdf");
			Thread.sleep(3000);
			clickjava(p.getClickupload());
			Thread.sleep(3000);

		}
		node.info("click on view and see an all document");
		List<WebElement> allvisible = p.getClickvisbile();
		for (int i = 0; i < allvisible.size(); i++) {
			clickjava(allvisible.get(i));
			Thread.sleep(3000);
			clickjava(p.getClickcloseicon());
			Thread.sleep(3000);

	}
		 node.info("click on next button ");
		 Thread.sleep(3000);
		 clickjava(p.getClicknext());
		 node.info(" user Enter the disclaimer page");
		 Assert.assertTrue(p.getDisplaydiscaimerpage().isDisplayed());
		 node.info("click on checkbox from i agree ");
		 clickjava(p.getDiscalmier());
		 Thread.sleep(3000);
		 node.info("click on submit button");
		 clickjava(p.getClicksubmitbutton());
		 Thread.sleep(2000);
		 node.pass("Applicant successfully submit the application Form. Once the application is submitted, the edit icon does not display.");
		 Assert.assertFalse(p.getClickeditapplicant().isDisplayed());
		
		 

	}
	
	
	
	

}
