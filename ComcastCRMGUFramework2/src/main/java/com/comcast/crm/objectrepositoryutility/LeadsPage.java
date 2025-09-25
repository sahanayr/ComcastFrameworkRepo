package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsPage {
	@FindBy(xpath = "//img[@alt=\"Create Lead...\"]")
	private WebElement addNewLeadBtn;
	
	@FindBy(name="searchBtn")
	private WebElement ele3;
	
}
