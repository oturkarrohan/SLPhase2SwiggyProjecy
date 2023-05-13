package com.swiggy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Landinpage {
	
	private Actions actions;
	private WebDriverWait wait;
	
	@FindBy(id="location")
	private WebElement locationBox;
	
	@FindBy(xpath ="//a[contains(@class,'_3iFC5')]")
	private WebElement findFood;
	
	@FindBy(xpath ="//span[contains(@class ,'_2W-T9')]")
	private WebElement locationSuggestion;
	
	@SuppressWarnings("deprecation")
	public Landinpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		wait = new WebDriverWait(driver,10);	
		
	}
	
	public void enterLocation(String city) {
		wait.until(ExpectedConditions.visibilityOf(locationBox));
		locationBox.sendKeys(city);
		
		}
	public void selectLocation() {
		wait.until(ExpectedConditions.visibilityOf(locationSuggestion));
		locationSuggestion.click();
	}
	
	public void continuebtn() {
		findFood.click();
	}
	
	
}
