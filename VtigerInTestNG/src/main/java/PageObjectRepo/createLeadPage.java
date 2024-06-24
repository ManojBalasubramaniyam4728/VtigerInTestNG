package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class createLeadPage {
	
	   //Globel variable 
		public WebDriver driver;
		
//**************************************************************************************************************************************		
        
		// Giving life to driver by Constracor
		public createLeadPage(WebDriver driver) {
			this.driver=driver;
		}
	
//**************************************************************************************************************************************		
	 
		// Locaters
	   By CreatingNewLead=By.xpath("//span[text()='Creating New Lead']");
	   By Salutation=By.xpath("//select[@name='salutationtype']");
	   By FirstName=By.xpath("//input[@name='firstname']");
	   By LastName=By.xpath("//input[@name='lastname']");
	   By Company=By.xpath("//input[@name='company']");
	   By Title=By.xpath("//input[@id='designation']");
	   By AnnualRevenue=By.xpath("//input[@name='annualrevenue']");
	   By NoOfEmployees=By.xpath("//input[@id='noofemployees']");
	   By Mobile=By.xpath("//input[@id='mobile']");
	   By Email=By.xpath("//input[@id='email']");
	   By LeadStatus=By.xpath("//select[@name='leadstatus']");
	   By UserAssignedToDropdown=By.xpath("//select[@name='assigned_user_id']");
	   By GroupAssignedToDropdown=By.xpath("//select[@name='assigned_group_id']");
	   By Street=By.xpath("//textarea[@name='lane']");
	   By PostalCode =By.xpath("//input[@id='code']");
	   By Country =By.xpath("//input[@id='country']");
	   By City =By.xpath("//input[@id='city']");
	   By State=By.xpath("//input[@id='state']");
	   By Save=By.xpath("//td[contains(text(),'State')]/following::input[contains(@value,'Save')]");
	   By LeadInformationTitle=By.xpath("//img[@id='aidLeadInformation']/../../../b");
	   
//**************************************************************************************************************************************		
	   
	   // User Defined Method To Above Locators
	     public WebElement CreatingNewLeadText() {
	         return	driver.findElement(CreatingNewLead);
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
	     
	     public WebElement CompanyTextfield() {
	         return	driver.findElement(Company);
	        }
	     
	     public WebElement TitleTextfield() {
	         return	driver.findElement(Title);
	        }
	     
	     public WebElement AnnualRevenueTextfield() {
	         return	driver.findElement(AnnualRevenue);
	        }
	     
	     public WebElement NoOfEmployeesTextfield() {
	         return	driver.findElement(NoOfEmployees);
	        }
	     
	     public WebElement MobileTextfield() {
	         return	driver.findElement(Mobile);
	        }
	     
	     public WebElement EmailTextfield() {
	         return	driver.findElement(Email);
	        }
	     
	     public WebElement LeadStatusDropdown() {
	         return	driver.findElement(LeadStatus);
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
	     
	     public WebElement StreetTextarea() {
	         return	driver.findElement(Street);
	         }
	     
	     public WebElement PostalCodeTextfield() {
	         return	driver.findElement(PostalCode);
	         }
	     
	     public WebElement CountryTextfield() {
	         return	driver.findElement(Country);
	         }
	     
	     public WebElement CityTextfield() {
	         return	driver.findElement(City);
	         }
	     
	     public WebElement StateTextfield() {
	         return	driver.findElement(State);
	         }
	     
	     public WebElement SaveButton() {
	         return	driver.findElement(Save);
	         }
	     
	     public WebElement LeadInformationTitle() {
	         return	driver.findElement(LeadInformationTitle);
	         }
	     
}
