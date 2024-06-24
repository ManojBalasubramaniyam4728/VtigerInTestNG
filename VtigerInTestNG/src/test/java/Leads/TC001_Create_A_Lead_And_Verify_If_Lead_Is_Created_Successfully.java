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
import PageObjectRepo.homePage;
import PageObjectRepo.leadsPage;
import PageObjectRepo.loginPage;
import Resources.base;

public class TC001_Create_A_Lead_And_Verify_If_Lead_Is_Created_Successfully extends base {
	public static Logger log=LogManager.getLogger(TC001_Create_A_Lead_And_Verify_If_Lead_Is_Created_Successfully.class.getName());
	
	@BeforeTest
	public void open_Browser_And_Navigate_To_Vtiger_Url_And_Login_To_Application() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(credientialsFilePath);
		prop.load(fis);
		String url = prop.getProperty("url");
		String UserName = prop.getProperty("Username");
		String Password = prop.getProperty("Password");
		
		driver = initializeDriver();
		log.info("Browser Opened Successfully"); 
		driver.get(url);
		log.info("Successfully Navigated to VTiger url ");
		
	    loginPage lgp = new loginPage(driver);
		
		WaitUntilvisibilityOf(lgp.LoginPage());
		log.info("Successfully Waited Until Visiblity Of Login Page");
		lgp.LoginPage().isDisplayed();
		log.info("Login Page is displayed");
		lgp.UserNameTextfield().click();
		log.info("Successfully clicked on User Name Textfield");
		lgp.UserNameTextfield().sendKeys(UserName);
		log.info("Successfully entered User Name in User Name Textfield");
		lgp.PasswordTextfield().click();
		log.info("Successfully clicked on Password Textfield");
		lgp.PasswordTextfield().sendKeys(Password);
		log.info("Successfully entered User Name in User Name Textfield");
		lgp.LoginButton().click();
		log.info("Successfully clicked on Login Button");
	}


	@Test
	public void Create_a_Lead_and_Verify() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(leadsTestDataFilePath);
		prop.load(fis);
		String Salutation = prop.getProperty("Salutation");
		String FirstName=prop.getProperty("FirstName");
		String LastName=prop.getProperty("LastName");
		String Company=prop.getProperty("Company");
		String Title=prop.getProperty("Title");
		String AnnualRevenue=prop.getProperty("AnnualRevenue");
		String NoOfEmployee=prop.getProperty("NoOfEmployee");
		String MobileNo=prop.getProperty("MobileNo");
		String Email=prop.getProperty("Email");
		String LeadStatus=prop.getProperty("LeadStatus");
		String AssignedToRadioButton=prop.getProperty("AssignedToRadioButton");
		String GroupAssignedToDropdown=prop.getProperty("GroupAssignedToDropdown");
		String StreetDetails=prop.getProperty("StreetDetails");
		String PostalCode=prop.getProperty("PostalCode");
		String Country=prop.getProperty("Country");
		String City=prop.getProperty("City");
		String State=prop.getProperty("State");
		String LengthNumberOfDigits=prop.getProperty("LengthNumberOfDigits");
		
		homePage hp = new homePage(driver);
		leadsPage lp = new leadsPage(driver);
		createLeadPage clp=new createLeadPage(driver);
		
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
		lp.CreateLeadButton().click();
		log.info("Successfully clicked on Create Lead Button");
		WaitUntilvisibilityOf(clp.CreatingNewLeadText());
		log.info("Successfully Waited Until Visiblity Of Creating New Lead Text");
		clp.CreatingNewLeadText().isDisplayed();
		log.info("Creating New Lead Text is displayed");
		clp.SalutationDropdown().click();
		log.info("Successfully clicked on Salutation Dropdown");
		selectingByVisibleText(clp.SalutationDropdown(),Salutation);
		log.info("Successfully seleceted on Salutation Dropdown");
		clp.FirstNameTextfield().click();
		log.info("Successfully clicked on First Name Textfield");
		int IntegerLengthNumberOfDigits = convertingStringToInteger(LengthNumberOfDigits);
		log.info("Successfully Converted String To Integer");
		String randomNumber=generateRandomNumberWithLengthNumberOfDigits(IntegerLengthNumberOfDigits);
		log.info("Successfully Generate Random Number WithLength Number Of Digits");
		concatenatedLeadFirstName=concatenateString1WithString2(FirstName, randomNumber);
		log.info("Successfully concatenate String1 With String2");
		clp.FirstNameTextfield().sendKeys(concatenatedLeadFirstName);
		log.info("Successfully entered  concatenated Contacts FirstName in First Name Textfield");
		clp.LastNameTextfield().click();
		log.info("Successfully clicked on Last Name Textfield");
		clp.LastNameTextfield().sendKeys(LastName);
		log.info("Successfully entered  Last Name in Last Name Textfield");
		clp.CompanyTextfield().click();
		log.info("Successfully clicked on Company Textfield");
		clp.CompanyTextfield().sendKeys(Company);
		log.info("Successfully entered  Company in Company Textfield");
		clp.TitleTextfield().click();
		log.info("Successfully clicked on Title Textfield");
		clp.TitleTextfield().sendKeys(Title);
		log.info("Successfully entered  Title in Title Textfield");
		clp.AnnualRevenueTextfield().click();
		log.info("Successfully clicked on Annual Revenue Textfield");
		clp.AnnualRevenueTextfield().clear();
		log.info("Successfully cleared on Annual Revenue Textfield");
		clp.AnnualRevenueTextfield().sendKeys(AnnualRevenue);
		log.info("Successfully entered Annual Revenue in Annual Revenue Textfield");
		clp.NoOfEmployeesTextfield().click();
		log.info("Successfully clicked on No Of Employees Textfield");
		clp.NoOfEmployeesTextfield().sendKeys(NoOfEmployee);
		log.info("Successfully entered No Of Employees in No Of Employees Textfield");
		clp.MobileTextfield().click();
		log.info("Successfully clicked on Mobile Textfield");
		clp.MobileTextfield().sendKeys(MobileNo);
		log.info("Successfully entered Mobile in Mobile Textfield");
		clp.EmailTextfield().click();
		log.info("Successfully clicked on Email Textfield");
		clp.EmailTextfield().sendKeys(Email);
		log.info("Successfully entered Email in Email Textfield");
		clp.LeadStatusDropdown().click();
		log.info("Successfully clicked on LeadStatus Dropdown");
		selectingByVisibleText(clp.LeadStatusDropdown(),LeadStatus );
		log.info("Successfully seleceted on LeadStatus Dropdown");
		clp.AssignedToRadioButton(AssignedToRadioButton).click();
		log.info("Successfully clicked on Assigned To Radio Button");
		clp.GroupAssignedToDropdown().click();
		log.info("Successfully clicked on Group Assigned To Dropdown");
        selectingByVisibleText(clp.GroupAssignedToDropdown(), GroupAssignedToDropdown);
        log.info("Successfully seleceted on GroupAssigned To Dropdown");
        clp.StreetTextarea().click();
        log.info("Successfully clicked on Street Textarea");
        clp.StreetTextarea().sendKeys(StreetDetails);
        log.info("Successfully Entered Street in Street Textarea");
        clp.PostalCodeTextfield().click();
        log.info("Successfully clicked on Postal Code Textfield");
        clp.PostalCodeTextfield().sendKeys(PostalCode);
        log.info("Successfully Entered Postal Code in Postal Code Textfield");
        clp.CountryTextfield().click();
        log.info("Successfully clicked on Country Textfield");
        clp.CountryTextfield().sendKeys(Country);
        log.info("Successfully Entered Country in Country Textfield");
        clp.CityTextfield().click();
        log.info("Successfully clicked on City Textfield");
        clp.CityTextfield().sendKeys(City);
        log.info("Successfully Entered City in City Textfield");
        clp.StateTextfield().click();
        log.info("Successfully clicked on State Textfield");
        clp.StateTextfield().sendKeys(State);
        log.info("Successfully Entered State in State Textfield");
        clp.SaveButton().click();
        log.info("Successfully clicked on Save Button");
        WaitUntilvisibilityOf(clp.LeadInformationTitle());
        log.info("Successfully Waited Until Visiblity Of Lead Information Title");
        clp.LeadInformationTitle().isDisplayed();
        log.info("Lead Information Title is displayed");
        hp.LeadsLink().click();
        log.info("Successfully clicked on Leads Link");
        WaitUntilvisibilityOf(lp.LeadsPageText());
        log.info("Successfully Waited Until Visiblity Of Leads Page Text");
        List<String> LeadNames= getTextInList(lp.LeadInformationVerification());
        log.info("Successfully Getted Text from List of Leads Information Verification");
        Boolean isDispalyed= isStringPresentInList(LeadNames,concatenatedLeadFirstName);
        log.info("Successfully Stored whether string is present in List or Not");
        assertTrue(isDispalyed);
        log.fatal("Lead is Created Successfully");
	}
	
        @AfterTest
        public void close_browser() {
    		closingDriver();
    		log.info("Successfully Closed The Browser");
    	}
        	
    }
	
		
	

