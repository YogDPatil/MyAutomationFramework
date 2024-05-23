package com.ui.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.CreateJobPage;
import com.ui.pages.LoginPage;
import com.ui.pojo.CreateJobUiPojo;
import com.utils.TestUtils;

public class CreateJobPageTest {

	WebDriver driver;
	LoginPage loginPage;
	CreateJobUiPojo createJobData;
	@BeforeMethod
	public void loadCreateJobPage() {
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver, "http://phoenix.testautomationacademy.in/sign-in");
		//createJobUiPojo = new CreateJobUiPojo("Apple", "IPhone", "Iphone 11", "In Warrenty");
		createJobData = TestUtils.getUIFakerDataForCreateJob();
	}

	
	@Test
 	public void testCreateJobByUI() throws InterruptedException {
		loginPage.doLogin("iamfd", "password").goToCreateJobPage().createJob(createJobData);
	}

	

	
	@AfterMethod
	public void tearDown() {
		loginPage.terminateBrowserSession();
	}	
}
