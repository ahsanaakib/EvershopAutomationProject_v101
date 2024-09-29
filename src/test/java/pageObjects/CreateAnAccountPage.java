package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPage extends BasePage{

	public CreateAnAccountPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//input[@placeholder='Full Name']")
	WebElement txtFullName;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnSignUp;
	
	public void setName(String name)
	{
		txtFullName.sendKeys(name);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void clickSignUp()
	{
		waitForElementToBeClickable(btnSignUp, 10);
		btnSignUp.click();
	}
}
