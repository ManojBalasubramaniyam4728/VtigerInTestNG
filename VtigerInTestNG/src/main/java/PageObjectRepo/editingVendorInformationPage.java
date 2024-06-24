package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class editingVendorInformationPage {

	//Globel variable 
		public WebDriver driver;
		
//**************************************************************************************************************************************		

		// Giving life to driver by Constracor
		public editingVendorInformationPage(WebDriver driver) {
			this.driver=driver;
		}
		
//**************************************************************************************************************************************		
	 
		// Locaters
	   By EditingVendorInformationPage=By.xpath("//span[contains(text(),' Vendor Information')]");
	   By GLAccountDropdown=By.xpath("//select[@name='glacct']");
	   By Save=By.xpath("//td[contains(text(),'State')]/following::input[contains(@value,'Save')]");
	
	   
//**************************************************************************************************************************************		
	   
	   // User Defined Method To Above Locators
	     public WebElement EditingVendorInformationPageText() {
	         return	driver.findElement(EditingVendorInformationPage);
	        }
	     
	     public WebElement GLAccountDropdownDropdown() {
	         return	driver.findElement(GLAccountDropdown);
	        }
	     
	     public WebElement SaveButton() {
	         return	driver.findElement(Save);
	        }
}
