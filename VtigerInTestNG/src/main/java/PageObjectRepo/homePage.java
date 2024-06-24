package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {
	
	// Global Variable
		public WebDriver driver;

//**************************************************************************************************************************************
		// Giving life to driver by Constracor
		public homePage(WebDriver driver) {
			this.driver = driver;
		}
		
//**************************************************************************************************************************************		
	
		// Locaters
		By Home=By.xpath("//a[@class='hdrLink']");
		By Calendar=By.xpath("//a[text()='Calendar']");
		By Leads=By.xpath("//a[text()='Leads']");
		By Organizations=By.xpath("//a[text()='Organizations']");
		By Contacts=By.xpath("//a[text()='Contacts']");
		By Opportunities=By.xpath("//a[text()='Opportunities']");
		By Products=By.xpath("//a[text()='Products']");
		By Documents=By.xpath("//a[text()='Documents']");
		By Email=By.xpath("//a[text()='Email']");
		By TroubleTickets=By.xpath("//td[@class='small']/..//a[text()='Trouble Tickets']");
		By Dashboard=By.xpath("//td[@class='small']/..//a[text()='Dashboard']");
		By More=By.xpath("//td[@class='small']/..//a[text()='More']");
		By SearchTextfield=By.xpath("//td//input[@value='Home']/..");
		By SearchIcon=By.xpath("//input[@title='Find']");
		
//**************************************************************************************************************************************		
		// User Defined Method To Above Locators
		
		public WebElement HomePage() {
		    return	driver.findElement(Home);
		    }
		
		public WebElement CalendarLink() {
		    return	driver.findElement(Calendar);
		    }
		
		public WebElement LeadsLink() {
			return	driver.findElement(Leads);
			}
		
		public WebElement OrganizationsLink() {
			return	driver.findElement(Organizations);
			}
		
		public WebElement ContactsLink() {
			return	driver.findElement(Contacts);
			}
		
		public WebElement OpportunitiesLink() {
			return	driver.findElement(Opportunities);
			}
		
		public WebElement ProductsLink() {
			return	driver.findElement(Products);
			}
		
		public WebElement DocumentsLink() {
			return	driver.findElement(Documents);
			}
		
		public WebElement EmailLink() {
		    return	driver.findElement(Email);
			}
		
		public WebElement TroubleTicketsLink() {
		    return	driver.findElement(TroubleTickets);
			}
		
		public WebElement DashboardLink() {
		    return	driver.findElement(Dashboard);
			}
		
		public WebElement MoreButton() {
		    return	driver.findElement(More);
			}
		
		public WebElement SearchTextfield() {
		    return	driver.findElement(SearchTextfield);
			}
		
		public WebElement SearchIcon() {
		    return	driver.findElement(SearchIcon);
			}
		
}
