package brokenlinksandcalender;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class CalenderPopupRedBus {
	@Test
	public void handleCalenderPopupTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//i[@class='icon___be1a22 icon icon-boarding_point']")).click();
		Thread.sleep(2000);
		
		
//		driver.findElement(By.xpath("//div[@class='inputAndSwapWrapper___e7dc96']/div[@class='labelCityWrapper___fd5744']/div[text()='From']")).sendKeys("Banglo");
//		driver.findElement(RelativeLocator.with(By.xpath("//div[@class='srcDestWrapper___e67e69'and@role='button']")))toleftof;
//		Actions a = new Actions(driver);
//		WebElement ele = driver.findElement(By.xpath("//div[@class='srcDest___aa6db3'and text()='Bangalore']"));
//		Thread.sleep(2000);
//		a.moveToElement(ele).perform();
//		
//		driver.findElement(By.xpath("//div[@class='dojWrapper___1f3d15']")).click();
		
				
		
	}
}
