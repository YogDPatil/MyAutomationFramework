package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtils;

public final class CreateJobPage extends BrowserUtils{

	private static final By OEM_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select OEM']/div/div[2]");
	
	private WebDriver driver;

	public CreateJobPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void createJob(String productName) {
		clickOn(OEM_DROPDOWN_LOCATOR);
		By OEM_PRODUCT_NAMES_LOCATOR = By.xpath("//span[contains(text(), '"+productName+"')]/..");
		selectValueFromCustomDropdown( OEM_PRODUCT_NAMES_LOCATOR);
	}
	
	public void getCreateJobPageUrl() {
		System.out.println(getCurrentUrl());
	}
}
