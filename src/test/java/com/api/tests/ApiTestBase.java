package com.api.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.constants.Env;
import com.utils.TestUtils;
import io.restassured.RestAssured;

public abstract class ApiTestBase {

	@BeforeClass(description = "setup the base uri")
	public void setUp() throws IOException
	{
		RestAssured.baseURI =TestUtils.getPropertiesFileValue(Env.QA, "BASE_URI");
	}
}
