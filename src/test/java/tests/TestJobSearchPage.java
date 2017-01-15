package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class TestJobSearchPage extends TestBase {
	@Test
	public void testNewjobCount(){
		String text = jobSearchPage.totaljobWebElement.getText();
		Assert.assertEquals(text, "New Jobs (Total: 1 Jobs)");
	}
	

	
	

}
