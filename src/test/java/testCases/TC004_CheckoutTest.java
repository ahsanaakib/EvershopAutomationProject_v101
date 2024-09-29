package testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ExpectedProductDetailsPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

public class TC004_CheckoutTest extends BaseClass {

	@Test(groups = { "Regression" })
	public void verify_checkoutProcessTest() {
		logger.info("*** Starting TC004_CheckoutTest ***");
		try {
			//Navigate to my account page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();

			//Enter login credentials
			MyAccountPage map = new MyAccountPage(driver);
			map.inputEmail(p.getProperty("email"));
			map.inputPassword(p.getProperty("password"));
			map.clickSignin();
			Thread.sleep(2000);

			//Search for product
			hp.clickSearchIcon();
			hp.clickForInText();
			hp.setProductName(p.getProperty("userSearch")); // sending product name by getting from config.properties

			Actions act = new Actions(driver);
			act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform(); // click Enter button from keyboard by actions

			//click on expected product
			SearchResultPage srp = new SearchResultPage(driver);
			srp.clickOnExpectedProduct();

			Thread.sleep(3000);
			ExpectedProductDetailsPage epdp = new ExpectedProductDetailsPage(driver);

			epdp.clickProductSize();	//select size
			Thread.sleep(3000);

			epdp.clickProductColor();	//select color
			Thread.sleep(3000);

			epdp.inputQty(p.getProperty("qty")); // sending quantity by getting from config.properties

			epdp.clickAddToCart();	//click on add to cart
			epdp.clickViewCart();	//click on view cart

			Thread.sleep(5000);

			CartPage cp = new CartPage(driver);

			// get product name and quantity
			String actProductName = cp.getProductName();
			String actQty = cp.getQuantity();
			
			//product validation
			Assert.assertTrue(actProductName.equalsIgnoreCase(p.getProperty("expProductName")),
					"Product name is mismatch (ignoring case)!");

			Assert.assertEquals(actQty, p.getProperty("expQty"), 
					"Product quantity mismatch!");
		
			if (actProductName.equalsIgnoreCase(p.getProperty("expProductName"))
					&& actQty.equals(p.getProperty("expQty"))) {
				try {
					cp.clickCheckout();
					Thread.sleep(1000);
					CheckoutPage cop = new CheckoutPage(driver);
					
					//shipping details
					cop.setFullName("AK");
					cop.setTelephone("123456");
					cop.setAddress("Mall street");
					cop.setCityName("Beijing");
					cop.clickCountry();
					Thread.sleep(1000);
					cop.selectCountry();
					cop.clickProvince();
					Thread.sleep(1000);
					cop.selectProvince();
					cop.setPostcode("1234");
					Thread.sleep(1000);
					cop.clickRadioCheckedExpress();

					cop.clickContinuePayment();	//click on payment
					Thread.sleep(2000);
					// place order
					cop.clickCashOnDelivery();	//click on cash on delivery
					Thread.sleep(2000);
					cop.clickPlaceOrder();
					try {
						boolean orderExists = cop.isOrderIdExists();
						String orderid = cop.getOrderId();
						System.out.println(orderid);
						if (!orderExists) {
							Assert.fail("Order Id does not exists!");
						} else {
							logger.info("Order Id:" + orderid);
						}
					} catch (Exception e) {
						Assert.fail("Test failed due to exception: " + e.getMessage());
					}
				} catch (Exception e) {
					logger.error("Test failed due to exception: " + e.getMessage());
					Assert.fail();
				}
			} 
			else 
			{
				Assert.fail("Failed to proceed to shipping details due to validation issues.");
			}

		} catch (Exception e) {
			logger.error("Test failed due to exception: " + e.getMessage());
			Assert.fail();
		}
		logger.info("*** Finished TC004_CheckoutTest ***");
	}

}
