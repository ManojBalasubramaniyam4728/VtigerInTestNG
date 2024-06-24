package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	// Global Variable
	public WebDriver driver;

//**************************************************************************************************************************************
	// Giving life to driver by Constracor
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
//**************************************************************************************************************************************
		
	  // Locaters
	By LoginPage=By.xpath("//input[@name='user_name']");
	By UserName=By.xpath("//input[@name='user_name']");
	By Password=By.xpath("//input[@name='user_password']");
	By Login=By.xpath("//input[@id='submitButton']");
	
//**************************************************************************************************************************************		
			
	  // User Defined Method To Above Locators
	
	    public WebElement LoginPage() {
	        return	driver.findElement(LoginPage);
	        }
	   
	    public WebElement UserNameTextfield() {
		    return	driver.findElement(UserName);
		    }
			
	    public WebElement PasswordTextfield() {
		    return	driver.findElement(Password);
			 }
	    
	    public WebElement LoginButton() {
		     return	driver.findElement(Login);
		     }
	    
		
}
