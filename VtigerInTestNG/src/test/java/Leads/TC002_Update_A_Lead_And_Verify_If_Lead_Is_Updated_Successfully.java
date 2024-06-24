package Leads;

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
import PageObjectRepo.createLeadPage;
import PageObjectRepo.editingLeadInformationPage;
import PageObjectRepo.homePage;
import PageObjectRepo.leadsPage;
import Resources.base;
import Resources.stepGroups;

public class TC002_Update_A_Lead_And_Verify_If_Lead_Is_Updated_Successfully extends base {
	public static Logger log= LogManager.getLogger(TC002_Update_A_Lead_And_Verify_If_Lead_Is_Updated_Successfully.class.getName());

	@BeforeTest
	public void Depends_On_Scripts() throws IOException {
		TC001_Create_A_Lead_And_Verify_If_Lead_Is_Created_Successfully clvlcs = new TC001_Create_A_Lead_And_Verify_If_Lead_Is_Created_Successfully();
		clvlcs.open_Browser_And_Navigate_To_Vtiger_Url_And_Login_To_Application();
		log.info("Successfully Opened Browser and Loged in to vtiger application");
		clvlcs.Create_a_Lead_and_Verify();
		log.info("Successfully Created Lead and verifyed");
		clvlcs.close_browser();
		log.info("Successfully Closed The Browser");
	}

	@Test
	public void Update_Created_A_Lead_And_Verify_It_Is_Updated() throws IOException {
		
		stepGroups sg = new stepGroups();
		
		sg.openBrowserAndNavigateToVtigerUrl();
		log.info("Successfully Opened Browser");
		sg.LoginToVtigerApplication();
		log.info("Successfully Loged in to vtiger application");
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(leadsTestDataFilePath);
		prop.load(fis);
		
		String EditingEmailId = prop.getProperty("EditingEmailId");

		homePage hp = new homePage(driver);
		leadsPage lp = new leadsPage(driver);
		editingLeadInformationPage elp = new editingLeadInformationPage(driver);
		createLeadPage clp = new createLeadPage(driver);

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
		lp.EditLeadLink(concatenatedLeadFirstName).click();
		log.info("Successfully clicked on Edit Lead Link");
		WaitUntilvisibilityOf(elp.EditingLeadInformationPageText());
		log.info("Successfully Waited Until Visiblity Of Editing Lead Information Page Text");
		elp.EditingLeadInformationPageText().isDisplayed();
		log.info("Editing Lead Information Page Text is displayed");
		clp.EmailTextfield().click();
		log.info("Successfully clicked on Email Textfield");
		clp.EmailTextfield().clear();
		log.info("Successfully clicked on Email Textfield");
		clp.EmailTextfield().sendKeys(EditingEmailId);
		log.info("Successfully entered EditingEmailId Id in Editing EmailId");
		scrollTillElementIsvisable(clp.SaveButton());
		log.info("Successfully scroll Till SaveButton Is visable");
		clp.SaveButton().click();
		log.info("Successfully clicked on Save Button");
		WaitUntilvisibilityOf(lp.LeadsPageText());
		log.info("Successfully Waited Until Visiblity Of Leads Page Text");
		List<String> EditedEmailId = getTextInList(lp.EditLeadEmailVerification());
		log.info("Successfully Getted Text from List of Edited Lead Email Verification");
		Boolean isDispalyed = isStringPresentInList(EditedEmailId, EditingEmailId);
		log.info("Successfully Stored whether string is present in List or Not");
		assertTrue(isDispalyed);
		log.info("Lead Email Id is Successfully Edited");
	}

	@AfterTest
	public void close_browser() {
		closingDriver();
		log.info("Successfully Closed The Browser");
	}
}
