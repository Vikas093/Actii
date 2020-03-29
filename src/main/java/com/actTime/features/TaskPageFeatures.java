package com.actTime.features;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.actTime.generic.BaseLib;
import com.actTime.pageObjects.BasePage;

import com.actTime.pageObjects.CreateNewTask;
import com.actTime.pageObjects.HomePage;
import com.actTime.pageObjects.ProjectAndCustomerPage;
import com.actTime.pageObjects.TaskPage;

public class TaskPageFeatures extends BaseLib {

	TaskPage tp;
	HomePage hp;
	ProjectAndCustomerPage pcp;
	CreateNewTask cnt;
	BasePage bp;
	

	public TaskPageFeatures(WebDriver driver) {
		tp = new TaskPage(driver);
		hp = new HomePage(driver);
		pcp = new ProjectAndCustomerPage(driver);
		cnt = new CreateNewTask(driver);
		bp=new BasePage(driver);
	}
		

	public void createcustomer(String customerName) {
		hp.getTaskEle().click();
		tp.getProjectsNCustomersEle().click();
		pcp.getCreateNewCustBtn().click();
		pcp.getCustTxtBx().sendKeys(customerName);
		pcp.getCreateCustomerBtn().click();
	}

	public void verifyCreateCust(String customerName) {
		String ExpMsg = "Customer \"" + customerName + "\" has been successfully created.";
		String ActualMsg = bp.getSucessMsgEle().getText();

		Assert.assertEquals(ActualMsg, ExpMsg);
		Reporter.log(ExpMsg, true);
	}

	public void logout() {
		hp.getLogoutBtn().click();
	}

	public void deleteCustomer(String customerName) {
		hp.getTaskEle().click();
		tp.getProjectsNCustomersEle().click();
		Select sel = new Select(pcp.getSelectCustdrpdwn());
		sel.selectByVisibleText(customerName);
		pcp.getShowBtn().click();
		pcp.getCustLink().click();
		pcp.getDelThisCustEle().click();
		pcp.getDeletePopupEle().click();

	}

	public void verifydeleteCust(String ExpCustomer) {
		String ExpTxt = "Customer has been successfully deleted.";
		String actualTxt = bp.getSucessMsgEle().getText();
		Assert.assertEquals(actualTxt, ExpTxt);

		Select sel = new Select(pcp.getSelectCustdrpdwn());
		List<WebElement> options = sel.getOptions();
		for (int i = 0; i < options.size(); i++) {
			String actualCustomer = options.get(i).getText();
			Assert.assertNotEquals(actualCustomer, ExpCustomer);
		}

		Reporter.log(ExpTxt, true);

	}

	public void createProject(String projectName, String customerName) {

		hp.getTaskEle().click();
		tp.getProjectsNCustomersEle().click();
		pcp.getCreateNewProjectBtn().click();
		WebElement selectCustomerToAddProject = pcp.getSelectCustomerToAddProject();
		Select select = new Select(selectCustomerToAddProject);
		select.selectByVisibleText(customerName);
		pcp.getProjectName().sendKeys(projectName);
		pcp.getCreateProjectBtn().click();

	}

	public void verifyCreatedProject(String ExpProjectName) {
		String ExpMsg = "Project \"" + ExpProjectName + "\" has been successfully created.";
		String actualMsg = bp.getSucessMsgEle().getText();
		Assert.assertEquals(actualMsg, ExpMsg);

		Reporter.log(ExpMsg, true);

	}
	
	public void deleteProject() {
		
		hp.getTaskEle().click();
        tp.getProjectsNCustomersEle().click();
        pcp.getSelectCustomerAndProjectElm().click();
        pcp.getDeleteSelected().click();
        pcp.getDelThisProEle().click();
		
		
	}
	
	
	public void verifydeleteProject() {
		
		String ExpTxt = "Selected projects have been successfully deleted.";
		String actualTxt = bp.getSucessMsgEle().getText();
		Assert.assertEquals(actualTxt, ExpTxt);
		Reporter.log(ExpTxt, true);
		
	}
	

	public void createNewTask(String projectName, String customerName, String taskName) {

		hp.getTaskEle().click();
		tp.getCreateNewTaskElm().click();

		WebElement selectCustomerToAddTask = cnt.getSelectCustomerToAddTaskFor();
		Select select1 = new Select(selectCustomerToAddTask);
		select1.selectByVisibleText(customerName);
		WebElement selectProjectToAddTask = cnt.getSelectProjectToAddTaskFor();
		Select select2 = new Select(selectProjectToAddTask);
		select2.selectByVisibleText(projectName);
		String firstXpath = "//input[@name='task[";
		String secondXpath = "].name']";

		List<WebElement> taskNameElement = cnt.getTaskNameEle();
		int taskElementSize = taskNameElement.size();

		for (int i = 0; i < taskElementSize - 4; i++) {
			String finalXpath = firstXpath + i + secondXpath;

			WebElement createTaskInputField = driver.findElement(By.xpath(finalXpath));
			createTaskInputField.sendKeys(taskName);

			cnt.getDeadLineEle().click();
			cnt.getSelectTaskDeadLineDateElm().click();
			cnt.getCreatedTaskAddToMyTimeTrackElm().click();
			cnt.getCreateTaskButton().click();

		}
	}

	public void verifyCreatedTask(String customerName, String projectName) {

		String ExpMsg = "1 new task was added to the customer \"" + customerName + "\", project \"" + projectName
				+ "\".";
		String actualMsg = bp.getSucessMsgEle().getText();
		Assert.assertEquals(actualMsg, ExpMsg);
		Reporter.log(ExpMsg, true);

	}
	
	
	public void completeTask() {
		hp.getTaskEle().click();
		tp.getSelectTaskElm().click();
		tp.getCompletedSelectedTaskButton().click();		
		
	}
	
	
	public void verifyCompleteTask() {
		
		String ExpMsg ="Selected tasks have been successfully completed.";
		String actualMsg = bp.getSucessMsgEle().getText();
		Assert.assertEquals(actualMsg, ExpMsg);
		
		
	
		
	}

}
