package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.LoginPage;
import com.ui.pages.Pages;
import com.ui.pojo.CreateJobUiPojo;
import com.utils.TestUtils;

public abstract class TestBase {
	// protected Pages pages;

	WebDriver driver;
	LoginPage loginPage;

	@Parameters("browser")
	@BeforeTest(alwaysRun = true)
	public void setupAnd(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		loginPage = new LoginPage(driver, "http://phoenix.testautomationacademy.in/sign-in");
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		// pages.terminateBrowserSession();
		driver.quit();
	}
}
