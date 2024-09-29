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
		try {
			//Navigate to My Account page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();

			//Enter login credentials
			MyAccountPage map = new MyAccountPage(driver);
			map.inputEmail(p.getProperty("email"));
			map.inputPassword(p.getProperty("password"));
			map.clickSignin();

			//Check for login failure
			try
			{
			String loginCheck = hp.incorrectEmailPwd(); //Get login validation message
			if (loginCheck.equals("Invalid email or password")) {
				logger.error("Login failed due to incorrect credentials.");
				Assert.fail("Login failed. Invalid email or password.");
				return; //Stop further execution if login failed
			}
			}catch (Exception e) {
				logger.info("Login appears to be successful, no error message found.");
			}

			//Proceed to account validation if login was successful
			hp.clickMyAccount();

			logger.info("Validating Name and Email");
			String actualName = map.getUserAccName();
			String actualEmail = map.getUserEmail();

			//Expected values
			String expectedName = "ahsan";
			String expectedEmailPart = "@gmail.com";

			//Validate account name
			if (!actualName.equals(expectedName)) {
				logger.error("Account name does not match. Expected: " + expectedName + ", Found: " + actualName);
				Assert.fail("Account name does not match.");
			}

			//Validate email format
			if (!actualEmail.contains(expectedEmailPart)) {
				logger.error("Email format does not match. Expected to contain: " + expectedEmailPart + ", Found: " + actualEmail);
				Assert.fail("Email format does not match.");
			}
			logger.info("Login verification passed!");

		}catch (Exception e) {
			logger.error("Exception encountered:", e);
			Assert.fail("Test case failed due to an exception: " + e.getMessage());
		}
	
		logger.info("*** Finished TC002_LoginTest ***");
	}
}
