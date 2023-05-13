package com.swiggy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrder {
	

	private Actions actions;
	private WebDriverWait wait;
	
	
	@FindBy(xpath ="(//div[contains(@class,'_-kShr')])[1]")
	private WebElement firstItem;
	
	//@FindBy(xpath ="//div[contains(@class,'_1RPOp')]")
	//private WebElement addBtn;
	
	//@FindBy(xpath ="//span[contains(@class,'_1W_TH')]")
	@FindBy(xpath ="//span[contains(text(), 'Step 1/1')]")
	private WebElement continueBtn1;
	
	@FindBy(xpath ="//span[contains(text(), 'Step 1/2')]")
	private WebElement continueBtn2;
	
	@FindBy(xpath ="//span[contains(@class,'_38xdN')]")
	private WebElement addItemBtn;
	
	@FindBy(xpath="//button[contains(@class,'_3hEcN')]")
	private WebElement checkOutBtn;

	@SuppressWarnings("deprecation")
	public PlaceOrder (WebDriver driver){
		PageFactory.initElements (driver, this);
		actions = new Actions (driver);
		wait = new WebDriverWait(driver, 30);
		}
	
	
	public void addItem() {
		wait.until(ExpectedConditions.visibilityOf(firstItem));
		WebElement addBtn = firstItem.findElement(By.xpath("//div[contains(@class,'_1RPOp')]"));
		addBtn.click();
	}
	
	
	public void continueorder() {
		try {
			try {		
				wait.until(ExpectedConditions.visibilityOf(continueBtn1));
				actions.moveToElement(continueBtn1).click().perform();
				}
			catch(Exception e)
			{
				wait.until(ExpectedConditions.visibilityOf(continueBtn2));		
				actions.moveToElement(continueBtn2).doubleClick().perform();
			}
		}
		catch(Exception e){
		//Skip to next step
		}
	}
	
	public void moveToCart() {
		wait.until(ExpectedConditions.visibilityOf(addItemBtn));
		addItemBtn.click();
	}
	
	public void checkoutAction() {
		wait.until(ExpectedConditions.visibilityOf(checkOutBtn));
		wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn));
		checkOutBtn.click();
	}
	
}


