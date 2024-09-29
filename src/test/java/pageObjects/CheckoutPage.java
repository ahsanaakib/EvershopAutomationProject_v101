package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Full name']")
	WebElement setFullName;
	
	@FindBy(xpath = "//input[@placeholder='Telephone']")
	WebElement setTelephone;
	
	@FindBy(xpath = "//input[@placeholder='Address']")
	WebElement setAddress;
	
	@FindBy(xpath = "//input[@placeholder='City']")
	WebElement setCityName;
	
	@FindBy(xpath = "//select[@placeholder='Country']")
	WebElement drpdwnCountry;
	
	@FindBy(xpath = "//select[@placeholder='Country']//option[3]")
	WebElement selectCountry;
	
	@FindBy(xpath = "//select[@placeholder='Province']")
	WebElement drpdwnProvince;
	
	@FindBy(xpath="//select[@placeholder='Province']//option[3]")
	WebElement selectProvince;
	
	@FindBy(xpath="//input[@placeholder='Postcode']")
	WebElement inputPostcode;
	@FindBy(xpath = "//button[@class='button primary']//span")
	WebElement btnContinuePayment;
	
	@FindBy(xpath = "//span[normalize-space()='Express Delivery - $15.00']")
	WebElement radioCheckedExp;
	@FindBy(xpath = "//span[normalize-space()='Standard Delivery - $5.00']")
	WebElement radioCheckedStd;
	//cash on delivery
	@FindBy(xpath = "(//*[name()='svg'])[11]")
	WebElement svgCashOnDel;
	//place order
	@FindBy(xpath = "//button[@class='button primary']//span[text()='Place Order']")
	WebElement btnPlaceOrder;
	//get Order Id
	@FindBy(xpath = "//h3[@class='thank-you flex justify-start space-x-8']//span")
	WebElement orderId;
	
	public void setFullName(String name)
	{
		setFullName.sendKeys(name);
	}
	public void setTelephone(String tphone)
	{
		setTelephone.sendKeys(tphone);
	}
	public void setAddress(String address)
	{
		setAddress.sendKeys(address);
	}
	public void setCityName(String cname)
	{
		setCityName.sendKeys(cname);
	}
	public void clickCountry()
	{
		drpdwnCountry.click();
	}
	public void selectCountry()
	{
		selectCountry.click();
	}
	public void clickProvince()
	{
		drpdwnProvince.click();
	}
	public void selectProvince()
	{
		selectProvince.click();
	}
	public void setPostcode(String pcode)
	{
		inputPostcode.sendKeys(pcode);
	}
	public void clickContinuePayment()
	{
		btnContinuePayment.click();
	}
	public void clickRadioCheckedExpress()
	{
		radioCheckedExp.click();
	}
	public void clickRadioCheckedStandard()
	{
		radioCheckedStd.click();
	}
	public void clickCashOnDelivery()
	{
		svgCashOnDel.click();
	}
	public void clickPlaceOrder()
	{
		btnPlaceOrder.click();
	}
	public boolean isOrderIdExists()
	{
		return orderId.isDisplayed();
	}
	public String getOrderId()
	{
		return orderId.getText();
	}
}
