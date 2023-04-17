package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.PageUtility;
import sevenrmartSupermarket.Pages.HomePage;
import sevenrmartSupermarket.Pages.LoginPage;


public class HomeTest extends Base{
	HomePage homepage;
	LoginPage loginpage;
	
	@Test
	public void checkSiteNameIsDisplayedOnTop() throws IOException {
		String expectedSiteName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"SiteName");
		loginpage=new  LoginPage(driver);
		loginpage.signIn();
		homepage=new HomePage(driver);
		boolean isSiteNameDisplayed=homepage.siteNameisDisplayed();
		assertTrue(isSiteNameDisplayed, "site name is not displayed on top");	
		String actualSiteName=homepage.verifySiteNameIsShownAtTop();
		assertEquals(actualSiteName,expectedSiteName,"Site name is given wrong");
	}
	@Test
	public void verifyManageLocationOpensToCorrespondingUrl() throws IOException {
		String expectedUrl=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"ManageLocation");
		loginpage=new  LoginPage(driver);
		loginpage.signIn();
		homepage=new HomePage(driver);
		homepage.clickManageLocation();
		String actualUrl=driver.getCurrentUrl();
		assertEquals( actualUrl,expectedUrl,"Manage Location page is not open" );
	}
	
	
}
