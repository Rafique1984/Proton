package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import utils.ReadProperties;

public class SauceLabs extends ReadProperties {

	DesiredCapabilities caps;

	public static WebDriver driver;

	public void setSauceLabs() {

		String userName = getSaucelabsPropetry("userName");
		String accsesskey = getSaucelabsPropetry("accessKey");
		String url = "https://" + userName + ":" + accsesskey + "@ondemand.saucelabs.com:443/wd/hub";

		caps = setCababilities();

		try {
			driver = new RemoteWebDriver(new URL(url), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.get(getPropetry("appUrl"));

	}

	public DesiredCapabilities setCababilities() {

		String browser = getSaucelabsPropetry("browser");

		if (browser.equalsIgnoreCase("chrome")) {

			caps = DesiredCapabilities.chrome();

		} else if (browser.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();

		} else if (browser.equalsIgnoreCase("saferi")) {
			caps = DesiredCapabilities.safari();

		} else {
			caps = DesiredCapabilities.safari();
		}

		caps.setCapability("version", getSaucelabsPropetry("browserVersion"));

		caps.setCapability("platform", getSaucelabsPropetry("operatingSystem"));

		return caps;
	}

}
