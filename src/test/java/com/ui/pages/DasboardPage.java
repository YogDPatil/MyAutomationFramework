package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtils;

public final class DasboardPage extends BrowserUtils{

	private static final By CREATE_JOB_LINK_LOCATOR = By.xpath("//span[contains(text(), 'Create Job')]/../../..");
	private static final By SIGNIN_USERNAME_LOCATOR = By.xpath("//span[contains(text(),'Signed in as')]/following-sibling::span");
	private static final By USER_ICON_LOCATOR = By.xpath("//mat-icon[@data-mat-icon-name='user-circle']/../../..");
	
	WebDriver driver;
	
	public DasboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getUsername() {
		clickOn(USER_ICON_LOCATOR);
		return getElementText(SIGNIN_USERNAME_LOCATOR);
	}

	public CreateJobPage goToCreateJobPage() {
		clickOn(CREATE_JOB_LINK_LOCATOR);
		return new CreateJobPage(driver);
	}
}
