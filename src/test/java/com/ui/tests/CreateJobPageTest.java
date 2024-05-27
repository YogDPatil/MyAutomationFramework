package com.ui.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.ui.pojo.CreateJobUiPojo;
import com.utils.TestUtils;

@Listeners(com.listeners.UiListeners.class)
public class CreateJobPageTest extends TestBase {

	private CreateJobUiPojo createJobData;

//	@BeforeMethod
//	public void loadCreateJobPage() {
//
//		// createJobUiPojo = new CreateJobUiPojo("Apple", "IPhone", "Iphone 11", "In
//		// Warrenty");
//		createJobData = TestUtils.getUIFakerDataForCreateJob();
//	}

	@Test
	public void testCreateJobByUI() throws InterruptedException {
		loginPage.doLogin("iamfd", "password").goToCreateJobPage().createJob(TestUtils.getUIFakerDataForCreateJob());
	}

}
