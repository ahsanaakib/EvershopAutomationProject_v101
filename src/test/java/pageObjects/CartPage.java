package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Nike zoom fly']")
	WebElement lnkaddedProduct;
	@FindBy (xpath = "//td[@class='hidden md:table-cell']//input[@value='2']")
	WebElement productQty;
	
	public String getProductName()
	{
		return lnkaddedProduct.getText();
	}
	public String getQuantity()
	{
		return productQty.getAttribute("value");
	}
}
