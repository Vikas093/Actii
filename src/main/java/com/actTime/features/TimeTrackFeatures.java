package com.actTime.features;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.actTime.generic.BaseLib;
import com.actTime.pageObjects.BasePage;
import com.actTime.pageObjects.CreateNewTask;
import com.actTime.pageObjects.TaskPage;
import com.actTime.pageObjects.TimeTrackPage;

public class TimeTrackFeatures extends BaseLib {
	TaskPage tp;
	TimeTrackPage ttp;
	CreateNewTask cnt;
	BasePage bp;

	public TimeTrackFeatures(WebDriver driver)

	{

		tp = new TaskPage(driver);
		ttp = new TimeTrackPage(driver);

		cnt = new CreateNewTask(driver);
		bp = new BasePage(driver);
	}

	public void clickOnCreateNewTask() {

		ttp.getCreateNewTask().click();

	}

	public void createNewTask(String projectName, String customerName, String taskName) {

		String parent = driver.getWindowHandle();
		Set<String> handler = driver.getWindowHandles();

		ArrayList<String> list = new ArrayList<String>(handler);

		// -----------------------------------------List
		// Iterator---------------------------------------------------
		ListIterator<String> handler1 = list.listIterator();

		// ------------------------------------------Conditional
		// check----------------------------------------------
		while (handler1.hasNext()) {

			// --------------------------------------Getting element one by
			// one--------------------------------
			String str = handler1.next();
			if (!parent.equalsIgnoreCase(str)) {

				// ------------------------------Switching to child
				// window------------------------------------
				driver.switchTo().window(str);
			}
		}

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
		driver.switchTo().window(parent);

	}

	public void verifyCreateTask() {
		String exptMsg = "Notice to all hospital to create isolation ward for COVID-19";
		ttp.getInsertExistingTask().click();

		String parent = driver.getWindowHandle();
		Set<String> handler = driver.getWindowHandles();

		ArrayList<String> list = new ArrayList<String>(handler);

		// -----------------------------------------List
		// Iterator---------------------------------------------------
		ListIterator<String> handler1 = list.listIterator();

		// ------------------------------------------Conditional
		// check----------------------------------------------
		while (handler1.hasNext()) {

			// --------------------------------------Getting element one by
			// one--------------------------------
			String str = handler1.next();
			if (!parent.equalsIgnoreCase(str)) {

				// ------------------------------Switching to child
				// window------------------------------------
				driver.switchTo().window(str);
			}
		}

		String actMsg = bp.getVerifyMessage().getText();
		Assert.assertEquals(actMsg, exptMsg);
		
		
		
		Reporter.log(exptMsg, true);

	}
	
	
	public void insertExistingTaskToEnterTimeTrackPage()
	{
		
		ttp.getInsertExistingTask().click();
		
		String parent = driver.getWindowHandle();
		Set<String> handler = driver.getWindowHandles();

		ArrayList<String> list = new ArrayList<String>(handler);

		// -----------------------------------------List
		// Iterator---------------------------------------------------
		ListIterator<String> handler1 = list.listIterator();

		// ------------------------------------------Conditional
		// check----------------------------------------------
		while (handler1.hasNext()) {

			// --------------------------------------Getting element one by
			// one--------------------------------
			String str = handler1.next();
			if (!parent.equalsIgnoreCase(str)) {

				// ------------------------------Switching to child
				// window------------------------------------
				driver.switchTo().window(str);
			}
		}

		
		ttp.getSelectTaskToAddElm().click();
		
		ttp.getInsertSelectedTaskToEnterTimeTrackPage().click();
		
	}
}
