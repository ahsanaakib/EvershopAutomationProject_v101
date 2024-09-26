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
		String userSearch="nike zoom fly";
		
		HomePage hp =new HomePage(driver);
		hp.clickSearchIcon();
		hp.clickForInText();
		hp.setProductName(userSearch); //sending product name
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform(); //click Enter button from keyboard
		
		SearchResultPage srp=new SearchResultPage(driver);
		srp.clickOnExpectedProduct(); 
		
		Thread.sleep(3000);
		ExpectedProductDetailsPage epdp= new ExpectedProductDetailsPage(driver);
		
		epdp.clickProductSize();
		Thread.sleep(3000);
	
		epdp.clickProductColor();
		Thread.sleep(3000);
		
		epdp.inputQty("2"); //sending quantity
		
		epdp.clickAddToCart();
		epdp.clickViewCart();
		
		CartPage cp= new CartPage(driver);
		Thread.sleep(2000);
		
		String expProductName="nike zoom fly";
		String actProductName=cp.getProductName();
		
		Assert.assertTrue(actProductName.equalsIgnoreCase(expProductName),"Product name is mismatch (ignoring case)!");
		//Assert.assertEquals(actProductName, expProductName, "Product name mismatch!");
		
		String expQty="2";
		String actQty=cp.getQuantity();
		
		Assert.assertEquals(actQty, expQty,"Product quantity mismatch!");
		
		}catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Finished TC003_CartValidationTest ***");
	}

}
