package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//span[normalize-space()='Nike zoom fly']")
	WebElement lnkExpProduct;
	
	public void clickOnExpectedProduct()
	{
		waitForElementToBeClickable(lnkExpProduct, 10);
		lnkExpProduct.click();
	}

}
