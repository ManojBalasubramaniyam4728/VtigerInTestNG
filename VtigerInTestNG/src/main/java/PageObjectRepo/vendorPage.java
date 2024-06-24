package PageObjectRepo;

import java.util.List; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class vendorPage{
 
	//Globel variable 
	public WebDriver driver;
	String VendorName="";
	
//**************************************************************************************************************************************		

	// Giving life to driver by Constracor
	public vendorPage(WebDriver driver) {
		this.driver=driver;
	}
	
//**************************************************************************************************************************************		
 
	// Locaters
   By VendorsPage=By.xpath("//td[@class='moduleName']//a[text()='Vendors']");
   By CreateVendor=By.xpath("//img[@title='Create Vendor...']");
   By VendorInformation=By.xpath("//a[@title='Vendors']");
   
//**************************************************************************************************************************************		
   
   // User Defined Method To Above Locators
     public WebElement VendorsPageText() {
         return	driver.findElement(VendorsPage);
        }
     
     public WebElement CreateVendorButton() {
         return	driver.findElement(CreateVendor);
        }
    
     public List<WebElement> VendorInformationVerification() {
         return	driver.findElements(VendorInformation);
         }
     
     public WebElement EditVendorLink(String VendorName) {
    	 By EditVendor=By.xpath("//td//a[text()='"+VendorName+"']/../../td/a[text()='edit']");
         return	driver.findElement(EditVendor);
        }
     
     public WebElement DeleteVendorNameLink(String VendorName) {
    	 By DeleteEditVendor=By.xpath("//td//a[text()='"+VendorName+"']/../../td/a[text()='del']");
         return	driver.findElement(DeleteEditVendor);
        }
}
