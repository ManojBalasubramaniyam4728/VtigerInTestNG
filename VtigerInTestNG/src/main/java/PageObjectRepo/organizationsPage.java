package PageObjectRepo;

import java.util.List; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class organizationsPage{
 
	//Globel variable 
	public WebDriver driver;
	String OrganizationsName="";
	
//**************************************************************************************************************************************		

	// Giving life to driver by Constracor
	public organizationsPage(WebDriver driver) {
		this.driver=driver;
	}
	
//**************************************************************************************************************************************		
 
	// Locaters
   By OrganizationsPage=By.xpath("//td[@class='moduleName']//a[text()='Organizations']");
   By CreateOrganizations=By.xpath("//img[@title='Create Organization...']");
   By OrganizationsInformation=By.xpath("//td[@class='lvtCol'][4]/following::tr//td[3]");
  
   
//**************************************************************************************************************************************		
   
   // User Defined Method To Above Locators
     public WebElement OrganizationsPageText() {
         return	driver.findElement(OrganizationsPage);
        }
     
     public WebElement CreateOrganizationsButton() {
         return	driver.findElement(CreateOrganizations);
        }
    
     public List<WebElement> OrganizationsInformationVerification() {
         return	driver.findElements(OrganizationsInformation);
         }
     
     public WebElement EditOrganizationsLink(String OrganizationsName) {
    	 By EditOrganizations=By.xpath("//td//a[text()='"+OrganizationsName+"']/../../td/a[text()='edit']");
         return	driver.findElement(EditOrganizations);
        }
     
     public WebElement DeleteOrganizationsLink(String OrganizationsName) {
    	 By DeleteEditOrganizations=By.xpath("//td//a[text()='"+OrganizationsName+"']/../../td/a[text()='del']");
         return	driver.findElement(DeleteEditOrganizations);
        }
}
