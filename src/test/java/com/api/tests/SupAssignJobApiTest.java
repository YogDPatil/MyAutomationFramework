package com.api.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.constants.Role;
import com.utils.TestUtils;

import io.restassured.RestAssured;

public final class SupAssignJobApiTest extends ApiTestBase{
	private String assignJobApiBody;
	
	@BeforeMethod(description = "steeing up api body")
	public void setupApiBody() {
		 assignJobApiBody = "{\n"+ "\"job_id\": \""+TestUtils.jobID+"\",\n"+ "\"engineer_id\": 2\n"+ "}";
	}
	
	@Test(description = "verify that sup can assign job using api", groups = {"sanity","smoke","e2e"})
	public void test_sup_assign_api_request() {
		
		RestAssured.given()
		.header("Authorization", TestUtils.getAuthTokenByEnumClass(Role.SUP))
		.header("Content-Type","application/json")
		//.body("{\n"+ "\"job_id\": \""+TestUtils.jobID+"\",\n"+ "\"engineer_id\": 2\n"+ "}")
		.body(assignJobApiBody)
		.when()
		.post(RestAssured.baseURI+"/engineer/assign")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}
}
