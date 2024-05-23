package com.ui.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.LoginPage;
import com.utils.BrowserUtils;

@Listeners(com.listeners.UiListeners.class)
public class LoginPageTest {
	
	WebDriver driver;
	LoginPage loginPage;

	
	
	@BeforeMethod(description = "setup browser and load the page")
	public void setup() {
		System.setProperty("webdriver.driver.chrome", System.getProperty("user.dir")+"/drivers.chromedriver");
		//BrowserUtils.initialiseDriver(Browser.CHROME);
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver, "http://phoenix.testautomationacademy.in/sign-in");
	}
	
	@Test(description = "test the user can login by ui")
	public void testLoginByUi() {
		
		AssertJUnit.assertEquals(loginPage.doLogin("iamfd", "password").getUsername(), "iamsup");
		
	}

	
	@AfterMethod
	public void tearDown() {
		loginPage.terminateBrowserSession();
	}
}
