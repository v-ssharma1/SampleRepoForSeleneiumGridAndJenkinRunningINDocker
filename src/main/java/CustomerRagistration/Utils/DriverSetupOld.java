package main.java.CustomerRagistration.Utils;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
//
//import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.firefox.*;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Parameters;

//import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.FirefoxBrowser;

public class DriverSetupOld {
	// private static WebDriver driver;

	// @Parameters("browser")
	public static WebDriver getWebDriver() {
		//
		// FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
		return DriverSetupOld.getFirefoxDriver(DriverSetupOld.getFirefoxOptions());

	}

	public static FirefoxOptions getFirefoxOptions() {

		// DesiredCapabilities firefox = DesiredCapabilities.firefox();
		DesiredCapabilities firefox = new DesiredCapabilities();
		firefox.setCapability("browserName", "firefox");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);

		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);

		FirefoxOptions firefoxOptions = new FirefoxOptions(firefox);
		// Linux
		if (System.getProperty("os.name").contains("Linux")) {
			firefoxOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		}
		return firefoxOptions;
	}

	public static WebDriver getFirefoxDriver(FirefoxOptions cap) {
		if (System.getProperty("os.name").contains("Mac OS X")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/Resources/Drivers/geckodriver");
			return new FirefoxDriver(cap);
		} else if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/Resources/Drivers/geckodriver");
			return new FirefoxDriver(cap);
		} else if (System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/Resources/Drivers/geckodriver");
			return new FirefoxDriver(cap);
		}

		return null;
	}
}
