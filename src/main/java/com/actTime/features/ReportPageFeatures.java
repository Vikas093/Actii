package com.actTime.features;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.actTime.generic.BaseLib;
import com.actTime.pageObjects.BasePage;
import com.actTime.pageObjects.CreateReportPage;
import com.actTime.pageObjects.HomePage;
import com.actTime.pageObjects.Reports;

public class ReportPageFeatures extends BaseLib {

	HomePage hp;
	Reports rp;
	CreateReportPage crp;
	BasePage bp;

	public ReportPageFeatures(WebDriver driver) {

		hp = new HomePage(driver);
		rp = new Reports(driver);
		crp = new CreateReportPage(driver);
		bp= new BasePage(driver);
	}

	public void generateStaffPerformanceReport(String reportName, String reportDes) {

		hp.getReportsEle().click();
		rp.getCreateReportsElm().click();
		crp.getConfigureReportParameterButtonElm().click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		crp.getGenerateReportButtonElm().click();

		String parent = driver.getWindowHandle();
		Set<String> handler = driver.getWindowHandles();

		System.out.println(handler.size());

		ArrayList<String> list = new ArrayList<String>(handler);

		// -----------------------------------------List
		// Iterator---------------------------------------------------
		ListIterator<String> handler1 = list.listIterator();

		// ------------------------------------------Conditional
		// check----------------------------------------------
		while (handler1.hasNext()) {

			// --------------------------------------Getting element one by
			// one--------------------------------
			String str = handler1.next();
			if (!parent.equalsIgnoreCase(str)) {

				// ------------------------------Switching to child
				// window------------------------------------
				driver.switchTo().window(str);
			}
		}
		crp.getSaveReportAsButtonElm().click();
		crp.getReportNameElm().sendKeys(reportName);
		crp.getDescriptionElm().sendKeys(reportDes);
		crp.getSaveReportButtonElm().click();

	}

	public void verifyGeneratedStaffPerformanceReport(String reportName) {

		String ExpTxt = "Report \"" + reportName + "\" has been saved.";

		String actualTxt = bp.getSucessMsgEle().getText();
		Assert.assertEquals(actualTxt, ExpTxt);
		Reporter.log(ExpTxt, true);

	}
	
	
	public void deletegeneratedStaffPerformanceReport()
	{
		hp.getReportsEle().click();
		crp.getDeleteGeneratedReportElm().click();
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	
	public void verifyDeletedGeneratedStaffPerformanceReport()
	{
		String ExpTxt = "Report has been successfully deleted";
		String actualTxt = bp.getSucessMsgEle().getText();
		Assert.assertEquals(actualTxt, ExpTxt);
		Reporter.log(ExpTxt, true);
	}

}
