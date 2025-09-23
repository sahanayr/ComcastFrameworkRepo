package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewTicketPage {
	WebDriver driver;
	
	public CreateNewTicketPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "ticket_title")
	private WebElement titleTxtAF;
	
	@FindBy (xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getTitleTxtAF() {
		return titleTxtAF;
	}
}
