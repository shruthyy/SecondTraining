package com.obsqura.TestNGNew;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LatestPractice  {
	public WebDriver driver;
	@BeforeMethod
	public void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PROJECTS\\eclipse-workspace\\TestNGNew\\src\\main\\java\\Resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	}
	
	@Test
	public void titleHere() {
		String exptitle="Obsqura Testing";
		String title=driver.getTitle();
		if(exptitle.equals(title)) {
			System.out.println("title is same");
		}
		assertEquals(exptitle,title,"both are same");
		
	}
	@Test
	public void urlHere() {
		String a= driver.getCurrentUrl();
	}
	
//	@Test
	public void goToGoogleHomepage() {
		driver.navigate().to("https://www.google.com/");
		String expectedText="purplle";
		WebElement googleInput=driver.findElement(By.cssSelector("input[aria-autocomplete=both]"));
	    boolean isTextDisplayed=googleInput.isDisplayed();
		googleInput.sendKeys("purplle");
	//	driver.navigate().back();
	//	driver.navigate().forward();
		WebElement whatIsViewed=driver.findElement(By.cssSelector("input[aria-autocomplete=both]"));
	    boolean a=whatIsViewed.isDisplayed();
	    
	   
	   
	
	}
//	@Test
	public void compareWords() {
		String expected="DATE PICKERS";
		WebElement whatIsActual=driver.findElement(By.linkText(" Date Pickers"));
		String actual=whatIsActual.getText();
		assertEquals(expected,actual,"BOTH WORDS ARE NOT SAME");
	}
//	@Test
	public void compareNewWords() {
		driver.navigate().to("https://www.firstcry.com/");
		String exp="Puzzles";
		WebElement a=driver.findElement(By.xpath("//img[@title='Puzzles']"));
		String actual=a.getText();
		assertEquals(exp,actual,"not same");
	}
	//@Test
	public void softAssert() {
		String expUrl="https://www.firstcry.com/";
		SoftAssert softassert=new SoftAssert();
		driver.navigate().to("https://www.firstcry.com/");
		driver.navigate().back();
		driver.navigate().forward();
		String actualUrl=driver.getCurrentUrl();
		softassert.assertEquals(expUrl, actualUrl,"not same as given");
		WebElement searchBar=driver.findElement(By.cssSelector("input#search_box"));
		searchBar.sendKeys("toys for kids 3years");
		WebElement clickSearchButton=driver.findElement(By.cssSelector("span.search-button"));
		clickSearchButton.click();
		boolean didItClickOnSearchButton= clickSearchButton.isEnabled();
		softassert.assertTrue(didItClickOnSearchButton, "searchbutton is not enabled");
		
	}
//	@Test
	public void pageSource() {
		driver.navigate().to("https://www.firstcry.com/");
		String expectedPS="var DynImgExtn = '.webp';";
		String actualPS=driver.getPageSource();
		assertTrue(actualPS.contains(expectedPS));
	}
//	@Test
	public void commandsWebElements() {
		WebElement enterMessageBox=driver.findElement(By.cssSelector("input[placeholder=Message]"));
		enterMessageBox.sendKeys("hai");
		enterMessageBox.clear();
		enterMessageBox.sendKeys("write something here");
		WebElement showMessage=driver.findElement(By.cssSelector("button#button-one"));
		showMessage.click();
	}
	@Test
	public void compareUrl() {
		driver.navigate().to("https://www.firstcry.com/");
		String expUrl="https://www.firstcry.com/";
		String actualUrl=driver.getCurrentUrl();
		assertEquals(expUrl,actualUrl,"url is different");
	}
	@AfterMethod
	public void quitAll() {
		driver.quit();
	}

}
