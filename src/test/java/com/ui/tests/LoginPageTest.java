package com.ui.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.LoginPage;
import com.utils.BrowserUtils;

@Listeners(com.listeners.UiListeners.class)
public final class LoginPageTest extends TestBase {

	@Test(description = "test the user can login by ui")
	public void testLoginByUi() {

		Assert.assertEquals(loginPage.doLogin("iamfd", "password").getUsername(), "iamsup");

	}

}
