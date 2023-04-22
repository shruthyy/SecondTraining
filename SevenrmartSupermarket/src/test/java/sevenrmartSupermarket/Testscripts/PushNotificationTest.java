package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.PushNotificationPage;
import sevenrmartSupermarket.Pages.SelectCategoryPage;

public class PushNotificationTest extends Base{
	PushNotificationPage pushnotificationpage;
	LoginPage loginpage;
	SelectCategoryPage selectcategorypage;
	
	@Test(retryAnalyzer =Retry.class)
	public void sentPushNotification() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"SelectCategory");
		String title=FakerUtility.titleName();
		String description=FakerUtility.descriptionName();
		loginpage=new  LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.enterTitleBox(title).enterDescriptionBox(description).clickSendButton();
		assertTrue(pushnotificationpage.alertForPushisDisplayed(),"Push Message is not sent successfully");
	}
}
