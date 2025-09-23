package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.data.fileutility.ExcelUtility;

public class GetProductInfoInAmazonTest
{
	@Test(dataProvider = "getData") 
	public void getProductInfoTest(String brandName , String productName )
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		String x = "//span[text()='"+productName+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span[1]/span[2]/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
	}
	
	@DataProvider
	public Object[][] getData() throws Exception
	{
		
		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowCount("amazon");
		
		Object[][] objArr =	new Object[rowCount][2];
		
		for (int i = 0; i < rowCount; i++) {
			objArr[i][0] = eLib.getDataFromExcel("amazon", i+1, 0);
			objArr[i][1] = eLib.getDataFromExcel("amazon", i+1, 1);
		}
	
		return objArr;
	}}
