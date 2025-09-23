package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewDocumentPage {
WebDriver driver;
	
	public CreateNewDocumentPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "notes_title")
	private WebElement titleTxtF;
	
	@FindBy (xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getTitleTxtF() {
		return titleTxtF;
	}
}
