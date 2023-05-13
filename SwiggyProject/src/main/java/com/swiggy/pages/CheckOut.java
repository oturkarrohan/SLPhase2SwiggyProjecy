package com.swiggy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOut {
	
	private Actions actions;
	private WebDriverWait wait;

	@FindBy(xpath="//span[contains(@class,'2EQ3T')]")
	private WebElement HeadingMsg;
	
	@SuppressWarnings("deprecation")
	public CheckOut(WebDriver driver) {
		PageFactory.initElements (driver, this);
		actions = new Actions (driver);
		wait = new WebDriverWait(driver, 10);
	}
	
	public String getMsg() {
		wait.until(ExpectedConditions.visibilityOf(HeadingMsg));
		String text = HeadingMsg.getText();
		return text;
	}
}
