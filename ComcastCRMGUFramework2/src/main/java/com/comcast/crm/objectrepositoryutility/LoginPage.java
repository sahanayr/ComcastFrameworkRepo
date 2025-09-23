
package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.data.webdriverutility.WebDriverUtility;
/**
 * contains login page elements and business library like login()
 * @author Sahana
 */
public class LoginPage extends WebDriverUtility {
	
	WebDriver driver;
	
		public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="user_name")
	private WebElement usernameTxtF;
	
	@FindBy (name="user_password")
	private	WebElement passwordTxtF;
	
	@FindBy (id="submitButton")
	private WebElement loginButton;

	public WebElement getUsernameTxtF() {
		return usernameTxtF;
	}

	public WebElement getPasswordTxtF() {
		return passwordTxtF;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	/**
	 * login to application based on username, password, url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	public void LoginToApp(String url, String username, String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameTxtF.sendKeys(username);
		passwordTxtF.sendKeys(password);
		loginButton.click();
		
	}
	
}
