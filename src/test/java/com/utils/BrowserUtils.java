package com.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtils {

	WebDriver driver;
	static WebDriver screenshotDriver;
	WebDriverWait wait;

	public BrowserUtils(WebDriver driver) {
		this.driver = driver;
		screenshotDriver = driver;
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
	
	public static String takeScreenshot(String testName) {
		// typecasted driver to takescreenshot
		TakesScreenshot takeScreenshot = (TakesScreenshot) screenshotDriver;
		// now capture screenshot and store it in file formate
		File srcScreenshotFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		//create directory to store screenshots if directory is not present
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("d-MMM-YY hh:mm:ss");
		String formatedDate  = formater.format(date);
		File fileDirectory = new File(System.getProperty("user.dir")+"/screenshots/"+formatedDate);
		try {
			// make directory if not present 
			FileUtils.forceMkdir(fileDirectory);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//create new file in png format so that screenshot file can copy into it
		String screenshotPath = System.getProperty("user.dir")+"/screenshots/"+formatedDate+"/"+testName+".png";
		File destScreenshotFile = new File(screenshotPath);
		try {
			destScreenshotFile.createNewFile();
			// here copy captured source screenshot file and paste it into destination file in .png format
			FileUtils.copyFile(srcScreenshotFile, destScreenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return screenshotPath;
	}
	
	public void initialiseDriver(Browser browser) {
		if(browser == Browser.CHROME) {
			driver = new ChromeDriver();
		}
		else if(browser == Browser.FIREFOX) {
			driver = new FirefoxDriver();
		}
		else if(browser == Browser.EDGE) {
			driver = new EdgeDriver();
		}
		else if (browser == Browser.SAFARI) {
			driver = new SafariDriver();
		}
		else {
			System.out.println("Browser is not compatible");
		}
	}

	public void terminateBrowserSession() {
		sleepFor(2);
		driver.quit();
	}
}
