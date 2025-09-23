package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
WebDriver driver;
	
	public CreateNewContactPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastNameTxtF;
	
	@FindBy (name = "support_start_date")
	private WebElement startDateTxtF;
	
	@FindBy (name = "support_end_date")
	private WebElement endDateTxtF;
	
	
	@FindBy (xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement addOrgBtn;
	
	public WebElement getAddOrgBtn() {
		return addOrgBtn;
	}

	public WebElement getStartDateTxtF() {
		return startDateTxtF;
	}

	public WebElement getEndDateTxtF() {
		return endDateTxtF;
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getLastNameTxtF() {
		return lastNameTxtF;
	}
}
