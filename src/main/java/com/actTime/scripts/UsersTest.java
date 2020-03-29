package com.actTime.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.actTime.features.LoginFeature;
import com.actTime.features.TaskPageFeatures;
import com.actTime.features.UsersPageFeatures;
import com.actTime.generic.BaseLib;
import com.actTime.generic.ExcelLib;

public class UsersTest extends BaseLib {
	
	@Test(enabled = true)
	public void createUserTest() throws IOException {

		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);
		
		String userName = elib.getCellData("Sheet1", 1, 3);
		String pwd = elib.getCellData("Sheet1", 2, 3);
		String rtPwd = elib.getCellData("Sheet1", 3, 3);
		String firstName = elib.getCellData("Sheet1", 4, 3);
		String lastName = elib.getCellData("Sheet1", 5, 3);
		String email = elib.getCellData("Sheet1", 6, 3);
		String mobile = elib.getCellData("Sheet1", 7, 3);
		UsersPageFeatures upf= new UsersPageFeatures(driver);
		upf.createUser(userName, pwd, rtPwd, firstName, lastName, email, mobile);
		upf.verifyCreatedUser();
		TaskPageFeatures tf= new TaskPageFeatures(driver);
		tf.logout();

}
	
	
	@Test(dependsOnMethods = "createUserTest")
	public void deleteUserTest() throws IOException
	{
		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);
		UsersPageFeatures upf= new UsersPageFeatures(driver);
		upf.deleteUsers();
		upf.verifyDeletedUser();
		
	}
}
