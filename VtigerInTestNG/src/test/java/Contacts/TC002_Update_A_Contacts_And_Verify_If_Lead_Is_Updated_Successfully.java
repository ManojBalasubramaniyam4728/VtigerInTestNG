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
import PageObjectRepo.contactsPage;
import PageObjectRepo.createContactsPage;
import PageObjectRepo.editingContactsInformationPagePage;
import PageObjectRepo.homePage;
import Resources.base;
import Resources.stepGroups;

public class TC002_Update_A_Contacts_And_Verify_If_Lead_Is_Updated_Successfully extends base {
	public static Logger log=LogManager.getLogger(TC002_Update_A_Contacts_And_Verify_If_Lead_Is_Updated_Successfully.class.getName());
 
	@BeforeTest
	public void Depends_On_Scripts() throws IOException {
		TC001_Create_A_Contact_And_Verify_If_Contact_Is_Created_Successfully ccavcs = new TC001_Create_A_Contact_And_Verify_If_Contact_Is_Created_Successfully();
		ccavcs.Depends_On_Scripts();
		log.info("Successfully Created Organization for creating contact");
		ccavcs.Create_A_Contacts_And_Verify();
		log.info("Contacts is Created Successfully");
		ccavcs.close_browser();
		log.info("Successfully Closed The Browser");
	}

	@Test
	public void Update_Created_A_Contacts_And_Verify_It_Is_Updated() throws IOException {
		
		stepGroups sg = new stepGroups();
		
		sg.openBrowserAndNavigateToVtigerUrl();
		log.info("Successfully Opened Browser");
		sg.LoginToVtigerApplication();
		log.info("Successfully Loged in to vtiger application");
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(contactsTestDataFilePath);
		prop.load(fis);
		
		String EditingEmailId = prop.getProperty("EditingEmailId");

		homePage hp = new homePage(driver);
		contactsPage cp = new contactsPage(driver);
		editingContactsInformationPagePage ecp = new editingContactsInformationPagePage(driver);
		createContactsPage ccp = new createContactsPage(driver);
		
		WaitUntilvisibilityOf(hp.HomePage());
		log.info("Successfully Waited Until Visiblity Of HomePage");
		hp.HomePage().isDisplayed();
		log.info("Home Page is displayed"); 
		hp.ContactsLink().click();
		log.info("Successfully clicked on ContactsLink");
		WaitUntilvisibilityOf(cp.ContactsPageText());
		log.info("Successfully Waited Until Visiblity Of Contacts Page Text");
		cp.ContactsPageText().isDisplayed();
		log.info("Contacts Page Text is displayed"); 
		cp.EditContactsLink(concatenatedContactsFirstName).click();
		log.info("Successfully clicked on Edit Contacts Link");
		WaitUntilvisibilityOf(ecp.EditingContactInformationPageText());
		log.info("Successfully Waited Until Visiblity Of Editing Contact Information PageText");
		ecp.EditingContactInformationPageText().isDisplayed();
		log.info("Editing Contact Information Page Text is displayed"); 
		ccp.EmailTextfield().click();
		log.info("Successfully clicked on Email Textfield");
		ccp.EmailTextfield().clear();
		log.info("Successfully cleared text in Email Textfield");
		ccp.EmailTextfield().sendKeys(EditingEmailId);
		log.info("Successfully entered  EditingEmailId in Editing Email Id Textfield");
		scrollTillElementIsvisable(ccp.SaveButton());
		log.info("Successfully scroll Till SaveButton Is visable");
		ccp.SaveButton().click();
		log.info("Successfully clicked on Save Button");
		WaitUntilvisibilityOf(cp.ContactsPageText());
		log.info("Successfully Waited Until Visiblity Of Contacts Page Text");
		List<String> EditedEmailId = getTextInList(cp.EditedContactsEmailVerification());
		log.info("Successfully Getted Text from List of Edited Contacts Email Verification");
		Boolean isDispalyed = isStringPresentInList(EditedEmailId, EditingEmailId);
		log.info("Successfully Stored whether string is present in List or Not");
		assertTrue(isDispalyed);
		log.info("Contacts Email Id is Successfully Edited");
	}

	@AfterTest
	public void close_browser() {
		closingDriver();
		log.info("Successfully Closed The Browser");
	}

}
