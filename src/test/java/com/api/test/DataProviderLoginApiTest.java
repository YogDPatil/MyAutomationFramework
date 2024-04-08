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
public final class DataProviderLoginApiTest extends ApiTestBase{
	

	@Test(description ="verify that user can login using api and validate token is generated",
			groups = {"smoke","sanity","e2e"},
			dataProviderClass = com.dataprovider.LoginDataProvider.class,
			dataProvider = "LoginData"
			)
	public void test_logi_api_request(String username, String password) throws IOException
	{
		RestAssured.given()
		.header("Content-Type","application/json")
		.body("{\n"+"\"username\":\""+username+"\",\n"+"\""
				+password+"\":\"password\"\n"+"}")
		.when()
		.post(RestAssured.baseURI+"/login")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.and()
		.time(Matchers.lessThan(500l))
		.body("message", Matchers.equalTo("Success"))
		.body("data.token", Matchers.notNullValue());
		
	}
}
