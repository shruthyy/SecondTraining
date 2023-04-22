package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;
import Utilities.ExcelUtility;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManageSliderPage;
import sevenrmartSupermarket.Pages.SelectCategoryPage;

public class ManageSliderTest extends Base {
	LoginPage loginpage;
	SelectCategoryPage selectcategorypage;
	ManageSliderPage  managesliderpage;
	
	
	@Test(groups= {"smoke"})
	public void addLinkToManageSlider() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,1, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageSlider");
		String newlink=ExcelUtility.getString(0,0, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageSlider");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		managesliderpage=new ManageSliderPage(driver);
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);	
		managesliderpage.clickNewButton().enterLinkToLinkTextBox(newlink).clickSaveButton();
		assertTrue( managesliderpage.alertisDisplayed(), "link is not added successfully");    
	}
	@Test(groups= {"smoke"})
	public void veriftClickingHomeButtonFromListSliderPage() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,1, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageSlider");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		managesliderpage=new ManageSliderPage(driver);
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managesliderpage=new ManageSliderPage(driver);
		managesliderpage.clickHomeButtonFromListSliderPage();
		assertTrue(managesliderpage.isHomePageDisplayedAfterClickingHomeButton(),"Home button is not working");
	}
	@Test(retryAnalyzer =Retry.class)
	public void deleteInListSliderPage() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,1, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageSlider");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managesliderpage=new ManageSliderPage(driver);
		managesliderpage.clickDelete();
		driver.switchTo().alert().accept();
		assertTrue(managesliderpage.isDeleteAlertDisplayed(),"link is not deleted");
	}
}
