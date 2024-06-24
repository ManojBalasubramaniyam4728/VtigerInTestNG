package PageObjectRepo;

import org.openqa.selenium.WebDriver;

public class deleteContactsPage {

    //Globel variable 
	public WebDriver driver;
	
//**************************************************************************************************************************************		

   //Giving life to driver by Constracor
	public deleteContactsPage(WebDriver driver) {
    this.driver=driver;
	    }
	
//**************************************************************************************************************************************		

	// User Defined Method For Alert Popup
	public void OkButton() {
	 driver.switchTo().alert().accept();
	    }
	
	public void CancelButton() {
	driver.switchTo().alert().dismiss();
	    }

}
