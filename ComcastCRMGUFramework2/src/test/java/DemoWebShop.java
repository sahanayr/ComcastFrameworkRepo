

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.data.webdriverutility.WebDriverUtility;


	public class DemoWebShop extends WebDriverUtility {
		
		WebDriver driver;
		
			public DemoWebShop(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
			@FindBy(className ="ico-register")
			private WebElement registerLink;
			@FindBy(id="gender-female")
			private WebElement femaleRb;
			@FindBy(id="FirstName")
			private WebElement firstNameTxtF;
			@FindBy(id="LastName")
			private WebElement lastNameTxtF;
			@FindBy(id="Email")
			private WebElement emailTxtF;
			@FindBy(id="Password")
			private WebElement passwordTxtF;
			@FindBy(id="ConfirmPassword")
			private WebElement confirmPasswordTxtF;
			@FindBy(id="register-button")
			private WebElement registerBtn;
			@FindBy(className="ico-login")
			private WebElement loginLink;
			
			@FindBy(xpath ="//a[@href='/books']")
			private WebElement booksLink;
			@FindBy(xpath ="(//input[@type='button'])[4]")
			private WebElement B1C;
			@FindBy(xpath = "(//input[@type='button'])[4]")
			private WebElement B2C;
			@FindBy(xpath = "(//input[@type='button'])[5]")
			private WebElement B3C;
			
			@FindBy(xpath = "(//span[@class=\"cart-label\"])[1]")
			private WebElement shopping;
			
			public WebElement getShopping() {
				return shopping;
			}

			public WebElement getBooksLink() {
				return booksLink;
			}

			public WebElement getB1C() {
				return B1C;
			}

			public WebElement getB2C() {
				return B2C;
			}

			public WebElement getB3C() {
				return B3C;
			}




			public void RegisterToApp() {
				registerBtn.click();
				femaleRb.click();
				firstNameTxtF.sendKeys("sahana");
				lastNameTxtF.sendKeys("yr");
				emailTxtF.sendKeys("qwertyuiop@gmail.com");
				passwordTxtF.sendKeys("qwertyuiop");
				confirmPasswordTxtF.sendKeys("qwertyuiop");
				registerBtn.click();
				

			}
			

}

