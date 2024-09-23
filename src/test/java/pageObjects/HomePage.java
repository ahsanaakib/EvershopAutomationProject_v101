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
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
}
