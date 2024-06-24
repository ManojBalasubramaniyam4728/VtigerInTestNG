package Leads;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjectRepo.deleteLeadPage;
import PageObjectRepo.homePage;
import PageObjectRepo.leadsPage;
import Resources.base;
import Resources.stepGroups;

public class TC003_Delete_A_Lead_And_Verify_If_Lead_Is_Deleted_Successfully extends base {
	public static Logger log=LogManager.getLogger(TC003_Delete_A_Lead_And_Verify_If_Lead_Is_Deleted_Successfully.class.getName());
	
	@BeforeTest
	public void Depends_On_Scripts() throws IOException {
		TC002_Update_A_Lead_And_Verify_If_Lead_Is_Updated_Successfully ulvlus = new TC002_Update_A_Lead_And_Verify_If_Lead_Is_Updated_Successfully();
		ulvlus.Depends_On_Scripts();
		log.info("Successfully Created Leads");
		ulvlus.Update_Created_A_Lead_And_Verify_It_Is_Updated();
		log.info("Successfully upadeted crated Lead");
		ulvlus.close_browser();
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
		leadsPage lp = new leadsPage(driver);
		deleteLeadPage dlp = new deleteLeadPage(driver);

		WaitUntilvisibilityOf(hp.HomePage());
		log.info("Successfully Waited Until Visiblity Of HomePage");
		hp.HomePage().isDisplayed();
		log.info("Home Page is displayed");
		hp.LeadsLink().click();
		log.info("Successfully clicked on Leads Link");
		WaitUntilvisibilityOf(lp.LeadsPageText());
		log.info("Successfully Waited Until Visiblity Of Leads Page Text");
		lp.LeadsPageText().isDisplayed();
		log.info("Leads Page Text is displayed");
		lp.DeleteLeadLink(concatenatedLeadFirstName).click();
		log.info("Successfully clicked on Delete Lead Link");
		dlp.OkButton();
		log.info("Successfully Switch to Ok Button Alert popup");
		try {
			if (lp.DeleteLeadLink(concatenatedLeadFirstName).isDisplayed()) {
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
