package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	//registration
	@FindBy(xpath="//div[@class='login-form-inner']//a")
	WebElement lnkCreateMyAcc;
	
	@FindBy(xpath="//div[@class='account-details-name flex gap-4']//div[2]")
	WebElement accName;
	
	@FindBy(xpath="//div[@class='account-details-email flex gap-4']//div[2]")
	WebElement accEmail;
	
	@FindBy(xpath="//div[@class='col-span-1']//a")
	WebElement lnkLogout;
	
	//login
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement loginEmail;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement loginPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnSignin;
	
	//registration
	public void clickCreateMyAcc()
	{
		waitForElementToBeClickable(lnkCreateMyAcc, 10);
		lnkCreateMyAcc.click();
	}
	
	public String getUserAccName()
	{
		return accName.getText();
	}
	public String getUserEmail()
	{
		return accEmail.getText();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	//login
	public void inputEmail(String email)
	{
		loginEmail.sendKeys(email);
	}
	public void inputPassword(String pwd)
	{
		loginPassword.sendKeys(pwd);
	}
	public void clickSignin()
	{
		btnSignin.click();
	}
	public boolean isUserLoggedIn()
	{
		return lnkLogout.isDisplayed();
	}
}
