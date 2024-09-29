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
	
	@FindBy(xpath = "//div[@class='text-critical mb-4']")
	WebElement msgInvalidEmailandPwd;
	
	public void clickMyAccount()
	{
		waitForElementToBeClickable(lnkMyAccount, 10);
		lnkMyAccount.click();
	}
	
	public void clickSearchIcon()
	{
		waitForElementToBeClickable(lnkSearch, 10);
		lnkSearch.click(); // click search link
	}
	public void clickForInText()
	{
		waitForElementToBeVisible(clickForInText, 10);
		clickForInText.click(); //click for input text
	}
	public void setProductName(String pname)
	{
		waitForElementToBeVisible(clickForInText, 10);
		clickForInText.sendKeys(pname);
	}
	public String incorrectEmailPwd()
	{
		waitForElementToBeVisible(msgInvalidEmailandPwd, 10);
		return msgInvalidEmailandPwd.getText();
	}
	
}
