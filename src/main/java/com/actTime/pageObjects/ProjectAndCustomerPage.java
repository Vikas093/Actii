package com.actTime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectAndCustomerPage {
	
	@FindBy(css = "input[value='Create New Customer']")
	private WebElement createNewCustBtn;

	@FindBy(css = "input[name ='name']")
	private WebElement CustTxtBx;
	
	@FindBy(name = "createCustomerSubmit")
	private WebElement createCustomerBtn;	
	
	@FindBy(name = "selectedCustomer")
	private WebElement SelectCustdrpdwn;
	
	@FindBy(css = "input[value='Delete This Customer']")
	private WebElement DelThisCustEle;
	
	@FindBy(css = "input[value*='Show']")
	private WebElement showBtn;
	
	@FindBy(xpath = "//td[starts-with(@id,'customerNameCell')]//a[contains(@href,'customer')]")
	private WebElement CustLink;
	
	
	@FindBy(xpath = "//input[@value='Create New Project']")
	private WebElement createNewProjectBtn;

	@FindBy(name = "name")
	private WebElement projectName;

	@FindBy(name = "createProjectSubmit")
	private WebElement createProjectBtn;

	@FindBy(name = "customerId")
	private WebElement selectCustomerToAddProject;
	
	@FindBy(id = "deleteButton")
	private WebElement DeletePopupEle;
	

	@FindBy(xpath = "//td[contains(@class,'selectProject')]/input")
	private WebElement selectCustomerAndProjectElm;
	
	@FindBy(xpath = "//input[@value='Delete Selected']")
	private WebElement deleteSelected;
	
	@FindBy(css = "input[value='Delete This Project']")
	private WebElement DelThisProEle;
	
	
	
	public ProjectAndCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getCreateNewCustBtn() {
		return createNewCustBtn;
	}



	public WebElement getCustTxtBx() {
		return CustTxtBx;
	}



	public WebElement getCreateCustomerBtn() {
		return createCustomerBtn;
	}



	


	public WebElement getSelectCustdrpdwn() {
		return SelectCustdrpdwn;
	}



	public WebElement getDelThisCustEle() {
		return DelThisCustEle;
	}



	public WebElement getShowBtn() {
		return showBtn;
	}



	public WebElement getCustLink() {
		return CustLink;
	}



	public WebElement getCreateNewProjectBtn() {
		return createNewProjectBtn;
	}



	public WebElement getProjectName() {
		return projectName;
	}



	public WebElement getSelectCustomerAndProjectElm() {
		return selectCustomerAndProjectElm;
	}



	public WebElement getDelThisProEle() {
		return DelThisProEle;
	}



	public WebElement getCreateProjectBtn() {
		return createProjectBtn;
	}



	public WebElement getSelectCustomerToAddProject() {
		return selectCustomerToAddProject;
	}
	
	public WebElement getDeletePopupEle()
	{
		return  DeletePopupEle;
	}



	public WebElement getDeleteSelected() {
		return deleteSelected;
	}
	
	
	
	

	
	

}
