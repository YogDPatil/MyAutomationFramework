package com.ui.tests;

import org.testng.annotations.Test;

import com.ui.pojo.CreateJobUiPojo;

public final class DashboardPageTest extends TestBase{
	
	
	@Test
	public void testCreatedJobTable() {
		loginPage.doLogin("iamfd", "password").getCreatedJobTableDetails();
	}
}
