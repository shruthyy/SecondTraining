package com.obsqura.TestNGNew;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGAnnotations extends Base {
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}
    @Test
	public void testCaseOne() {
		System.out.println("Testcase 1");
	}
    @Test
	public void testCaseTwo() {
		System.out.println("Testcase 2");
	}
    @AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}
     @AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
	}
   @AfterTest
	public void afterTest() {
		System.out.println("AfterTest");
	}
   @BeforeTest
	public void BeforeTest() {
		System.out.println("BeforeTest");
		
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
	}

    @BeforeGroups
   public void beforeGroup() {
	System.out.println("BeforeGroup");
   }
    @BeforeSuite
   public void beforeSuit() {
	System.out.println("BeforeSuit");
}
    @AfterSuite   
    public void afterSuit() {
    	System.out.println("AfterSuit");
    }
}
