package com.ui.tests;

import org.testng.annotations.Test;

public final class DashboardPageTest extends TestBase{

	
	@Test
	public void testCreatedJobTable() {
		loginPage.doLogin("iamfd", "password").getCreatedJobTableDetails();
	}
}
