package annotations;

import org.testng.annotations.Test;

public class ConfigurationAnnotations extends BaseClass{
	@Test(invocationCount = 3)
	public void Test1() {
		System.out.println("Executed Test1");	
	}
	
	
	
	@Test(enabled = false)
	public void Test2() {
		System.out.println("Executed Test2");
	}
	
}
