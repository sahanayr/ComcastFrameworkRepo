package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	WebDriver driver;
	
	public ContactInformationPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement contactInfo;
	
	@FindBy (id = "dtlview_Support Start Date")
	private WebElement startDateInfo;
	
	@FindBy (id = "dtlview_Support End Date")
	private WebElement endDateInfo;
	
	@FindBy (id = "mouseArea_Organization Name")
	private WebElement orgName;

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getStartDateInfo() {
		return startDateInfo;
	}

	public WebElement getEndDateInfo() {
		return endDateInfo;
	}

	public WebElement getContactInfo() {
		return contactInfo;
	}
}
