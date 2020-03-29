package com.actTime.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.actTime.features.HomePageFeatures;
import com.actTime.features.LoginFeature;

import com.actTime.generic.BaseLib;
import com.actTime.generic.ExcelLib;

public class LoginTest extends BaseLib{
	
	@Test(priority = 1)
	public void validLoginTest() throws IOException
	{
		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);
		HomePageFeatures hpf= new HomePageFeatures(driver);
		hpf.verifyEnterTimeTrackPage();
		hpf.verifyHomePageTitle(driver);	
		
	}

	@Test(priority = 2,enabled=true)
	public void invalidLogin() throws IOException
	{
		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 2);
		String password = elib.getCellData("Sheet1", 2, 2);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);
		lf.verifyinvalidlogin();
	}

}
