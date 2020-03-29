package com.actTime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewUsersPage {
	
	@FindBy(name="username")
	private WebElement userName;
	
	@FindBy(name="passwordText")
	private WebElement pwd;
	
	@FindBy(name="passwordTextRetype")
	private WebElement reTypepwd;
	
	@FindBy(name="firstName")
	private WebElement firstName;
	
	@FindBy(name="lastName")
	private WebElement lastName;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="mobile")
	private WebElement mobile;
	
	@FindBy(name="overtimeTracking")
	private WebElement enterOvertimeTracking;
	
	@FindBy(xpath="//td[contains(@class,'formfieldtitle')]/input[@name='rightGranted[1]']")
	private WebElement generateReportsCheckboxElm;
	
	@FindBy(xpath="//td[contains(@class,'formfieldtitle')]/input[@name='rightGranted[2]']")
	private WebElement manageCustomersAndProjectsCheckboxElm;
	
	
	
	@FindBy(xpath="//td[@class='formbuttonpane']/input[contains(@value,'Create User')]")
	private WebElement createUserElm;
	
	public CreateNewUsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getReTypepwd() {
		return reTypepwd;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getEnterOvertimeTracking() {
		return enterOvertimeTracking;
	}

	public WebElement getGenerateReportsCheckboxElm() {
		return generateReportsCheckboxElm;
	}

	public WebElement getManageCustomersAndProjectsCheckboxElm() {
		return manageCustomersAndProjectsCheckboxElm;
	}

	

	public WebElement getCreateUserElm() {
		return createUserElm;
	}
	
	
	
	
	
	

}
