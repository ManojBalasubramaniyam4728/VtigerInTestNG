package PageObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;

public class createContactsPage {
	
	   //Globel variable 
		public WebDriver driver;
		
//**************************************************************************************************************************************		
        
		// Giving life to driver by Constracor
		public createContactsPage(WebDriver driver) {
			this.driver=driver;
		}
	
//**************************************************************************************************************************************		
	 
		// Locaters
	   By CreatingNewContact=By.xpath("//span[text()='Creating New Contact']");
	   By Salutation=By.xpath("//select[@name='salutationtype']");
	   By FirstName=By.xpath("//input[@name='firstname']");
	   By LastName=By.xpath("//input[@name='lastname']");
	   By SelectOrganizationName=By.xpath("//input[@name='account_name']/..//img[@title='Select']");
	   By OrganizationsPopup=By.xpath("//td[text()='Organizations']");
	   By Search= By.xpath("//td[@class='dvtCellLabel']/input[@name='search_text']");
	   By NumberOfOrganizations=By.xpath("//tr[@onmouseout]/td/a");
	   By Email=By.xpath("//input[@id='email']");
	   By Mobile=By.xpath("//input[@id='mobile']");
	   By UserAssignedToDropdown=By.xpath("//select[@name='assigned_user_id']");
	   By GroupAssignedToDropdown=By.xpath("//select[@name='assigned_group_id']");
	   By MailingStreet=By.xpath("//textarea[@name='mailingstreet']");
	   By MailingPobox =By.xpath("//input[@id='mailingpobox']");
	   By MailingCity =By.xpath("//input[@id='mailingcity']");
	   By MailingState =By.xpath("//input[@id='mailingstate']");
	   By MailingPostalCode=By.xpath("//input[@id='mailingzip']");
	   By MailingCountry=By.xpath("//input[@id='mailingcountry']");
	   By CopyMailingAddress=By.xpath("//b[text()='Copy Mailing Address']/..//input[@name='cpy']");
	   By Save=By.xpath("//td[contains(text(),'State')]/following::input[contains(@value,'Save')]");
	   By ContactInformation=By.xpath("//td[text()='Contact Information']");
	   
//**************************************************************************************************************************************		
	   
	   // User Defined Method To Above Locators
	     public WebElement CreatingNewContactText() {
	         return	driver.findElement(CreatingNewContact);
	        }
	     
	     public WebElement SalutationDropdown() {
	         return	driver.findElement(Salutation);
	        }
	     
	     public WebElement FirstNameTextfield() {
	         return	driver.findElement(FirstName);
	        }
	     
	     public WebElement LastNameTextfield() {
	         return	driver.findElement(LastName);
	        }
	     
	     public WebElement SelectOrganizationPlusButton() {
	         return	driver.findElement(SelectOrganizationName);
	        }
	     
	     public WebElement OrganizationsPopupText() {
	         return	driver.findElement(OrganizationsPopup);
	        }
	     
	     public List<WebElement> NumberOfOrganizationsLink() {
	         return	driver.findElements(NumberOfOrganizations);
	        }
	     
	     public WebElement SearchTextfield() {
	         return	driver.findElement(Search);
	        }
	     
	     public WebElement LastOrganizationNameInOrganizationPopupLink(int LastIndex) {
	    	 By EditContacts=By.xpath("(//tr[@onmouseout]/td/a)["+LastIndex+"]");
	         return	driver.findElement(EditContacts);
	        }
	     
	     public WebElement EmailTextfield() {
	         return	driver.findElement(Email);
	        }
	     
	     public WebElement MobileTextfield() {
	         return	driver.findElement(Mobile);
	        }
	     
	     public WebElement AssignedToRadioButton(String AssignedToRadioButton) {
	    	 By AssignedToRadio=By.xpath("//td//input[@type='radio' and @value='"+AssignedToRadioButton+"']");
	    	 return	driver.findElement(AssignedToRadio);
	        }
	     
	     public WebElement UserAssignedToDropdown() {
	         return	driver.findElement(UserAssignedToDropdown);
	        }
	    
	     public WebElement GroupAssignedToDropdown() {
	         return	driver.findElement(GroupAssignedToDropdown);
	        }
	     
	     public WebElement MailingStreetTextarea() {
	         return	driver.findElement(MailingStreet);
	         }
	     
	     public WebElement MailingPoboxTextfield() {
	         return	driver.findElement(MailingPobox);
	         }
	     
	     public WebElement MailingCityTextfield() {
	         return	driver.findElement(MailingCity);
	         }
	     
	     public WebElement MailingStateTextfield() {
	         return	driver.findElement(MailingState);
	         }
	     
	     public WebElement MailingPostalCodeTextfield() {
	         return	driver.findElement(MailingPostalCode);
	         }
	     
	     public WebElement MailingCountryTextfield() {
	         return	driver.findElement(MailingCountry);
	         }
	     
	     public WebElement CopyMailingAddressRadioButton() {
	         return	driver.findElement(CopyMailingAddress);
	         }
	     
	     public WebElement SaveButton() {
	         return	driver.findElement(Save);
	         }
	     
	     public WebElement ContactInformationTitle() {
	         return	driver.findElement(ContactInformation);
	         }
	     
	     public ByXPath ContactInformationTitleLocater() {
	         return	(ByXPath) ContactInformation;
	         }
}
