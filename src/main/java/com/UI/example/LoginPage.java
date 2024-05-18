package com.UI.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtils{

	private static final By USERNAME_TEXT_BOX = By.id("username");
	private static final By PASSWORD_TEXT_BOX = By.id("password");
	private static final By SIGNIN_BUTTON = By.xpath("//span[contains(text(),'Sign in')]/../..");
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public DasboardPage doLogin(String username, String password) {
		enterText(USERNAME_TEXT_BOX, username);
		enterText(PASSWORD_TEXT_BOX, password);
		clickOn(SIGNIN_BUTTON);
		return new DasboardPage(driver);
	}


}
