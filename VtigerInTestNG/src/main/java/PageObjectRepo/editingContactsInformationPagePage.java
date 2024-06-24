package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class editingContactsInformationPagePage {

	//Globel variable 
		public WebDriver driver;
		
//**************************************************************************************************************************************		

		// Giving life to driver by Constracor
		public editingContactsInformationPagePage(WebDriver driver) {
			this.driver=driver;
		}
		
//**************************************************************************************************************************************		
	 
		// Locaters
	   By EditingContactInformation=By.xpath("//span[contains(text(),'Editing Contact Information')]");
	   By Email=By.xpath("//input[@id='email']");
	   By Save=By.xpath("//td[contains(text(),'State')]/following::input[contains(@value,'Save')]");
	
	   
//**************************************************************************************************************************************		
	   
	   // User Defined Method To Above Locators
	     public WebElement EditingContactInformationPageText() {
	         return	driver.findElement(EditingContactInformation);
	        }
	     
	     public WebElement EmailTextfield() {
	         return	driver.findElement(Email);
	        }
	     
	     public WebElement SaveButton() {
	         return	driver.findElement(Save);
	        }
}
