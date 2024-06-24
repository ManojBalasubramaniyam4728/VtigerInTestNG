package Organization;

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
import PageObjectRepo.createOrganizationsPage;
import PageObjectRepo.homePage;
import PageObjectRepo.organizationsPage;
import Resources.base;
import Resources.stepGroups;

public class TC001_Create_An_Organization_And_Verify_If_Organization_Is_Created_Successfully extends base{
	public static Logger log=LogManager.getLogger(TC001_Create_An_Organization_And_Verify_If_Organization_Is_Created_Successfully.class.getName());

	@BeforeTest
	public void open_Browser_And_Navigate_To_Vtiger_Url_And_Login_To_Application() throws IOException {
		stepGroups sg = new stepGroups();
		sg.openBrowserAndNavigateToVtigerUrl();
		log.info("Successfully Opened Browser");
		sg.LoginToVtigerApplication();
		log.info("Successfully Loged in to vtiger application");
	}
	
	@Test
	public void Create_A_Organization_And_Verify() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(organizationsTestDataFilePath);
		prop.load(fis);
		String OrganizationName = prop.getProperty("OrganizationName");
		String Website = prop.getProperty("Website");
		String Employees = prop.getProperty("Employees");
		String AssignedToRadioButton = prop.getProperty("AssignedToRadioButton");
		String GroupAssignedToDropdown = prop.getProperty("GroupAssignedToDropdown");
		String Phone = prop.getProperty("Phone");
		String Email = prop.getProperty("Email");
		String BillingAddress = prop.getProperty("BillingAddress");
		String BillingPOBox = prop.getProperty("BillingPOBox");
		String BillingCity = prop.getProperty("BillingCity");
		String BillingState = prop.getProperty("BillingState");
		String BillingPostalCode = prop.getProperty("BillingPostalCode");
		String BillingCountry = prop.getProperty("BillingCountry");
		String LengthNumberOfDigits=prop.getProperty("LengthNumberOfDigits");
		
		homePage hp = new homePage(driver);
		organizationsPage op = new organizationsPage(driver);
		createOrganizationsPage cop = new createOrganizationsPage(driver);
		
		WaitUntilvisibilityOf(hp.HomePage());
		log.info("Successfully Waited Until Visiblity Of HomePage");
		hp.HomePage().isDisplayed();
		log.info("Home Page is displayed");
		hp.OrganizationsLink().click();
		log.info("Successfully clicked on Organizations Link");
		WaitUntilvisibilityOf(op.OrganizationsPageText());
		log.info("Successfully Waited Until Visiblity Of Organizations Page Text");
		op.OrganizationsPageText().isDisplayed();
		log.info("Organizations Page Text is displayed");
		op.CreateOrganizationsButton().click();
		log.info("Successfully clicked on Create Organizations Button");
		WaitUntilvisibilityOf(cop.CreatingNewOrganizationText());
		log.info("Successfully Waited Until Visiblity Of Creating New Organization Text");
		cop.CreatingNewOrganizationText().isDisplayed();
		log.info("Creating New Organization Text is displayed");
		cop.OrganizationNameTextfield().click();
		log.info("Successfully clicked on Organization Name Textfield");
		int IntegerLengthNumberOfDigits = convertingStringToInteger(LengthNumberOfDigits);
		log.info("Successfully Converted String To Integer");
		String randomNumber=generateRandomNumberWithLengthNumberOfDigits(IntegerLengthNumberOfDigits);
		log.info("Successfully Generate Random Number WithLength Number Of Digits");
		concatenatedOrganizationName=concatenateString1WithString2(OrganizationName, randomNumber);
		log.info("Successfully concatenate String1 With String2");
		cop.OrganizationNameTextfield().sendKeys(concatenatedOrganizationName);
		log.info("Successfully entered Organization Name in Organization Name Textfield");
		cop.WebsiteTextfield().click();
		log.info("Successfully clicked on Website Textfield");
		cop.WebsiteTextfield().sendKeys(Website);
		log.info("Successfully entered Website in Website Textfield");
		cop.EmployeesTextfield().click();
		log.info("Successfully clicked on Employees Textfield");
		cop.EmployeesTextfield().sendKeys(Employees);
		log.info("Successfully entered Employees in Employees Textfield");
		cop.EmailOptOutCheckbox().click();
		log.info("Successfully clicked on Email Opt Out Checkbox");
		cop.AssignedToRadioButton(AssignedToRadioButton).click();
		log.info("Successfully clicked on Assigned To Radio Button");
		cop.GroupAssignedToDropdown().click();
		log.info("Successfully clicked on GroupAssigned To Dropdown");
        selectingByVisibleText(cop.GroupAssignedToDropdown(), GroupAssignedToDropdown);
        log.info("Successfully seleceted on Group Assigned To Dropdown");
        cop.PhoneTextfield().click();
        log.info("Successfully clicked on Phone Textfield");
        cop.PhoneTextfield().sendKeys(Phone);
        log.info("Successfully entered Phone in Phone Textfield");
        cop.EmailTextfield().click();
        log.info("Successfully clicked on Email Textfield");
        cop.EmailTextfield().sendKeys(Email);
        log.info("Successfully entered Email in EmailTextfield");
        cop.BillingAddressTextarea().click();
        log.info("Successfully clicked on Billing Address Textarea");
        cop.BillingAddressTextarea().sendKeys(BillingAddress);
        log.info("Successfully entered Billing Address in Billing Address Textarea");
        cop.BillingPOBoxTextarea().click();
        log.info("Successfully clicked on Billing POBox Textarea");
        cop.BillingPOBoxTextarea().sendKeys(BillingPOBox);
        log.info("Successfully entered Billing POBox in Billing POBox Textarea");
        cop.BillingCityTextfield().click();
        log.info("Successfully clicked on Billing City Textfield");
        cop.BillingCityTextfield().sendKeys(BillingCity);
        log.info("Successfully entered Billing City in Billing City Textfield");
        cop.BillingStateTextfield().click();
        log.info("Successfully clicked on Billing State Textfield");
        cop.BillingStateTextfield().sendKeys(BillingState);
        log.info("Successfully entered Billing State in Billing State Textfield");
        cop.BillingCountryTextfield().click();
        log.info("Successfully clicked on Billing Country Textfield");
        cop.BillingCountryTextfield().sendKeys(BillingCountry);
        log.info("Successfully entered Billing Country in Billing Country Textfield");
        cop.BillingPostalCodeTextfield().click();
        log.info("Successfully clicked on Billing Postal Code Textfield");
        cop.BillingPostalCodeTextfield().sendKeys(BillingPostalCode);
        log.info("Successfully entered Billing PostalCode in Billing Postal Code Textfield");
        cop.CopyBillingAddressRadioButton().click();
        log.info("Successfully clicked on Copy Billing Address Radio Button");
        cop.SaveButton().click();
        log.info("Successfully clicked on Save Button");
        WaitUntilvisibilityOfElementLocated(cop.OrganizationInformationTitleLocater());
        log.info("Successfully Waited Until Visiblity Of Organization Information Title Locater");
        cop.OrganizationInformationTitle().isDisplayed();
        log.info("Organization Information Title Locateris displayed");
        hp.OrganizationsLink().click();
        log.info("Successfully clicked on Organizations Link");
        WaitUntilvisibilityOf(op.OrganizationsPageText());
        log.info("Successfully Waited Until Visiblity Of Organizations Page Text");
        List<String> OrganizationsNames= getTextInList(op.OrganizationsInformationVerification());
        log.info("Successfully Getted Text from List of Organizations Information Verification");
        Boolean isDispalyed= isStringPresentInList(OrganizationsNames,concatenatedOrganizationName);
        log.info("Successfully Stored whether string is present in List or Not");
        assertTrue(isDispalyed);
        log.info("Organizations Is Created Successfully");
	}
	
      @AfterTest
     public void close_browser() {
       stepGroups sg = new stepGroups();
       sg.closeBrowser();
       log.info("Successfully Closed The Browser");
    	}
	}

