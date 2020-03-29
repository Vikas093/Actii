package com.actTime.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.actTime.pageObjects.HomePage;

public class HomePageFeatures {

	HomePage etp;

	public HomePageFeatures(WebDriver driver)

	{
		etp = new HomePage(driver);
	}

	

	public void verifyEnterTimeTrackPage() {
		String expText = "Enter Time-Track";
		String actualTxt = etp.getEnterTimeTrackTitle().getText();
		Assert.assertEquals(actualTxt, expText);
		Reporter.log("EnterTimeTrackPage is verified", true);

	}

	public void verifyHomePageTitle(WebDriver driver) {
		String actualhomePageTitle = driver.getTitle();
		String expHomePageTitle = "actiTIME - Enter Time-Track";
		Assert.assertEquals(actualhomePageTitle, expHomePageTitle);
		Reporter.log("HomePage title is verified", true);

	}

}
