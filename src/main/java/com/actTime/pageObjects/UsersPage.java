package com.actTime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
	
	@FindBy(xpath = "//div[contains(@id,'ext-comp-1002')]/span[text()='Create New User']")
	private WebElement createNewUsersButtonElm;	
	
	
	@FindBy(xpath = "//table[contains(@class,'userListTable')]//tr[3]//a")
	private WebElement CreatedUserLinkElm;	
	
	@FindBy(xpath = "//input[@value='Delete This User']")
	private WebElement deleteThisUserButtonElm;	
	
	
	
	
		public UsersPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}		
		
		
		public WebElement getCreateNewUsersButtonElm() {
			return createNewUsersButtonElm;
		}


		public WebElement getCretedUserLinkElm() {
			return CreatedUserLinkElm;
		}


		public WebElement getDeleteThisUserButtonElm() {
			return deleteThisUserButtonElm;
		}
		
		
		


}
