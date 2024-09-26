package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExpectedProductDetailsPage extends BasePage{

	public ExpectedProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//ul[@class='variant-option-list flex justify-start gap-2 flex-wrap']//li[1]/a[text()='S']")
	WebElement lnkProductSize;
	
	@FindBy(xpath = "//a[normalize-space()='Blue']")
	WebElement lnkProductColor;
	
	@FindBy(xpath = "//input[@placeholder='Qty']")
	WebElement inputQty;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement btnAddToCart;
	
	@FindBy(xpath = "//a[normalize-space()='VIEW CART (1)']")
	WebElement btnViewCart;
	
	public void clickProductSize()
	{
		lnkProductSize.click(); // size M
	}
	public void clickProductColor()
	{
		lnkProductColor.click();	//color purple
	}
	public void inputQty(String qty)
	{
		inputQty.clear();
		inputQty.sendKeys(qty);	//quantity 2
	}
	public void clickAddToCart()
	{
		btnAddToCart.click();
	}
	public void clickViewCart()
	{
		btnViewCart.click();
	}
	
}
