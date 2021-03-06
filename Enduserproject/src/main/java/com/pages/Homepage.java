package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.report.Myreports;
import com.utills.Dataprovider;
import com.webdriverback.Webdriveractions;

public class Homepage extends Webdriveractions{

	public By _amazonhomeimage = By.id("nav-logo-sprites");
	public By _productsearchbar = By.id("twotabsearchtextbox");
	public By _productsuggestlist = By.xpath("//div[starts-with(@id,'issDiv')]");
	public By _submit = By.xpath("//input[@type='submit']");
	
	private static enum exceltestcolumn {
		Productname
	}
	
	public void Verifyhomepage() {
		try {
			if(Webdriveractions.iselementdisplayed(_amazonhomeimage)) {
				Myreports.addlogs("Amazom Home page landed successfully ", "Pass");
			}else {
				Myreports.addlogs("Amazom Home page landed not landed on successfully", "Pass");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Searchbar() {
		try {
			boolean listcount = false;	
			String product = Dataprovider.getExcelData(exceltestcolumn.Productname.toString());
			typeValue(_productsearchbar, product);
			List<WebElement> allsearch = getdriver().findElements(_productsuggestlist);
			if(allsearch.size()>0) {
				listwebelementdispalyed(allsearch);
				for(int i=0;i<allsearch.size();i++) {
					if(product.toLowerCase().equals(allsearch.get(i).getText())){
						allsearch.get(i).click();
						listcount = true;
						break;
					}
				}
			}
			if(listcount) {
				Myreports.addlogs("Product is available in serach list and selected", "Pass");
			}else {
				Myreports.addlogs("Product is not available in search history", "Info");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(Webdriveractions.iselementdisplayed(_submit)) {
				getdriver().findElement(_submit).click();
				Myreports.addlogs("Product search submit button clicked", "Pass");
			}else {
				Myreports.addlogs("Product search submit button not visible", "fail");
			}
			
		}
	}
}
