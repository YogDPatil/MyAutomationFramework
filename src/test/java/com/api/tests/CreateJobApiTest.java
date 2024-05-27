package com.api.tests;

import java.io.IOException; 

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.pojo.ApiRequestBody;
import com.utils.TestUtils;

import io.restassured.RestAssured;
import com.constants.Role;

public final class CreateJobApiTest extends ApiTestBase {
	ApiRequestBody apiRequestBody = new ApiRequestBody();
	
	@Test(description = "verify that user can create job using api and validate response",
			groups = {"smoke","sanity","e2e"})
	public void test_create_job_api_test() throws IOException {
		TestUtils.jobID = RestAssured.given()
		.header("Authorization",TestUtils.getAuthTokenByEnumClass(Role.FD))
		.header("Content-Type","application/json")
		.body(apiRequestBody.getCreateJobApiRequestBody())
		.when()
		.post(RestAssured.baseURI+"/job/create")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.body("data.id", Matchers.notNullValue())
		.extract().jsonPath().get("data.id");
	}
	
}
