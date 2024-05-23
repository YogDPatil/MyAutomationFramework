package com.ui.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.CreateJobUiPojo;
import com.utils.BrowserUtils;

public final class CreateJobPage extends BrowserUtils {

	private static final By OEM_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select OEM']/..");
	private static final By PRODUCT_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select Product name']/..");
	private static final By MODEL_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select Model name']/..");
	private static final By IMEI_TEXTBOX_LOCATOR = By.xpath("//input[@data-placeholder='0123456789']");
	private static final By PURCHASE_DATE_LOCATOR = By.xpath("//input[@data-placeholder='dd/mm/yyyy']");
	private static final By WARRENTY_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select Warranty Status']/..");
	private static final By FNAME_LOCATOR = By.xpath("//input[@data-placeholder='First Name']");
	private static final By LNAME_LOCATOR = By.xpath("//input[@data-placeholder='Last Name']");
	private static final By CONTACT_NO_LOCATOR = By.xpath("//input[@data-placeholder='Contact No.']");
	private static final By EMAILID_LOCATOR = By.xpath("//input[@data-placeholder='Email Id.']");
	private static final By FLAT_NO_LOCATOR = By.xpath("//input[@data-placeholder='Flat/Society No.']");
	private static final By APPARTMENT_LOCATOR = By.xpath("//input[@data-placeholder='Apartment Name']");
	private static final By LANDMARK_LOCATOR = By.xpath("//input[@data-placeholder='Choose a Landmark']");
	private static final By STREET_LOCATOR = By.xpath("//input[@data-placeholder='Street Name.']");
	private static final By AREA_LOCATOR = By.xpath("//input[@data-placeholder='Area']");
	private static final By Pincode_LOCATOR = By.xpath("//input[@data-placeholder='Pincode']");
	private static final By STATE_DROPDOWN_LOCATOR = By.xpath("//input[@data-placeholder='Select State']");
	private static final By Remark_LOCATOR = By.xpath("//input[@data-placeholder='Remarks']");
	private static final By PROBLE_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select Problem']/..");
	private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Submit')]/..");
	private static final By SUCCESS_MESSAGE = By.xpath("//span[contains(text(),'Job created successfully')]");

	private WebDriver driver;

	public CreateJobPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public String createJob(CreateJobUiPojo data) throws InterruptedException {
		Thread.sleep(2000);
		clickOn(OEM_DROPDOWN_LOCATOR);
		By OEM_LOCATOR = By.xpath("//span[contains(text(), '" + data.getOemName() + "')]/..");
		selectValueFromCustomDropdown(OEM_LOCATOR);
		clickOn(PRODUCT_DROPDOWN_LOCATOR);
		By PRODUCT_NAMES_LOCATOR = By.xpath("//span[contains(text(), '" + data.getProductName() + "')]/..");
		selectValueFromCustomDropdown(PRODUCT_NAMES_LOCATOR);
		clickOn(MODEL_DROPDOWN_LOCATOR);
		By MODEL_DROPDOWN_LOCATOR = By.xpath("//span[contains(text(), '" + data.getModelName() + "')]/..");
		selectValueFromCustomDropdown(MODEL_DROPDOWN_LOCATOR);
		enterText(IMEI_TEXTBOX_LOCATOR, data.getImei());
		clickOn(WARRENTY_DROPDOWN_LOCATOR);
		By WARRENTY_STATUS_LOCATOR = By.xpath("//span[contains(text(), '" + data.getWarrentyStatus() + "')]/..");
		selectValueFromCustomDropdown(WARRENTY_STATUS_LOCATOR);
		clickOn(PROBLE_DROPDOWN_LOCATOR);
		By PROBLEM_LOCATOR = By.xpath("//span[contains(text(), '" + data.getMobileProblem() + "')]/..");
		selectValueFromCustomDropdown(PROBLEM_LOCATOR);
		enterText(Remark_LOCATOR, data.getRemark());
		enterText(FNAME_LOCATOR, data.getfName());
		enterText(LNAME_LOCATOR, data.getlName());
		enterText(CONTACT_NO_LOCATOR, data.getContactNo());
		enterText(EMAILID_LOCATOR, data.getEmaiID());
		enterText(PURCHASE_DATE_LOCATOR, data.getPurchaseDate());
		enterText(IMEI_TEXTBOX_LOCATOR, data.getImei());
		enterText(FLAT_NO_LOCATOR, data.getFlatNo());
		enterText(APPARTMENT_LOCATOR, data.getAppartmentNo());
		enterText(LANDMARK_LOCATOR, data.getLandmark());
		enterText(STREET_LOCATOR, data.getStreetName());
		enterText(AREA_LOCATOR, data.getArea());
		enterText(Pincode_LOCATOR, data.getPincode());
		enterText(Remark_LOCATOR, data.getRemark());
		clickOn(STATE_DROPDOWN_LOCATOR);
		By STATE_LOCATOR = By.xpath("//span[contains(text(), '" + data.getState() + "')]/..");
		selectValueFromCustomDropdown(STATE_LOCATOR);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		String message = getElementText(SUCCESS_MESSAGE);
		String[] jobID = message.split(" ");
		System.out.println(jobID[0]);
		return jobID[0];
		
	}

	public void getCreateJobPageUrl() {
		System.out.println(getCurrentUrl());
	}
}
