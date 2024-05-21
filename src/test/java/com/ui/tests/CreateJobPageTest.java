package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.LoginPage;

public class CreateJobPageTest {

	WebDriver driver;
	LoginPage loginPage;

	@BeforeMethod
	public void loadCreateJobPage() {
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver, "http://phoenix.testautomationacademy.in/sign-in");
	}

	
	@Test
	public void testCreateJobByUI() {
		loginPage.doLogin("iamfd", "password").goToCreateJobPage().createJob("Apple");
	}

	
	@AfterMethod
	public void tearDown() {
		loginPage.terminateBrowserSession();
	}	
}
