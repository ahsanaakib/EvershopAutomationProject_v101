package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CreateAnAccountPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	@Test(groups= {"Sanity"})
	public void verify_accRegistration()
	{
		logger.info("*** Starting TC001_AccountRegistrationTest ***");
		try
		{
			//Navigate to My Account page
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
		
			//Proceed to create account
			MyAccountPage map=new MyAccountPage(driver);
			map.clickCreateMyAcc();
		
			CreateAnAccountPage cap=new CreateAnAccountPage(driver);
			
			cap.setName("ahsan");
			cap.setEmail(randomString() + "@gmail.com");
			cap.setPassword("test@123");
			cap.clickSignUp();
			Thread.sleep(3000);
			
			//Navigate to My Account page
			hp.clickMyAccount();
		
			logger.info("Validating Name and Email");
			if(map.getUserAccName().equals("ahsan") && map.getUserEmail().contains("@gmail.com"))
			{
				Assert.assertTrue(true);
			}
			else
			{
			Assert.fail("Account info not matched");
			}
			
			map.clickLogout();
		
		}catch (Exception e) {
			logger.error("Exception encountered:", e);
			Assert.fail("Test case failed due to an exception: " + e.getMessage());
		}
		logger.info("*** Finished TC001_AccountRegistrationTest ***");
	}
}
