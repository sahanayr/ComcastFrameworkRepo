package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivateSim {

public class InvoiceTest {
	@Test(retryAnalyzer = com.comcast.crm.listnerutility.RetryListenerImpementation.class)
	public void activateSimTest() {
		System.out.println("Execute createInvoicetest ");
		Assert.assertEquals("", "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
	
}

}
