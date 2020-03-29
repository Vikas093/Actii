package com.actTime.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.actTime.features.LoginFeature;
import com.actTime.features.ReportPageFeatures;
import com.actTime.generic.BaseLib;
import com.actTime.generic.ExcelLib;

public class ReportTest extends BaseLib {
	
	
	@Test(priority = 1)
	public void generateStaffPerformanceReportTest() throws IOException
	{
		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);
		
		String reportName= elib.getCellData("Sheet1", 1, 4);
		String reportDes = elib.getCellData("Sheet1", 2, 4);
		
		ReportPageFeatures rpf= new ReportPageFeatures(driver);
		rpf.generateStaffPerformanceReport(reportName, reportDes);
		String createdReport = elib.getCellData("Sheet1", 3, 4);
		rpf.verifyGeneratedStaffPerformanceReport(createdReport);
	}
	
	
	@Test(priority = 2)
	public void deleteGenerateStaffPerformanceReportTest() throws IOException
	{
		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);
		ReportPageFeatures rpf= new ReportPageFeatures(driver);
		rpf.deletegeneratedStaffPerformanceReport();
		rpf.verifyDeletedGeneratedStaffPerformanceReport();
	}
		

}
