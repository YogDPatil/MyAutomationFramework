package com.api.stepdefinations;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import com.constants.Env;
import com.utils.TestUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginStepDef {

	RequestSpecification request;
	Response response;
	
	@Given("The base url of the application is {string}")
	public void the_base_url_of_the_application_is(String url) {
		RestAssured.baseURI = url;
	}

	@Given("The header passed is {string} and {string}")
	public void the_header_passed_is_and(String key, String value) {
		request = RestAssured.given()
		.header(key, value);
	}

	@Given("Enter login credentials in body {string} and {string}")
	public void enter_login_credentials_in_body_and(String string, String string2) {
		request.body("{\n"+"\"username\":\""+TestUtils.getPropertiesFileValue(Env.QA,"LOGIN_ID")+"\",\n"+"\""
				+TestUtils.getPropertiesFileValue(Env.QA, "PASSWORD")+"\":\"password\"\n"+"}");
	}

	@When("Post api request with endpoint {string}")
	public void post_api_request_with_endpoint(String endpoint) {
		response = request.when()
				.post(RestAssured.baseURI+endpoint);
	}


	@Then("Validate status code {int}")
	public void validate_status_code(int statusCode) {
		response.then().log().all().assertThat().statusCode(statusCode);
	}

	@And("Response time should be less than {int}")
	public void response_time_should_be_less_than(Integer responseTime) {
		response.then().assertThat().time(Matchers.lessThan((long)responseTime));
	}

	@And("The response body should contains {string} message")
	public void the_response_body_should_contains_message(String message) {
		response.then().body("message", Matchers.equalTo(message));
	}

	@And("Token should be generated")
	public void token_should_be_generated() {
		response.then().body("data.token ", Matchers.notNullValue());
	}

}
