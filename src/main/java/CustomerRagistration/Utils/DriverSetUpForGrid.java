package main.java.CustomerRagistration.Utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSetUpForGrid {
	static String baseUrl = "https://webapps.tekstac.com/CustomerRegistration/";
	static DesiredCapabilities cap;

	public static WebDriver getWebDriver(String browser) throws MalformedURLException {
		// String hubUrl = "http://192.168.0.20:4444/wd/hub";
		String hubUrl = "http://localhost:4445/wd/hub";
		WebDriver driver;
		if (browser.equalsIgnoreCase("CHROME")) {
			cap = DesiredCapabilities.chrome();
		} else if (browser.equalsIgnoreCase("FIREFOX") || browser == null) {
			cap = DesiredCapabilities.firefox();
		}
		driver = new RemoteWebDriver(new URL(hubUrl), cap);
		driver.get(baseUrl);
		return driver;
	}
}
