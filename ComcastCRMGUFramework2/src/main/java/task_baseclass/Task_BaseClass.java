package task_baseclass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Task_BaseClass {
	@BeforeSuite
	public void configBS() {
		System.out.println("BeforeSuite Executed");
	}
	@BeforeTest 
	public void configBT(){
		System.out.println("BeforeTest Executed");
	}
	@BeforeClass
	public void configBC() {
		System.out.println("BeforeClass Executed");
	}
	@BeforeMethod
	public void configBM() {
		System.out.println("BeforeMethod Executed");
	}
	@AfterSuite
	public void configAS() {
		System.out.println("AfterSuite Executed");
	}
	@AfterTest
	public void configAT(){
		System.out.println("AfterTest Executed");
	}
	@AfterClass
	public void configAC() {
		System.out.println("AfterClass Executed");
	}
	@AfterMethod
	public void configAM() {
		System.out.println("AfterMethod Executed");
	}
}
