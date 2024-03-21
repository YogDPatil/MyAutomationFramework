package com.api.test;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Env;
import com.utils.TestUtils;

import io.restassured.RestAssured;
@Listeners(com.listeners.ApiListeners.class)
@Test(testName = "Login Api Test")
public final class LoginApiTest extends ApiTestBase{
	

	@Test(description ="verify that user can login using api and validate token is generated",
			groups = {"smoke","sanity","e2e"}, retryAnalyzer = com.listeners.RetryAnalyzer.class)
	public void test_logi_api_request() throws IOException
	{
		RestAssured.given()
		.header("Content-Type","application/json")
		.body("{\n"+"\"username\":\""+TestUtils.getPropertiesFileValue(Env.QA,"LOGIN_ID")+"\",\n"+"\""
				+TestUtils.getPropertiesFileValue(Env.QA, "PASSWORD")+"\":\"password\"\n"+"}")
		.when()
		.post(RestAssured.baseURI+"/login")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.and()
		.time(Matchers.lessThan(150l))
		.body("message", Matchers.equalTo("Success"))
		.body("data.token", Matchers.notNullValue());
		
	}
}
