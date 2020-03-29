package com.actTime.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.actTime.features.LoginFeature;
import com.actTime.features.WorkScheduleFeature;
import com.actTime.generic.BaseLib;
import com.actTime.generic.ExcelLib;

public class WorkScheduleTest extends BaseLib {
	
	
	@Test(priority  =1)
	public void selectCalenderDateForHolidayForOfficeDueToCoronaVirusTest() throws IOException
	{
		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);		
		WorkScheduleFeature wsf= new WorkScheduleFeature(driver);
		wsf.selectCalenderDateForHolidayForOfficeDueToCoronaVirus();

	}
	
	@Test(priority  =2)
	public void diffrentTableViewOfCalenderTest() throws IOException
	{
		
		ExcelLib elib = new ExcelLib("C:\\SeleniumContent\\TestData\\testdata.xlsx");
		String username = elib.getCellData("Sheet1", 1, 1);
		String password = elib.getCellData("Sheet1", 2, 1);
		LoginFeature lf = new LoginFeature(driver);
		lf.validateLogin(username, password);
		WorkScheduleFeature wsf= new WorkScheduleFeature(driver);
		wsf.diffrentTableViewOfCalender();
	}

}
