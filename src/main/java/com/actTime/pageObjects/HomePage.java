package com.actTime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "(//td[@class ='pagetitle'])[2]")
	private WebElement enterTimeTrackTitle;

	@FindBy(xpath = "//div[text()='Tasks']")
	private WebElement taskEle;

	@FindBy(id = "logoutLink")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//div[text()='Users']")
	private WebElement usersEle;
	
	@FindBy(xpath = "//div[contains(text(),'Reports')]")
	private WebElement reportsEle;
	
	@FindBy(xpath = "//div[contains(text(),'Work Schedule')]")
	private WebElement workScheduleEle;
	
	
	

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEnterTimeTrackTitle() {
		return enterTimeTrackTitle;
	}

	public WebElement getTaskEle() {
		return taskEle;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getUsersEle() {
		return usersEle;
	}

	public WebElement getReportsEle() {
		return reportsEle;
	}

	public WebElement getWorkScheduleEle() {
		return workScheduleEle;
	}
	
	
	
}
