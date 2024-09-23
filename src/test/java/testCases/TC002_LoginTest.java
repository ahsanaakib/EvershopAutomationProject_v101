package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups= {"Sanity"})
	public void verify_loginTest()
	{
		logger.info("*** Starting TC002_LoginTest ***");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		
		MyAccountPage map=new MyAccountPage(driver);
		map.inputEmail(p.getProperty("email"));
		map.inputPassword(p.getProperty("password"));
		map.clickSignin();
		
		Thread.sleep(3000);
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
		}catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Finished TC002_LoginTest ***");
	}
}
