package com.runner;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.report.Myreports;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions (features= {"src/test/java/featuredefinition"}, glue= {"com.test.Mysample"}, tags = "@First", monochrome=true)

public class Orderrunner extends AbstractTestNGCucumberTests {
	
	public static void startreport(ITestContext xmlname)
	{
		String Suitename=xmlname.getSuite().getName();
		Myreports.startreport(Suitename);
	}
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}
