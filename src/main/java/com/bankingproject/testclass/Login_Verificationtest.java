package com.bankingproject.testclass;
import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.bankingproject.pageobjectclass.Base_Class;
import com.bankingproject.pageobjectclass.LoginPage;
import com.bankingproject.utilities.Exeldata;

public class Login_Verificationtest extends Base_Class {
	
	 
	
	@Test
	public void FirstLoginTest() throws IOException, InterruptedException {
		
	
		driver.get(baseURL);
		test = extent.createTest("Verify Application Login");
		LoginPage login = new LoginPage(driver);	
		login.SetUserID(Exeldata.getdata(1, 0));
		test.log(Status.PASS, "Username successfully entered");
		
		login.SetPassword(Exeldata.getdata(1, 1));
		test.log(Status.PASS, "Password successfully entered");
		
		Thread.sleep(2000);
		
		login.ClickonLoginbtn();
		test.log(Status.PASS, "Clicked on login button");
		
	}
	@Test
	public void SecondLoginTest() throws IOException, InterruptedException {
		
		
		driver.get(baseURL);
		test = extent.createTest("Verify Application Login");
		LoginPage login1 = new LoginPage(driver);	
		login1.SetUserID(Exeldata.getdata(2, 0));
		test.log(Status.PASS, "Username successfully entered");
		
		login1.SetPassword(Exeldata.getdata(2, 1));
		test.log(Status.PASS, "Password successfully entered");
		Thread.sleep(2000);
		login1.ClickonLoginbtn();
		test.log(Status.PASS, "Clicked on login button");
	}
	@Test
public void ThirdLoginTest() throws IOException, InterruptedException {
		
		
		driver.get(baseURL);
		test = extent.createTest("Verify Application Login");
		LoginPage login2 = new LoginPage(driver);	
		login2.SetUserID(Exeldata.getdata(3, 0));
		test.log(Status.PASS, "Username successfully entered");
		
		login2.SetPassword(Exeldata.getdata(3, 1));
		test.log(Status.PASS, "Password successfully entered");
		
		Thread.sleep(2000);
		
		login2.ClickonLoginbtn();
		test.log(Status.PASS, "Clicked on login button");
	}

}
