package Com.Ecommerce.PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;

public class TC_Ecommerce_AddToCart extends Ecommerce_BaseClass  {
	
	public TC_Ecommerce_AddToCart() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),\"Computers \")]")
	public WebElement computers;
	
	@FindBy(xpath="//a[contains(text(),\"Notebooks \")]")
	public WebElement Notebooks;
	
	@FindBy(xpath="//a[@title=\"Show details for Apple MacBook Pro 13-inch\"]")
	public WebElement SelectMackbook;
	
	@FindBy(id="add-to-cart-button-4")
	public WebElement Addtocart;
	
	@FindBy(xpath="//p[@class=\"content\"]")
	public WebElement message;
	
	@FindBy(xpath="//span[@title=\"Close\"]")
	public WebElement CloseTab;
	
	public void Notebook() {
		Notebooks.click();
	}
	
	public void SelectProduct() {
		SelectMackbook.click();
	}
	
	public void AddToCart() {
		Addtocart.click();
	}
	
	public void ProductAdded() {
		message.isDisplayed();
	}
	
	public void Close() {
		CloseTab.click();
	}


}
