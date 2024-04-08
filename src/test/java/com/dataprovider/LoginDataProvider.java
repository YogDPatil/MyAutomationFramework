package com.dataprovider;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.utils.TestUtils;


public class LoginDataProvider {
	
	@DataProvider(name = "LoginData")
	public Iterator<String[]> loginDataProvide() {
		return TestUtils.readCsvFile("loginData");
	}

}
