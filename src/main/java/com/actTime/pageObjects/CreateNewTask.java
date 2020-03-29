package com.actTime.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewTask {

	@FindBy(xpath = "//select[@name='customerId']")
	private WebElement selectCustomerToAddTaskFor;

	@FindBy(xpath = "//select[@name='projectId']")
	private WebElement selectProjectToAddTaskFor;

	@FindBy(xpath = "//input[@class='text']")
	private List<WebElement> taskNameEle;

	@FindBy(xpath = "//img[@id='ext-gen7']")
	private WebElement deadLineEle;

	@FindBy(xpath = "//table[contains(@class,'x-date-inner')]//tr[5]//span[text()='27']")
	private WebElement selectTaskDeadLineDateElm;

	@FindBy(xpath = "//input[contains(@name,'task[0].markedToBeAddedToUserTasks')]")
	private WebElement createdTaskAddToMyTimeTrackElm;
	
	@FindBy(xpath = "//input[@value='Create Tasks']")
	private WebElement createTaskButton;
	

	@FindBy(xpath = "//input[@name='taskSelected[22]']")
	private WebElement selectTaskChecBoxElm;
	
	@FindBy(xpath = "//input[@value='Delete Selected Tasks']")
	private WebElement deleteSelectedTaskButtonElm;
	
	
	
	
	

	public CreateNewTask(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectCustomerToAddTaskFor() {
		return selectCustomerToAddTaskFor;
	}

	public WebElement getSelectProjectToAddTaskFor() {
		return selectProjectToAddTaskFor;
	}

	public WebElement getCreateTaskButton() {
		return createTaskButton;
	}

	public List<WebElement> getTaskNameEle() {
		return taskNameEle;
	}

	public WebElement getDeadLineEle() {
		return deadLineEle;
	}

	public WebElement getSelectTaskDeadLineDateElm() {
		return selectTaskDeadLineDateElm;
	}

	public WebElement getCreatedTaskAddToMyTimeTrackElm() {
		return createdTaskAddToMyTimeTrackElm;
	}

	public WebElement getSelectTaskChecBoxElm() {
		return selectTaskChecBoxElm;
	}

	public WebElement getDeleteSelectedTaskButtonElm() {
		return deleteSelectedTaskButtonElm;
	}
	
	

}
