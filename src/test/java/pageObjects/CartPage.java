package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Nike zoom fly']")
	WebElement lnkaddedProduct;	//product link	
	
	@FindBy (xpath = "//td[@class='hidden md:table-cell']//input[@value='5']")
	WebElement productQty;	//quantity
	
	@FindBy(xpath="//a[@class='button primary']//span")
	WebElement btnCheckout;	//Checkout
	
	public String getProductName()
	{
		try 
		{
			return lnkaddedProduct.getText();

        }catch (NoSuchElementException e) {
        	String errorMsg = "Product link element not found.";
            System.out.println(errorMsg);
            Assert.fail(errorMsg);         // test fail and logging to report
            return null;
        }
	}
	public String getQuantity()
	{
		 try 
		 {
			 return productQty.getAttribute("value");
	     }catch(NoSuchElementException e) {
	    	 String errorMsg = "Product quantity element not found.";
	         System.out.println(errorMsg);  
	         Assert.fail(errorMsg);         
	         return null;
	     }
	}
	
	public void clickCheckout()
	{        
		 try 
		 {
			 btnCheckout.click();
	     } 
		 catch (NoSuchElementException e) {
			 String errorMsg = "Checkout button element not found.";
	         System.out.println(errorMsg);
	         Assert.fail(errorMsg);       
	     }
	}
	
}
