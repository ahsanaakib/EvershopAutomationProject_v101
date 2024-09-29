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
		waitForElementToBeClickable(lnkProductSize, 10);
		lnkProductSize.click(); // size M
	}
	public void clickProductColor()
	{
		waitForElementToBeClickable(lnkProductColor, 10);
		lnkProductColor.click();	//color blue
	}
	public void inputQty(String qty)
	{
		waitForElementToBeVisible(inputQty, 10);
		inputQty.clear();
		inputQty.sendKeys(qty);	//quantity 2
	}
	public void clickAddToCart()
	{
		waitForElementToBeClickable(btnAddToCart, 10);
		btnAddToCart.click();
	}
	public void clickViewCart()
	{
		waitForElementToBeClickable(btnViewCart, 10);
		btnViewCart.click();
	}
	
}
