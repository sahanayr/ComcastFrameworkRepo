package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInformationPage {
WebDriver driver;
	
	public ProductsInformationPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy (className = "lvtHeaderText")
	private WebElement productInfo;

	public WebElement getProductInfo() {
		return productInfo;
	}
}
