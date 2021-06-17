package com.webdriverback;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Webdriveractions {
	private static ThreadLocal<String> browser= new ThreadLocal<String>();
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	private static ThreadLocal<String> url=new ThreadLocal<String>(); 
	private static ThreadLocal<String> modeexe=new ThreadLocal<String>(); 

	public static void setbrowsers(String browserset)
	{
		browser.set(browserset);
	}
	public static String getbrowser()
	{
		return browser.get();
	}

	public static void setdrivers(WebDriver drive)
	{
		driver.set(drive);
	}
	public static WebDriver getdriver()
	{
		return driver.get();
	}
	public static void seturl(String appurl) {
		url.set(appurl);
	}
	public static String geturl()
	{
		return url.get();
	}
	public static void setexemode(String exemode) {
		modeexe.set(exemode);
	}
	public static String getexemode()
	{
		return modeexe.get();
	}

}
