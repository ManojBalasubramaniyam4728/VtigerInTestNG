package Organization;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjectRepo.deleteOrganizationsPage;
import PageObjectRepo.homePage;
import PageObjectRepo.organizationsPage;
import Resources.base;
import Resources.stepGroups;

public class TC003_Delete_An_Organization_And_Verify_If_Organization_Is_Deleted_successfully extends base {
	public static Logger log=LogManager.getLogger(TC003_Delete_An_Organization_And_Verify_If_Organization_Is_Deleted_successfully.class.getName());

	@BeforeTest
	public void Depends_On_Scripts() throws IOException {
		TC002_Update_An_Organization_And_Verify_If_Organization_Is_Updated_Successfully uaav = new TC002_Update_An_Organization_And_Verify_If_Organization_Is_Updated_Successfully();
		uaav.Depends_On_Scripts();
		log.info("Successfully Opened Browser and crated Organization");
		uaav.Update_Created_a_Organization_and_Verify_It_Is_Updated();
		log.info("Successfully upadeted crated Organization");
		uaav.close_browser();
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
			organizationsPage op = new organizationsPage(driver);
			deleteOrganizationsPage dop = new deleteOrganizationsPage(driver);

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
			op.DeleteOrganizationsLink(concatenatedOrganizationName).click();
			log.info("Successfully clicked on DeleteOrganizations Link");
			dop.OkButton();
			log.info("Successfully Switch to Ok Button Alert popup");
			try {
				if (op.DeleteOrganizationsLink(concatenatedOrganizationName).isDisplayed()) {
					log.error("Failed To Delete The Organizations");
				}

			} 
			catch (NoSuchElementException exception) {
				log.info("Organizations Is Deleted Successfully");
			}
		}

		@AfterTest
		public void close_browser() {
			closingDriver();
			log.info("Successfully Closed The Browser");
		}
	}

