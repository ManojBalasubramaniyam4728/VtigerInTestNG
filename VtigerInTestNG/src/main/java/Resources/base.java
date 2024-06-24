package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	
    //global Variables
	public static WebDriver driver;
	public static String concatenatedContactsFirstName="";
	public static String concatenatedLeadFirstName="";
	public static String concatenatedOrganizationName="";
	public static String concatenatedVendorName="";
	public static String credientialsFilePath="C:\\Users\\user\\eclipse-workspace\\VtigerInTestNG\\src\\main\\java\\Resources\\credientials.properties";
	public static String screenShootFilePath="C:\\Users\\user\\eclipse-workspace\\VtigerInTestNG\\ScreenShot\\";
	public static String leadsTestDataFilePath="C:\\Users\\user\\eclipse-workspace\\VtigerInTestNG\\src\\main\\java\\Resources\\leadsTestData.properties";
	public static String organizationsTestDataFilePath="C:\\Users\\user\\eclipse-workspace\\VtigerInTestNG\\src\\main\\java\\Resources\\organizationsTestData.properties";
	public static String contactsTestDataFilePath="C:\\Users\\user\\eclipse-workspace\\VtigerInTestNG\\src\\main\\java\\Resources\\contactsTestData.properties";
	public static String vendorTestDataFilePath="C:\\Users\\user\\eclipse-workspace\\VtigerInTestNG\\src\\main\\java\\Resources\\vendorTestData.properties";
	
//**************************************************************************************************************************************
   //User Defined Method To Invoking Browsers
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(credientialsFilePath);
		prop.load(fis);
		String browserName = prop.getProperty("Browser");
		 
		
		if (browserName.equalsIgnoreCase("chrome")) {
           WebDriverManager.chromedriver().setup();
             driver=new ChromeDriver();
             driver.manage().window().maximize();
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		     driver=new FirefoxDriver();
		     driver.manage().window().maximize();
		}
		
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
		     driver=new EdgeDriver();
		     driver.manage().window().maximize();
		}
		
		else {
			WebDriverManager.iedriver().setup();
			 driver=new InternetExplorerDriver();
			 driver.manage().window().maximize();
		}
		
		return driver;
	}
	
//**************************************************************************************************************************************
	//User Defined Method For Closing The Browser
	public void closingDriver() {
	       driver.close();
	       driver=null;
	}
//**************************************************************************************************************************************
	//User Defined Method To Explicit Wait
	public void WaitUntilvisibilityOf(WebElement Element) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(credientialsFilePath);
		prop.load(fis);
		String ExplicitWait=prop.getProperty("ExplicitWait");
		Integer ExplicitWaitTime=Integer.parseInt(ExplicitWait);
		//logic gos here
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(ExplicitWaitTime));
		 wait.until(ExpectedConditions.visibilityOf(Element));
	}
	
//**************************************************************************************************************************************
		//User Defined Method To Explicit Wait LocaterValue
		public void WaitUntilvisibilityOfElementLocated(By.ByXPath LocaterValue) throws IOException {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(credientialsFilePath);
			prop.load(fis);
			String ExplicitWait=prop.getProperty("ExplicitWait");
			Integer ExplicitWaitTime=Integer.parseInt(ExplicitWait);
			//logic gos here
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(ExplicitWaitTime));
			 wait.until(ExpectedConditions.visibilityOfElementLocated(LocaterValue));
		}
		
//**************************************************************************************************************************************
       //User Defined Method For Taking Screnshot On Failed Steps
	 public void getScreenShot(String result) throws IOException{
        	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(src, new File(screenShootFilePath+result+"screenshot.png"));
        }

//**************************************************************************************************************************************
        //User Defined Method For Selecting And Deseleting Elements In Diffrent Forms
	 public void selectingByIndex(WebElement element, Integer number) {
        	Select select=new Select(element);
        	select.selectByIndex(number);
        }
        
        public void selectingByVisibleText(WebElement element, String text) {
        	Select select=new Select(element);
        	select.selectByVisibleText(text);
        }
        
        public void selectingByValue(WebElement element, String Value) {
        	Select select=new Select(element);
        	select.selectByValue(Value);
        }
        
        public void deSelectingByIndex(WebElement element, Integer number) {
        	Select select=new Select(element);
        	select.deselectByIndex(number);
        }
        
        public void deSelectingByVisibleText(WebElement element, String text) {
        	Select select=new Select(element);
        	select.deselectByVisibleText(text);
        }
        
        public void deSelectingByValue(WebElement element, String Value) {
        	Select select=new Select(element);
        	select.deselectByValue(Value);
        }
        
        public void deSelectingAll(WebElement element) {
        	Select select=new Select(element);
        	select.deselectAll();
        }
        
//**************************************************************************************************************************************
        //User Defined Method For Getting Text From List Of Webelements
        public ArrayList<String> getTextInList(List<WebElement> elements) {
            ArrayList<String> GettedText = new ArrayList<String>();
            for (WebElement element : elements) {
            	GettedText.add(element.getText());
            }
            return GettedText;
        }
        
//**************************************************************************************************************************************
        //User Defined Method For Getting Text From List Of Webelements
        public int getSizeInList(List<WebElement> elements) {
           int GettedSize=elements.size();
            return GettedSize;
        }
        
//**************************************************************************************************************************************
        //User Defined Method For Verification That String Is Present In List
        public boolean isStringPresentInList(List<String> list, String searchString) {
            for (String element : list) {
                if (element.contains(searchString)) {
                    return true;
                }
            }
            return false;
        }

//**************************************************************************************************************************************
        //User Defined Method For Scroll By JavascriptExecutor
        public static void scrollTillElementIsvisable(WebElement element) {
    		JavascriptExecutor scroll = (JavascriptExecutor) driver;
    		scroll.executeScript("arguments[0].scrollIntoView(false);", element);
        }
        
//**************************************************************************************************************************************
        //User Defined Method For Refresh Browser Window
        public static void refreshBrowserWindow() {
        	driver.navigate().refresh();
        }
        
//**************************************************************************************************************************************
      //User Defined Method For Generate random number with length Number Of Digit
        public static String generateRandomNumberWithLengthNumberOfDigits(int length) {
        	Random random = new Random();
        	String generatedNumber="";
        	for(int i=1;i<=length;i++) {
        		int randomNumber = (int) (random.nextInt(9) + 0);    
        		generatedNumber+=randomNumber;        
    		}
        	return generatedNumber;
        }
        
//**************************************************************************************************************************************
        //User Defined Method For Concatenate String1 with string2
        public static String concatenateString1WithString2(String string1,String string2) {
         String	concatenatedString = string1+""+string2;
        	return concatenatedString;
        }
        
//**************************************************************************************************************************************
        //User Defined Method For Converting String To Integer
        public static int convertingStringToInteger(String value) {
         Integer stringToInteger=Integer.parseInt(value);
        	return stringToInteger;
        }
        
//**************************************************************************************************************************************
        //User Defined Method For Switch to window if URL contains url
        public static void switchtToWindowIfURLContainsUrl(String url) {
        	Set<String> windowHandles = driver.getWindowHandles();
        	for (String windowHandle : windowHandles) {
        	    driver.switchTo().window(windowHandle);
        	    String currentUrl = driver.getCurrentUrl();
        	    if (currentUrl.contains(url)) {
        	        break;
        	    }
        	}
        }
        
//**************************************************************************************************************************************
        //User Defined Method For Switch to parent window
        public static void switchToParentWindow() {
        	String currentWindowHandle = driver.getWindowHandle();
        	Set<String> windowHandles = driver.getWindowHandles();
        	for(String windowhandel:windowHandles) {
     		   if(!windowhandel.equals(currentWindowHandle)) {
     			   driver.switchTo().window(windowhandel);
     	                  }
                   }
        }
        
//**************************************************************************************************************************************
        //User Defined Method For Click By Java Script Executor
        public static void clickByJavaScriptExecutor(WebElement element) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", element);
     	                  }
        
//**************************************************************************************************************************************
        //User Defined Method For Click By Coordinates
        public static void clickByCoordinates( int xCoordinate ,int yCoordinate) {
            Actions actions = new Actions(driver);
            actions.moveByOffset(xCoordinate, yCoordinate);
        }
}
