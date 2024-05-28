package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebElement;

import com.api.pojo.ApiRequestBody;
import com.constants.Env;
import com.constants.Role;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.ui.pojo.CreateJobUiPojo;

import io.restassured.RestAssured;

public abstract class TestUtils {

	static ApiRequestBody apiRequestBody;
	public static String jobID;

	public static String convertPojoToJson(Object object){
		Gson gson = new Gson();
		return gson.toJson(object);
	}

	public static String getPropertiesFileValue(Env env, String keyValue) {
		try {
			File file = new File(System.getProperty("user.dir")+"/Config/"+env+"config.properties");
			FileReader fileReader = new FileReader(file);
			Properties properties = new Properties();
			properties.load(fileReader);
			return properties.getProperty(keyValue);
		}
		catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getAuthToken(String role) {
		String loginbody = null;
		if(role.equals("fd")) {
			loginbody = "{\n"
					+ "    \"username\": \"iamfd\",\n"
					+ "    \"password\": \"password\"\n"
					+ "}";
		}
		else if(role.equals("eng")) {
			loginbody = "{\n"
					+ "    \"username\": \"iameng\",\n"
					+ "    \"password\": \"password\"\n"
					+ "}";
		}
		else if(role.equals("sup")) {
			loginbody = "{\n"
					+ "    \"username\": \"iamsup\",\n"
					+ "    \"password\": \"password\"\n"
					+ "}";
		}
		String token = RestAssured.given()
				.header("Content-Type","application/json")
				.body(loginbody)
				.when()
				.post(RestAssured.baseURI+"/login")
				.then()
				.log().all()
				.extract().jsonPath().get("data.token");
		return token;
	}

	public static String getAuthTokenByEnumClass(Role role) {
		String loginbody = null;
		if(role == Role.FD) {
			loginbody = "{\n"
					+ "    \"username\": \"iamfd\",\n"
					+ "    \"password\": \"password\"\n"
					+ "}";
		}
		else if(role == Role.ENG) {
			loginbody = "{\n"
					+ "    \"username\": \"iameng\",\n"
					+ "    \"password\": \"password\"\n"
					+ "}";
		}
		else if(role == Role.SUP) {
			loginbody = "{\n"
					+ "    \"username\": \"iamsup\",\n"
					+ "    \"password\": \"password\"\n"
					+ "}";
		}
		String token = RestAssured.given()
				.header("Content-Type","application/json")
				.body(loginbody)
				.when()
				.post(RestAssured.baseURI+"/login")
				.then()
				.log().all()
				.extract().jsonPath().get("data.token");
		return token;
	}

	public static int getJobID(){
		apiRequestBody = new ApiRequestBody();
		int jobID = RestAssured.given()
				.header("Authorization",getAuthTokenByEnumClass(Role.FD))
				.header("Content-Type","application/json")
				.body(apiRequestBody.getCreateJobApiRequestBody())
				.when()
				.post("http://139.59.91.96:9000/v1"+"/job/create")
				.then()
				.log().all()
				.assertThat()
				.statusCode(200)
				.body("data.id", Matchers.notNullValue())
				.extract().jsonPath().get("data.id");
		return jobID;
	}
	
	public static Iterator<String[]> readCsvFile(String fileName) {
		File csvFile = new File(System.getProperty("user.dir")+"//testData//"+fileName+".csv");
		FileReader fileReader;
		CSVReader csvReader;
		List<String[]> data = null;
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			data = csvReader.readAll();
			
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<String[]> dataIterator = data.iterator();
		dataIterator.next(); // 0th index retrived but not stored means csv file column heading can avoid to pass into code
		return dataIterator;
	}


	public static CreateJobUiPojo getUIFakerDataForCreateJob() {
		Faker faker = new Faker();
		return new CreateJobUiPojo("Apple", "IPhone", "Iphone 11", faker.numerify("##############"),
				"12/4/2024", "In Warrenty", "Poor battery life", "Remark", faker.name().firstName(), faker.name().lastName(),
				faker.numerify("98########"), faker.internet().emailAddress(), faker.address().buildingNumber(), faker.address().buildingNumber(),
				faker.address().cityName(), faker.address().streetName(), faker.address().city(), "Maharashtra", faker.numerify("######"));
	}
	
	public static boolean searchEnteryInList(List<String> list, String reqData) {
		boolean status = false;
		for(String data:list) {
			//String data = entry.getText();
			if(data.equals(reqData)) {
				status = true;
				break;
			}else {
				status = false;
			}
		}
		return status;
	}
	
}
