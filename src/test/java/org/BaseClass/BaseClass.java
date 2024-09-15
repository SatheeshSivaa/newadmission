package org.BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.Listener.ExtentReport;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v127.network.Network;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	


	
	//public static Logger logger=Logger.getLogger( BaseClass.class);
	
	
	
	public static WebDriver driver;
	public static void Launchdriver() {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(option);
		option.addArguments("--disable-popup-blocking");
		DevTools devTool = ((HasDevTools) driver).getDevTools();
		devTool.createSession();
		
		
		
		devTool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		 devTool.addListener(Network.requestWillBeSent(), entry -> {
			
		   	 
			// Request request1 = entry.getRequest();
			 org.openqa.selenium.devtools.v127.network.model.Request request1 = entry.getRequest();
		   	 request1.getUrl();
			 request1.getMethod();
			   	
			 
            // System.out.println("Request (id) URL      : (" + entry.getRequestId() + ") " 
                   //  + entry.getRequest().getUrl()
                    // + " (" + entry.getRequest().getMethod() + ")");
        // });
		 });
	     devTool.addListener(org.openqa.selenium.devtools.v127.network.Network.responseReceived(), response -> {
	    	 
	    	  // Response res = response.getResponse();
	    	 org.openqa.selenium.devtools.v127.network.model.Response res = response.getResponse();
	        //  wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    
		
	       
	           // System.out.print("Response URL: ");
	           // System.out.println(res.getUrl());
	           // System.out.println(res.getStatus());
	            if (res.getStatus().toString().startsWith("503")) {
	    	      
	    
			
	            	System.out.println(res.getUrl() + "   is falling with Status code "+res.getStatus());
	            	
	            	 ExtentReport.test.info(res.getUrl() + "  is falling with Status code "+res.getStatus());
		                String screenShot = null;
						try {
							screenShot = screenShot(driver, res.getUrl());
						} catch (AWTException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                ExtentReport.test.addScreenCaptureFromPath(screenShot);
	            }
	            
	            
	             if(res.getStatus().toString().startsWith("500")){
	            	   System.out.println(res.getUrl() + "  is falling with Status code "+res.getStatus());
	            		 ExtentReport.test.info(res.getUrl() + " is falling with Status code "+res.getStatus());
	 	                String screenShot = null;
						try {
							screenShot = screenShot(driver, res.getUrl());
						} catch (AWTException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	 	                ExtentReport.test.addScreenCaptureFromPath(screenShot);
					
	            }
	              //  System.out.println(logMessage);
	               
		 
      	
	            	
	            
					
				
	            
	        });
		
		
	}
	
	
		
	
     
		
	
    	
		
	
	

	public static void windowmax() {
		driver.manage().window().maximize();

	}
	public static void launhurl(String url) {
		driver.get(url);
	}
    public static void passtext(String txt,WebElement ele) {
    	ele.sendKeys(txt);
    }
    public static void passtext2(String txt,WebElement ele) {
    	ele.sendKeys(txt);
    }
	public static void closebrowser() {
    	driver.quit();
		
	}
	public static void clickbtn(WebElement ele) {
		ele.click();
		
	}
	public static void implicitywait() {
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	public static String gettext(WebElement ele ) {
		String text = ele.getText();
		return text;
		
	}
	public static Actions a;
	public static void moveelement(WebElement move) {
		
		 a=new Actions(driver);
		a.moveToElement(move).build().perform();
	}
	
	public static void clickAction(WebElement click) {
		 a = new Actions(driver);
		a.moveToElement(click).click().perform();
	}
	public static void  sendkey(String ele,WebElement pass) {
		 a=new Actions(driver);
		a.moveToElement(pass).click().sendKeys(ele).perform();
	}
	public static void doubleclick(WebElement click) {
		 a = new Actions(driver);
		a.moveToElement(click).doubleClick().perform();
	
	}
	public static String  pagetitle() {
		String title = driver.getTitle();
		return title;
	}
	public static void dragdrap(WebElement drag, WebElement drop) {
		 a = new Actions(driver);
		a.dragAndDrop(drag, drop).perform();
	}
	
	public static JavascriptExecutor js;
	public static void clickjava(WebElement ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}
   public static void scrollpage() {
	   js = (JavascriptExecutor) driver;
	   for (int second = 0;; second++) {
		    if(second >=60){
		        break;
		    } 
		    
	  // js.executeScript(Scroll,"window.scrollBy(0,700)", "");
	   js.executeScript("window.scrollBy(0, 700)","");
   }
   }
   public static void scrollpagedown(WebElement ele) {
	   js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].scrollIntoView(true);", ele);
   }
   public static void scrollpageup(WebElement ele) {
	   js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].scrollIntoView(false);", ele);
   }
	
   
	/*public  String excelread(String Sheetname, int rownum,int cellnum) throws IOException {
		String value=null;
		File f = new File(
				"C:\\Users\\Satheesh S\\eclipse-workspace\\CRMANDADMISSIONGGI\\CRMANDADMISSIONGGIEXCELREPORT\\CRM And Admission Module (1).xlsx");
		FileInputStream fis =new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
	 Sheet mysheet = wb.getSheet(Sheetname);
		Row r = mysheet.getRow(rownum);
		Cell c = r.getCell(cellnum);
		int cell = c.getCellType();
		if (cell==1) {
			value = c.getStringCellValue();
			
		}
		else if (DateUtil.isCellDateFormatted(c)) {
			Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat s=new SimpleDateFormat("dd-MMM-yy");
			value= s.format(dateCellValue);
		}
		else {
			double numericCellValue = c.getNumericCellValue();
			long i=(long) numericCellValue;
			value = String.valueOf(i);
		}
		return value;
		
		
	}*/
	

	public static String screenShot(WebDriver driver,String filename) throws AWTException, IOException {
    TakesScreenshot tk = (TakesScreenshot) driver;
    File source = tk.getScreenshotAs(OutputType.FILE);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
    String times = formatter.format(new Date());
    String screenshotName = "failed_" + times + ".png";
    String screenshotPath = "D:\\failed\\" + screenshotName; // Define path for the screenshot
   
   // String screenshotPath = "D://" + screenshotName; // Define path for the screenshot
    File destination = new File(screenshotPath);
    
   
	 
    
    // Copy the screenshot to the defined path
    try {
		FileUtils.copyFile(source, destination);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return screenshotPath;
		
	}	
	@org.testng.annotations.BeforeSuite
	 public void BeforeSuite() {
	  ExtentReport.setExtent();
	  
	 }
	 @org.testng.annotations.AfterSuite
	 public void AfterSuite() {
	  ExtentReport.endReport();
	 }	
	 public static Robot r;
	public static void upload(String pathname) throws AWTException {
		StringSelection selection = new StringSelection(pathname);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		r=new Robot();
		r.setAutoDelay(1000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.setAutoDelay(1000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		

	}
	public static WebDriverWait wait;
	public static void clickwait(WebElement ele) {
		//wait = new WebDriverWait(driver, 10);
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
	}
	public static void visiblewait(String name,WebElement ele) {
		//wait = new WebDriverWait(driver, 10);
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) ele)).sendKeys(name);
	
	}
	public static void sendwait(String path,WebElement ele) {
	//	wait = new WebDriverWait(driver, 10);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).sendKeys(path);
	
	}
	public static void visiblewait1(String name, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(locator));
        ele.sendKeys(name);
    }
	
	public static void clickvisiblewait1( WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(locator));
        ele.click();
    }

	public static  void  clickfluentWait(WebElement ele) {
        Wait<WebDriver> wait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(StaleElementReferenceException.class);
           wait1.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                 ele.click();
				return ele;
            }
        });
       
	     

        
	
	}

	public static  void  sendfluentWait(String data,WebElement ele) {
        Wait<WebDriver> wait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(Exception.class);
           wait1.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                 ele.sendKeys(data);
				return ele;
            }
        });
       
	     

        
	
	}
	
	
	
	
	
	public static void Refresh() {
		driver.navigate().refresh();
		
	}
	public static void clear(WebElement ele) {
		ele.clear();

	}
	
	/*public static void excelwrite(String sheetname,String writename,int newrow,int newcell) throws IOException {
		
		File f = new File("C:\\Users\\Satheesh S\\eclipse-workspace\\CRMANDADMISSIONGGI\\CRMANDADMISSIONGGIEXCELREPORT\\CRM And Admission Module (1).xlsx");
		FileInputStream fis =new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
	 Sheet mysheet = wb.getSheet(sheetname);
	Row row = mysheet.getRow(newrow);
	Cell cell = row.getCell(newcell);
	cell.setCellValue(writename);
	 FileOutputStream fos = new FileOutputStream(f);
	 wb.write(fos);
      fos.close();
	}*/
	
	public static void copy() throws AWTException {
		r= new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
		//r.keyPress(KeyEvent.VK_TAB);
		//r.keyRelease(KeyEvent.VK_TAB);
	}
	public static void paste() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		

	}
	 public static void enter() throws AWTException {
	      r=new Robot(); 
         r.keyPress(KeyEvent.VK_ENTER);
	     r.keyRelease(KeyEvent.VK_ENTER);
  
}

/*String [][] data=null;
@DataProvider(name="data") 
public String[][]logindataprovider() throws IOException {	
	data=getdataexcel();
	return data;
}
public String[][] getdataexcel() throws IOException {
	FileInputStream fis = new FileInputStream(
			"C:\\Users\\Satheesh S\\eclipse-workspace\\CRMANDADMISSIONGGI\\CRMANDADMISSIONGGIEXCELREPORT\\CRM And Admission Module (1).xlsx");
	Workbook wb=new XSSFWorkbook(fis);
	Sheet sheet = wb.getSheet("Testdata2");
	int NumberOfRows = sheet.getPhysicalNumberOfRows();
	int colCount = sheet.getRow(0).getLastCellNum();
	String testdata[][]=new String[NumberOfRows-1][colCount] ;
	
	for (int i = 1; i <NumberOfRows; i++) {
		for (int j = 0; j <colCount; j++) { 
			testdata[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();


			 
	}
}
	
	return testdata;
	

	
	
	}	*/
	
	



public static void back() {
	driver.navigate().back();
	
}
   public static  void window() {
	   String currentHandle = driver.getWindowHandle();

       // Open a new window using JavaScript
       ((JavascriptExecutor) driver).executeScript("window.open();");
	   Set<String> handles = driver.getWindowHandles();
       String newWindowHandle = null;
       for (String handle : handles) {
           if (!handle.equals(currentHandle)) {
               newWindowHandle = handle;
               break;
           }
       }

       // Switch to the new window if it's not null
       if (newWindowHandle != null) {
           driver.switchTo().window(newWindowHandle);
       } else {
           System.out.println("No new window found.");
       }


}



 public static void removeuser() throws AWTException {
	    r=new Robot();
		
		
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.delay(2000);
		
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
 }

 public static void removepass() throws AWTException {
	    r=new Robot();
	    r.delay(2000);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);

		
		

}
  public static void citizen() throws AWTException {
	     r=new Robot();
		 r.keyPress(KeyEvent.VK_TAB);
		 r.keyRelease(KeyEvent.VK_TAB);
		 r.keyPress(KeyEvent.VK_I); r.keyRelease(KeyEvent.VK_I);
		 r.keyPress(KeyEvent.VK_N); r.keyRelease(KeyEvent.VK_N);
		 r.keyPress(KeyEvent.VK_D); r.keyRelease(KeyEvent.VK_D);
		 r.keyPress(KeyEvent.VK_I); r.keyRelease(KeyEvent.VK_I);
}
 
  public static void state() throws AWTException {
	     r=new Robot();
		 r.keyPress(KeyEvent.VK_TAB);
		 r.keyRelease(KeyEvent.VK_TAB);
			/*
			 * r.keyPress(KeyEvent.VK_T); r.keyRelease(KeyEvent.VK_T);
			 * r.keyPress(KeyEvent.VK_A); r.keyRelease(KeyEvent.VK_A);
			 * r.keyPress(KeyEvent.VK_M); r.keyRelease(KeyEvent.VK_M);
			 * r.keyPress(KeyEvent.VK_I); r.keyRelease(KeyEvent.VK_I);
			 * r.keyPress(KeyEvent.VK_L); r.keyRelease(KeyEvent.VK_L);
			 * r.keyPress(KeyEvent.VK_SPACE); r.keyRelease(KeyEvent.VK_SPACE);
			 * r.keyPress(KeyEvent.VK_N); r.keyRelease(KeyEvent.VK_N);
			 * r.keyPress(KeyEvent.VK_A); r.keyRelease(KeyEvent.VK_A);
			 * r.keyPress(KeyEvent.VK_D); r.keyRelease(KeyEvent.VK_D);
			 * r.keyPress(KeyEvent.VK_U); r.keyRelease(KeyEvent.VK_U);
			 */
		 
}
  
	public static void startupbrowser() {
		Launchdriver();
		launhurl("https://uatggi.creatrixcampus.net/auth/login");
		windowmax();
		implicitywait();
	}

   public static void popupscroll(WebElement popup) {
	   JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
       
       while (true) {
           jsExecutor.executeScript(
               "arguments[0].scrollTop = arguments[0].scrollTop + arguments[0].offsetHeight;", popup);
           try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException e) {
               e.printStackTrace();
	   
           }  
       }
   }

   public String excelread(String sheetName, int rowNum, int cellNum) throws IOException {
	    String value = null;
	    File file = new File("C:\\Users\\Satheesh S\\eclipse-workspace\\CRMandAdmission-GGI\\CRMandAdmissionExceldata\\CRM And Admission Module (1).xlsx");

	    try (FileInputStream fis = new FileInputStream(file);
	         Workbook workbook = new XSSFWorkbook(fis)) {
	         
	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) {
	            throw new IllegalArgumentException("Sheet not found: " + sheetName);
	        }

	        Row row = sheet.getRow(rowNum);
	        if (row == null) {
	            throw new IllegalArgumentException("Row not found: " + rowNum);
	        }

	        Cell cell = row.getCell(cellNum);
	        if (cell == null) {
	            throw new IllegalArgumentException("Cell not found: " + cellNum);
	        }

	        switch (cell.getCellType()) {
	            case STRING:
	                value = cell.getStringCellValue();
	                break;
	            case NUMERIC:
	                if (DateUtil.isCellDateFormatted(cell)) {
	                    Date dateCellValue = cell.getDateCellValue();
	                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
	                    value = sdf.format(dateCellValue);
	                } else {
	                    value = String.valueOf((long) cell.getNumericCellValue());
	                }
	                break;
	            case BOOLEAN:
	                value = String.valueOf(cell.getBooleanCellValue());
	                break;
	            case FORMULA:
	                value = cell.getCellFormula(); // or evaluate it if needed
	                break;
	            default:
	                value = "";
	        }
	    }

	    return value;
   
      
  

	
   }
   
   public static void excelWrite(String sheetName, String writeName, int newRow, int newCell) throws IOException {
	    File file = new File("C:\\Users\\Satheesh S\\eclipse-workspace\\CRMandAdmission-GGI\\CRMandAdmissionExceldata\\CRM And Admission Module (1).xlsx");
	    
	    try (FileInputStream fis = new FileInputStream(file);
	         Workbook workbook = new XSSFWorkbook(fis)) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) {
	            sheet = workbook.createSheet(sheetName); // Create sheet if it doesn't exist
	        }

	        Row row = sheet.getRow(newRow);
	        if (row == null) {
	            row = sheet.createRow(newRow); // Create row if it doesn't exist
	        }

	        Cell cell = row.getCell(newCell);
	        if (cell == null) {
	            cell = row.createCell(newCell); // Create cell if it doesn't exist
	        }

	        cell.setCellValue(writeName);

	        try (FileOutputStream fos = new FileOutputStream(file)) {
	            workbook.write(fos);
	        }

	    }
	}
   
   @DataProvider(name="data1")
   public String[][] logindataprovider1() throws IOException {
       return getdataexcel1();
   }

   public String[][] getdataexcel1() throws IOException {
       String[][] testdata;

       try (FileInputStream fis = new FileInputStream(
               "C:\\Users\\Satheesh S\\eclipse-workspace\\CRMANDADMISSIONGGI\\CRMANDADMISSIONGGIEXCELREPORT\\CRM And Admission Module (1).xlsx");
            Workbook wb = new XSSFWorkbook(fis)) {

           Sheet sheet = wb.getSheet("Testdata2");
           int numberOfRows = sheet.getPhysicalNumberOfRows();
           int colCount = sheet.getRow(0).getLastCellNum();
           testdata = new String[numberOfRows - 1][colCount];

           for (int i = 1; i < numberOfRows; i++) {
               for (int j = 0; j < colCount; j++) {
                   Cell cell = sheet.getRow(i).getCell(j);
                   if (cell != null) {
                       switch (cell.getCellType()) {
                           case STRING:
                               testdata[i - 1][j] = cell.getStringCellValue();
                               break;
                           case NUMERIC:
                               testdata[i - 1][j] = String.valueOf(cell.getNumericCellValue());
                               break;
                           case BOOLEAN:
                               testdata[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
                               break;
                           default:
                               testdata[i - 1][j] = "";
                       }
                   } else {
                       testdata[i - 1][j] = "";
                   }
               }
           }
       }

       return testdata;
   }

   public static void download(String name) {
	   File file = new File("C:\\Users\\Satheesh S\\Downloads");
	   File[] totalFiles = file.listFiles();
	   
	   for (File file2 : totalFiles) {
		   if (file2.getName().contains(name)) {
			   break;
			
		} 
		
	}
	


   }
   public static void tab() {
	    r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
   }
   
   
}

   

	
 





   
   







