package com.swiggy.testscripts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;


public class OrderPizzaTestStep  extends Driver{
	
	@Given("a user is on the home of Swiggy")
	public void a_user_is_on_the_home_of_swiggy() {
		Assert.assertTrue(driver.getTitle().equals("Order food online from India's best food delivery service. Order from restaurants near you"));    
	}

	@Given("he Enters location as {string}")
	public void he_enters_location_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		landingPage.enterLocation(string);
	}
	

	@When("he selects first location from suggested location in suggestion-box")
	public void he_selects_first_location_from_suggested_location_in_suggestion_box() {
		landingPage.selectLocation(); 
		
	}

	
	@When("he redirects to ItemPage")
	public void he_redirects_to_item_page() {
		
	System.out.println("test casse"); 
		
	    
	}

	@When("he hover over search icon")
	public void he_hover_over_search_icon() {
		items.hoverOverSerch();
	}

	@When("He Enters Item as {string}")
	public void he_enters_item_as(String string) {
		
	    items.enterItem(string);
	}

	@When("he select first suggested Item in pizza cateogory")
	public void he_select_first_suggested_item_in_pizza_cateogory() {
		items.itemResult();
	}

	@When("he searchs resturant and select first restaurant")
	public void he_searchs_resturant_and_select_first_restaurant() {
		items.switchToRestaurant();
		items.selectFirstRestaurant();
	}
	
	@When("he adds the first recommended item")
	public void he_adds_the_first_recommended_item() {
		placeOrder.addItem();
	}

	
	@When("he redirects to orderPage")
	public void he_redirects_to_order_page() {
		placeOrder.continueorder();
	}
	
	@When("he adds first item to cart")
	public void he_adds_first_item_to_cart() {
		placeOrder.moveToCart();
	}

	@When("he click on checkout button")
	public void he_click_on_checkout_button() {
		placeOrder.checkoutAction();
	    
	}

	@Then("he should be able to order a pizza suscessfully")
	public void he_should_be_able_to_order_a_pizza_suscessfully() {
		String expectedErrMsg = "SECURE CHECKOUT";
		String actualErrMsg = checkOut.getMsg();
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
	    
	}
	
	

}
