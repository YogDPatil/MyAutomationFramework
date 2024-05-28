package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.DasboardPage;
import com.ui.pojo.CreateJobUiPojo;
import com.utils.TestUtils;

public final class DashboardPageTest extends TestBase {

	private DasboardPage dashBoard;
	private String jobID;

	@BeforeMethod
	public void dashboardPageSetUp() {
		dashBoard = new DasboardPage(driver);
	}

	@Test()
	public void testCreatedJobTable() {
		jobID = loginPage.doLogin("iamfd", "password").goToCreateJobPage()
				.createJob(TestUtils.getUIFakerDataForCreateJob());
		Assert.assertTrue(dashBoard.getCreatedJobTableDetails().contains(jobID));

	}
}
