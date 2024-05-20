package com.ui.pages;

import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtils;

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
