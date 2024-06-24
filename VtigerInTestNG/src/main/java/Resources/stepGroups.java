package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import PageObjectRepo.loginPage; 

public class stepGroups extends base{
	
   //Step Group For Open Browser And Navigate To Vtiger Url
	public void openBrowserAndNavigateToVtigerUrl() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(credientialsFilePath);
		prop.load(fis);
		String url = prop.getProperty("url");
		
		driver = initializeDriver();
		driver.get(url);
	}
	
	//Step Group Login To Vtiger Application()
	public void LoginToVtigerApplication() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(credientialsFilePath);
		prop.load(fis);
		String UserName = prop.getProperty("Username");
		String Password = prop.getProperty("Password");
		
	    loginPage lgp = new loginPage(driver);
		
		WaitUntilvisibilityOf(lgp.LoginPage());
		lgp.LoginPage().isDisplayed();
		lgp.UserNameTextfield().click();
		lgp.UserNameTextfield().sendKeys(UserName);
		lgp.PasswordTextfield().click();
		lgp.PasswordTextfield().sendKeys(Password);
		lgp.LoginButton().click();
	}
	
	 //Step Group Login To Vtiger Application()
	 public void closeBrowser() {
    		closingDriver();
    }
}

