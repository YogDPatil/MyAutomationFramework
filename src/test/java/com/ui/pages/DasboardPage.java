package com.ui.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.pojo.DashboardTablePojo;
import com.utils.BrowserUtils;
import com.utils.TestUtils;

public final class DasboardPage extends BrowserUtils {

	private static final By CREATE_JOB_LINK_LOCATOR = By.xpath("//span[contains(text(), 'Create Job')]/../../..");
	private static final By DASHBOARD_LINK_LOCATOR = By.xpath("//span[contains(text(), 'Dashboard')]/../../..");
	private static final By SIGNIN_USERNAME_LOCATOR = By
			.xpath("//span[contains(text(),'Signed in as')]/following-sibling::span");
	private static final By USER_ICON_LOCATOR = By.xpath("//mat-icon[@data-mat-icon-name='user-circle']/../../..");
	private static final By CREATED_TODAY_BUTTON_LOCATOR = By
			.xpath("//div[contains(text(), 'Created today')]/../div/button");
	private static final By CREATED_JOB_TABLE_LOCATOR = By.xpath("//mat-table[@role='table']");
	private static final By CREATED_JOB_TABLE_ROW_LOCATOR = By.xpath("//mat-row");
	private static final By CREATED_JOB_TABLE_CELL_LOCATOR = By.xpath("//mat-cell");

	WebDriver driver;
	WebDriverWait wait;
	private List<String> jobIDs;
	private List<WebElement> cellList = null;
	private List<DashboardTablePojo> tableList;

	public DasboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public String getUsername() {
		clickOn(USER_ICON_LOCATOR);
		return getElementText(SIGNIN_USERNAME_LOCATOR);
	}

	public CreateJobPage goToCreateJobPage() {
		clickOn(CREATE_JOB_LINK_LOCATOR);
		return new CreateJobPage(driver);
	}

	public boolean verifyCreatedJobIsPresentInTable(String jobId) {
		clickOn(DASHBOARD_LINK_LOCATOR);
		clickOn(CREATED_TODAY_BUTTON_LOCATOR);
		WebElement createdJobElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(CREATED_JOB_TABLE_LOCATOR));
		wait.until(ExpectedConditions.visibilityOfElementLocated(CREATED_JOB_TABLE_ROW_LOCATOR));
		List<WebElement> rowList = createdJobElement.findElements(CREATED_JOB_TABLE_ROW_LOCATOR);
		System.out.println("****" + rowList.size());
		tableList = new ArrayList<DashboardTablePojo>();
		jobIDs = new ArrayList<String>();
		boolean status = false;
		for (WebElement row : rowList) {

			cellList = row.findElements(CREATED_JOB_TABLE_CELL_LOCATOR);

		}

		for (WebElement cell : cellList) {
			String cellData = cell.getText();
			if (cellData.contains("JOB_")) {
				jobIDs.add(cellData);
			}
		}

		 System.out.println(jobIDs.toString());

		// return jobNumber;
		// return status;
		return TestUtils.searchEnteryInList(jobIDs, jobId);
	}
}
