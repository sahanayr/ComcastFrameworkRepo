package brokenlinksandcalender;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class IRCTC {

	@Test
	public void handleCalenderPopup() throws Throwable {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-8 ui-autocomplete ui-widget']//input[@role='searchbox']")).sendKeys("TUMAKURU - TK ");
		driver.findElement(By.xpath("//span[starts-with(text(),' TUMAKURU - TK ')]")).click();
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-9 ui-autocomplete ui-widget']//input[@role='searchbox']")).sendKeys("BANDRA - BA ");
		driver.findElement(By.xpath("//span[starts-with(text(),' BANDRA - BA ')]")).click();
		driver.findElement(By.xpath("//span[@class='ng-tns-c59-10 ui-calendar']//input[@type='text']")).click();
//		driver.findElement(By.xpath("//a[text()='31']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-next-icon pi pi-chevron-right ng-tns-c59-10')]")).click();
		driver.findElement(By.xpath("//a[text()='20']")).click();
		
	}
}
