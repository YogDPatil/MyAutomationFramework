package com.UI.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class DasboardPage extends BrowserUtils{

	private static final By CREATE_JOB_LINK_LOCATOR = By.xpath("//span[contains(text(), 'Create Job')]/../../..");
	
	public DasboardPage(WebDriver driver) {
		super(driver);
	}
	
	public CreateJobPage goToCreateJobPage() {
		clickOn(CREATE_JOB_LINK_LOCATOR);
		return new CreateJobPage(driver);
	}
}
