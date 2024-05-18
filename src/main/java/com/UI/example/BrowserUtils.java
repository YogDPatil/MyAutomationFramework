package com.UI.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BrowserUtils {
	
	WebDriver driver;
	
	public BrowserUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToWebSite(String url) {
		driver.get(url);
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void enterText(By locator, String text) {
		sleepFor(4);
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}
	
	public void clickOn(By locator) {
		sleepFor(2);
		driver.findElement(locator).click();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void sleepFor(int sec){
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void quitBrowser() {
		sleepFor(4);
		driver.quit();
	}
}
