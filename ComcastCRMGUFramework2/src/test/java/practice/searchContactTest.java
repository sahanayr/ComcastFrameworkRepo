package practice;
/**
 * test class for Contact module 
 * @author Sahana
 */

import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.LoginPage;

import baseclass.BaseClass;

public class searchContactTest extends BaseClass {
	/**
	 * scenario:login()==>navigateToContact==>createContact()==>verify
	 */
	@Test 
	public void searchContactTest() {
		/*step 1 : login to application*/
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp("url", "username", "password");
		
	}
}
