package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactWithPhNum_DP_Test2 {
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName, String lastName) {
		System.out.println("FirstName:"+firstName +", LastName:" + lastName);
	}
	
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr =	new Object[3][2];
		objArr[0][0] = "sahana";
		objArr[0][1] = "yr";
		
		objArr[1][0] = "vinay";
		objArr[1][1] = "yr";
		
		objArr[2][0] = "poorna";
		objArr[2][1] = "chandra";
		
		return objArr;
		
		
	}
}


