package Vendor;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjectRepo.deleteVendor;
import PageObjectRepo.homePage;
import PageObjectRepo.moreLinkPage;
import PageObjectRepo.vendorPage;
import Resources.base;
import Resources.stepGroups;

public class TC003_Delete_A_Vendor_And_Verify_If_Vendor_Is_Deleted_Sucessfully extends base{
	public static Logger log=LogManager.getLogger(TC003_Delete_A_Vendor_And_Verify_If_Vendor_Is_Deleted_Sucessfully.class.getName());
	
	@BeforeTest
	public void Depends_On_Scripts() throws IOException {
		TC002_Update_A_Vendor_And_Verify_If_Vendor_Is_Updated_Successfully uvav = new TC002_Update_A_Vendor_And_Verify_If_Vendor_Is_Updated_Successfully();
		uvav.Depends_On_Scripts();
		log.info("Successfully Opened Browser and crated Vendor");
		uvav.Update_Created_a_Vandor_and_Verify_It_Is_Updated();
		log.info("Successfully upadeted crated Vendor");
		uvav.close_browser();
		log.info("Successfully Closed The Browser");
	}
	
		@Test
		public void Delete_The_Created_And_Updated_Lead() throws IOException {
			
	        stepGroups sg = new stepGroups();
			
			sg.openBrowserAndNavigateToVtigerUrl();
			log.info("Successfully Opened Browser");
			sg.LoginToVtigerApplication();
			log.info("Successfully Loged in to vtiger application");
			
			homePage hp = new homePage(driver);
			vendorPage vp = new vendorPage(driver);
			deleteVendor dvp = new deleteVendor(driver);
			moreLinkPage mlp=new moreLinkPage(driver);

			WaitUntilvisibilityOf(hp.HomePage());
			log.info("Successfully Waited Until Visiblity Of HomePage");
			hp.HomePage().isDisplayed();
			log.info("Home Page is displayed");
			hp.MoreButton().click();
			log.info("Successfully clicked on More Button");
			mlp.VendorsLink().click();
			log.info("Successfully clicked on Vendors Link");
			WaitUntilvisibilityOf(vp.VendorsPageText());
			log.info("Successfully Waited Until Visiblity Of Vendors Page Text");
			vp.VendorsPageText().isDisplayed();
			log.info("Vendors Page Text is displayed");
			vp.DeleteVendorNameLink(concatenatedVendorName).click();
			log.info("Successfully clicked on Delete Vendor Name Link");
			dvp.OkButton();
			log.info("Successfully Switch to Ok Button Alert popup");
			try {
				if (vp.DeleteVendorNameLink(concatenatedVendorName).isDisplayed()) {
					log.error("Failed To Delete The Vendor");
				}

			} catch (NoSuchElementException exception) {
				log.info("Vendor Is Deleted Successfully");
			}
		}

		@AfterTest
		public void close_browser() {
			closingDriver();
			log.info("Successfully Closed The Browser");
		}
}
