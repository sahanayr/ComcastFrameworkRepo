package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOpportunityPage {
WebDriver driver;
	
	public CreateNewOpportunityPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "potentialname")
	private WebElement opportunityNameTxtF;
	
	@FindBy (xpath = "//img[@title=\"Select\"]")
	private WebElement addRelatedToBtn;
	
	@FindBy (name = "opportunity_type")
	private WebElement typeDd;
	
	@FindBy (name = "leadsource")
	private WebElement sourceDd;
	
	@FindBy (name = "closingdate")
	private WebElement closeDateTxtF;
	
	@FindBy (xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	public WebElement getTypeDd() {
		return typeDd;
	}

	public WebElement getSourceDd() {
		return sourceDd;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCloseDateTxtF() {
		return closeDateTxtF;
	}

	public WebElement getOpportunityNameTxtF() {
		return opportunityNameTxtF;
	}

	public WebElement getAddRelatedToBtn() {
		return addRelatedToBtn;
	}
	
	public void createOpportunity(String type, String source) {	
		Select s = new Select(typeDd);
		s.selectByVisibleText(type);
		Select s1 = new Select(sourceDd);
		s1.selectByVisibleText(source);
	}
	
	
	
}
