package Vendor;

import static org.testng.Assert.assertTrue; 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjectRepo.createVendorPage;
import PageObjectRepo.homePage;
import PageObjectRepo.moreLinkPage;
import PageObjectRepo.vendorPage;
import Resources.base;
import Resources.stepGroups;

public class TC001_Create_A_Vendor_And_Verify_If_Vendor_Is_Created_Successfully extends base{
	public static Logger log=LogManager.getLogger(TC001_Create_A_Vendor_And_Verify_If_Vendor_Is_Created_Successfully.class.getName());
	
		@BeforeTest
		public void open_Browser_And_Navigate_To_Vtiger_Url_And_Login_To_Application() throws IOException {
			stepGroups sg = new stepGroups();
			sg.openBrowserAndNavigateToVtigerUrl();
			log.info("Successfully Opened Browser");
			sg.LoginToVtigerApplication();
			log.info("Successfully Loged in to vtiger application");
		}
		
		@Test
		public void Create_A_Vendor_And_Verify() throws IOException {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(vendorTestDataFilePath);
			prop.load(fis);
			String VendorName = prop.getProperty("VendorName");
			String Email = prop.getProperty("Email");
			String GLAccount = prop.getProperty("GLAccount");
			String PhoneNo = prop.getProperty("PhoneNo");
			String Website = prop.getProperty("Website");
			String Street = prop.getProperty("Street");
			String City = prop.getProperty("City");
			String PostalCode = prop.getProperty("PostalCode");
			String PObox = prop.getProperty("PObox");
			String State = prop.getProperty("State");
			String Country = prop.getProperty("Country");
			String Description = prop.getProperty("Description");
			String LengthNumberOfDigits=prop.getProperty("LengthNumberOfDigits");
			
			homePage hp = new homePage(driver);
			vendorPage vp = new vendorPage(driver);
			createVendorPage cvp = new createVendorPage(driver);
			moreLinkPage mlp = new moreLinkPage(driver);
			
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
			vp.CreateVendorButton().click();
			log.info("Successfully clicked on Create Vendor Button");
			WaitUntilvisibilityOf(cvp.CreatingNewVendorText());
			log.info("Successfully Waited Until Visiblity Of Creating New Vendor Text");
			cvp.CreatingNewVendorText().isDisplayed();
			log.info("Creating New Vendor Text is displayed");
			cvp.VendorNameTextfield().click();
			log.info("Successfully clicked on Vendor Name Textfield");
			int IntegerLengthNumberOfDigits = convertingStringToInteger(LengthNumberOfDigits);
			log.info("Successfully Converted String To Integer");
			String randomNumber=generateRandomNumberWithLengthNumberOfDigits(IntegerLengthNumberOfDigits);
			concatenatedVendorName=concatenateString1WithString2(VendorName, randomNumber);
			log.info("Successfully Generate Random Number WithLength Number Of Digits");
			cvp.VendorNameTextfield().sendKeys(concatenatedVendorName);
			log.info("Successfully entered Vendor Name Textfield in Vendor Name Textfield");
			cvp.EmailTextfield().click();
			log.info("Successfully clicked on Email Textfield");
	        cvp.EmailTextfield().sendKeys(Email);
	        log.info("Successfully entered Email in Email Textfield");
	        cvp.GLAccountDropdown().click();
	        log.info("Successfully clicked on GLAccount- Dropdown");
	        selectingByValue(cvp.GLAccountDropdown(), GLAccount);
	        log.info("Successfully Selected GL Account in GL Account Dropdown ");
			cvp.WebsiteTextfield().click();
			log.info("Successfully clicked on Website Textfield");
			cvp.WebsiteTextfield().sendKeys(Website);
			log.info("Successfully entered Website in WebsiteTextfield");
			cvp.PhoneTextfield().click();
			log.info("Successfully clicked on Phone Textfield");
	        cvp.PhoneTextfield().sendKeys(PhoneNo);
	        log.info("Successfully entered PhoneNo in PhoneNo Textfield");
			cvp.StreetTextare().click();
			log.info("Successfully clicked on Street Textare");
	        cvp.StreetTextare().sendKeys(Street);
	        log.info("Successfully entered Street in Street Textfield");
	        cvp.CityTextfield().click();
	        log.info("Successfully clicked on Email Textfield");
	        cvp.CityTextfield().sendKeys(City);
	        log.info("Successfully entered City in City Textfield");
	        cvp.PostalCodeTextfield().click();
	        log.info("Successfully clicked on Postal Code Textfield");
	        cvp.PostalCodeTextfield().sendKeys(PostalCode);
	        log.info("Successfully entered PostalCode in PostalCode Textfield");
	        cvp.PoboxTextfield().click();
	        log.info("Successfully clicked on Pobox Textfield");
	        cvp.PoboxTextfield().sendKeys(PObox);
	        log.info("Successfully entered PObox in PObox Textfield");
	        cvp.StateTextfield().click();
	        log.info("Successfully clicked on State Textfield");
	        cvp.StateTextfield().sendKeys(State);
	        log.info("Successfully entered State in State Textfield");
	        cvp.CountryTextfield().click();
	        log.info("Successfully clicked on Country Textfield");
	        cvp.CountryTextfield().sendKeys(Country);
	        log.info("Successfully entered Country in Country Textfield");
	        cvp.DescriptionTextfield().sendKeys(Description);
	        log.info("Successfully entered Description in Description Textarea");
	        cvp.SaveButton().click();
	        log.info("Successfully clicked on Save Button");
	        WaitUntilvisibilityOf(cvp.VendorInformationTitle());
	        log.info("Successfully Waited Until Visiblity Of Vendor Information Title");
	        cvp.VendorInformationTitle().isDisplayed();
	        log.info("Vendor Information Title is displayed");
	        mlp.VendorsLink().click();
	        log.info("Successfully clicked on Vendors Link");
	        WaitUntilvisibilityOf(vp.VendorsPageText());
	        log.info("Successfully Waited Until Visiblity Of Vendors Page Text");
	        List<String> VandorNames= getTextInList(vp.VendorInformationVerification());
	        log.info("Successfully Getted Text from List of Vendor Information Verification");
	        Boolean isDispalyed= isStringPresentInList(VandorNames,concatenatedVendorName);
	        log.info("Successfully Stored whether string is present in List or Not");
	        assertTrue(isDispalyed);
	        log.info("Vendor Is Created Successfully");
		}
		
	      @AfterTest
	     public void close_browser() {
	       stepGroups sg = new stepGroups();
	       sg.closeBrowser();
	       log.info("Successfully Closed The Browser");
	    	}

}
