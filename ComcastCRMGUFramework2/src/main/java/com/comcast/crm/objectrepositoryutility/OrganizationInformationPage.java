package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	WebDriver driver;
	
	public OrganizationInformationPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(className ="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id ="dtlview_Industry")
	private WebElement industryInfo;
	
	@FindBy(id ="dtlview_Type")
	private WebElement typeInfo;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement phoneNum;
	
	public WebElement getPhoneNum() {
		return phoneNum;
	}

	public WebElement getIndustryInfo() {
		return industryInfo;
	}

	public WebElement getTypeInfo() {
		return typeInfo;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	
}
