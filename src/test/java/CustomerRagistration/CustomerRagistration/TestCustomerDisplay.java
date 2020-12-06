package test.java.CustomerRagistration.CustomerRagistration;

import java.io.File;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentTest;
import main.java.CustomerRagistration.Utils.DriverSetUpForGrid;
import main.java.CustomerRagistration.Utils.ExcelReader;

public class TestCustomerDisplay {
	static String baseUrl = "https://webapps.tekstac.com/CustomerRegistration/"; // Assign the value for baseUrl
	static WebDriver driver;
	public static ExtentTest test;
	public static File reportDirectory;

	@Parameters("browser")
	@BeforeClass
	public void SetUp(String browser) throws MalformedURLException // DO NOT change the method signature
	{
		driver = DriverSetUpForGrid.getWebDriver(browser);
		driver.get(baseUrl);
	}

	// @Test
	public static void TestValidCustomerDetails() {

	}

	// @Test
	public static void TestInValidCustomerDetails() {

	}

	// @DataProvider
	public Object[][] getDataFromSheet() {
		ExcelReader excelReader = new ExcelReader();
		return excelReader.getDataFromSheet("customer_valid");
	}

	// @BeforeTest
	public void beforeTest() throws Exception {
		reportDirectory = new File(System.getProperty("user.dir") + "/TestResults/Screenshots/");
	}

	// @AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	// public static void getNavigationScreen(WebDriver driver) {
	// // log.info("capturing ui navigation screen...");
	// // Screen size is very big hence screenshots are not coming properly and
	// hence
	// // we are jooming in for 40% so that screenshot may come properly.
	// // new JavaScriptHelper(driver).zoomINTheScrin(40);
	// // below line will add the screenshot to emailed report under output folder.
	// String screen = captureScreenShot("", driver);
	// // if you zoom the screen in it is necessay to zoom it out back to normal
	// // othervise system will not be able to read object locators.
	// // new JavaScriptHelper(driver).zoomINTheScrin(100);
	//// try {
	//// // below line will add the screenshot to extent report under report folder.
	//// //test.addScreenCaptureFromPath(screen);
	//// } catch (IOException e) {
	//// e.printStackTrace();
	//// }
	// }

	// public static String captureScreenShot(String fileName, WebDriver driver) {
	// if (driver == null) {
	// // log.info("driver is null");
	// return null;
	// }
	// if (fileName == "") {
	// fileName = "Blank";
	// }
	// Reporter.log("captureScreen method called");
	// File destFile = null;
	//
	// File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	// try {
	// // reportDirectory was intialzed before test.
	// // reportDirectory = new
	// //
	// File(ResourceHelper.getResorcePath("/src/test/TestResults/com/uiAutomationRetailSite/Expedia/GCO/ScreenShots/");
	//
	// destFile = new File(reportDirectory + "/" + fileName + "_" + new
	// Random().nextInt(100000) + "_"
	// + new
	// SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(Calendar.getInstance().getTime())
	// + ".png");
	// Files.copy(scrFile.toPath(), destFile.toPath());
	// // System.out.println("destFile getAbsolutePath: " +
	// // destFile.getAbsolutePath());
	// // This will help us to link the screen shot in testNG extent report
	// Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" +
	// destFile.getAbsolutePath()
	// + "' height='100' width='100'/> </a>");
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return destFile.toString();
	// }

}
