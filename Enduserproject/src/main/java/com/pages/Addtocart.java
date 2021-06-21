package com.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webdriverback.Webdriveractions;

public class Addtocart extends Webdriveractions{

	public By _Listproduct = By.xpath("//div[@data-component-type='s-search-result']");
	public static Map<String, Float> Productprice = new HashMap<>();	
 	
	public void Selectfirstitem() {
		try {
			List<WebElement> _allsearch = getdriver().findElements(_Listproduct);
			listwebelementdispalyed(_allsearch);
			
		} catch (Exception e) {
			
		}
	}
	
}
