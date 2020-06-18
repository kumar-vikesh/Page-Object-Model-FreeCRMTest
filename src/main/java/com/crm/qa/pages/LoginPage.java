package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//PageFactory or OR:
	
	@FindBy(name ="email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath ="//button[contains(text(),'SignUp')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initialization of Page Objects of this class with driver
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, new LoginPage());
		driver.get(prop.getProperty("url"));
	}
	
	//Actions
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	/*public boolean validateCrmLogo()
	{
		return crmLogo.isDisplayed();
	}*/
	
	public HomePage login(String uname,String Pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(Pwd);
		loginBtn.click();
		return new HomePage(); //After Login, It should land at HomePage so written HomePage
	}
}
