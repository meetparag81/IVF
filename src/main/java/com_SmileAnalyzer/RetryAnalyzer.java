package com_SmileAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com_Smile_Base.TestBase;

public class RetryAnalyzer implements IRetryAnalyzer
{
	int counter = 0;
	int retrylimit=3;
	public boolean retry(ITestResult arg0)
	{
		if(counter < retrylimit)
		{
			counter++;
			return true;
		}
		return false;
	}
	
	 
	
	
	

	
}
