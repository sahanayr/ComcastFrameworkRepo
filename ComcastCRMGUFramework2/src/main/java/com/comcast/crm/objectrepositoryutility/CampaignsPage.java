package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	WebDriver driver;
	
	public CampaignsPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//img[@alt=\"Create Campaign...\"]")
	private WebElement newcampaignBtn;

	public WebElement getNewcampaignBtn() {
		return newcampaignBtn;
	}
}
