package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homePage;
	public LoginPageTest() {
		//Invoke or Call Parent Class : TestBase Constructor 
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = loginpage.validateLoginPageTitle();
		//Now will write assertion Here
		Assert.assertEquals(title, "Cogmento CRM");
	}
	/*@Test(priority=2)
	public void crmLogoTest()
	{
		boolean flag = loginpage.validateCrmLogo();
		Assert.assertTrue(flag);
	}*/
	@Test(priority=2)
	public void loginTest()
	{
		homePage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
