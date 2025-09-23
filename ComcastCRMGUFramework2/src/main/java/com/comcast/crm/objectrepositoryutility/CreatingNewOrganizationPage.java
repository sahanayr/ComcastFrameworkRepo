package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
WebDriver driver;
	
	public CreatingNewOrganizationPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(name = "accountname")
	private WebElement orgNameTxtF;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDd;
	
	@FindBy(name = "phone")
	private WebElement phoneNumTxtF;
	
	public WebElement getPhoneNumTxtF() {
		return phoneNumTxtF;
	}
	@FindBy(name = "accounttype")
	private WebElement typeDd;

	public WebElement getIndustryDd() {
		return industryDd;
	}

	public WebElement getTypeDd() {
		return typeDd;
	}

	public WebElement getOrgNameTxtF() {
		return orgNameTxtF;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
			
	}
	
	public void createOrg(String OrganizationName) {
		orgNameTxtF.sendKeys(OrganizationName);
		saveBtn.click();
}
	
	public void createOrg(String OrganizationName, String industry) {
		orgNameTxtF.sendKeys(OrganizationName);
		Select s = new Select(industryDd);
		s.selectByVisibleText(industry);
		saveBtn.click();
}
	public void createOrg(String OrganizationName, String industry, String type) {
		orgNameTxtF.sendKeys(OrganizationName);
		Select s = new Select(industryDd);
		s.selectByVisibleText(industry);
		Select s1 = new Select(typeDd);
		s1.selectByVisibleText(type);
		saveBtn.click();
}}
