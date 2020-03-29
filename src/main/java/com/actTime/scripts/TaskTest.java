package com.actTime.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.actTime.features.LoginFeature;
import com.actTime.features.TaskPageFeatures;
import com.actTime.generic.BaseLib;
import com.actTime.generic.ExcelLib;

public class TaskTest extends BaseLib {

	@Test(enabled = true)
	public void createCustomerTest() throws IOException {

		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);

		String customerName = elib.getCellData("Sheet1", 3, 1);
		TaskPageFeatures tf = new TaskPageFeatures(driver);
		tf.createcustomer(customerName);
		tf.verifyCreateCust(customerName);
		tf.logout();
	}

	@Test(dependsOnMethods = { "createCustomerTest" }, enabled = false)
	public void deleteCustomerTest() throws IOException {
		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);
		String customerName = elib.getCellData("Sheet1", 3, 1);
		TaskPageFeatures tf = new TaskPageFeatures(driver);
		tf.deleteCustomer(customerName);
		tf.verifydeleteCust(customerName);
		tf.logout();

	}

	@Test(dependsOnMethods = { "createCustomerTest" }, enabled = true)
	public void createNewProjectTest() throws IOException {

		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);
		String projectName = elib.getCellData("Sheet1", 4, 1);
		String customerNameForProjectCreation = elib.getCellData("Sheet1", 3, 1);
		TaskPageFeatures tf = new TaskPageFeatures(driver);
		tf.createProject(projectName, customerNameForProjectCreation);
		tf.verifyCreatedProject(projectName);

		tf.logout();

	}

	@Test(dependsOnMethods = { "createNewProjectTest" },enabled=false)
	public void deleteProjectTest() throws IOException {
		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);
		TaskPageFeatures tf = new TaskPageFeatures(driver);
		tf.deleteProject();
		tf.verifydeleteProject();
	}

	@Test(dependsOnMethods = { "createNewProjectTest" },enabled = true)
	public void createNewTaskTest() throws IOException {
		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);
		String customerName = elib.getCellData("Sheet1", 3, 1);
		TaskPageFeatures tf = new TaskPageFeatures(driver);
		String projectName = elib.getCellData("Sheet1", 4, 1);
		String taskName = elib.getCellData("Sheet1", 5, 1);
		tf.createNewTask(projectName, customerName, taskName);
		tf.verifyCreatedTask(customerName, projectName);
		tf.logout();

	}
	
	
	@Test(dependsOnMethods = { "createNewTaskTest" },enabled=true)
	public void completeTaskTest() throws IOException
	{
		
		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);
		TaskPageFeatures tf = new TaskPageFeatures(driver);
		tf.completeTask();
		tf.verifyCompleteTask();
		
	}
}
