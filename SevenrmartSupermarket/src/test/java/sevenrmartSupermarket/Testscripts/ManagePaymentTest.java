package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManagePaymentPage;
import sevenrmartSupermarket.Pages.SelectCategoryPage;

public class ManagePaymentTest extends Base{
	LoginPage loginpage;
	SelectCategoryPage selectcategorypage;
	ManagePaymentPage managepaymentpage;
	
	@Test
	public void checkUpdationInManagePaymentMethod() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManagePaymentMethods");
		String amount=ExcelUtility.getString(0,1, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManagePaymentMethods");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);	
		managepaymentpage=new ManagePaymentPage(driver);
		managepaymentpage.clickDebitUpdateButton().changeValueInDebitPayLimitTextBox(amount).clickUpdate();
		assertTrue(managepaymentpage.isAlertShownWhenUpdationIsDone(),"Updation not done successfully");
	}
	@Test
	public void verifyStatusChangeWhenStatusButtonIsClicked() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManagePaymentMethods");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);	
		managepaymentpage=new ManagePaymentPage(driver);
		managepaymentpage.clickDebitStatusButton();
		assertTrue(managepaymentpage.isAlertShownWhenStatusIsChanged(),"Status not changed successfully");
	}
	@Test
	public void verifyWorkingOfResetButton_clickReset_RedirectToBackPage() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManagePaymentMethods");
		String amount=ExcelUtility.getString(0,1, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManagePaymentMethods");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);	
		managepaymentpage=new ManagePaymentPage(driver);
		managepaymentpage.clickDebitUpdateButton().changeValueInDebitPayLimitTextBox(amount).clickResetButton();
		assertTrue(managepaymentpage.isBackPageShownAfterClickingReset(),"Reset button is not working");
		
	}

}
