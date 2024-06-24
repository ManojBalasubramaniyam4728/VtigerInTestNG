package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class editingLeadInformationPage {

	//Globel variable 
		public WebDriver driver;
		
//**************************************************************************************************************************************		

		// Giving life to driver by Constracor
		public editingLeadInformationPage(WebDriver driver) {
			this.driver=driver;
		}
		
//**************************************************************************************************************************************		
	 
		// Locaters
	   By EditingLeadInformationPage=By.xpath("//span[contains(text(),'Editing Lead Information')]");
	   By Email=By.xpath("//input[@id='email']");
	   By Save=By.xpath("//td[contains(text(),'State')]/following::input[contains(@value,'Save')]");
	
	   
//**************************************************************************************************************************************		
	   
	   // User Defined Method To Above Locators
	     public WebElement EditingLeadInformationPageText() {
	         return	driver.findElement(EditingLeadInformationPage);
	        }
	     
	     public WebElement EmailTextfield() {
	         return	driver.findElement(Email);
	        }
	     
	     public WebElement SaveButton() {
	         return	driver.findElement(Save);
	        }
}
