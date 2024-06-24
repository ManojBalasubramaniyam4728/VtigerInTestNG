package Contacts;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjectRepo.contactsPage;
import PageObjectRepo.deleteContactsPage;
import PageObjectRepo.homePage;
import Resources.base;
import Resources.stepGroups;

public class TC003_Delete_A_Contact_And_Verify_If_Contact_Is_Deleted_Sucessfully extends base{
public static Logger log= LogManager.getLogger(TC003_Delete_A_Contact_And_Verify_If_Contact_Is_Deleted_Sucessfully.class.getName());
	
	
	@BeforeTest
	public void Depends_On_Scripts() throws IOException {
		TC002_Update_A_Contacts_And_Verify_If_Lead_Is_Updated_Successfully ucvcus = new TC002_Update_A_Contacts_And_Verify_If_Lead_Is_Updated_Successfully();
		ucvcus.Depends_On_Scripts();
		log.info("Successfully Created Organization for created contact");
		ucvcus.Update_Created_A_Contacts_And_Verify_It_Is_Updated();
		log.info("Successfully edited Contact");
		ucvcus.close_browser();
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
		contactsPage cp = new contactsPage(driver);
		deleteContactsPage dcp = new deleteContactsPage(driver);

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
		cp.DeleteContactsLink(concatenatedContactsFirstName).click();
		log.info("Successfully clicked on Delete Contacts Link");
		dcp.OkButton();
		log.info("Successfully Switch to Ok Button Alert popup");
		try {
			if (cp.DeleteContactsLink(concatenatedContactsFirstName).isDisplayed()) {
				log.error("Failed To Delete The Contacts");
			}

		} catch (NoSuchElementException exception) {
			log.info("Contacts Is Deleted Successfully");
		}
	}

	@AfterTest
	public void close_browser() {
		closingDriver();
		log.info("Successfully Closed The Browser");
	}
}
