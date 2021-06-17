package com.webdriverback;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webuiactions extends Webdriveractions{

	
	public static void waitmethod(By ele)
	{
		WebDriverWait wait=new WebDriverWait(getdriver(), 20);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

}
