package PageObjectRepo;


import java.util.List; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class contactsPage {
	 
		//Globel variable 
		public WebDriver driver;
		String FirstName="";
		
//**************************************************************************************************************************************		

		// Giving life to driver by Constracor
		public contactsPage(WebDriver driver) {
			this.driver=driver;
		}
		
//**************************************************************************************************************************************		
	 
		// Locaters
	   By ContactsPage=By.xpath("//td[@class='moduleName']//a[text()='Contacts']");
	   By CreateContacts=By.xpath("//img[@title='Create Contact...']");
	   By ContactsInformation=By.xpath("//span[@vtfieldname='firstname']/preceding-sibling::a");
	   By EditedContactsEmail=By.xpath("//td[@class='lvtCol'][4]/following::tr//td[7]");
	  
	   
//**************************************************************************************************************************************		
	   
	   // User Defined Method To Above Locators
	     public WebElement ContactsPageText() {
	         return	driver.findElement(ContactsPage);
	        }
	     
	     public WebElement CreateContactsButton() {
	         return	driver.findElement(CreateContacts);
	        }
	    
	     public List<WebElement> ContactsInformationVerification() {
	         return	driver.findElements(ContactsInformation);
	         }
	     
	     public WebElement EditContactsLink(String FirstName) {
	    	 By EditContacts=By.xpath("//td//a[text()='"+FirstName+"']/../../td/a[text()='edit']");
	         return	driver.findElement(EditContacts);
	        }
	     
	     public List<WebElement> EditedContactsEmailVerification() {
	         return	driver.findElements(EditedContactsEmail);
	         }
	     
	     public WebElement DeleteContactsLink(String FirstName) {
	    	 By DeleteContacts=By.xpath("//td//a[text()='"+FirstName+"']/../../td/a[text()='del']");
	         return	driver.findElement(DeleteContacts);
	        }
	}
