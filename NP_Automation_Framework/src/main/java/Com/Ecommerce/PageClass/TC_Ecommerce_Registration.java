package Com.Ecommerce.PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;

public class TC_Ecommerce_Registration extends Ecommerce_BaseClass {
	
	
	public TC_Ecommerce_Registration() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),\"Register\")]")
	 WebElement Registration;
	
	@FindBy(id="FirstName")
	WebElement Firstname;
	
	@FindBy(id="LastName")
	WebElement Lastname;
	
	@FindBy(id="Email")
	WebElement Email;
	
	@FindBy(id="Password")
	WebElement Password;
	
	@FindBy(id="ConfirmPassword")
	WebElement ConfirmPassword;
	
	@FindBy(id="register-button")
	WebElement RegisterButton;
	
	public void RegistrationForm() {
		
		Registration.click();
		
	}
	
	public void SetFirstName(String name) {
		Firstname.sendKeys(name);
	}
	
	public void SetLastName(String name) {
		Lastname.sendKeys(name);
	}
	
	public void SetEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void SetPassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void SetConfirmPassword(String pass) {
		ConfirmPassword.sendKeys(pass);
	}
	public void Submit() {
		RegisterButton.click();
	}

}
