package com.webdriverback;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Webdrivermanager {

	private static enum Browser {
		FIREFOX, 
		CHROME, 
		IE, 
		SAFARI, 
		GHOST, 
		HTMLUNIT, 
		HTMLUNITJS;
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
