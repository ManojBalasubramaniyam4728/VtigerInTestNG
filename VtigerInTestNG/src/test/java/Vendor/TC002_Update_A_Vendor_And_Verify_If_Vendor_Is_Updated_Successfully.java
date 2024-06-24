package Vendor;

import static org.testng.Assert.assertTrue; 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjectRepo.createVendorPage;
import PageObjectRepo.editingVendorInformationPage;
import PageObjectRepo.homePage;
import PageObjectRepo.moreLinkPage;
import PageObjectRepo.vendorPage;
import Resources.base;
import Resources.stepGroups;

public class TC002_Update_A_Vendor_And_Verify_If_Vendor_Is_Updated_Successfully extends base {
	public static Logger log=LogManager.getLogger(TC002_Update_A_Vendor_And_Verify_If_Vendor_Is_Updated_Successfully.class.getName());
	
	@BeforeTest
	public void Depends_On_Scripts() throws IOException {
		TC001_Create_A_Vendor_And_Verify_If_Vendor_Is_Created_Successfully cvav = new TC001_Create_A_Vendor_And_Verify_If_Vendor_Is_Created_Successfully();
		cvav.open_Browser_And_Navigate_To_Vtiger_Url_And_Login_To_Application();
		log.info("Successfully Opened Browser And Loged in to Vtiger application");
		cvav.Create_A_Vendor_And_Verify();
		log.info("Successfully Vendor created ");
		cvav.close_browser();
		log.info("Successfully Closed The Browser");
	}
	
	@Test
	public void Update_Created_a_Vandor_and_Verify_It_Is_Updated() throws IOException {
			
			stepGroups sg = new stepGroups();
			
			sg.openBrowserAndNavigateToVtigerUrl();
			log.info("Successfully Opened Browser");
			sg.LoginToVtigerApplication();
			log.info("Successfully Loged in to vtiger application");
			
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(vendorTestDataFilePath);
			prop.load(fis);
			String EditingGLAccount = prop.getProperty("EditingGLAccount");
			String getAttribute = prop.getProperty("getAttribute");

		    homePage hp = new homePage(driver);
			vendorPage vp = new vendorPage(driver);
			editingVendorInformationPage evp = new editingVendorInformationPage(driver);
			createVendorPage cvp = new createVendorPage(driver);
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
			vp.EditVendorLink(concatenatedVendorName).click();
			log.info("Successfully clicked on Edit Vendor Link");
			WaitUntilvisibilityOf(evp.EditingVendorInformationPageText());
			log.info("Successfully Waited Until Visiblity Of Editing Vendor Information Page Text");
			evp.EditingVendorInformationPageText().isDisplayed();
			log.info("Editing Vendor Information Page Text is displayed");
			cvp.GLAccountDropdown().click();
			log.info("Successfully clicked on GL Account Dropdown");
			selectingByValue(cvp.GLAccountDropdown(), EditingGLAccount);
			log.info("Successfully Selected Editing GL Account in GL Account Dropdown ");
			scrollTillElementIsvisable(cvp.SaveButton());
			log.info("Successfully scroll Till SaveButton Is visable");
			cvp.SaveButton().click();
			log.info("Successfully clicked on Save Button");
			WaitUntilvisibilityOf(vp.VendorsPageText());
			log.info("Successfully Waited Until Visiblity Of Vendors Page Text");
			refreshBrowserWindow();
			log.info("Successfully refreshed Browser Window");
			vp.EditVendorLink(concatenatedVendorName).click();
			log.info("Successfully clicked on Edit Vendor Link");
			WaitUntilvisibilityOf(evp.EditingVendorInformationPageText());
			log.info("Successfully Waited Until Visiblity Of Editing Vendor Information- PageText");
			evp.EditingVendorInformationPageText().isDisplayed();
			log.info("Editing Vendor Information Page Text is displayed");
			String GLAccount=cvp.GLAccountDropdown().getAttribute(getAttribute);
			log.info("Successfully getted getAttribute from displayed and stored in variable");
			assertTrue(EditingGLAccount.contains(GLAccount));
			log.info("Vendor Email Id is Successfully Edited");
	}
	
		@AfterTest
		public void close_browser() {
			closingDriver();
			log.info("Successfully Closed The Browser");
		}
}
