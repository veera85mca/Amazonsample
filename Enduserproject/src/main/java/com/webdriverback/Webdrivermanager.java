package com.webdriverback;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Webdrivermanager {

	private static ThreadLocal<String> browser= new ThreadLocal<String>();
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	private static ThreadLocal<String> url=new ThreadLocal<String>(); 
	private static ThreadLocal<String> modeexe=new ThreadLocal<String>(); 
	
	private static enum Browser {
		FIREFOX, 
		CHROME, 
		IE, 
		SAFARI, 
		GHOST, 
		HTMLUNIT, 
		HTMLUNITJS;
	}

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
	
	
	public static RemoteWebDriver invokeDriver(String browserName, String exeMode){
		RemoteWebDriver driver = null;
		try {
			if (exeMode.equalsIgnoreCase("remote") || exeMode.equalsIgnoreCase("grid")) {
				//driver = WebDriverManager.createRemoteDriver(browser);
			} else {
				browserName = (browserName != null) ? browserName : "chrome";
				try {
					switch (Browser.valueOf(browserName.toUpperCase())) {
					case FIREFOX:
					{
						System.setProperty("webdriver.gecko.driver", "./Alldrivers/geckodriver.exe");
						driver = new FirefoxDriver();
					}
						break;
					case IE:
						System.setProperty("webdriver.ie.driver", "./Alldrivers/IEDriverServer.exe");
						driver = new InternetExplorerDriver();
						break;
					case SAFARI:
						driver = new SafariDriver();
						break;
					case CHROME:
						System.setProperty("webdriver.chrome.driver", "./Alldrivers/chromedriver.exe");
						driver = new ChromeDriver();
						break;
					default:
						System.setProperty("webdriver.chrome.driver", "./Alldrivers/chromedriver.exe");
						driver = new ChromeDriver();
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return driver;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

}
