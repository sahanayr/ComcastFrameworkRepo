package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketInfoPage {
WebDriver driver;
	
	public TroubleTicketInfoPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy (className = "dvHeaderText")
	private WebElement troubleTitleInfo;

	public WebElement getTroubleTitleInfo() {
		return troubleTitleInfo;
	}
}
