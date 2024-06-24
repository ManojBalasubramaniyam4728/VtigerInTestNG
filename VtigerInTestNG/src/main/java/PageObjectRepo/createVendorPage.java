package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class createVendorPage {
	
	   //Globel variable 
		public WebDriver driver;
		
//**************************************************************************************************************************************		
        
		// Giving life to driver by Constracor
		public createVendorPage(WebDriver driver) {
			this.driver=driver;
		}
	
//**************************************************************************************************************************************		
	 
		// Locaters
	   By CreatingNewVendor=By.xpath("//span[text()='Creating New Vendor']");
	   By VendoName=By.xpath("//input[@name='vendorname']");
	   By Email=By.xpath("//input[@id='email']");
	   By GLAccountDropdown=By.xpath("//select[@name='glacct']");
	   By Phone=By.xpath("//input[@id='phone']");
	   By Website=By.xpath("//input[@name='website']");
	   By Street=By.xpath("//textarea[@name='street']");
	   By City =By.xpath("//input[@id='city']");
	   By PostalCode =By.xpath("//input[@id='postalcode']");
	   By Pobox =By.xpath("//input[@id='pobox']");
	   By State=By.xpath("//input[@id='state']");
	   By Country =By.xpath("//input[@id='country']");
	   By Description =By.xpath("//b[contains(text(),'Description Name:')]/../following::textarea[@class='detailedViewTextBox']");
	   By Save=By.xpath("//td[contains(text(),'State')]/following::input[contains(@value,'Save')]");
	   By VendorInformation=By.xpath("//td[text()='Vendor Information']");
	   
//**************************************************************************************************************************************		
	   
	   // User Defined Method To Above Locators
	     public WebElement CreatingNewVendorText() {
	         return	driver.findElement(CreatingNewVendor);
	        }
	     
	     public WebElement VendorNameTextfield() {
	         return	driver.findElement(VendoName);
	        }
	     
	     public WebElement EmailTextfield() {
	         return	driver.findElement(Email);
	        }
	     
	     public WebElement GLAccountDropdown() {
	         return	driver.findElement(GLAccountDropdown);
	        }
	     
	     public WebElement PhoneTextfield() {
	         return	driver.findElement(Phone);
	        }
	     
	     public WebElement WebsiteTextfield() {
	         return	driver.findElement(Website);
	         }
	     
	     public WebElement StreetTextare() {
	         return	driver.findElement(Street);
	         }
	     
	     public WebElement CityTextfield() {
	         return	driver.findElement(City);
	         }

	     public WebElement PostalCodeTextfield() {
	         return	driver.findElement(PostalCode);
	         }
	     
	     public WebElement PoboxTextfield() {
	         return	driver.findElement(Pobox);
	         }
	     
	     public WebElement StateTextfield() {
	         return	driver.findElement(State);
	         }
	     
	     public WebElement CountryTextfield() {
	         return	driver.findElement(Country);
	         }
	     
	     public WebElement DescriptionTextfield() {
	         return	driver.findElement(Description);
	         }
	     
	     public WebElement SaveButton() {
	         return	driver.findElement(Save);
	         }
	     
	     public WebElement VendorInformationTitle() {
	         return	driver.findElement(VendorInformation);
	         }
	     
}
