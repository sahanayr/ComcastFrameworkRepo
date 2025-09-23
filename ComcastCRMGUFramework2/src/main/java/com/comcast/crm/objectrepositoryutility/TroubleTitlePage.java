package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTitlePage {
WebDriver driver;
	
	public TroubleTitlePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//img[@alt=\"Create Ticket...\"]")
	private WebElement newTitleBtn;

	public WebElement getNewTitleBtn() {
		return newTitleBtn;
	}
}
