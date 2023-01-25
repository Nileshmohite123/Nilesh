package Com.Ecommerce.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import Com.Ecommerce.PageClass.TC_Ecommerce_Registration;

public class TC_NewRegistration extends Ecommerce_BaseClass{
	
	@Test
	
	public void Registration() throws IOException {
		TC_Ecommerce_Registration TEA=new TC_Ecommerce_Registration();
		
		TEA.RegistrationForm();
		
		TEA.SetFirstName("Nilesh");
		
		TEA.SetLastName("Mohite");
		
		TEA.SetEmail("mohitenilesh7522@gmail.com");
		
		TEA.SetPassword("Mohite@123");
		
		TEA.SetConfirmPassword("Mohite@123");
		
		TEA.Submit();
		
		boolean test=driver.findElement(By.xpath("//div[contains(text(),\"Your registration completed\")]")).isDisplayed();
		
		if(test==true) {
			logger.info("User Created");
			Assert.assertTrue(true);
		}
		
		else {
			logger.info("UserCreation Failed");
			getScreenshotAs("Registration");
			Assert.assertTrue(false);
		}
		
	}

}
