package com.swiggy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Items {
	
	private Actions actions;
	private WebDriverWait wait;
	
	@FindBy(linkText = "Search")
	private WebElement serchIcon;
	
	@FindBy(xpath = "//input[contains(@placeholder ,'Search for restaurants and food')]")
	private WebElement placeHolder;
	
	@FindBy(xpath = "(//div[contains(@class,'_23LIV')])[1]")
	private WebElement itemResult;
	
	@FindBy(xpath ="//span[@data-testid='RESTAURANT-nav-tab-pl']")
	private WebElement selRestaurantBtn;
	
	@FindBy(xpath ="(//div[@class='styles_restaurantListItem__1lOsF'])[1]")
	private WebElement firstRestaurant;

	@SuppressWarnings("deprecation")
	public Items (WebDriver driver){
	PageFactory.initElements (driver, this);
	actions = new Actions (driver);
	wait = new WebDriverWait(driver, 10);
	}
	
	public void hoverOverSerch () {
		wait.until(ExpectedConditions.visibilityOf(serchIcon));
		serchIcon.click();
	}
	
	public void enterItem(String item) {
		wait.until(ExpectedConditions.visibilityOf(placeHolder));
		placeHolder.sendKeys(item);
		
	}
	public void itemResult() {	
		wait.until(ExpectedConditions.visibilityOf(itemResult));
		itemResult.click();
		//actions.sendKeys(Keys.ENTER).build().perform();
	}
	public void switchToRestaurant() {
		wait.until(ExpectedConditions.visibilityOf(selRestaurantBtn));
		selRestaurantBtn.click();
	}
	public void selectFirstRestaurant() {
		wait.until(ExpectedConditions.visibilityOf(firstRestaurant));
		firstRestaurant.click();
	}

}
