package com.actTime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateReportPage {
	
	
	@FindBy(xpath = "//span[text()='Staff Performance']")
	private WebElement staffPerformanceElm;
	
	@FindBy(xpath = "//input[@id='configureReportParametersButton']")
	private WebElement configureReportParameterButtonElm;
	
	
	@FindBy(xpath = "//input[@id='generateReport']")
	private WebElement generateReportButtonElm;
	
	@FindBy(xpath = "//input[@id='saveReportAs']")
	private WebElement saveReportAsButtonElm;
	
	
	@FindBy(xpath = "//input[@id='reportName']")
	private WebElement reportNameElm;
	
	@FindBy(xpath = "//input[@id='reportName']")
	private WebElement descriptionElm;
	
	@FindBy(xpath = "//input[@id='saveReport']")
	private WebElement saveReportButtonElm;
	
	@FindBy(xpath = "//img[contains(@class,'delete-button')]")
	private WebElement deleteGeneratedReportElm;
	
	
	
	public CreateReportPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getStaffPerformanceElm() {
		return staffPerformanceElm;
	}

	public WebElement getConfigureReportParameterButtonElm() {
		return configureReportParameterButtonElm;
	}

	public WebElement getGenerateReportButtonElm() {
		return generateReportButtonElm;
	}

	public WebElement getSaveReportAsButtonElm() {
		return saveReportAsButtonElm;
	}

	public WebElement getReportNameElm() {
		return reportNameElm;
	}

	public WebElement getDescriptionElm() {
		return descriptionElm;
	}

	public WebElement getSaveReportButtonElm() {
		return saveReportButtonElm;
	}

	public WebElement getDeleteGeneratedReportElm() {
		return deleteGeneratedReportElm;
	}
	
	
	
	
	
	
	
	


}
