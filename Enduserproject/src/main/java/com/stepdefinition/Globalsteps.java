package com.stepdefinition;

import com.report.Myreports;
import com.webdriverback.Webdriveractions;
import com.webdriverback.Webdrivermanager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Globalsteps extends Webdriveractions
{
	@Given("User launch the url in browser")
		public void user_launch_the_url_in_browser() {
		try {
			Myreports.addlogs(Thread.currentThread().getStackTrace()[1].getMethodName(), "Info");
	    	launchurl(Webdrivermanager.geturl());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    	    	
	}  

}
