package com.ui.tests;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.ui.pages.LoginPage;
import com.ui.pages.Pages;
import com.ui.pojo.CreateJobUiPojo;
import com.utils.TestUtils;

public abstract class TestBase {
	//protected Pages pages;

	WebDriver driver;
	LoginPage loginPage;
	

	@BeforeTest(alwaysRun = true)
	public void setupAnd() {
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver, "http://phoenix.testautomationacademy.in/sign-in");
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		//pages.terminateBrowserSession();
		driver.quit();
	}
}
