package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName, String lastName, long phoneNumber) {
		System.out.println("FirstName:"+firstName +", LastName:" + lastName +", PhoneNumber:"+phoneNumber);
	}
	
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr =	new Object[3][3];
		objArr[0][0] = "sahana";
		objArr[0][1] = "yr";
		objArr[0][2] = 9741635963l;
		
		objArr[1][0] = "vinay";
		objArr[1][1] = "yr";
		objArr[1][2] = 6363236067l;
		
		objArr[2][0] = "poorna";
		objArr[2][1] = "chandra";
		objArr[2][2] = 9620529938l;
		
		return objArr;
		
		
	}
}


