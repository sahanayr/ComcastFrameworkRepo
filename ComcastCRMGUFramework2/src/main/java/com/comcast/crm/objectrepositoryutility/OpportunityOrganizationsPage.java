package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityOrganizationsPage {
WebDriver driver;
	
	public OpportunityOrganizationsPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (name = "search_text")
	private WebElement searchTxtF;
	
	@FindBy (name = "search")
	private WebElement searchNowBtn;

	public WebElement getSearchTxtF() {
		return searchTxtF;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
}
