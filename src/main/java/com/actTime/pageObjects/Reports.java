package com.actTime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reports {
	
	@FindBy(xpath = "//span[text()='Create Report']")
	private WebElement createReportsElm;
	
	public Reports (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateReportsElm() {
		return createReportsElm;
	}	
	
	


}
