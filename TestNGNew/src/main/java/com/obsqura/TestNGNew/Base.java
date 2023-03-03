package com.obsqura.TestNGNew;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Base {
	public WebDriver driver;
	@BeforeMethod
	public void initializeBrowser(){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PROJECTS\\eclipse-workspace\\TestNGNew\\src\\main\\java\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();
	// driver.get("https://www.google.com/");
	// driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
	//	driver.navigate().to("https://www.firstcry.com/");
	 driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();
	}
	
	
	
     @AfterMethod
	 public void driverQuit() {
	    	driver.quit();
	    }

}
