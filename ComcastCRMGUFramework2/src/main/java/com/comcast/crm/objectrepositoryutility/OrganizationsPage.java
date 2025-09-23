package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	WebDriver driver;
	
	public OrganizationsPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//img[@alt=\"Create Organization...\"]")
	private WebElement createNewOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement seartchTxtF;
	
	@FindBy(name="search_field")
	private WebElement searchDd;
	
	@FindBy (name = "submit")
	private WebElement searchBtn;
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSeartchTxtF() {
		return seartchTxtF;
	}

	public WebElement getSearchDd() {
		return searchDd;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	
}
