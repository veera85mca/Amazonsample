package com.stepdefinition;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.report.Myreports;
import com.utills.Dataprovider;
import com.webdriverback.Webdrivermanager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;



public class Hooks extends Webdrivermanager {
	@Before
	public void beforescenario(Scenario scenaname)
	{
		Myreports.starttest(scenaname.getName());
		RemoteWebDriver driver=Webdrivermanager.invokeDriver(getbrowser(), getexemode());
		setdrivers(driver);
		Dataprovider.loadExcelData("./Myproperty/Testdata_Collections.xlsx", "Sheet1", scenaname.getName());
	}
	@After
	public void afterscenario()
	{
		if(getdriver()!=null)
		{
			getdriver().quit();
		}
		Myreports.closereport();
	}
}
