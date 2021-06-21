package com.webdriverback;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.report.Myreports;

public class Webdriveractions extends Webdrivermanager{
	
	private static int implicitwaittime = 30;
	private static int iTimeOut = 20;
	
	public static void launchurl(String applicationurl)
	{
		try {
			getdriver().manage().timeouts().implicitlyWait(implicitwaittime, TimeUnit.SECONDS);
			((JavascriptExecutor)getdriver()).executeScript("window.focus();");
			getdriver().get(applicationurl);
		} catch (WebDriverException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
	
	public static boolean iselementdisplayed(By element) {
			boolean status = false;
			try {
				WebDriverWait wait = new WebDriverWait(getdriver(), iTimeOut);
				wait.until(ExpectedConditions.visibilityOfElementLocated(element));
				status = getdriver().findElement(element).isDisplayed();
				return status;
			} catch (Exception e) {
				return false;
			} 
	}
	
	public static boolean typeValue(By element, String textToEnter) {
		boolean bReturn = false;
		String elementName = "";
		try {
			WebDriverWait waiter = new WebDriverWait(getdriver(), iTimeOut);
			// waiter.until(ExpectedConditions.presenceOfElementLocated(element));
			waiter.until(ExpectedConditions.visibilityOfElementLocated(element));
			// waiter.until(ExpectedConditions.elementToBeClickable(element));
			elementName = getdriver().findElement(element).getText();
			if (elementName.isEmpty()) {
				elementName = element.toString();
			}
			moveToElement(element);
			getdriver().findElement(element).clear();
			getdriver().findElement(element).click();
			getdriver().findElement(element).sendKeys(textToEnter);
			Myreports.addlogs("Entered value \"" + textToEnter + "\" on element \"" + elementName + "\"", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Myreports.addlogs("Unable to find element \"" + element.toString() + "\" in page: ", "FAIL");
			e.printStackTrace();
			throw (e);
		}
		return bReturn;
	}
	
	public static void moveToElement(By element) {
		try {
			Actions actions = new Actions(getdriver());
			actions.moveToElement(getdriver().findElement(element));
			actions.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean listwebelementdispalyed(List<WebElement> elements) {
		boolean listReturn = false;
		try {
			WebDriverWait waiter = new WebDriverWait(getdriver(), iTimeOut);
			// waiter.until(ExpectedConditions.presenceOfElementLocated(element));
			waiter.until(ExpectedConditions.visibilityOfAllElements(elements));
			listReturn =true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listReturn;
	}


	
}
