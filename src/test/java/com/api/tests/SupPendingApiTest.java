package com.api.test;

import org.testng.annotations.Test;

import com.constants.Role;
import com.utils.TestUtils;

import io.restassured.RestAssured;

public final class SupPendingApiTest extends ApiTestBase{
	@Test(description = "verify that ")
	public void test_sup_pending_api_test() {
		RestAssured.given()
		.header("Authorization",TestUtils.getAuthTokenByEnumClass(Role.SUP))
		.when()
		.get(RestAssured.baseURI+"/job/pending")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}
}
