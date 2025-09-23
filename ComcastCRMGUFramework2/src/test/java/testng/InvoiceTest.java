package testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.comcast.crm.listnerutility.listnerImplementationClass.class)
public class InvoiceTest extends baseclass.BaseClass{
	@Test
	public void createInvoicetest() {
		System.out.println("Execute createInvoicetest ");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
	@Test
	public void createInvoiceWithontacttest() {
		System.out.println("Execute createInvoiceWithontacttest ");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
