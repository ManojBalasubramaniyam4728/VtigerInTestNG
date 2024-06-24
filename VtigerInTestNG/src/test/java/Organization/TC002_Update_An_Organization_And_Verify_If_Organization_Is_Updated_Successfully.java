 package Organization;

import static org.testng.Assert.assertTrue; 

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjectRepo.createOrganizationsPage;
import PageObjectRepo.editingOrganizationsInformationPage;
import PageObjectRepo.homePage;
import PageObjectRepo.organizationsPage;
import Resources.base;
import Resources.stepGroups;

public class TC002_Update_An_Organization_And_Verify_If_Organization_Is_Updated_Successfully extends base {
	public static Logger log=LogManager.getLogger(TC002_Update_An_Organization_And_Verify_If_Organization_Is_Updated_Successfully.class.getName());

	@BeforeTest
	public void Depends_On_Scripts() throws IOException {
		TC001_Create_An_Organization_And_Verify_If_Organization_Is_Created_Successfully coav = new TC001_Create_An_Organization_And_Verify_If_Organization_Is_Created_Successfully();
		coav.open_Browser_And_Navigate_To_Vtiger_Url_And_Login_To_Application();
		log.info("Successfully Opened Browser");
		coav.Create_A_Organization_And_Verify();
		log.info("Successfully Organization created ");
		coav.close_browser();
		log.info("Successfully Closed The Browser");
	}
	
	@Test
	public void Update_Created_a_Organization_and_Verify_It_Is_Updated() throws IOException {
			
			stepGroups sg = new stepGroups();
			
			sg.openBrowserAndNavigateToVtigerUrl();
			log.info("Successfully Opened Browser");
			sg.LoginToVtigerApplication();
			log.info("Successfully Loged in to vtiger application");
			
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(organizationsTestDataFilePath);
			prop.load(fis);
			String EditingEmailId = prop.getProperty("EditingEmailId");
			String getAttribute = prop.getProperty("getAttribute");

		    homePage hp = new homePage(driver);
			organizationsPage op = new organizationsPage(driver);
			editingOrganizationsInformationPage eop = new editingOrganizationsInformationPage(driver);
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
			op.EditOrganizationsLink(concatenatedOrganizationName).click();
			log.info("Successfully clicked on Edit Organizations Link");
			WaitUntilvisibilityOf(eop.EditingOrganizationsInformationPageText());
			log.info("Successfully Waited Until Visiblity Of Editing Organizations Information Page Text");
			eop.EditingOrganizationsInformationPageText().isDisplayed();
			log.info("Editing Organizations Information Page Text is displayed");
			cop.EmailTextfield().click();
			log.info("Successfully clicked on Email Textfield");
			cop.EmailTextfield().clear();
			log.info("Successfully cleared on Email Textfield");
			cop.EmailTextfield().sendKeys(EditingEmailId);
			log.info("Successfully entered EditingEmailId in Email Textfield");
			scrollTillElementIsvisable(cop.SaveButton());
			log.info("Successfully scroll Till SaveButton Is visable");
			cop.SaveButton().click();
			log.info("Successfully clicked on Save Button");
			WaitUntilvisibilityOf(op.OrganizationsPageText());
			log.info("Successfully Waited Until Visiblity Of Organizations Page Text");
			refreshBrowserWindow();
			log.info("Successfully refreshed Browser Window");
			op.EditOrganizationsLink(concatenatedOrganizationName).click();
			log.info("Successfully clicked on EditOrganizations Link");
			WaitUntilvisibilityOf(eop.EditingOrganizationsInformationPageText());
			log.info("Successfully Waited Until Visiblity Of Editing Organizations Information Page Text");
			eop.EditingOrganizationsInformationPageText().isDisplayed();
			log.info("Editing Organizations Information Page Text is displayed");
			String EditedEmailId=cop.EmailTextfield().getAttribute(getAttribute);
			log.info("Successfully getted getAttribute from displayed and stored in variable");
			assertTrue(EditingEmailId.contains(EditedEmailId));
			log.info("Organizations Email Id is Successfully Edited");
	 }
	
		@AfterTest
		public void close_browser() {
			closingDriver();
			log.info("Successfully Closed The Browser");
		}
	}
	