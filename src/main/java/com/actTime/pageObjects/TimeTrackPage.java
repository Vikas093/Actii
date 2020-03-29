package com.actTime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeTrackPage {
	
	
	@FindBy(xpath = "//a[text()='Create new tasks']")
	private WebElement createNewTask;	
	
	@FindBy(xpath = "//a[text()='Insert existing tasks']")
	private WebElement insertExistingTask;	
	
	@FindBy(xpath = "//table[@id='tasks-table']//tr[2]/td[4]/input")
	private WebElement selectTaskToAddElm;
	
	@FindBy(xpath = "//input[@value='Insert Selected Tasks to the Enter Time-Track Page']")
	private WebElement insertSelectedTaskToEnterTimeTrackPage;	
	
	
	
	public TimeTrackPage  (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewTask() {
		return createNewTask;
	}

	public WebElement getInsertExistingTask() {
		return insertExistingTask;
	}
	
	public WebElement getSelectTaskToAddElm() {
		return selectTaskToAddElm;
	}

	public WebElement getInsertSelectedTaskToEnterTimeTrackPage() {
		return insertSelectedTaskToEnterTimeTrackPage;
	}
	
	
	
	
	
	
	
	

}
