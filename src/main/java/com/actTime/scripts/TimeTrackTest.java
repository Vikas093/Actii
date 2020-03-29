package com.actTime.scripts;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.actTime.features.LoginFeature;
import com.actTime.features.TaskPageFeatures;
import com.actTime.features.TimeTrackFeatures;
import com.actTime.generic.BaseLib;
import com.actTime.generic.ExcelLib;
import com.actTime.pageObjects.HomePage;
import com.actTime.pageObjects.TaskPage;

public class TimeTrackTest extends BaseLib {

	@Test(enabled = true)
	public void createNewTaskFromTimeTrackTest() throws IOException {

		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);
		TaskPageFeatures tpf = new TaskPageFeatures(driver);
		String customerName = elib.getCellData("Sheet1", 3, 1);
		TaskPageFeatures tf = new TaskPageFeatures(driver);
		String projectName = elib.getCellData("Sheet1", 4, 1);
		String taskName = elib.getCellData("Sheet1", 5, 1);
		
		
		tf.createcustomer(customerName);
		tf.logout();
		String username1 = elib.getCellData("Sheet1", 1, 1);
		String password1 = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf1 = new LoginFeature(driver);
		lf1.validateLogin(username1, password1);
		tf.createProject(projectName, customerName);
		tf.logout();
		
		String username2 = elib.getCellData("Sheet1", 1, 1);
		String password2 = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf2 = new LoginFeature(driver);
		lf2.validateLogin(username2, password2);
		
		
		TimeTrackFeatures ttf = new TimeTrackFeatures(driver);
		
		ttf.clickOnCreateNewTask();
		ttf.createNewTask(projectName, customerName, taskName);
		ttf.verifyCreateTask();		
		
	}
	
	
	@Test(dependsOnMethods = "createNewTaskFromTimeTrackTest")
	public void insertExistingTaskToTimeTrackPageTest() throws IOException
	{
		
		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);
		
		TimeTrackFeatures ttf = new TimeTrackFeatures(driver);
		ttf.insertExistingTaskToEnterTimeTrackPage();
		
		
		
	}
}