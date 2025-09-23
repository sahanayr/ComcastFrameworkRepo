package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	public WebElement getLeadsLink() {
		return leadsLink;
	}

	@FindAll({@FindBy (xpath = "//a[text()='Opportunities']"),@FindBy (xpath = "//a[@href=\"index.php?module=Potentials&action=index\"]")})	
	private WebElement opportunityLink;
	
	@FindBy (linkText = "Products")
	private WebElement productsLink;
	
	@FindBy (linkText = "Documents")
	private WebElement documentsLink;
	
	@FindBy (linkText = "Trouble Tickets")
	private WebElement ticketsLink;
	
	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public void setSignOutLink(WebElement signOutLink) {
		this.signOutLink = signOutLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getTicketsLink() {
		return ticketsLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getOpportunityLink() {
		return opportunityLink;
	}
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public void navigateToCampaignsPage() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLink.click();
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutLink.click();
	}
	
	
	
}
