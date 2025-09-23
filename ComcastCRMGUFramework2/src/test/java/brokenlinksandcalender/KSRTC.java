package brokenlinksandcalender;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class KSRTC {

	@Test
	public void handleCalenderPopup() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/");
		driver.findElement(By.xpath("//span[text()='Select Departure City']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search Your City Name']")).sendKeys("agumbe");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//em[text()='Agumbe']")).click();
		driver.findElement(By.xpath("//select[@data-placeholder='Select Destination City')))
	}
}
