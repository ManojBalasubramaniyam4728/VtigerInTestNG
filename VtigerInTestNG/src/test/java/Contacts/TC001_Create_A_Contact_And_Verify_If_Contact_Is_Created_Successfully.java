package Contacts;

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
import Organization.TC001_Create_An_Organization_And_Verify_If_Organization_Is_Created_Successfully;
import PageObjectRepo.contactsPage;
import PageObjectRepo.createContactsPage;
import PageObjectRepo.homePage;
import Resources.base;
import Resources.stepGroups;

public class TC001_Create_A_Contact_And_Verify_If_Contact_Is_Created_Successfully extends base {
	public static Logger log=LogManager.getLogger(TC001_Create_A_Contact_And_Verify_If_Contact_Is_Created_Successfully.class.getName());
	
	@BeforeTest
	public void Depends_On_Scripts() throws IOException {
		TC001_Create_An_Organization_And_Verify_If_Organization_Is_Created_Successfully coav = new TC001_Create_An_Organization_And_Verify_If_Organization_Is_Created_Successfully();
		coav.open_Browser_And_Navigate_To_Vtiger_Url_And_Login_To_Application();
		log.info("Browser Opened Loged In To Vtiger successfully "); 
		coav.Create_A_Organization_And_Verify();
		log.info("Organization Created Successfully"); 
		coav.close_browser();
		log.info("Browser Closed Successfully"); 
	}
	
	@Test
	public void Create_A_Contacts_And_Verify() throws IOException {
		stepGroups sg = new stepGroups();
		
		sg.openBrowserAndNavigateToVtigerUrl();
		sg.LoginToVtigerApplication();
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(contactsTestDataFilePath);
		prop.load(fis);
		String Salutation = prop.getProperty("Salutation");
		String FirstName = prop.getProperty("FirstName");
		String LastName = prop.getProperty("LastName");
		String ParentUrl = prop.getProperty("ParentUrl");
		String PopupUrl = prop.getProperty("PopupUrl");
		String Email = prop.getProperty("Email");
		String Phone = prop.getProperty("Phone");
		String AssignedToRadioButton = prop.getProperty("AssignedToRadioButton");
		String AssignedTo = prop.getProperty("AssignedTo");
		String MailingAddress = prop.getProperty("MailingAddress");
		String MailingPOBox = prop.getProperty("MailingPOBox");
		String MailingCity = prop.getProperty("MailingCity");
		String MailingState = prop.getProperty("MailingState");
		String MailingPostalCode = prop.getProperty("MailingPostalCode");
		String MailingCountry = prop.getProperty("MailingCountry");
		String LengthNumberOfDigits=prop.getProperty("LengthNumberOfDigits");
		
		homePage hp = new homePage(driver);
		contactsPage cp = new contactsPage(driver);
		createContactsPage ccp=new createContactsPage(driver);
		
		WaitUntilvisibilityOf(hp.HomePage());
		log.info("Successfully Waited Until Visiblity Of HomePage"); 
		hp.HomePage().isDisplayed();
		log.info("Home Page is displayed"); 
		hp.ContactsLink().click();
		log.info("Successfully clicked on ContactsLink"); 
		WaitUntilvisibilityOf(cp.ContactsPageText());
		log.info("Successfully Waited Until Visiblity Of Contacts Page"); 
		cp.ContactsPageText().isDisplayed();
		log.info("Contacts Page Text is displayed"); 
		cp.CreateContactsButton().click();
		log.info("Successfully clicked on Create Contacts Button");
		WaitUntilvisibilityOf(ccp.CreatingNewContactText());
		log.info("Successfully Waited Until Visiblity Of Creating New Contact Text"); 
		ccp.CreatingNewContactText().isDisplayed();
		log.info("Creating New Contact Text is displayed"); 
		ccp.SalutationDropdown().click();
		log.info("Successfully clicked on Salutation Dropdown");
		selectingByVisibleText(ccp.SalutationDropdown(), Salutation);
		log.info("Successfully seleceted on Salutation Dropdown");
		ccp.FirstNameTextfield().click();
		log.info("Successfully clicked on First Name Textfield");
		int IntegerLengthNumberOfDigits = convertingStringToInteger(LengthNumberOfDigits);
		log.info("Successfully Converted String To Integer");
		String randomNumber=generateRandomNumberWithLengthNumberOfDigits(IntegerLengthNumberOfDigits);
		log.info("Successfully Generate Random Number WithLength Number Of Digits");
		concatenatedContactsFirstName=concatenateString1WithString2(FirstName, randomNumber);
		log.info("Successfully concatenate String1 With String2");
		ccp.FirstNameTextfield().sendKeys(concatenatedContactsFirstName);
		log.info("Successfully entered  concatenated Contacts FirstName in First Name Textfield");
		ccp.LastNameTextfield().click();
		log.info("Successfully clicked on Last Name Textfield");
		ccp.LastNameTextfield().sendKeys(LastName);
		log.info("Successfully entered  Last Name in Last Name Textfield");
		ccp.SelectOrganizationPlusButton().click();
		log.info("Successfully seleceted on Organization Plus Button");
		switchtToWindowIfURLContainsUrl(PopupUrl);
		log.info("Successfully switcht To Window If URL Contains PopupUrl");
		WaitUntilvisibilityOf(ccp.OrganizationsPopupText());
		log.info("Successfully Waited Until Visiblity Of Organizations Popup Text");
		ccp.OrganizationsPopupText().isDisplayed();
		log.info("Organizations Popup Text Page is displayed"); 
	    int size=getSizeInList(ccp.NumberOfOrganizationsLink());
	    log.info("Successfully Getted Size In List"); 
	    ccp.LastOrganizationNameInOrganizationPopupLink(size).click();
	    log.info("Successfully Getted Size In List"); 
	    switchtToWindowIfURLContainsUrl(ParentUrl);
	    log.info("Successfully switcht To Window If URL Contains ParentUrl");
	    ccp.EmailTextfield().click();
	    log.info("Successfully clicked on Email Textfield");
	    ccp.EmailTextfield().sendKeys(Email);
	    log.info("Successfully entered  Email  in Email Textfield");
	    ccp.MobileTextfield().click();
	    log.info("Successfully clicked on Mobile Textfield");
	    ccp.MobileTextfield().sendKeys(Phone);
	    log.info("Successfully entered  Mobile Number in Mobile Number Textfield");
	    ccp.AssignedToRadioButton(AssignedToRadioButton).click();
	    log.info("Successfully clicked on Assigned To Radio Button");
	    ccp.GroupAssignedToDropdown().click();
	    log.info("Successfully clicked on Group Assigned To Dropdown");
	    selectingByVisibleText(ccp.GroupAssignedToDropdown(), AssignedTo);
		log.info("Successfully seleceted on Assigned To");
	    ccp.MailingStreetTextarea().click();
	    log.info("Successfully clicked on Mailing Street Textarea");
	    ccp.MailingStreetTextarea().sendKeys(MailingAddress);
	    log.info("Successfully entered Mailing Street in Mailing Street Textarea");
	    ccp.MailingPoboxTextfield().click();
	    log.info("Successfully clicked on Mailing Pobox Textfield");
	    ccp.MailingPoboxTextfield().sendKeys(MailingPOBox);
	    log.info("Successfully entered Mailing Pobox in Mailing Pobox Textfield");
	    ccp.MailingCityTextfield().click();
	    log.info("Successfully clicked on Mailing City Textfield");
	    ccp.MailingCityTextfield().sendKeys(MailingCity);
	    log.info("Successfully entered Mailing City in Mailing City Textfield");
	    ccp.MailingStateTextfield().click();
	    log.info("Successfully clicked on Mailing State Textfield");
	    ccp.MailingStateTextfield().sendKeys(MailingState);
	    log.info("Successfully entered Mailing State in Mailing State Textfield");
	    ccp.MailingPostalCodeTextfield().click();
	    log.info("Successfully clicked on Mailing Postal Code Textfield");
	    ccp.MailingPostalCodeTextfield().sendKeys(MailingPostalCode);
	    log.info("Successfully entered Mailing Postal Code in Mailing Postal Code Textfield");
	    ccp.MailingCountryTextfield().click();
	    log.info("Successfully clicked on Mailing Country Textfield");
	    ccp.MailingCountryTextfield().sendKeys(MailingCountry);
	    log.info("Successfully entered Mailing Country in Mailing Country Textfield");
	    ccp.CopyMailingAddressRadioButton().click();
	    log.info("Successfully clicked on Copy Mailing Address Radio Button");
	    ccp.SaveButton().click();
	    log.info("Successfully clicked on Save Button");
	    WaitUntilvisibilityOf(ccp.ContactInformationTitle());
	    log.info("Successfully Waited Until Visiblity Of Contact Information Title"); 
        ccp.ContactInformationTitle().isDisplayed();
        log.info("Contact Information Title is displayed"); 
        hp.ContactsLink().click();
        log.info("Successfully clicked on Contacts Link");
        WaitUntilvisibilityOf(cp.ContactsPageText());
        log.info("Successfully Waited Until Visiblity Of Contacts Page Text");
        List<String> ContactsNames= getTextInList(cp.ContactsInformationVerification());
        log.info("Successfully Getted Text from List of Contacts Information Verification");
        Boolean isDispalyed= isStringPresentInList(ContactsNames,concatenatedContactsFirstName);
        log.info("Successfully Stored whether string is present in List or Not");
        assertTrue(isDispalyed);
        log.info("Contacts is Created Successfully");
	}
       
	@AfterTest
	 public void close_browser() {
		closingDriver();
		log.info("Successfully Closed The Browser");
	}
	    
	   
  }