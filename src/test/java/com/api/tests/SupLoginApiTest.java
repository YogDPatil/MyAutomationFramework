package com.api.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public final class SupLoginApiTest extends ApiTestBase {

	@Test(description = "verify that sup can login using api", groups = {"smoke", "sanity", "e2e"})
	public void test_sup_login_api_request()
	{
		RestAssured.given()
		.header("Content-Type","application/json")
		.body("{\n"+ "    \"username\": \"iamsup\",\n"+ "    \"password\": \"password\"\n"+ "}")
		.when()
		.post(RestAssured.baseURI+"/login")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}
}
