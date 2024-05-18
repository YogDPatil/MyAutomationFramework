package com.api.stepdefinations;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJobStepDef {

	RequestSpecification requestSpecification;
	Response response;

	@And("The header of the request is")
	public void the_header_of_the_request_is(DataTable dataTable) {
		requestSpecification = RestAssured.given();
		List<Map<String, String>> dataMap = dataTable.asMaps();
		for(Map<String, String> data : dataMap) {
			String key = data.get("Key");
			String value = data.get("Value");
			requestSpecification.header(key, value);
		}
	}

	@And("The request body is")
	public void the_request_body_is(DataTable dataTable) {
		
		List<Map<String, String>> bodyMapData = dataTable.asMaps();	
		for(Map<String, String> data : bodyMapData) {
			String customerFN = data.get("CustomerFName");
			String customerLN = data.get("CustomerLName");
			String imei = data.get("IMEI");
			String productName = data.get("ProductName");
			String mobileNumber = data.get("MobileNumber");
			String dop = data.get("DOP");
			String email = data.get("Email");
			
			requestSpecification.body("{\n"
					+ "    \"mst_service_location_id\": 0,\n"
					+ "    \"mst_platform_id\": 2,\n"
					+ "    \"mst_warrenty_status_id\": 1,\n"
					+ "    \"mst_oem_id\": 1,\n"
					+ "    \"customer\": {\n"
					+ "        \"first_name\": \""+customerFN+"\",\n"
					+ "        \"last_name\": \""+customerLN+"\",\n"
					+ "        \"mobile_number\": \""+mobileNumber+"\",\n"
					+ "        \"mobile_number_alt\": \"\",\n"
					+ "        \"email_id\": \""+email+"\",\n"
					+ "        \"email_id_alt\": \""+email+"\"\n"
					+ "    },\n"
					+ "    \"customer_address\": {\n"
					+ "        \"flat_number\": \"135\",\n"
					+ "        \"apartment_name\": \"33166\",\n"
					+ "        \"street_name\": \"9072 Marvin Point\",\n"
					+ "        \"landmark\": \"9603\",\n"
					+ "        \"area\": \"New Ashleyfort\",\n"
					+ "        \"pincode\": \"6959689\",\n"
					+ "        \"country\": \"Maharashtra\",\n"
					+ "        \"state\": \"India\"\n"
					+ "    },\n"
					+ "    \"customer_product\": {\n"
					+ "        \"dop\": \"2023-06-10T18:30:00.000Z\",\n"
					+ "        \"serial_number\": \""+imei+"\",\n"
					+ "        \"imei1\": \""+imei+"\",\n"
					+ "        \"imei2\": \""+imei+"\",\n"
					+ "        \"popurl\": \"2023-06-10T18:30:00.000Z\",\n"
					+ "        \"product_id\": 1,\n"
					+ "        \"mst_model_id\": 1\n"
					+ "    },\n"
					+ "    \"problems\": [\n"
					+ "        {\n"
					+ "            \"id\": 1,\n"
					+ "            \"remark\": \"Phone not working\"\n"
					+ "        }\n"
					+ "       \n"
					+ "    ]\n"
					+ "}");
			
		}
		

	}

	@And("The post request with the endpont {string}")
	public void the_post_request_with_the_endpont(String endpoint) {
		response = requestSpecification.when()
		.post(RestAssured.baseURI+endpoint);
	}

	@Then("Job nunber needs to create")
	public void job_nunber_needs_to_create() {
		response.then().log().all();
	}

	@And("Status code of create job api request should be {int}")
	public void status_code_of_create_job_api_request_should_be(Integer int1) {

	}
}
