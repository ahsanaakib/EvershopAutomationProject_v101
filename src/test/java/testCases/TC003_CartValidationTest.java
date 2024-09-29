package testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.ExpectedProductDetailsPage;
import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

public class TC003_CartValidationTest extends BaseClass {
	
	@Test(groups= {"Sanity","Regression"})
	public void verify_cartValidation()
	{
		logger.info("*** Starting TC003_CartValidationTest ***");
		try
		{	
			//Search for product
			HomePage hp =new HomePage(driver);
			hp.clickSearchIcon();
			hp.clickForInText();
			hp.setProductName(p.getProperty("userSearch")); //sending product name by using config.properties
			
			Actions act = new Actions(driver);
			act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform(); //click Enter button from keyboard by using actions
			
			//click on expected product
			SearchResultPage srp=new SearchResultPage(driver);
			srp.clickOnExpectedProduct(); 
			
			ExpectedProductDetailsPage epdp= new ExpectedProductDetailsPage(driver);
			
			epdp.clickProductSize(); //select size
			Thread.sleep(3000);
		
			epdp.clickProductColor(); //select color
			Thread.sleep(3000);
			
			epdp.inputQty(p.getProperty("qty")); //input quantity
			
			epdp.clickAddToCart();	//click on add to cart
			epdp.clickViewCart();	//click on view cart
			
			CartPage cp= new CartPage(driver);
			Thread.sleep(2000);
		
			//get product name and quantity
			String actProductName=cp.getProductName();
			String actQty=cp.getQuantity();
			
			//product validation in cart page
			Assert.assertTrue(actProductName.equalsIgnoreCase(p.getProperty("expProductName")),"Product name is mismatch (ignoring case)!");			
			Assert.assertEquals(actQty, p.getProperty("expQty"),"Product quantity mismatch!");
		
		}catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Finished TC003_CartValidationTest ***");
	}

}
