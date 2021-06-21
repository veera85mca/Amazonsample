package com.stepdefinition;

import com.pages.Homepage;
import com.report.Myreports;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Orderflow {
	Homepage home = new Homepage();
	
	@When("User landed on homepage")
	public void User_landed_on_homepage() {
		try {
			Myreports.addlogs(Thread.currentThread().getStackTrace()[1].getMethodName(), "Info");
			home.Verifyhomepage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Given("User enter the book in search bar") 
	public void User_enter_the_book_in_search_bar() {
		try {
			Myreports.addlogs(Thread.currentThread().getStackTrace()[1].getMethodName(), "Info");
			home.Searchbar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User landed on add to cart button page")
	public void User_landed_on_add_to_cart_button_page() {
			
	}
	@And("User validate the product price in add to cart page")
	public void User_validate_the_product_price_in_add_to_cart_page() {
			
	}

	@But("User slick the proceed cart page")
	public void User_slick_the_proceed_cart_page() {
			
	}

	@Then("User landed on billing page")
	public void User_landed_on_billing_page() {
		
	}
}
