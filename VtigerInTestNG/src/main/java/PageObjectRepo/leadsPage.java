package PageObjectRepo;

import java.util.List; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class leadsPage {
 
	//Globel variable 
	public WebDriver driver;
	String LeadName="";
	
//**************************************************************************************************************************************		

	// Giving life to driver by Constracor
	public leadsPage(WebDriver driver) {
		this.driver=driver;
	}
	
//**************************************************************************************************************************************		
 
	// Locaters
   By LeadsPage=By.xpath("//td[@class='moduleName']//a[text()='Leads']");
   By CreateLead=By.xpath("//img[@title='Create Lead...']");
   By LeadInformation=By.xpath("//td[@class='lvtCol'][4]/following::tr//td[4]");
   By EditedLeadEmail=By.xpath("//td[@class='lvtCol'][4]/following::tr//td[8]");
  
   
//**************************************************************************************************************************************		
   
   // User Defined Method To Above Locators
     public WebElement LeadsPageText() {
         return	driver.findElement(LeadsPage);
        }
     
     public WebElement CreateLeadButton() {
         return	driver.findElement(CreateLead);
        }
    
     public List<WebElement> LeadInformationVerification() {
         return	driver.findElements(LeadInformation);
         }
     
     public WebElement EditLeadLink(String LeadName) {
    	 By EditLead=By.xpath("//td//a[text()='"+LeadName+"']/../../td/a[text()='edit']");
         return	driver.findElement(EditLead);
        }
     
     public List<WebElement> EditLeadEmailVerification() {
         return	driver.findElements(EditedLeadEmail);
         }
     
     public WebElement DeleteLeadLink(String LeadName) {
    	 By DeleteLead=By.xpath("//td//a[text()='"+LeadName+"']/../../td/a[text()='del']");
         return	driver.findElement(DeleteLead);
        }
}
