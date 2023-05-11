package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import Utilities.ExcelUtility;
import Utilities.GeneralUtility;
import retry.Retry;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManageDeliveryBoyPage;
import sevenrmartSupermarket.Pages.SelectCategoryPage;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginpage;
	SelectCategoryPage selectcategorypage;
	ManageDeliveryBoyPage managedeliveryboypage;
	
	@Test(retryAnalyzer =Retry.class)
	public void verifyNewDeliveryBoyDetailsAreFoundInListDeliveryBoyTable_AfterAddingNewDeliveryBoyWithRequiredDetails() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String input=ExcelUtility.getString(0,0, GeneralUtility.TESTDATAFILE, "ManageDeliveryBoy");
   	    String name=ExcelUtility.getString(0,1, GeneralUtility.TESTDATAFILE, "ManageDeliveryBoy");
   	    String passwordnew=ExcelUtility.getString(1,0, GeneralUtility.TESTDATAFILE, "ManageDeliveryBoy");
   	    String username=ExcelUtility.getString(0,3,GeneralUtility.TESTDATAFILE, "ManageDeliveryBoy");
   	    String deliveryboynew=ExcelUtility.getString(2,0,GeneralUtility.TESTDATAFILE,"ManageDeliveryBoy");
   	    loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickNewButtonToAddDeliveryBoy().enterNameToAddNewDeliveryBoy(name).enterUsernameToAddNewDeliveryBoy(username).enterPasswordToAddNewDeliveryBoy(passwordnew);
		managedeliveryboypage.clickSaveButtonToAddDeliveryBoy();
		assertTrue(managedeliveryboypage.searchInTheTable(deliveryboynew),"New Delivery Boy Details are not added successfully");	
	}
	@Test(retryAnalyzer =Retry.class)
	public void verifyListDeliveryBoyPageIsDisplayedWhenCancelButtonIsClickedAfterEnteringNewDeliveryBoyName() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String input=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE, "ManageDeliveryBoy");
   	    String name=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE, "ManageDeliveryBoy");
   	    loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickNewButtonToAddDeliveryBoy().enterNameToAddNewDeliveryBoy(name);
		managedeliveryboypage.clickCancelButton();
		assertTrue(managedeliveryboypage.isListDeliveryBoyPagDisplayedAfterCancel(),"List deliveryboy page not displayed after cancelling");	
	}
}
