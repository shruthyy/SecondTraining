package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.GeneralUtility;
import Utilities.RandomDataUtility;
import retry.Retry;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.PushNotificationPage;
import sevenrmartSupermarket.Pages.SelectCategoryPage;

public class PushNotificationTest extends Base{
	PushNotificationPage pushnotificationpage;
	LoginPage loginpage;
	SelectCategoryPage selectcategorypage;
	
	
	@Test(priority=2,retryAnalyzer =Retry.class)
	public void verifyAlertMessageIsDisplayedWhenPushNotificationIsSend_ByEnteringTitleAndDescriptionAndClickingSendButton() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"SelectCategory");
		String title=RandomDataUtility.titleName();
		String description=RandomDataUtility.descriptionName();
		loginpage=new  LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.enterTitleBox(title).enterDescriptionBox(description).clickSendButton();
		assertTrue(pushnotificationpage.alertForPushisDisplayed(),"Push Message Alert is not Displayed");
	}
	@Test(priority=1,retryAnalyzer =Retry.class)
	public void verifyTitleBoxGetsClearedByClickingResetButtonAfterEnteringTheTitle() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"SelectCategory");
		String title=RandomDataUtility.titleName();
		loginpage=new  LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.enterTitleBox(title).clickResetButton();
		assertTrue(pushnotificationpage.isTitleBoxClearedAfterClickingResetButton(),"TitleBox is not cleared after reseting");
	}
}
