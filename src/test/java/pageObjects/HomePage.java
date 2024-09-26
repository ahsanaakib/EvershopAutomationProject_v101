package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//div[@class='self-center']//a")
	WebElement lnkMyAccount;
	
	@FindBy (xpath="//a[@class='search-icon']")
	WebElement lnkSearch; //search link locator
	
	@FindBy (xpath="//input[@placeholder='Search']")
	WebElement clickForInText;
	
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickSearchIcon()
	{
		lnkSearch.click(); // click search link
	}
	public void clickForInText()
	{
		clickForInText.click(); //click for input text
	}
	public void setProductName(String pname)
	{
		clickForInText.sendKeys(pname);
	}
	
	
}
