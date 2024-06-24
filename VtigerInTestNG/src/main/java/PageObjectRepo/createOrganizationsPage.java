package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class createOrganizationsPage {
	
	   //Globel variable 
		public WebDriver driver;
		
//**************************************************************************************************************************************		
        
		// Giving life to driver by Constracor
		public createOrganizationsPage(WebDriver driver) {
			this.driver=driver;
		}
	
//**************************************************************************************************************************************		
	 
		// Locaters
	   By CreatingNewOrganization=By.xpath("//span[text()='Creating New Organization']");
	   By OrganizationName=By.xpath("//input[@name='accountname']");
	   By Website=By.xpath("//input[@name='website']");
	   By Employees=By.xpath("//input[@id='employees']");
	   By EmailOptOut=By.xpath("//input[@name='emailoptout' and @type='checkbox']");
       By UserAssignedToDropdown=By.xpath("//select[@name='assigned_user_id']");
	   By GroupAssignedToDropdown=By.xpath("//select[@name='assigned_group_id']");
	   By Phone=By.xpath("//input[@id='phone']");
	   By Email=By.xpath("//input[@id='email1']");
	   By BillingAddress=By.xpath("//textarea[@name='bill_street']");
	   By BillingPOBox=By.xpath("//input[@id='bill_pobox']");
	   By BillingCity=By.xpath("//input[@id='bill_city']");
	   By BillingState=By.xpath("//input[@id='bill_state']");
	   By BillingPostalCode=By.xpath("//input[@id='bill_code']");
	   By BillingCountry=By.xpath("//input[@id='bill_country']");
	   By CopyBillingAddress=By.xpath("//b[text()='Copy Billing address']/..//input[@name='cpy']");
	   By Save=By.xpath("//td[contains(text(),'State')]/following::input[contains(@value,'Save')]");
	   By OrganizationInformationTitle=By.xpath("//td[text()='Organization Information']");
	   
//**************************************************************************************************************************************		
	   
	   // User Defined Method To Above Locators
	     public WebElement CreatingNewOrganizationText() {
	         return	driver.findElement(CreatingNewOrganization);
	        }
	     
	     public WebElement OrganizationNameTextfield() {
	         return	driver.findElement(OrganizationName);
	        }
	     
	     public WebElement WebsiteTextfield() {
	         return	driver.findElement(Website);
	        }
	     
	     public WebElement EmployeesTextfield() {
	         return	driver.findElement(Employees);
	        }
	     
	     public WebElement EmailOptOutCheckbox() {
	         return	driver.findElement(EmailOptOut);
	        }
	     
	     public WebElement AssignedToRadioButton(String AssignedToRadioButton) {
	    	 By AssignedToRadio=By.xpath("//td//input[@type='radio' and @value='"+AssignedToRadioButton+"']");
	    	 return	driver.findElement(AssignedToRadio);
	        }
	     
	     public WebElement UserAssignedToDropdown() {
				return driver.findElement(UserAssignedToDropdown);
			}
	     
	     public WebElement GroupAssignedToDropdown() {
         return	driver.findElement(GroupAssignedToDropdown);
            }
    
	     public WebElement PhoneTextfield() {
	         return	driver.findElement(Phone);
	        }
	     
	     public WebElement EmailTextfield() {
	         return	driver.findElement(Email);
	        }
	     
	     public WebElement BillingAddressTextarea() {
	         return	driver.findElement(BillingAddress);
	         }
	     
	     public WebElement BillingPOBoxTextarea() {
	         return	driver.findElement(BillingPOBox);
	         }
	     
	     public WebElement BillingCityTextfield() {
	         return	driver.findElement(BillingCity);
	         }
	     
	     public WebElement BillingStateTextfield() {
	         return	driver.findElement(BillingState);
	         }
	     
	     public WebElement BillingPostalCodeTextfield() {
	         return	driver.findElement(BillingPostalCode);
	         }
	     
	     public WebElement BillingCountryTextfield() {
	         return	driver.findElement(BillingCountry);
	         }
	     
	     public WebElement CopyBillingAddressRadioButton() {
	         return	driver.findElement(CopyBillingAddress);
	         }
	     
	     public WebElement SaveButton() {
	         return	driver.findElement(Save);
	         }
	     
	     public WebElement OrganizationInformationTitle() {
	    	 return	driver.findElement(OrganizationInformationTitle);
	         }
	     
	     public ByXPath OrganizationInformationTitleLocater() {
	         return	(ByXPath) OrganizationInformationTitle;
	         }
	     
}
