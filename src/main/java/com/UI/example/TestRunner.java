package com.UI.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner{
	


	public static void main(String[] args)  {
		System.setProperty("webdriver.driver.chrome", System.getProperty("user.dir")+"/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.maximizeWindow();
		loginPage.goToWebSite("http://phoenix.testautomationacademy.in/sign-in");
		loginPage.doLogin("iamfd", "password").goToCreateJobPage().getCreateJobPageUrl();
		
		
		loginPage.quitBrowser();
		}
}
