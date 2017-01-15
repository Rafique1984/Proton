package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ReadProperties;

public class Driver extends ReadProperties {

	public static WebDriver driver;

	public void setDriver() {
		String browser = getPropetry("browser");
		if (browser.equalsIgnoreCase("firefox")) {
			initFirefox();
		} else {
			initFirefox();
		}
		setDriverProperties();
		driver.get(getPropetry("appUrl"));

	}

	private void setDriverProperties() {
		driver.manage().window().maximize();

	}

	private void initFirefox() {
		driver = new FirefoxDriver();
	}

}
