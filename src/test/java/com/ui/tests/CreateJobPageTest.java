package com.ui.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.ui.pojo.CreateJobUiPojo;
import com.utils.TestUtils;

@Listeners(com.listeners.UiListeners.class)
public class CreateJobPageTest extends TestBase {

	private CreateJobUiPojo createJobData;

	@BeforeMethod(alwaysRun = true)
	public void loadCreateJobPage() {

		// createJobUiPojo = new CreateJobUiPojo("Apple", "IPhone", "Iphone 11", "In
		// Warrenty");
		createJobData = TestUtils.getUIFakerDataForCreateJob();
	}

	@Test(description = "To verify job creatred by ui successfully", groups = {"sanity"})
	public void testCreateJobByUI() {
		Assert.assertTrue(loginPage.doLogin("iamfd", "password").goToCreateJobPage().createJob(createJobData)
				.contains("JOB_"));
	}

}
