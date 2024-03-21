package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utils.TestUtils;

public class RetryAnalyzer implements IRetryAnalyzer {
	private static int count = 1;
	private static final int MAX_ATTEMPT =Integer.parseInt(TestUtils.getPropertiesFileValue(Env.QA, "MAX_ATTEMPTS"));
	
	@Override
	public boolean retry(ITestResult result) {
		if(count <= MAX_ATTEMPT) {
			count = count+1;
			return true;
		}
		return false; //the test will not executed again and will mark as a falied
	}

}
