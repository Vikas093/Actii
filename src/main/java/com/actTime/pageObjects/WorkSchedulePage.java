package com.actTime.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author vikas
 *
 */

public class WorkSchedulePage {
	
	@FindBy(xpath = "(//table[@id='calendar_table'][@class='calendarTable'])[2]//tr//td//span")
	private List<WebElement> calenderListElm;	
	
	@FindBy(xpath = "//a[text()='Select the Number of Months to View']")
	private WebElement selectTheNoOfMonthToViewElm;	
	
	@FindBy(xpath = "//div[@id='formatSelectorPopup']//div")
	private List<WebElement> differentTableViewElm;	
	
	
	
	
	public WorkSchedulePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public List<WebElement> getCalenderListElm() {
		return calenderListElm;
	}


	public WebElement getSelectTheNoOfMonthToViewElm() {
		return selectTheNoOfMonthToViewElm;
	}


	public List<WebElement> getDifferentTableViewElm() {
		return differentTableViewElm;
	}
	
	
	
	
	
	
	


}
