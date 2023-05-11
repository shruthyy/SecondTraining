package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.GeneralUtility;
import retry.Retry;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManagePaymentPage;
import sevenrmartSupermarket.Pages.SelectCategoryPage;

public class ManagePaymentTest extends Base{
	LoginPage loginpage;
	SelectCategoryPage selectcategorypage;
	ManagePaymentPage managepaymentpage;
	
	@Test(retryAnalyzer =Retry.class)
	public void verifyAlertIsDisplayedWhenDebitAmountIsUpdated_ByClickingDebitUpdateButtonChangingValueAndClickUpdateButton() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0, GeneralUtility.TESTDATAFILE, "ManagePaymentMethods");
		String amount=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE, "ManagePaymentMethods");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);	
		managepaymentpage=new ManagePaymentPage(driver);
		managepaymentpage.clickDebitUpdateButton().changeValueInDebitPayLimitTextBox(amount).clickUpdate();
		assertTrue(managepaymentpage.isAlertShownWhenUpdationIsDone(),"Alert after Updation not displayed");
	}
	@Test(retryAnalyzer =Retry.class)
	public void verifyAlertIsDisplayedWhenStatusIsChanged_ByClickingStatusButtonOfDebitInTable() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE, "ManagePaymentMethods");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);	
		managepaymentpage=new ManagePaymentPage(driver);
		managepaymentpage.clickDebitStatusButton();
		assertTrue(managepaymentpage.isAlertShownWhenStatusIsChanged(),"Alert for Status change not displayed");
	}
	@Test(retryAnalyzer =Retry.class)
	public void verifyUserIsRedirectToManagePaymentMethodsPage_ByClickingDebitUpdateButtonChangingValueAndclickingReset() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0, GeneralUtility.TESTDATAFILE,"ManagePaymentMethods");
		String amount=ExcelUtility.getString(0,1, GeneralUtility.TESTDATAFILE,"ManagePaymentMethods");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);	
		managepaymentpage=new ManagePaymentPage(driver);
		managepaymentpage.clickDebitUpdateButton().changeValueInDebitPayLimitTextBox(amount).clickResetButton();
		assertTrue(managepaymentpage.isBackPageShownAfterClickingReset(),"Reset button is not working");		
	}
}
