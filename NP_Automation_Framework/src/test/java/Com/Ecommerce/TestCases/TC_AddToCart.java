package Com.Ecommerce.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import Com.Ecommerce.PageClass.TC_Ecommerce_AddToCart;
import Com.Ecommerce.PageClass.TC_Ecommerce_Login_Page;

public class TC_AddToCart extends Ecommerce_BaseClass {
	
	@Test
	
public void AddProduct() throws InterruptedException, IOException {
		
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
		
		TC_Ecommerce_AddToCart TEA =new TC_Ecommerce_AddToCart();
		
		Actions act=new Actions(driver);
		
		WebElement computers=driver.findElement(By.xpath("//a[contains(text(),\"Computers \")]"));
		
       act.moveToElement(computers).perform();
       
       logger.info("mouse over on computer");
       
       TEA.Notebook();
       logger.info("Click on notebook text");
       
       TEA.SelectProduct();
       
       logger.info("product selected");
       
       
       TEA.AddToCart();
       logger.info("Add to cart");
       
       TEA.ProductAdded();
       logger.info("Verified message");
       
       TEA.Close();
       logger.info("clicked on close Tab");
}	

}
