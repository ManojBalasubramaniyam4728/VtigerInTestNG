package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class editingOrganizationsInformationPage {

	//Globel variable 
		public WebDriver driver;
		
//**************************************************************************************************************************************		

		// Giving life to driver by Constracor
		public editingOrganizationsInformationPage(WebDriver driver) {
			this.driver=driver;
		}
		
//**************************************************************************************************************************************		
	 
		// Locaters
	   By EditingOrganizationsInformationPage=By.xpath("//span[contains(text(),'Editing Organization Information')]");
	   By Email=By.xpath("//input[@id='email1']");
	   By Save=By.xpath("//td[contains(text(),'State')]/following::input[contains(@value,'Save')]");
	
	   
//**************************************************************************************************************************************		
	   
	   // User Defined Method To Above Locators
	     public WebElement EditingOrganizationsInformationPageText() {
	         return	driver.findElement(EditingOrganizationsInformationPage);
	        }
	     
	     public WebElement EmailTextfield() {
	         return	driver.findElement(Email);
	        }
	     
	     public WebElement SaveButton() {
	         return	driver.findElement(Save);
	        }
}
