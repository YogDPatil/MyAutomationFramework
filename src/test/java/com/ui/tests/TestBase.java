package com.ui.tests;

import org.testng.annotations.AfterMethod;

import com.ui.pages.Pages;

public class TestBase {
	protected Pages pages;
	@AfterMethod
	public void tearDown() {
		pages.terminateBrowserSession();
	}
}
