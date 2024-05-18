package com.UI.example;

import org.openqa.selenium.WebDriver;

public final class CreateJobPage extends BrowserUtils{

	private WebDriver driver;

	public CreateJobPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void getCreateJobPageUrl() {
		System.out.println(getCurrentUrl());
	}
}
