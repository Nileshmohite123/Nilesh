package Com.Ecommerce.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import Com.Ecommerce.PageClass.TC_Ecommerce_Login_Page;

public class TC_Login_Testcase extends Ecommerce_BaseClass {
	
	@Test
	public void LoginTestCase() throws InterruptedException, IOException {
		
		logger.info("Open commerce url");
		
		TC_Ecommerce_Login_Page TE= new TC_Ecommerce_Login_Page();
		
		TE.SetUsername(username);
		
		logger.info("Enter user mail");
		
		TE.SetPasswordname(password);
		logger.info("Enter user password");
		
		Thread.sleep(300);
		
		TE.LoginBtn();
		
		logger.info("Clicked on login button");
		
		Thread.sleep(300);
		
		
		if(driver.getTitle().equals("nopCommerce demo store")) {
			Assert.assertTrue(true);
			
			logger.info("Login successfully");
		}
		
		else {
			getScreenshotAs("LoginTestCase");
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
	}

}
