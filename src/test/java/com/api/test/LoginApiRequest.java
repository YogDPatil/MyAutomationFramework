package com.api.test;

import com.api.pojo.LoginApiPojo;
import com.utils.TestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginApiRequest {

	public static void main(String[] args)
	{
		LoginApiPojo loginApiPojo = new LoginApiPojo("iamfd","password");
		System.out.println(loginApiPojo);
		System.out.println(TestUtils.convertPojoToJson(loginApiPojo));
		
		RestAssured.baseURI = "http://139.59.91.96:9000/v1";
	
		Response response = RestAssured.given()
		.header("Content-Type","application/json")
		.body(TestUtils.convertPojoToJson(loginApiPojo))
		.post(RestAssured.baseURI+"/login");
		
		System.out.println(response.asPrettyString());
		
	}
}
