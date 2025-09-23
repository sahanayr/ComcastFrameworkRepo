package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class BaseClass {
	@BeforeMethod
	public void BM() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void AM() {
		System.out.println("After Method");
	}
	
	@BeforeClass
	public void BC() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void AC() {
		System.out.println("After Class");
	}
	
	@BeforeSuite
	public void BS() {
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void AS() {
		System.out.println("After Suite");
	}
	@BeforeTest
	public void BT() {
		System.out.println("Before Test");
	}
	@AfterTest
	public void AT() {
		System.out.println("After Test");
	}
	
	
	
	@BeforeMethod
	public void BM1() {
		System.out.println("Before Method1");
	}
	
	@AfterMethod
	public void AM1() {
		System.out.println("After Method1");
	}
	
	@BeforeClass
	public void BC1() {
		System.out.println("Before Class1");
	}
	
	@AfterClass
	public void AC1() {
		System.out.println("After Class1");
	}
	
	@BeforeSuite
	public void BS1() {
		System.out.println("Before Suite1");
	}
	@AfterSuite
	public void AS1() {
		System.out.println("After Suite1");
	}
	@BeforeTest
	public void BT1() {
		System.out.println("Before Test1");
	}
	@AfterTest
	public void AT1() {
		System.out.println("After Test1");
	}
}
