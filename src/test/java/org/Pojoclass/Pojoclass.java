package org.Pojoclass;

import java.util.List;

import org.BaseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojoclass extends BaseClass {
	public Pojoclass() {
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	
	//Leads code
	@FindBy(xpath = "//span[text()='Salutation *']")
	private WebElement selectsalutation;
	
	public WebElement getSelectsalutation() {
		return selectsalutation;
	}


	@FindBy(xpath = "//input[@type='email']" )
	private WebElement Enterusername;
	@FindBy(xpath = "//input[@formcontrolname='password']")
	private WebElement Enterpassword;
	@FindBy(id = "kt_login_signin_submit")
	private WebElement login;
	@FindBy(xpath = "//div[@class='mat-tooltip-trigger kt-header__topbar-item kt-header__topbar-item--langs']")
	private WebElement dashboard;
	@FindBy(xpath = "//div[contains(text(),'username ')]")
	private WebElement errormessage;
	@FindBy(xpath ="//div[@id='dropdownBasic1']//img")
	private WebElement clickMenuicon;
	@FindBy(xpath = "//span[text()='CRM']")
	private WebElement clickCrm;
	@FindBy(xpath = "//span[text()='Leads']")
	private WebElement clickLeads;
	@FindBy (xpath = "//i[@class='flaticon2-plus']")
	private WebElement clickadd;
	@FindBy(xpath = "//mat-label[text()='First Name']")
	private WebElement EnterFirstname;
	@FindBy(xpath = "//mat-label[text()='Last Name']")
	private WebElement EnterLastName;
	@FindBy(xpath ="//span[contains(text(),'Gender')]")
	private WebElement ClickGender;
	@FindBy(xpath ="//span[@class='mat-option-text']")
	private List<WebElement> selectgender;
    @FindBy(xpath = "//mat-label[contains(text(),' Date of Birth')]")
	private WebElement clickdateofbirth;
    
	@FindBy(xpath = "//span[@class='owl-dt-control-content owl-dt-control-button-content']")
	private List<WebElement> selectyear;
	@FindBy(xpath = "//table[@class='owl-dt-calendar-table owl-dt-calendar-multi-year-table']/tbody/tr/td")
	private List<WebElement> clickbirthyear;
	@FindBy (xpath = "//span[@class='owl-dt-control-button-content']")
	private List<WebElement>  clickyear;
	@FindBy(xpath = "//table[@class='owl-dt-calendar-table owl-dt-calendar-year-table']/tbody/tr/td")
	private  List<WebElement> selectmonth;
	@FindBy(xpath = "//table[@class='owl-dt-calendar-table owl-dt-calendar-month-table']/tbody/tr/td")
	private List<WebElement> selectdate;
	@FindBy(xpath = "//input[@placeholder='Email Id *']")
	private WebElement Enteremail;
	@FindBy(xpath = "//div[@class='iti__selected-flag dropdown-toggle']")
	private WebElement clickcountryflag;
	@FindBy(id = "country-search-box")
	private WebElement serachcountryflag;
	@FindBy(xpath = "//span[@class='iti__country-name']")
	private List<WebElement> selectcountry;
	@FindBy(id = "phone")
	private WebElement Enterphonenum;
	
	
	
	@FindAll({@FindBy(xpath = "//input[@data-placeholder='Nationality']"),
	@FindBy(xpath = "//input[@data-placeholder='Nationality']")})
	private WebElement clicknationality;
	@FindBy(xpath = "//span[text()='Indian ']")
	private WebElement selectnationality;
	@FindBy(xpath = "//span[contains(text(),'Highest ')]")
	private WebElement clicktqualificationfield;
	@FindBy(xpath = "//span[text()='Matriculation ']")
	private WebElement selectkqualification;
	@FindBy(xpath = "//span[text()='Cycle']")
	private WebElement clicktadmissionfield;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	private List<WebElement> selectadmission;
	@FindBy(xpath = "//span[text()='Program Level of Interest *']")
	private WebElement clickprogramfield;
	@FindBy(xpath = "(//mat-option[@role='option'])[2]")
	private WebElement selectprogramlevel;
	@FindBy(xpath = "//span[contains(text(),'Program To Apply')]")
	private WebElement clickprograminterestfield;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	private List<WebElement> selectprogram1;
	@FindBy(xpath = "//span[text()='Program - 2nd priority']")
	private WebElement clickprogrampriorityfield1;
	@FindBy(xpath = "(//mat-option[@role='option'])[3]")
	private WebElement selectprogram2;
	@FindBy(xpath = "//span[text()='Program - 3rd priority']")
	private WebElement clickprogrampriorityfield2;
	@FindBy(xpath = "(//mat-option[@role='option'])[6]")
	private WebElement selectprogram3;
	@FindBy(xpath = "//span[@class='mat-checkbox-label']")
	private List<WebElement> clicksocialcheckbox;
	@FindBy(xpath = "(//span[@class='mat-radio-inner-circle'])[2]")
	private WebElement clickradioperson;
	@FindBy(id ="form-submit")
	private WebElement clicksubmitbutton;
	@FindBy(xpath = "//mat-label[contains(text(),'Please specify')]")
	private WebElement clickspecifyname;
	@FindBy(xpath = "//div[@class='errorBlock alert alert-outline-dark kt-portlet alert-dismissible mt-2']")
	private WebElement errorleadpage;
	
	//eligble code
	@FindBy(xpath = "//i[@class='flaticon-settings-1']")
	private WebElement clicksettingicon;
	@FindBy(xpath = "(//i[@class='fa fa-chevron-down'])[1]")
	private WebElement clickchangestatus;
	@FindBy(xpath = "(//span[text()='Change Status *'])[2]")
	private WebElement clickstatusfield;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	private List<WebElement> selectstatus;
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement clickupdate;
	@FindBy(xpath = "(//button[text()='Update'])[2]")
	private WebElement leadupdate;
	
	public WebElement getLeadupdate() {
		return leadupdate;
	}


	// view credential code
	@FindBy(xpath = "(//i[@class='flaticon-eye'])[6]")
	private WebElement clickviewcredential;
	@FindBy(xpath = "(//a[@target='_blank'])[2]")
	private WebElement clicklink;
	@FindBy(xpath = "//span[contains(text(),'Username')]")
	private WebElement mouseoverusername;
	@FindBy(xpath = "//span[contains(text(),'Password')]")
	private WebElement mouseoverpassword;
	
	// Admission code
	@FindBy(xpath = "//span[text()='Admission']")
	private WebElement clickadmission;
	@FindBy(id = "kt_aside_toggler")
	private WebElement clicksidemenu;
	@FindBy(xpath = "//span[text()='Application forms']")
	private WebElement clickapplicationforms;
	@FindBy(xpath = "(//i[@class='flaticon-edit'])[1]")
	private WebElement clickediticon;
	@FindBy(id = "form-saveNext")
	private WebElement clicknext;
	
	// Applicant Application code
	@FindBy(xpath = "//mat-icon[text()='create']")
	private WebElement clickeditapplicant;
	@FindBy(xpath = "//input[@placeholder='Passport Number']")
	private WebElement enterpassportno;
	@FindBy(xpath = "//input[@data-placeholder='Country of Citizenship *']")
	private WebElement clickcitizenfields;
	@FindBy(xpath = "//span[text()=' India ']")
	private WebElement selectcitizen;
	@FindBy(xpath = "(//div[@class='iti__selected-flag dropdown-toggle'])[2]")
	private WebElement clickcountryflag2;
	@FindBy(xpath = "(//input[@type='tel'])[2]")
	private WebElement Enterhomecontact;
	@FindBy(xpath = "//input[@placeholder='Alternate Email *']")
	private WebElement Enteralternateemail;
	@FindBy(xpath = "//mat-label[text()='Alternate Mobile Number']")
	private WebElement visiblehome;
	@FindBy(xpath = "(//input[@placeholder='Search Country'])[2]")
	private WebElement Serachcountryflag2;
	@FindBy(xpath = "(//span[text()='India (भारत)'])[2]")
	private WebElement getSelectcountry2;
	@FindBy(xpath = "//input[@data-placeholder='Home Address']")
	private WebElement EnterHomeAdress;
	@FindBy(xpath = "//span[@class='mat-form-field-label-wrapper ng-tns-c99-236']")
	private WebElement Clickcountryfield;
	@FindBy(xpath = "//span[text()=' India ']")
	private WebElement selectindia2;
	@FindBy(xpath ="//span[text()=' Tamil Nadu ']")
	private WebElement selctstate;
	@FindBy(xpath = "//input[@placeholder='City name']")
	private WebElement EntercityName;
	@FindBy(xpath ="//input[@placeholder='Postal/ Zip Code']")
	private WebElement Enterpostalname;
	@FindBy(xpath = "//input[@data-placeholder='State/ Province']")
	private WebElement clickprovince;
	//diploma
	@FindBy(xpath = "(//input[@placeholder='Institutions'])[3]")
	private WebElement institution3;
	@FindBy(xpath = "(//input[@placeholder='Board Name'])[2]")
	private WebElement boardname3;
	@FindBy(xpath = "(//input[@placeholder='Year of passing'])[3]")
	private WebElement yearofpassing3;
	@FindBy(xpath = "(//input[@placeholder='Marking scheme'])[3]")
	private WebElement markingschem3;
	@FindBy(xpath = "(//input[@placeholder='Obtained percentage or CGPA'])[3]")
	private WebElement cgpa4;
	@FindBy(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c102-77']")
	private WebElement mediumofstudy3;
	
	
	
	
	
	
	// academic qualification;
     @FindBy(xpath = "(//input[@data-placeholder='Country'])[2]")
	private WebElement clickacdemiccountryfields;
	@FindBy(xpath = "//input[@placeholder='10th School Name']")
	private WebElement Enteruniversity;
	
	@FindBy(xpath = "//input[@placeholder='10th School Name']")
	private WebElement enterschoolnmae;
	@FindBy(xpath = "//input[@placeholder='10th Board/University']")
	private WebElement enterboarduniversity;
	@FindBy(xpath = "//input[@placeholder='10th Year Of Passing']")
	private WebElement yearofpassing;
	@FindBy(xpath = "/html/body/kt-base/div/div/div[1]/div/div/ng-component/kt-application-edit/dynamic-form/kt-portlet/div/kt-portlet-body/div/div/div/div/div/form/div[5]/div[2]/div/div/div[1]/app-select[1]/div/div/div/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]")
	private WebElement markingscheme;
	@FindBy(xpath = "//input[@placeholder='10th-Percentage/CGPA']")
	private WebElement cgpg10;
	@FindBy(xpath = "/html/body/kt-base/div/div/div[1]/div/div/ng-component/kt-application-edit/dynamic-form/kt-portlet/div/kt-portlet-body/div/div/div/div/div/form/div[5]/div[2]/div/div/div[1]/app-select[3]/div/div/div/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]")
	private WebElement subject10;
	@FindBy(xpath = "/html/body/kt-base/div/div/div[1]/div/div/ng-component/kt-application-edit/dynamic-form/kt-portlet/div/kt-portlet-body/div/div/div/div/div/form/div[5]/div[2]/div/div/div[1]/app-select[2]/div/div/div/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]")
	private WebElement mediumstudy10;
	
    @FindBy(xpath = "(//input[@placeholder='Board Name'])[1]")
    private WebElement Enterattendedform;
	@FindAll({@FindBy(xpath = "(//input[@placeholder='Attended To'])[1]"),@FindBy(xpath = "(//input[@placeholder='Attended To'])[1]")})
    private WebElement Enterattendedto;
	@FindAll({@FindBy(xpath = "(//input[@placeholder='Year of passing'])[1]"),@FindBy(xpath = "(//input[@placeholder='Degree Awarded'])[1]")})
    private WebElement EnterdegreAwarded;
	@FindAll({@FindBy(xpath = "(//input[@placeholder='Major Specialisation'])[1]"),@FindBy(xpath = "(//input[@placeholder='Major Specialisation'])[1]")})
    private WebElement EnterMajorSpecialisation;
	@FindAll({@FindBy(xpath = "(//input[@placeholder='Class of Honours'])[1]"),@FindBy(xpath = "(//input[@placeholder='Class of Honours'])[1]")})
    private WebElement Enterclassofhonours;
	@FindAll({@FindBy(xpath = "(//input[@placeholder='Marking scheme'])[1]"),@FindBy(xpath = "(//input[@placeholder='Overall GPA'])[1]")})
	private WebElement Entergpa;
	@FindAll({@FindBy(xpath = "(//input[@placeholder='Obtained percentage or CGPA'])[1]"),@FindBy(xpath = "(//input[@placeholder='Max. Possible GPA'])[1]")})
    private WebElement Entermaxgpa;
	@FindBy(xpath = "//input[@placeholder='TOEFL/ IELTS/ Bulats']")
	private WebElement EnterTOIEBU;
	@FindBy(xpath = "//span[@class='mat-radio-label-content']")
    private List<WebElement> Clicklanguagecheckbox;
	
  //other academic qualification
	@FindAll({@FindBy(xpath = "(//input[@data-placeholder='Country'])[3]"),@FindBy(xpath = "(//input[@data-placeholder='Country'])[3]")})
	private WebElement clickacdemiccountryfields1;
	@FindAll({@FindBy(xpath = "(//input[@placeholder='Institutions'])[2]"),@FindBy(xpath = "(//input[@placeholder='Name of University'])[2]")})
	private WebElement Enteruniversity1;
	@FindAll({@FindBy(xpath = "(//input[@placeholder='Attended From'])[2]"),@FindBy(xpath = "(//input[@placeholder='Attended From'])[2]")})
    private WebElement Enterattendedform1;
	@FindAll({@FindBy(xpath = "(//input[@placeholder='Year of passing'])[2]"),@FindBy(xpath = "(//input[@placeholder='Attended To'])[2]")})
    private WebElement Enterattendedto1;
	@FindAll({@FindBy(xpath = "(//input[@placeholder='Year of passing'])[2]"),@FindBy(xpath = "(//input[@placeholder='Degree Awarded'])[2]")})
    private WebElement EnterdegreAwarded1;
	@FindAll({@FindBy(xpath = "(//input[@placeholder='Major Specialisation'])[2]"),@FindBy(xpath = "(//input[@placeholder='Major Specialisation'])[2]")})
    private WebElement EnterMajorSpecialisation1;
	@FindAll({@FindBy(xpath = "(//input[@placeholder='Class of Honours'])[2]"),@FindBy(xpath = "(//input[@placeholder='Class of Honours'])[2]")})
    private WebElement Enterclassofhonours1;
	@FindAll({@FindBy(xpath = "(//input[@placeholder='Marking scheme'])[2]"),@FindBy(xpath = "(//input[@placeholder='Overall GPA'])[2]")})
	private WebElement Entergpa1;
	@FindAll({@FindBy(xpath = "(//input[@placeholder='Obtained percentage or CGPA'])[2]"),@FindBy(xpath = "(//input[@placeholder='Max. Possible GPA'])[2]")})
    private WebElement Entermaxgpa1;
	@FindAll({@FindBy(xpath = "(//span[text()='Yes '])[2]"),@FindBy(xpath = "(//span[text()='Yes '])[2]")})
    private WebElement Clicklanguagecheckbox1;
	
	// Employment Details
	@FindBy(xpath = "//input[@placeholder='Employer']")
	private WebElement enteremployer;
	@FindBy(xpath = "//input[@placeholder='Designation']")
	private WebElement Enterdesignation;
	@FindBy(xpath = "//input[@placeholder='Year']")
	private WebElement enteryear;
	@FindBy(xpath = "//input[@placeholder='Months']")
	private WebElement entermonth;
	
	// attach file code
	@FindBy(xpath = "//span[text()='Attach Files']")
	private List<WebElement> clickattachfile;
	
	@FindBy(xpath = "//mat-label[text()='Document Name']")
	private WebElement enterdocumentname;
	@FindBy(xpath = "//mat-label[text()='Document Description']")
	private WebElement enterdocumentdescription;
	@FindBy(xpath = "//h3[text()=' Browse or drag file to upload']")
	private WebElement clicktobrowse;
	@FindBy(xpath = "//span[text()='Upload']")
	private WebElement clickupload;
	@FindBy(xpath = "//mat-icon[text()='visibility']")
	private List<WebElement> clickvisbile;
	@FindBy(xpath = "(//i[@class='la la-close'])[3]")
	private WebElement clickcloseicon;
	
	// Admission module status
	@FindBy(xpath = "//div[text()='Status *']")
	private WebElement clickadmissionstatus;
	
	@FindBy(xpath = "//span[text()='Application Submitted']")
	private WebElement clickapplicationsubmitstatus;
	@FindBy(xpath = "//span[text()='Document verifications']")
	private WebElement clickdocumentverificationstatus;
	@FindBy(xpath = "//span[text()='Document Reupload']")
	private WebElement clickdocumentuploadstatus;
	@FindBy(xpath = "//span[text()='Document re-uploaded']")
	private WebElement clickdocumentreuploadedstatus;
	@FindBy(xpath = "//span[(text()='Document verified')]")
	private WebElement clickdocumentverifiedstatus;
	@FindBy(xpath = "//span[text()='Application  Approved']")
	private WebElement clickapplicationapprovedstatus;
	@FindBy(xpath = "//span[text()='Application Rejected']")
	private WebElement clickapplicationrejected;
	@FindBy(xpath = "//span[text()='Offer letter Accepted']")
	private WebElement clickofferletteraccept;
	@FindBy(xpath = "//span[text()='Offer letter Rejected']")
	private WebElement clickofferletterreject;
	@FindBy(xpath = "//span[text()='Registration Fee Paid']")
	private WebElement clickfeespaidstatus;
	@FindBy(xpath = "//span[text()='Enrolled']")
	private WebElement clickenrolledstatus;
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement clickonyes;
	
	// document code
	@FindBy(id = "tab-documents")
	private WebElement clicktabdocuments;
	@FindBy(xpath = "//i[@class='fa fa-eye']")
	private WebElement clickdocumentview;
	@FindBy(xpath = "//span[text()='COMMUNITY SERVICE']")
	private WebElement scrollview;
	@FindBy(xpath = "//i[@class='fa-check-circle fa text-grey']")
	private List<WebElement> clickapprove;
	@FindBy(id = "tab-status")
	private WebElement clicktabstatus;
	
// applicant accept letter
	@FindBy(xpath = "//mat-icon[text()='visibility']")
	private WebElement clickofferletterviewicon;
	@FindBy(xpath = "//button[text()='Accept offer letter !']")
	private WebElement clickacceptofferletter;
	@FindBy(xpath = "//button[text()='I am not Interested']")
	private WebElement clicknotinterest;
	@FindBy(xpath = "//mat-icon[text()='visibility']")
	private WebElement clickviewoffer;
	@FindBy(id = "tab-offer")
	private WebElement clicktaboffer;
	@FindBy(id = "tab-invoice")
	private WebElement clickinvoice;
	@FindBy(xpath = "//a[text()='Pay']")
	private WebElement clickpay;
	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement clickdashonvoicedashboard;
	@FindBy(xpath = "//textarea[@class='swal2-textarea']")
	private WebElement entercomments;
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement clickrejectsubmit;
	
	
	// enroll code 
	@FindBy(xpath = "//span[text()='Academics']")
	private WebElement ClickAcademics;
	@FindBy(xpath = "//span[text()='Programs']")
	private WebElement clickacademicprograms;
	@FindBy(xpath = "//span[text()='Student Enrollment']")
	private WebElement Clickenrollment;
	@FindBy(xpath = "//span[text()='Yet to enroll ']")
	private WebElement clickyetenroll;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement clickenrollcheck;
	@FindBy(xpath = "//span[text()=' Actions ']")
	private WebElement clickactions;
	@FindBy(xpath = "//span[text()='Enroll']")
	private WebElement clickenroll;
	@FindBy(xpath = "//div[text()='Select Academic Year']")
	private WebElement clickacademicyaerfield;
	@FindBy(xpath = "//div[@class='ng-star-inserted']")
	private List<WebElement> selectacademicyear;
	@FindBy(xpath = "//div[text()='Select Semster']")
	private WebElement clicksemsterfield;
	@FindBy(xpath = "//div[text()='Test_Sem2405']")
	private WebElement selectsem;
	@FindBy(xpath = "//div[text()='Select Program']")
	private WebElement clickenrollprogramfield;
	@FindBy(xpath = "//div[text()='Test_PGM001']")
	private WebElement selectprogram;
	@FindBy(xpath = "//div[text()='Select ProgramSection']")
	private WebElement clickprogramsectionfield;
	@FindBy(xpath = "//div[text()='Test_PGM001-A']")
	private WebElement slectprogramsection;
	@FindBy(xpath = "//div[text()=' Enroll ']")
	private WebElement clickstudentenroll;
	
	// EDIT Application code 
	@FindBy(xpath = "//input[@data-placeholder='Program *']")
	private WebElement clickeditprogram;
	@FindBy(xpath = "//span[text()=' Master of Business Administration ']")
	private WebElement selecteditprogram;
	
	//View Code
	@FindBy(xpath = "//div[text()='Personal Details']")
	private WebElement clickpersonaldeatils;
	@FindBy(xpath = "//div[@class='kt-portlet__body']")
	private WebElement clickscroll;
	@FindBy(xpath = "//div[text()='Academic Qualifications']")
	private WebElement viewacademic;
	@FindBy(xpath = "//div[text()='Employment Details']")
	private WebElement viewemployedeatils;
	@FindBy(xpath = "//div[text()='Documents']")
	private WebElement viewdocuments;
	@FindBy(xpath = "//img[@class='ctx-close-icon']")
	private WebElement viewclose;
	
	// manadtory code 
	@FindBy(xpath = "//div[contains(text(),'Please check the mandatory fields')]")
	private WebElement checkmandatory;
	@FindBy(xpath = "//ul[@class='mt-2 mb-0']")
	private WebElement errorfield;
	
	
	@FindBy(xpath = "//input[@placeholder='Search by Name']")
	private WebElement searchallname;
	
	//Filter Code 
	@FindBy(xpath = "//i[@class='flaticon2-dashboard']")
	private WebElement clickfilter;
	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement Entername;
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement Enteremailfield;
	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[1]")
	private WebElement filterprogram;
	
	
	
	
	
	
	@FindBy(xpath = "//span[contains(text(),'Lead Successfully Submitted. Kindly check your E-mail')]")
	private WebElement leadsdisplay;
	@FindBy(xpath = "//div[contains(text(),'Please check the mandatory fields')]")
	private WebElement errormessagelead;
	@FindBy(xpath = "//input[@class='form-control kt-quick-search__input']")
	private WebElement leadssearchbar;
	@FindBy(xpath = "//i[@class='flaticon-eye']")
	private WebElement clickleadview;
	@FindBy(xpath = "//button[contains(text(),' Preview ')]")
	private WebElement clickpreview;
	@FindBy(xpath = "//i[@class='flaticon-download-1']")
	private WebElement clickdownload;
	@FindBy(xpath = "//label[@class='mat-tooltip-trigger labelHeading ng-star-inserted']")
	private List<WebElement> clickallactivity;
	@FindBy(xpath = "//textarea[@data-placeholder='Enter comments']")
	private List<WebElement> enterleadcomments;
	@FindBy(xpath = "//h3[contains(text(),' Eligible')]")
	private WebElement statusdisplay;
	@FindBy(xpath = "//span[contains(text(),'Lead Process flow')]")
	private WebElement displayiukl;
	@FindBy(xpath = "//i[@class='flaticon2-cross']")
	private WebElement closepreview;
	
	@FindBy(xpath = "//input[@data-placeholder=\"Gender *\"]")
	private WebElement applicantgender;
	 @FindAll({
	        @FindBy(xpath = "/html/body/kt-base/div/div/div[1]/div/div/ng-component/kt-application-edit/dynamic-form/kt-portlet/div/kt-portlet-body/div/div/div/div/div/form/div[2]/div[2]/div/div/div[1]/app-date/div/div/div/mat-form-field/div/div[1]/div[3]/input"),
	        @FindBy(xpath = "//input[@placeholder='Date Of Birth *']")
	    })
	private WebElement applicantdateofbirth;
	@FindBy(xpath = "//input[@data-placeholder='Country of Residence *']")
	private WebElement countryofresidence;
	@FindBy(xpath = "(//input[@data-placeholder='Country *'])[1]")
	private WebElement clickapplicantcountry;
	@FindBy(xpath = "//input[@data-placeholder='State']")
	private WebElement applicantstate;
	@FindBy(xpath = "//input[@data-placeholder='Study Level']")
	private WebElement enterstudylevel;
	 @FindAll({
	        @FindBy(xpath = "/html/body/kt-base/div/div/div[1]/div/div/ng-component/kt-application-edit/dynamic-form/kt-portlet/div/kt-portlet-body/div/div/div/div/div/form/div[2]/div[2]/div/div/div[1]/app-select[1]/div/div/div/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]"),
	        @FindBy(xpath = "//span[text()='Marital status']")
	    })
	private WebElement martialstatus;
	 
	 @FindAll({@FindBy(xpath = "//*[@id=\"c_gender\"]/div/div/mat-form-field/div/div[1]/div[3]"),
		 @FindBy(xpath = "//span[contains(text(),'Gender')]")})
		private WebElement clickgendervalue;
	 
	 
	 @FindBy(xpath = "/html/body/kt-base/div/div/div[1]/div/div/ng-component/kt-application-edit/dynamic-form/kt-portlet/div/kt-portlet-body/div/div/div/div/div/form/div[2]/div[2]/div/div/div[1]/app-select[3]/div/div/div/mat-form-field/div/div[1]/div[3]")
	  private WebElement clickphysicaldisabled;
	 
	 @FindBy(xpath = "/html/body/kt-base/div/div/div[1]/div/div/ng-component/kt-application-edit/dynamic-form/kt-portlet/div/kt-portlet-body/div/div/div/div/div/form/div[2]/div[2]/div/div/div[1]/app-select[5]/div/div/div/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]")
	 private WebElement clickhostelreqired;
	 
	 @FindBy(xpath = "//input[@placeholder='Blood Group']")
	private WebElement bloodgroup;
	@FindBy(xpath = "//input[@placeholder='Aadhar No']")
	private WebElement aadharno;
	
	@FindBy(xpath = "//input[@data-placeholder='Religion']")
	private WebElement clickreligion;
	@FindBy(xpath = "//input[@placeholder='Date of issue']")
	private WebElement clickdateofissue;
	@FindBy(xpath = "//input[@placeholder='Date of expiry']")
	private WebElement dateofexpiry;
	@FindBy(xpath = "/html/body/kt-base/div/div/div[1]/div/div/ng-component/kt-application-edit/dynamic-form/kt-portlet/div/kt-portlet-body/div/div/div/div/div/form/div[2]/div[2]/div/div/div[2]/app-select[4]/div/div/div/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span")
	private WebElement clicktransport;
	@FindBy(xpath = "//span[@class='mat-radio-label-content']")
	private List<WebElement>  CorrespondenceAddress;
	@FindBy(xpath = "(//div[@class='angular-editor-textarea'])[2]")
	private WebElement entertextarea1;
	@FindBy(xpath = "//input[@placeholder='District name']")
	private WebElement enterdistrictname;
	@FindBy(xpath = "//input[@data-placeholder='Pincode']")
	private WebElement enterpincode;
	@FindBy(xpath = "//input[@data-placeholder='Country name']")
	private WebElement entercountryname;
	@FindBy(xpath = "/html/body/kt-base/div/div/div[1]/div/div/ng-component/kt-application-edit/dynamic-form/kt-portlet/div/kt-portlet-body/div/div/div/div/div/form/div[2]/div[2]/div/div/div[2]/app-select[3]/div/div/div/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span")
	private WebElement catagory;
   @FindBy(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c102-47']")
   private WebElement fathetitle;
   @FindBy(xpath = "//input[@placeholder='Father occupation']")
   private WebElement fatheroccupation;
   @FindBy(xpath = "//input[@placeholder='Father email address']")
   private WebElement fatheremail;
   @FindBy(xpath = "//input[@placeholder='Father Name']")
   private WebElement fathername;
   @FindBy(xpath = "//input[@placeholder='Father annual income']")
   private WebElement fatherincome;
   @FindBy(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c102-53']")
   private WebElement mothertitle;
   @FindBy(xpath = "//input[@placeholder='Mother Name']")
   private WebElement mothername;
   @FindBy(xpath = "//input[@placeholder='Mother email address']")
   private WebElement motheremailaddress;
   @FindBy(xpath = "//input[@placeholder='Mother occupation']")
   private WebElement motheroccupation;
   @FindBy(xpath = "(//div[@class='iti__selected-flag dropdown-toggle'])[3]")
   private WebElement parentcountryflag;
   @FindBy(id ="country-search-box")
   private WebElement searchparentcountry;
   @FindBy(xpath = "(//input[@type='tel'])[3]")
   private WebElement enterparentnumber;
  @FindBy(xpath = "(//div[@class='iti__selected-flag dropdown-toggle'])[4]")
  private WebElement mothercountryflag;
  @FindBy(id = "country-search-box")
  private WebElement mothersearchcountry;
  @FindBy(xpath = "(//input[@type='tel'])[4]")
  private WebElement mothernumber;
  @FindBy(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c102-63']")
  private WebElement mediumofstudy;
   @FindBy(xpath = "(//div[@class='angular-editor-textarea'])[3]")
   private WebElement textarea2;
   @FindBy(xpath = "//input[@placeholder='Board name']")
   private WebElement boardname2;
   
   @FindBy(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c102-70']")
   private WebElement mediumofstudy2;
   @FindBy(xpath = "(//div[@class='angular-editor-textarea'])[4]")
   private WebElement textarea3;
   @FindBy(xpath = "(//div[@class='angular-editor-textarea'])[5]")
   private WebElement textarea4;
   @FindBy(xpath = "//span[@class='mat-checkbox-label']")
   private WebElement discalmier;
   
   @FindBy(xpath = "//div[@class='mat-tab-label-content']")
   private List<WebElement> viewapplication;
   
   @FindBy(xpath = "//a[@class='nav-link']")
   private List<WebElement> allfieldopen;
   
   @FindBy(xpath = "//span[text()='Enrolled  ']")
   private WebElement clickstudentenrolled;
   @FindBy(xpath = "(//i[@class='la la-close'])[3]")
   private WebElement mandatorycloseicon;
   
   
   
   
   
   // admission cycle code 
   @FindBy(xpath = "//span[contains(text(),'Cycle')]")
   private WebElement clickcycle;
   @FindBy(xpath = "//input[@placeholder='Admission Cycle Name *']")
   private WebElement clickadmissioncycle;
   @FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[1]")
   private WebElement cycleprogram;
   @FindBy(xpath = "//button[text()=' Select All']")
   private WebElement selectall;
   @FindBy(xpath = "//button[text()=' Clear All']")
   private WebElement clearall;
   
   @FindBy(xpath = "//input[@placeholder='Semester *']")
   private WebElement clicksemester;
   @FindBy(xpath = "//span[text()='Application Form *']")
   private WebElement clickapplicationform;
   @FindBy(xpath = "//input[@placeholder='Batch *']")
   private WebElement clickbatch;
   @FindBy(xpath = "//input[@placeholder='App - Start Value *']")
   private WebElement clickappsatrtvalue;
   @FindBy(xpath = "//input[@placeholder='App - Prefix *']")
   private WebElement clickappprefix;
   @FindBy(xpath = "//input[@placeholder='Current Value']")
   private WebElement entercurrentvalue;
   @FindBy(xpath = "//input[@placeholder='Cut-Off Dates *']")
   private WebElement cutoffdate;
   @FindBy(xpath = "//input[@placeholder='Status Rule *']")
   private WebElement enterstatusrole;
   @FindBy(xpath = "//span[text()='Accept Offer']")
   private WebElement enteracceptoffer;
   @FindBy(xpath = "//input[@placeholder=\"Show on status\"]")
   private WebElement showonstatus;
   @FindBy(xpath = "//input[@placeholder='On Accept change status to']")
   private WebElement enterplaceholder;
   @FindBy(xpath = "//input[@placeholder='Start Date *']")
   private WebElement startdate;
   
   @FindBy(xpath = "//div[@class='mat-ripple mat-option-ripple']")
   private List<WebElement> enterallstatus;
   @FindBy(xpath = "//span[text()=' Application  Approved ']")
   private WebElement clickappliactionAproved;
   @FindBy(xpath = "//input[@placeholder='On Reject change status to']")
   private WebElement offterletterreject;
   @FindBy(xpath = "//span[text()='Status *']")
   private WebElement clickactive;
   
   
   
   @FindBy(xpath = "//input[@placeholder='10th School Name']")
   private WebElement enterschoolname;
   @FindBy(xpath = "//input[@placeholder='10th Board/University']")
   private WebElement enterschoolboard;
   @FindBy(xpath = "//input[@placeholder='10th Year Of Passing']")
   private WebElement enter10thpassing;
   @FindBy(xpath = "//input[@placeholder='10th-Percentage/CGPA']")
   private WebElement enter10thggpa;
   @FindBy(xpath = "//input[@placeholder='12th School/College Name']")
   private WebElement enter12thcollegename;
   @FindBy(xpath = "//input[@placeholder='12th Board/University']")
   private WebElement enter12thboardname;
   @FindBy(xpath = "//input[@placeholder='12th Year Of Passing']")
   private WebElement enter12thpassing;
   @FindBy(xpath = "//input[@placeholder='12th Percentage/CGPA']")
   private WebElement enter12thggpa;
   
   @FindBy(xpath = "//span[@class='mat-option-text']")
   private List<WebElement> allsalutation;
   @FindBy(xpath = "//i[@class='flaticon-eye']")
   private WebElement clickview;
   
   @FindBy(xpath = "//img[@alt='close']")
   private WebElement viewleadclose;
   @FindBy(xpath = "//strong[@class='kt-link kt-link--brand kt-font-bolder']")
   private List<WebElement> activityupdateddisplay;
   @FindBy(xpath = "//div[@class='kt-widget kt-widget--user-profile-3 ng-star-inserted']")
   private WebElement basicdeatilsdisplay;
   @FindBy(xpath = "//span[text()='Lead Process flow']")
   private WebElement leadprocess;
   @FindBy(xpath = "//div[@class='errorBlock alert alert-outline-dark kt-portlet alert-dismissible mt-2']")
   private WebElement applicatioformerror;
   @FindBy(xpath = "//div[@class='kt-heading kt-heading--md'][normalize-space()='Address Details']")
   private WebElement addressdeatilsdisplay;
   @FindBy(xpath = "//div[@class='kt-heading kt-heading--md'][normalize-space()='Parents details']")
   private WebElement parentdeatilsdisplay;
   

	@FindBy(xpath = "//div[@class='kt-heading kt-heading--md'][normalize-space()='Education details']")
	private WebElement educationalpagedisplay;
	@FindBy(xpath = "/html/body/kt-base/div/div/div[1]/div/div/ng-component/kt-application-edit/dynamic-form/kt-portlet/div/kt-portlet-body/div/div/div/div/div/form/div[5]/div[2]/div/div/div[1]/app-select[4]/div/div/div/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]")
	private WebElement markingschem12;
	@FindBy(xpath = "/html/body/kt-base/div/div/div[1]/div/div/ng-component/kt-application-edit/dynamic-form/kt-portlet/div/kt-portlet-body/div/div/div/div/div/form/div[5]/div[2]/div/div/div[1]/app-select[5]/div/div/div/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span")
	private WebElement medium12;
	@FindBy(xpath = "/html/body/kt-base/div/div/div[1]/div/div/ng-component/kt-application-edit/dynamic-form/kt-portlet/div/kt-portlet-body/div/div/div/div/div/form/div[5]/div[2]/div/div/div[1]/app-select[6]/div/div/div/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]")
	private WebElement subject12;
	@FindBy(xpath = "//div[@class='kt-heading kt-heading--md'][normalize-space()='Documents']")
	private WebElement documentspagesdisplay;
	@FindBy(xpath = "//div[@class='kt-heading kt-heading--md'][normalize-space()='Disclaimer']")
	private WebElement displaydiscaimerpage;
	@FindBy(xpath = "//mat-icon[normalize-space()='close']")
	private List<WebElement> closeuploadfile;
	@FindBy(xpath = "//button[text()=' Draft ']")
	private WebElement clickdraft;
    @FindBy(xpath = "//div[@class='kt-widget__bottom']")
    private WebElement viewonapplicationdeatils;
    @FindBy(xpath = "//div[@class='kt-portlet']//div[@class='kt-portlet__body']")
    private WebElement admissionpreview;
    @FindBy(xpath = "//mat-expansion-panel-header[@role='button']")
    private List<WebElement> clickallarrow;
    @FindBy(xpath = "//div[@role='region']")
    private List<WebElement> viewalldeatilsadmission;
    @FindBy(xpath = "//i[@class='fa fa-eye']")
    private List<WebElement> documentviewadmission;
    @FindBy(xpath = "//i[@class='fa-times-circle fa text-grey']")
    private List<WebElement> rejectdocument;
    





	public List<WebElement> getRejectdocument() {
		return rejectdocument;
	}


	public List<WebElement> getDocumentviewadmission() {
		return documentviewadmission;
	}


	public List<WebElement> getViewalldeatilsadmission() {
		return viewalldeatilsadmission;
	}


	public List<WebElement> getClickallarrow() {
		return clickallarrow;
	}


	public WebElement getAdmissionpreview() {
		return admissionpreview;
	}


	public WebElement getViewonapplicationdeatils() {
		return viewonapplicationdeatils;
	}


	public WebElement getClickdraft() {
	return clickdraft;
}


	public WebElement getDisplaydiscaimerpage() {
	return displaydiscaimerpage;
}


public List<WebElement> getCloseuploadfile() {
	return closeuploadfile;
}


	public WebElement getDocumentspagesdisplay() {
	return documentspagesdisplay;
}


	public WebElement getMarkingschem12() {
	return markingschem12;
}


public WebElement getMedium12() {
	return medium12;
}


public WebElement getSubject12() {
	return subject12;
}


	public WebElement getMediumstudy10() {
	return mediumstudy10;
}


	public WebElement getMarkingscheme() {
	return markingscheme;
}


public WebElement getCgpg10() {
	return cgpg10;
}


public WebElement getSubject10() {
	return subject10;
}


	public WebElement getEducationalpagedisplay() {
	return educationalpagedisplay;
}


	public WebElement getParentdeatilsdisplay() {
	return parentdeatilsdisplay;
}


	public WebElement getAddressdeatilsdisplay() {
	return addressdeatilsdisplay;
}


	public WebElement getClicktransport() {
	return clicktransport;
}


	public WebElement getClickhostelreqired() {
	return clickhostelreqired;
}


	public WebElement getClickphysicaldisabled() {
	return clickphysicaldisabled;
}


	public WebElement getClickgendervalue() {
	return clickgendervalue;
}


	public WebElement getApplicatioformerror() {
	return applicatioformerror;
}


	public WebElement getLeadprocess() {
	return leadprocess;
}


	public WebElement getBasicdeatilsdisplay() {
	return basicdeatilsdisplay;
}


	public List<WebElement> getActivityupdateddisplay() {
	return activityupdateddisplay;
}


	public WebElement getViewleadclose() {
	return viewleadclose;
}


	public WebElement getClickview() {
	return clickview;
}


	public List<WebElement> getAllsalutation() {
	return allsalutation;
}


	public WebElement getEnterschoolname() {
	return enterschoolname;
}


public WebElement getEnterschoolboard() {
	return enterschoolboard;
}


public WebElement getEnter10thpassing() {
	return enter10thpassing;
}


public WebElement getEnter10thggpa() {
	return enter10thggpa;
}


public WebElement getEnter12thcollegename() {
	return enter12thcollegename;
}


public WebElement getEnter12thboardname() {
	return enter12thboardname;
}


public WebElement getEnter12thpassing() {
	return enter12thpassing;
}


public WebElement getEnter12thggpa() {
	return enter12thggpa;
}


	public WebElement getOffterletterreject() {
	return offterletterreject;
}


public WebElement getClickactive() {
	return clickactive;
}


	public WebElement getClickappliactionAproved() {
	return clickappliactionAproved;
}


	public List<WebElement> getEnterallstatus() {
	return enterallstatus;
}


	public WebElement getStartdate() {
	return startdate;
}


	public WebElement getSelectall() {
	return selectall;
}


public WebElement getClearall() {
	return clearall;
}


	public WebElement getClickadmissioncycle() {
	return clickadmissioncycle;
}


public WebElement getCycleprogram() {
	return cycleprogram;
}


public WebElement getClicksemester() {
	return clicksemester;
}


public WebElement getClickapplicationform() {
	return clickapplicationform;
}


public WebElement getClickbatch() {
	return clickbatch;
}


public WebElement getClickappsatrtvalue() {
	return clickappsatrtvalue;
}


public WebElement getClickappprefix() {
	return clickappprefix;
}


public WebElement getEntercurrentvalue() {
	return entercurrentvalue;
}


public WebElement getCutoffdate() {
	return cutoffdate;
}


public WebElement getEnterstatusrole() {
	return enterstatusrole;
}


public WebElement getEnteracceptoffer() {
	return enteracceptoffer;
}


public WebElement getShowonstatus() {
	return showonstatus;
}


public WebElement getEnterplaceholder() {
	return enterplaceholder;
}


	public WebElement getEnterschoolnmae() {
	return enterschoolnmae;
}


public WebElement getEnterboarduniversity() {
	return enterboarduniversity;
}


public WebElement getYearofpassing() {
	return yearofpassing;
}


public WebElement getClickcycle() {
	return clickcycle;
}


	public WebElement getMandatorycloseicon() {
	return mandatorycloseicon;
}


	public WebElement getClickstudentenrolled() {
	return clickstudentenrolled;
}


	public List<WebElement> getAllfieldopen() {
	return allfieldopen;
}


	public List<WebElement> getViewapplication() {
	return viewapplication;
}


	public WebElement getDiscalmier() {
	return discalmier;
}


	public WebElement getInstitution3() {
	return institution3;
}


public WebElement getBoardname3() {
	return boardname3;
}


public WebElement getYearofpassing3() {
	return yearofpassing3;
}


public WebElement getMarkingschem3() {
	return markingschem3;
}


public WebElement getCgpa4() {
	return cgpa4;
}


public WebElement getMediumofstudy3() {
	return mediumofstudy3;
}


public WebElement getTextarea4() {
	return textarea4;
}


	public WebElement getTextarea3() {
	return textarea3;
}


	public WebElement getMediumofstudy2() {
	return mediumofstudy2;
}


	public WebElement getBoardname2() {
	return boardname2;
}


	public WebElement getMediumofstudy() {
	return mediumofstudy;
}


public WebElement getTextarea2() {
	return textarea2;
}


	public WebElement getMothercountryflag() {
	return mothercountryflag;
}


public WebElement getMothersearchcountry() {
	return mothersearchcountry;
}


public WebElement getMothernumber() {
	return mothernumber;
}


	public WebElement getParentcountryflag() {
	return parentcountryflag;
}


public WebElement getSearchparentcountry() {
	return searchparentcountry;
}


public WebElement getEnterparentnumber() {
	return enterparentnumber;
}


	public WebElement getFathetitle() {
	return fathetitle;
}


public WebElement getFatheroccupation() {
	return fatheroccupation;
}


public WebElement getFatheremail() {
	return fatheremail;
}


public WebElement getFathername() {
	return fathername;
}


public WebElement getFatherincome() {
	return fatherincome;
}


public WebElement getMothertitle() {
	return mothertitle;
}


public WebElement getMothername() {
	return mothername;
}


public WebElement getMotheremailaddress() {
	return motheremailaddress;
}


public WebElement getMotheroccupation() {
	return motheroccupation;
}


	public WebElement getCatagory() {
		return catagory;
	}


	public WebElement getEntercountryname() {
		return entercountryname;
	}


	public List<WebElement> getCorrespondenceAddress() {
		return CorrespondenceAddress;
	}


	public WebElement getEntertextarea1() {
		return entertextarea1;
	}


	public WebElement getEnterdistrictname() {
		return enterdistrictname;
	}


	public WebElement getEnterpincode() {
		return enterpincode;
	}


	public WebElement getClickreligion() {
		return clickreligion;
	}


	public WebElement getClickdateofissue() {
		return clickdateofissue;
	}


	public WebElement getDateofexpiry() {
		return dateofexpiry;
	}


	public WebElement getBloodgroup() {
		return bloodgroup;
	}


	public WebElement getAadharno() {
		return aadharno;
	}


	public WebElement getMartialstatus() {
		return martialstatus;
	}


	public WebElement getEnterstudylevel() {
		return enterstudylevel;
	}


	public WebElement getMouseoverpassword() {
		return mouseoverpassword;
	}


	public WebElement getApplicantstate() {
		return applicantstate;
	}


	public WebElement getClickapplicantcountry() {
		return clickapplicantcountry;
	}


	public WebElement getCountryofresidence() {
		return countryofresidence;
	}


	public WebElement getApplicantdateofbirth() {
		return applicantdateofbirth;
	}


	public WebElement getApplicantgender() {
		return applicantgender;
	}


	public WebElement getClosepreview() {
		return closepreview;
	}


	public WebElement getLeadssearchbar() {
		return leadssearchbar;
	}


	public WebElement getClickleadview() {
		return clickleadview;
	}


	public WebElement getClickpreview() {
		return clickpreview;
	}


	public WebElement getClickdownload() {
		return clickdownload;
	}


	public List<WebElement> getClickallactivity() {
		return clickallactivity;
	}


	public List<WebElement> getEnterleadcomments() {
		return enterleadcomments;
	}


	public WebElement getStatusdisplay() {
		return statusdisplay;
	}


	public WebElement getDisplayiukl() {
		return displayiukl;
	}


	public WebElement getErrormessagelead() {
		return errormessagelead;
	}


	public WebElement getLeadsdisplay() {
		return leadsdisplay;
	}


	public WebElement getErrormessage() {
		return errormessage;
	}


	public WebElement getFilterprogram() {
		return filterprogram;
	}


	public WebElement getEnteremailfield() {
		return Enteremailfield;
	}


	public WebElement getClickfilter() {
		return clickfilter;
	}


	public WebElement getEntername() {
		return Entername;
	}


	public WebElement getSearchallname() {
		return searchallname;
	}


	public WebElement getErrorfield() {
		return errorfield;
	}


	public WebElement getCheckmandatory() {
		return checkmandatory;
	}


	public WebElement getViewclose() {
		return viewclose;
	}


	public WebElement getViewacademic() {
		return viewacademic;
	}


	public WebElement getViewemployedeatils() {
		return viewemployedeatils;
	}


	public WebElement getViewdocuments() {
		return viewdocuments;
	}


	public WebElement getClickscroll() {
		return clickscroll;
	}


	public WebElement getClickpersonaldeatils() {
		return clickpersonaldeatils;
	}


	public WebElement getClickeditprogram() {
		return clickeditprogram;
	}


	public WebElement getSelecteditprogram() {
		return selecteditprogram;
	}


	public WebElement getClickrejectsubmit() {
		return clickrejectsubmit;
	}


	public WebElement getEntercomments() {
		return entercomments;
	}


	public WebElement getClickstudentenroll() {
		return clickstudentenroll;
	}


	public WebElement getClicksemsterfield() {
		return clicksemsterfield;
	}


	public WebElement getSelectsem() {
		return selectsem;
	}


	public WebElement getClickenrollprogramfield() {
		return clickenrollprogramfield;
	}


	public WebElement getSelectprogram() {
		return selectprogram;
	}


	public WebElement getClickprogramsectionfield() {
		return clickprogramsectionfield;
	}


	public WebElement getSlectprogramsection() {
		return slectprogramsection;
	}


	public List<WebElement> getSelectacademicyear() {
		return selectacademicyear;
	}


	public WebElement getClickdashonvoicedashboard() {
		return clickdashonvoicedashboard;
	}


	public WebElement getClickAcademics() {
		return ClickAcademics;
	}




	public WebElement getClickacademicprograms() {
		return clickacademicprograms;
	}


	public WebElement getClickenrollment() {
		return Clickenrollment;
	}


	public WebElement getClickyetenroll() {
		return clickyetenroll;
	}


	public WebElement getClickenrollcheck() {
		return clickenrollcheck;
	}


	public WebElement getClickactions() {
		return clickactions;
	}


	public WebElement getClickenroll() {
		return clickenroll;
	}


	public WebElement getClickacademicyaerfield() {
		return clickacademicyaerfield;
	}


	public WebElement getClickinvoice() {
		return clickinvoice;
	}


	public WebElement getClickpay() {
		return clickpay;
	}


	public WebElement getClicktaboffer() {
		return clicktaboffer;
	}


	public WebElement getClickviewoffer() {
		return clickviewoffer;
	}


	public WebElement getClickofferletterviewicon() {
		return clickofferletterviewicon;
	}


	public WebElement getClickacceptofferletter() {
		return clickacceptofferletter;
	}


	public WebElement getClicknotinterest() {
		return clicknotinterest;
	}


	public WebElement getClicktabstatus() {
		return clicktabstatus;
	}


	public List<WebElement> getClickapprove() {
		return clickapprove;
	}


	public WebElement getClicktabdocuments() {
		return clicktabdocuments;
	}


	public WebElement getClickdocumentview() {
		return clickdocumentview;
	}


	public WebElement getScrollview() {
		return scrollview;
	}


	public WebElement getClickonyes() {
		return clickonyes;
	}


	public WebElement getClickadmissionstatus() {
		return clickadmissionstatus;
	}


	public List<WebElement> getClickvisbile() {
		return clickvisbile;
	}


	public WebElement getClickcloseicon() {
		return clickcloseicon;
	}


	public WebElement getClickupload() {
		return clickupload;
	}


	public WebElement getClickprovince() {
		return clickprovince;
	}


	public WebElement getEnterpostalname() {
		return Enterpostalname;
	}


	public WebElement getEntercityName() {
		return EntercityName;
	}


	public WebElement getSelctstate() {
		return selctstate;
	}


	public WebElement getEnterHomeAdress() {
		return EnterHomeAdress;
	}


	public WebElement getClickcountryfield() {
		return Clickcountryfield;
	}


	public WebElement getSelectindia2() {
		return selectindia2;
	}


	public WebElement getGetSelectcountry2() {
		return getSelectcountry2;
	}


	public WebElement getSerachcountryflag2() {
		return Serachcountryflag2;
	}


	public WebElement getVisiblehome() {
		return visiblehome;
	}


	public WebElement getClickcountryflag2() {
		return clickcountryflag2;
	}
	

	// leadscode
	public WebElement getClicksubmitbutton() {
		return clicksubmitbutton;
	}
	public WebElement getEnterusername() {
		return Enterusername;
	}
	public WebElement getEnterpassword() {
		return Enterpassword;
	}
	public WebElement getLogin() {
		return login;
	}
	public WebElement getDashboard() {
		return dashboard;
	}
	public WebElement getClickMenuicon() {
		return clickMenuicon;
	}
	public WebElement getClickCrm() {
		return clickCrm;
	}
	public WebElement getClickLeads() {
		return clickLeads;
	}
	public WebElement getClickadd() {
		return clickadd;
	}
	public WebElement getEnterFirstname() {
		return EnterFirstname;
	}
	public WebElement getEnterLastName() {
		return EnterLastName;
	}
	public WebElement getClickGender() {
		return ClickGender;
	}
	
	
	public List<WebElement> getSelectgender() {
		return selectgender;
	}


	public WebElement getClickdateofbirth() {
		return clickdateofbirth;
	}
	public List<WebElement> getSelectyear() {
		return selectyear;
	}
	
	public List<WebElement> getClickbirthyear() {
		return clickbirthyear;
	}


	public List<WebElement> getClickyear() {
		return clickyear;
	}


	public List<WebElement> getSelectmonth() {
		return selectmonth;
	}


	public List<WebElement> getSelectdate() {
		return selectdate;
	}


	public WebElement getEnteremail() {
		return Enteremail;
	}
	public WebElement getClickcountryflag() {
		return clickcountryflag;
	}
	public WebElement getSerachcountryflag() {
		return serachcountryflag;
	}
	public List<WebElement> getSelectcountry() {
		return selectcountry;
	}
	public WebElement getEnterphonenum() {
		return Enterphonenum;
	}
	public WebElement getClicknationality() {
		return clicknationality;
	}
	public WebElement getSelectnationality() {
		return selectnationality;
	}
	public WebElement getClicktqualificationfield() {
		return clicktqualificationfield;
	}
	public WebElement getSelectkqualification() {
		return selectkqualification;
	}
	public WebElement getClicktadmissionfield() {
		return clicktadmissionfield;
	}
	public List<WebElement> getSelectadmission() {
		return selectadmission;
	}
	public WebElement getClickprogramfield() {
		return clickprogramfield;
	}
	public WebElement getSelectprogramlevel() {
		return selectprogramlevel;
	}
	public WebElement getClickprograminterestfield() {
		return clickprograminterestfield;
	}
	public List<WebElement> getSelectprogram1() {
		return selectprogram1;
	}
	public WebElement getClickprogrampriorityfield1() {
		return clickprogrampriorityfield1;
	}
	public WebElement getSelectprogram2() {
		return selectprogram2;
	}
	public WebElement getClickprogrampriorityfield2() {
		return clickprogrampriorityfield2;
	}
	public WebElement getSelectprogram3() {
		return selectprogram3;
	
	}
	public List<WebElement> getClicksocialcheckbox() {
		return clicksocialcheckbox;
	}
	
	public WebElement getClickspecifyname() {
		return clickspecifyname;
	}


	public WebElement getClickradioperson() {
		return clickradioperson;
	}
	// eligble code 
	public WebElement getClicksettingicon() {
		return clicksettingicon;
	}
	public WebElement getClickchangestatus() {
		return clickchangestatus;
	}
	public WebElement getClickstatusfield() {
		return clickstatusfield;
	}
	public List<WebElement> getSelectstatus() {
		return selectstatus;
	}
	public WebElement getClickupdate() {
		return clickupdate;
	}
	public WebElement getClickviewcredential() {
		return clickviewcredential;
	}

	public WebElement getClicklink() {
		return clicklink;
	}
	public WebElement getMouseoverusername() {
		return mouseoverusername;
	}
	public WebElement getClickadmission() {
		return clickadmission;
	}
	public WebElement getClicksidemenu() {
		return clicksidemenu;
	}
	
	// Applicant details
	public WebElement getClickapplicationforms() {
		return clickapplicationforms;
	}
	public WebElement getClickediticon() {
		return clickediticon;
	}
	public WebElement getClicknext() {
		return clicknext;
	}
	public WebElement getClickeditapplicant() {
		return clickeditapplicant;
	}
	public WebElement getEnterpassportno() {
		return enterpassportno;
	}
	public WebElement getClickcitizenfields() {
		return clickcitizenfields;
	}
	public WebElement getSelectcitizen() {
		return selectcitizen;
	}
	public WebElement getEnterhomecontact() {
		return Enterhomecontact;
	}
	public WebElement getEnteralternateemail() {
		return Enteralternateemail;
	}

	// academic qualification
	
	public WebElement getClickacdemiccountryfields() {
		return clickacdemiccountryfields;
	}


	public WebElement getEnteruniversity() {
		return Enteruniversity;
	}


	public WebElement getEnterattendedform() {
		return Enterattendedform;
	}


	public WebElement getEnterattendedto() {
		return Enterattendedto;
	}


	public WebElement getEnterdegreAwarded() {
		return EnterdegreAwarded;
	}


	public WebElement getEnterMajorSpecialisation() {
		return EnterMajorSpecialisation;
	}


	public WebElement getEnterclassofhonours() {
		return Enterclassofhonours;
	}


	public WebElement getEntergpa() {
		return Entergpa;
	}


	public WebElement getEntermaxgpa() {
		return Entermaxgpa;
	}


	public WebElement getEnterTOIEBU() {
		return EnterTOIEBU;
	}


	public List<WebElement> getClicklanguagecheckbox() {
		return Clicklanguagecheckbox;
	}


	public WebElement getClickacdemiccountryfields1() {
		return clickacdemiccountryfields1;
	}


	public WebElement getEnteruniversity1() {
		return Enteruniversity1;
	}


	public WebElement getEnterattendedform1() {
		return Enterattendedform1;
	}


	public WebElement getEnterattendedto1() {
		return Enterattendedto1;
	}


	public WebElement getEnterdegreAwarded1() {
		return EnterdegreAwarded1;
	}


	public WebElement getEnterMajorSpecialisation1() {
		return EnterMajorSpecialisation1;
	}


	public WebElement getEnterclassofhonours1() {
		return Enterclassofhonours1;
	}


	public WebElement getEntergpa1() {
		return Entergpa1;
	}


	public WebElement getEntermaxgpa1() {
		return Entermaxgpa1;
	}


	public WebElement getClicklanguagecheckbox1() {
		return Clicklanguagecheckbox1;
	}





	public WebElement getEnteremployer() {
		return enteremployer;
	}


	public WebElement getEnterdesignation() {
		return Enterdesignation;
	}


	public WebElement getEnteryear() {
		return enteryear;
	}


	public WebElement getEntermonth() {
		return entermonth;
	}


	public List<WebElement> getClickattachfile() {
		return clickattachfile;
	}


	public WebElement getEnterdocumentname() {
		return enterdocumentname;
	}


	public WebElement getEnterdocumentdescription() {
		return enterdocumentdescription;
	}


	public WebElement getClicktobrowse() {
		return clicktobrowse;
	}
	// Admission module status

	public WebElement getClickapplicationsubmitstatus() {
		return clickapplicationsubmitstatus;
	}


	public WebElement getClickdocumentverificationstatus() {
		return clickdocumentverificationstatus;
	}


	public WebElement getClickdocumentuploadstatus() {
		return clickdocumentuploadstatus;
	}


	public WebElement getClickdocumentreuploadedstatus() {
		return clickdocumentreuploadedstatus;
	}


	public WebElement getClickdocumentverifiedstatus() {
		return clickdocumentverifiedstatus;
	}


	public WebElement getClickapplicationapprovedstatus() {
		return clickapplicationapprovedstatus;
	}


	public WebElement getClickapplicationrejected() {
		return clickapplicationrejected;
	}


	public WebElement getClickofferletteraccept() {
		return clickofferletteraccept;
	}


	public WebElement getClickofferletterreject() {
		return clickofferletterreject;
	}


	public WebElement getClickfeespaidstatus() {
		return clickfeespaidstatus;
	}


	public WebElement getClickenrolledstatus() {
		return clickenrolledstatus;
	}
	
	
	
	
	public WebElement getErrorleadpage() {
		return errorleadpage;
	}
    
	
	public WebElement getAllfieldleaderror() {
		return allfieldleaderror;
	}

	@FindBy(xpath = "//span[contains(text(),'Successfully created')]")
	private WebElement succesfuulycreated;
	 @FindBy(xpath = "//span[contains(text(),'Successfully Updated')]")
	 private WebElement successfullyupdatedmessage;
	 @FindBy(xpath = "(//mat-select[@role='combobox'])[3]")
	 private WebElement clickeditprogramapply;
	 @FindBy(xpath = "//mat-tab-body[@role='tabpanel']")
	 private WebElement allviewdetailsviwed;
	 @FindBy(xpath = "//div[@class='kt-heading kt-heading--md'][normalize-space()='Program Apply']")
	 private WebElement programapplydisplay;
	 @FindBy(xpath = "//div[@class='kt-heading kt-heading--md'][normalize-space()='Personal Details']")
	 private WebElement personaldeatilsdisplayed;
	 
	 
	 
	
	public WebElement getPersonaldeatilsdisplayed() {
		return personaldeatilsdisplayed;
	}


	public WebElement getProgramapplydisplay() {
		return programapplydisplay;
	}


	public WebElement getAllviewdetailsviwed() {
		return allviewdetailsviwed;
	}


	public WebElement getClickeditprogramapply() {
		return clickeditprogramapply;
	}


	public WebElement getSuccesfuulycreated() {
		return succesfuulycreated;
	}
	
	


	public WebElement getSuccessfullyupdatedmessage() {
		return successfullyupdatedmessage;
	}


	@FindBy(xpath = "//div[@class='errorBlock alert alert-outline-dark kt-portlet alert-dismissible mt-2']")
	private WebElement allfieldleaderror;

	@FindBy(xpath = "//span[text()='Academics']")
	private WebElement clickacademic;
	@FindBy(xpath = "//a[text()='Semester']")
	private WebElement clicksem;
	@FindBy(xpath = "//input[@placeholder='Academic Year']")
	private WebElement enteracademic;
    @FindBy(xpath = "//span[text()='Settings']")
    private WebElement clicksetting;
   @FindBy(xpath = "//span[@class='mat-option-text']")
   private List<WebElement> selectyearacademic;
   
    @FindBy(xpath = "//input[@data-placeholder='Start Date *']")
    private WebElement enterstartdate;
    @FindBy(xpath = "//table[@class='owl-dt-calendar-table owl-dt-calendar-month-table']/tbody/tr/td")
    private List<WebElement> clicktime;
   @FindBy(css = "#mat-select-value-7")
   private WebElement cssclolor;














	public WebElement getCssclolor() {
	return cssclolor;
}


	public WebElement getEnterstartdate() {
		return enterstartdate;
	}


	public List<WebElement> getClicktime() {
		return clicktime;
	}


	public List<WebElement> getSelectyearacademic() {
	return selectyearacademic;
}


	public WebElement getClicksetting() {
		return clicksetting;
	}


	public WebElement getClickacademic() {
		return clickacademic;
	}


	public WebElement getClicksem() {
		return clicksem;
	}


	public WebElement getEnteracademic() {
		return enteracademic;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	




