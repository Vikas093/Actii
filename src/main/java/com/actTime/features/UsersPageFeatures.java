package com.actTime.features;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.actTime.generic.BaseLib;
import com.actTime.pageObjects.BasePage;
import com.actTime.pageObjects.CreateNewUsersPage;
import com.actTime.pageObjects.HomePage;

import com.actTime.pageObjects.UsersPage;

public class UsersPageFeatures extends BaseLib {

	HomePage hp;
	UsersPage up;
	CreateNewUsersPage cnup;
	BasePage bp;

	public UsersPageFeatures(WebDriver driver)

	{
		hp = new HomePage(driver);
		up = new UsersPage(driver);
		cnup = new CreateNewUsersPage(driver);
		bp=new BasePage(driver);

	}
	
	
	public void createUser(String userName,String pwd,String rtPwd,String firstName,String lastName,String email,String mobileNumber)
	{
		hp.getUsersEle().click();
		up.getCreateNewUsersButtonElm().click();
		cnup.getUserName().sendKeys(userName);
		cnup.getPwd().sendKeys(pwd);
		cnup.getReTypepwd().sendKeys(rtPwd);
		cnup.getFirstName().sendKeys(firstName);
		cnup.getLastName().sendKeys(lastName);
		cnup.getEmail().sendKeys(email);
		cnup.getMobile().sendKeys(mobileNumber);
		cnup.getEnterOvertimeTracking().click();
		cnup.getGenerateReportsCheckboxElm().click();
		cnup.getManageCustomersAndProjectsCheckboxElm().click();
	    cnup.getCreateUserElm().click();
	}
	
	
	public void verifyCreatedUser() {
		
		String ExpMsg ="User account has been successfully created.";
		String ActualMsg = bp.getSucessMsgEle().getText();
		Assert.assertEquals(ActualMsg, ExpMsg);
		Reporter.log(ExpMsg, true);
	}
	
	
	public void deleteUsers(){
		hp.getUsersEle().click();
		up.getCretedUserLinkElm().click();
		up.getDeleteThisUserButtonElm().click();
		Alert userDeltionAlert=driver.switchTo().alert();
		userDeltionAlert.accept();
		
	}
	
	public void verifyDeletedUser() {
		String ExpMsg ="User account has been successfully deleted.";
		String ActualMsg = bp.getSucessMsgEle().getText();
		Assert.assertEquals(ActualMsg, ExpMsg);
		Reporter.log(ExpMsg, true);
	}

}
