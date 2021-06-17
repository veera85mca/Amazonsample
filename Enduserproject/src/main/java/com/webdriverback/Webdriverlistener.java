package com.webdriverback;

import org.testng.IInvokedMethodListener;
import org.testng.IInvokedMethod;
import org.testng.ITestResult;

public class Webdriverlistener extends Webdriveractions implements IInvokedMethodListener {

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {
			String browser= method.getTestMethod().getXmlTest().getLocalParameters().get("browser");
			setbrowsers(browser);
			String url= method.getTestMethod().getXmlTest().getLocalParameters().get("url");
			seturl(url);
			String executionmode= method.getTestMethod().getXmlTest().getLocalParameters().get("exemode");
			setexemode(executionmode);
		}
		
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
	
		
	}

	
}
