package com.actTime.features;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.actTime.generic.BaseLib;
import com.actTime.pageObjects.HomePage;
import com.actTime.pageObjects.WorkSchedulePage;

public class WorkScheduleFeature extends BaseLib {

	HomePage hp;
	WorkSchedulePage wsp;

	public WorkScheduleFeature(WebDriver driver) {
		hp = new HomePage(driver);
		wsp = new WorkSchedulePage(driver);

	}

	public void selectCalenderDateForHolidayForOfficeDueToCoronaVirus() {

		hp.getWorkScheduleEle().click();
		List<WebElement> calenderDateList = wsp.getCalenderListElm();

		int listSize = calenderDateList.size();

		for (int i = 0; i < listSize; i++) {

			WebElement we = calenderDateList.get(i);

			if (we.getText().equals("23") || we.getText().equals("24") || we.getText().equals("25")
					|| we.getText().equals("26") || we.getText().equals("27") || we.getText().equals("30")
					|| we.getText().equals("31")) {

				calenderDateList.get(i).click();
			}

		}
	}

	public void diffrentTableViewOfCalender() {
		hp.getWorkScheduleEle().click();
		wsp.getSelectTheNoOfMonthToViewElm().click();
		List<WebElement> tableViewList = wsp.getDifferentTableViewElm();
		
		int listSize = tableViewList.size();
		
		for (int i = 0; i < listSize; i++) {
			
			tableViewList.get(i).click();
			wsp.getSelectTheNoOfMonthToViewElm().click();
			
		}


	}

}
