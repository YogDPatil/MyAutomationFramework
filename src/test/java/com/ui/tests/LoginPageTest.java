package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.LoginPage;

public class LoginPageTest {
	WebDriver driver;
	LoginPage loginPage;
	@BeforeMethod(description = "setup browser and load the page")
	public void setup() {
		System.setProperty("webdriver.driver.chrome", System.getProperty("user.dir")+"/drivers.chromedriver");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver, "http://phoenix.testautomationacademy.in/sign-in");
	}
	
	@Test(description = "test the user can login by ui")
	public void testLoginByUi() {
		
		Assert.assertEquals(loginPage.doLogin("iamfd", "password").getUsername(), "iamfd");
		
	}

	@AfterMethod
	public void tearDown() {
		loginPage.terminateBrowserSession();
	}
}
