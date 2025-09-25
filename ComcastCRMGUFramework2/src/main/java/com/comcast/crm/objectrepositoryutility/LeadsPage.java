package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsPage {
	@FindBy(xpath = "//img[@alt=\"Create Lead...\"]")
	private WebElement addNewLeadBtn;
	
<<<<<<< HEAD
	@FindBy(name="searchBtn")
	private WebElement ele3;
	
=======
	@FindBy(name="search")
	private WebElement ele2;
>>>>>>> branch 'master' of https://github.com/sahanayr/ComcastFrameworkRepo.git
}
