package Com.Ecommerce.PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;

public class TC_Ecommerce_Login_Page extends Ecommerce_BaseClass{
	
	public TC_Ecommerce_Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	public WebElement Username;
	
	@FindBy(id="Password")
	public WebElement Password;
	
	@FindBy(xpath="//button[contains(text(),\"Log in\")]")
	public WebElement LoginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	public WebElement Logout;
	
	
	
	public void SetUsername(String Uname) {
		
		Username.sendKeys(Uname);
	}
	
	public void SetPasswordname(String Pass) {
		
		Password.sendKeys(Pass);
	}
	public void LoginBtn() {
		LoginBtn.click();
	}
	
	public void Logout() {
		Logout.click();
	}

}
