package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class moreLinkPage {
	// Global Variable
		public WebDriver driver;

//**************************************************************************************************************************************
		// Giving life to driver by Constracor
		public moreLinkPage(WebDriver driver) {
			this.driver = driver;
		}
//**************************************************************************************************************************************
			
		  // Locaters
		By More=By.xpath("//td[@class='small']/..//a[text()='More']");
		By Tools=By.xpath("//a[contains(text(),'Tools')]");
		By SMSNotifier=By.xpath("//a[text()='SMSNotifier']");
		By OurSites=By.xpath("//a[text()='Our Sites']");
		By Integration=By.xpath("//a[text()='Integration']");
		By MailManager=By.xpath("//a[text()='Mail Manager']");
		By PBXManager=By.xpath("//a[text()='PBX Manager']");
		By Comments=By.xpath("//a[text()='Comments']");
		By RecycleBin=By.xpath("//a[text()='Recycle Bin']");
		By RSS=By.xpath("//a[text()='RSS']");
		By Analytics=By.xpath("//a[contains(text(),'Analytics')]");
		By Reports=By.xpath("//a[text()='Reports']");
		By Marketing=By.xpath("//a[contains(text(),'Marketing')]");
		By Campaigns=By.xpath("//a[text()='Campaigns']");
		By Support=By.xpath("//a[contains(text(),'Support')]");
		By ServiceContracts=By.xpath("//a[text()='Service Contracts']");
		By ProjectMilestones=By.xpath("//a[text()='Project Milestones']");
		By ProjectTasks=By.xpath("//a[text()='Project Tasks']");
		By Projects=By.xpath("//a[text()='Projects']");
		By FAQ=By.xpath("//a[text()='FAQ']");
		By Inventory=By.xpath("//a[contains(text(),'Inventory')]");
		By Services=By.xpath("//a[text()='Services']");
		By Assets=By.xpath("//a[text()='Assets']");
		By PurchaseOrder=By.xpath("//a[text()='Purchase Order']");
		By PriceBooks=By.xpath("//a[text()='Price Books']");
		By Vendors=By.xpath("//a[text()='Vendors']");
		By Sales=By.xpath("//a[contains(text(),'Sales')]");
		By Invoice=By.xpath("//a[text()='Invoice']");
		By SalesOrder=By.xpath("//a[text()='Sales Order']");
		By Quotes=By.xpath("//a[text()='Quotes']");
		
//**************************************************************************************************************************************		
				
		  // User Defined Method To Above Locators
		
		    public WebElement MoreButton() {
		        return	driver.findElement(More);
		        }
		    
		    public WebElement ToolsLink() {
		        return	driver.findElement(Tools);
		        }
		    
		    public WebElement SMSNotifierLink() {
		        return	driver.findElement(SMSNotifier);
		        }

		    public WebElement OurSitesLink() {
		        return	driver.findElement(OurSites);
		        }
		    
		    public WebElement IntegrationLink() {
		        return	driver.findElement(Integration);
		        }
		    
		    public WebElement MailManagerLink() {
		        return	driver.findElement(MailManager);
		        }
		    
		    public WebElement PBXManagerLink() {
		        return	driver.findElement(PBXManager);
		        }
		    
		    public WebElement CommentsLink() {
		        return	driver.findElement(Comments);
		        }
		    
		    public WebElement RecycleBinLink() {
		        return	driver.findElement(RecycleBin);
		        }
		    
		    public WebElement RSSLink() {
		        return	driver.findElement(RSS);
		        }
		    
		    public WebElement  AnalyticsLink() {
		        return	driver.findElement(Analytics);
		        }
		    
		    public WebElement  ReportsLink() {
		        return	driver.findElement(Reports);
		        }
		    
		    public WebElement  MarketingLink() {
		        return	driver.findElement(Marketing);
		        }
		    
		    public WebElement  CampaignsLink() {
		        return	driver.findElement(Campaigns);
		        }
		    
		    public WebElement  ServiceContractsLink() {
		        return	driver.findElement(ServiceContracts);
		        }
		    
		    public WebElement  ProjectMilestonesLink() {
		        return	driver.findElement(ProjectMilestones);
		        }
		    
		    public WebElement  ProjectTasksLink() {
		        return	driver.findElement(ProjectTasks);
		        }
		    
		    public WebElement  ProjectsLink() {
		        return	driver.findElement(Projects);
		        }
		    
		    public WebElement  FAQLink() {
		        return	driver.findElement(FAQ);
		        }
		    
		    public WebElement  InventoryLink() {
		        return	driver.findElement(Inventory);
		        }
		    
		    public WebElement  ServicesLink() {
		        return	driver.findElement(Services);
		        }
		    
		    public WebElement  AssetsLink() {
		        return	driver.findElement(Assets);
		        }
		    
		    public WebElement  PurchaseOrderLink() {
		        return	driver.findElement(PurchaseOrder);
		        }
		    
		    public WebElement  PriceBooksLink() {
		        return	driver.findElement(PriceBooks);
		        }
		    
		    public WebElement  VendorsLink() {
		        return	driver.findElement(Vendors);
		        }
		    
		    public WebElement  SalesLink() {
		        return	driver.findElement(Sales);
		        }
		    
		    public WebElement  InvoiceLink() {
		        return	driver.findElement(Invoice);
		        }
		    
		    public WebElement  SalesOrderLink() {
		        return	driver.findElement(SalesOrder);
		        }
		    
		    public WebElement  QuotesLink() {
		        return	driver.findElement(Quotes);
		        }
		    
		   
}
