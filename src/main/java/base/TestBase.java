package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pases.JobSearchPage;

public class TestBase extends Driver {
	 public JobSearchPage jobSearchPage;
	
	@BeforeTest
	public void setup() {
		if (Boolean.valueOf(getPropetry("saucelabs"))) {
			SauceLabs sauce = new SauceLabs();
			sauce.setSauceLabs();
			driver = sauce.driver;
		} else {
			setDriver();
		}
		jobSearchPage = PageFactory.initElements(driver, JobSearchPage.class);

	}

	
	

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
