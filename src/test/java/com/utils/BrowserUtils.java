package com.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BrowserUtils {

	WebDriver driver;
	WebDriverWait wait;

	public BrowserUtils(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void goToWebSite(String url) {
		driver.get(url);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void enterText(By locator, String text) {
		//sleepFor(4);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
		//driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}

	public void clickOn(By locator) {
		//sleepFor(2);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		//driver.findElement(locator).click();
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

	public String getElementText(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}

	public void terminateBrowserSession() {
		sleepFor(2);
		driver.quit();
	}
}
