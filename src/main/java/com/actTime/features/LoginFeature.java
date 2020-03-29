package com.actTime.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.actTime.pageObjects.LoginPage;

public class LoginFeature  {
	
	LoginPage lp; 
	
	
	public  LoginFeature(WebDriver driver)	
	
	{
		lp=new LoginPage(driver);
	}

	
	
	public void validateLogin(String username,String pwd)
	{
	lp.getUnTxtBx().sendKeys(username);
	lp.getPwdTxtBx().sendKeys(pwd);
	lp.getLoginButton().click();
	}

	public void verifyinvalidlogin()
	{
		String ExpMsg = "Username or Password is invalid. Please try again.";
		String actualMsg = lp.getErrmsgEle().getText();
		Assert.assertEquals(actualMsg, ExpMsg);
		
		Reporter.log("invalid login is verified", true);
	}
}
