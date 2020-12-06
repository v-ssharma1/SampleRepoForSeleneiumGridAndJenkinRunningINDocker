package test.java.CustomerRagistration.CustomerRagistration;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.CustomerRagistration.CustomerRagistration.CustomerFormPage;
import main.java.CustomerRagistration.Utils.DriverSetUpForGrid;
import main.java.CustomerRagistration.Utils.ExcelReader;

public class TestCustomerForm {
	static String baseUrl = "https://webapps.tekstac.com/CustomerRegistration/"; // Assign the value for baseUrl
	static WebDriver driver;
	TestCustomerForm testCustomerForm;
	CustomerFormPage customerFormPage;
	String errorMessage;
	static String UpdateResult = "Fail";
	ExcelReader excelReader;

	@Parameters("browser")
	@BeforeTest
	public void SetUp(String browser) throws MalformedURLException // DO NOT change the method signature
	{
		System.out.println("browser Name is " + browser);
		driver = DriverSetUpForGrid.getWebDriver(browser);
		// driver.get(baseUrl);
	}

	@Test(dataProvider = "getDataFromSheet")
	// public void testInValidCustomerDetails(String testCaseName, String
	// customerName, String age, String address,
	// String phoneNumber, String email, String result)
	public void testInValidCustomerDetails(String testCaseName, String customerName, String age, String address,
			String phoneNumber, String email) {
		customerFormPage = new CustomerFormPage(driver);
		// excelReader = new ExcelReader();
		System.out.println("===========Strat Test - " + testCaseName + "=============");
		try {
			if (customerName.trim().isEmpty()) {
				System.out.println("Inserting Customer Name " + customerName);
				customerFormPage.setCustomerName("");
			} else {
				System.out.println("Inserting Customer Name " + customerName);
				customerFormPage.setCustomerName(customerName);
			}
			if (age.trim().isEmpty()) {
				System.out.println("Inserting Customer Age " + age);
				customerFormPage.setAge("");
			} else {
				System.out.println("Inserting Customer Age " + age);
				customerFormPage.setAge(age);
			}
			if (address.trim().isEmpty()) {
				System.out.println("Inserting Customer Address " + address);
				customerFormPage.setAddress("");
			} else {
				System.out.println("Inserting Customer Address " + address);
				customerFormPage.setAddress(address);
			}
			if (email.trim().isEmpty()) {
				System.out.println("Inserting Customer Email " + email);
				customerFormPage.setEmail("");
			} else {
				System.out.println("Inserting Customer Email " + email);
				customerFormPage.setEmail(email);
			}
			if (phoneNumber.trim().isEmpty()) {
				System.out.println("Inserting Customer PhoneNumber " + phoneNumber);
				customerFormPage.setPhoneNumber("");
			} else {
				System.out.println("Inserting Customer PhoneNumber " + phoneNumber);
				customerFormPage.setPhoneNumber(phoneNumber);
			}
			System.out.println("Click On Submit button.");
			customerFormPage.submitForm();
			errorMessage = customerFormPage.getErrorMessage();
			// Thread.sleep(1000);
			System.out.println("Error Message is: " + errorMessage);
			if (customerName.trim().isEmpty()) {
				System.out.println("Validating the error message for blank valueof customer name.");
				System.out.println("Error Message is: " + errorMessage);
				Assert.assertTrue(errorMessage.equals("Customer name cannot be blank"),
						"Test Case " + testCaseName + "is being executed.");
				System.out.println("Test Case " + testCaseName + "has been passed.");
				UpdateResult = "Pass";
			}
			// if (customerName.trim().isEmpty() || address.trim().isEmpty() ||
			// email.trim().isEmpty()
			// || phoneNumber.trim().isEmpty() && age.trim().isEmpty()) {
			// Assert.assertTrue(errorMessage.equals("Age cannot be blank")
			// || errorMessage.equals("Customer name cannot be blank\nAge cannot be blank")
			// || errorMessage.equals("Age cannot be blank\nAddress cannot be blank")
			// || errorMessage.equals("Age cannot be blank\nphoneNumber cannot be blank")
			// || errorMessage.equals("Age cannot be blank\nEmail cannot be blank")
			// || errorMessage
			// .equals("Customer name cannot be blank\nAge cannot be blank\nAddress cannot
			// be blank")
			// || errorMessage.equals(
			// "Customer name cannot be blank\nAge cannot be blank\nPhone Number cannot be
			// blank")
			// || errorMessage
			// .equals("Customer name cannot be blank\nAge cannot be blank\nEmail cannot be
			// blank")
			// || errorMessage
			// .equals("Age cannot be blank\nAddress cannot be blank\nphoneNumber cannot be
			// blank")
			// || errorMessage.equals("Age cannot be blank\nAddress cannot be blank\nEmail
			// cannot be blank")
			// || errorMessage
			// .equals("Age cannot be blank\nphoneNumber cannot be blank\nEmail cannot be
			// blank")
			// || errorMessage.equals(
			// "Customer name cannot be blank\nAge cannot be blank\nphoneNumber cannot be
			// blank\nEmail cannot be blank")
			// || errorMessage.equals(
			// "Customer name cannot be blank\nAge cannot be blank\nAddress cannot be
			// blank\nEmail cannot be blank")
			// || errorMessage.equals(
			// "Customer name cannot be blank\nAge cannot be blank\nAddress cannot be
			// blank\nPhone Number cannot be blank")
			// || errorMessage.equals(
			// "Age cannot be blank\nAddress cannot be blank\nPhone Number cannot be
			// blank\nEmail cannot be blank")
			// || errorMessage.equals(
			// "Customer name cannot be blank\nAge cannot be blank\nAddress cannot be
			// blank\nPhone Number cannot be blank\nEmail cannot be blank"),
			// "Test Case " + testCaseName + "is being executed.");
			// System.out.println("Test Case " + testCaseName + "has been passed.");
			// UpdateResult = "Pass";
			// } else {
			// System.out.println("Test Case " + testCaseName + "has been failed.");
			// }
			if (address.trim().isEmpty()) {

				Assert.assertTrue(errorMessage.equals("Address cannot be blank"),
						"Test Case " + testCaseName + "is being executed.");
				System.out.println("Test Case " + testCaseName + "has been passed.");
				UpdateResult = "Pass";
			}
			if (email.trim().isEmpty()) {
				Assert.assertTrue(errorMessage.equals("Email cannot be blank"),
						"Test Case " + testCaseName + "is being executed.");
				System.out.println("Test Case " + testCaseName + "has been passed.");
				UpdateResult = "Pass";
			}
			if (phoneNumber.trim().isEmpty()) {
				Assert.assertTrue(errorMessage.equals("phoneNumber cannot be blank"),
						"Test Case " + testCaseName + "is being executed.");
				System.out.println("Test Case " + testCaseName + "has been passed.");
				UpdateResult = "Pass";
			}
		} catch (Exception e) {
			UpdateResult = "Fail";
			e.printStackTrace();
		}
		// System.out.println("Updating test result.");
		// excelReader.setCellData("customer_invalid", UpdateResult, testCaseName);
		System.out.println("=======================EndTest===============");
	}

	@DataProvider
	public Object[][] getDataFromSheet() {
		// excelReader = new ExcelReader();
		// return excelReader.getDataFromSheet("customer_invalid");
		Object[][] dataset = { { "Test_Case_1", "Saurabh", "22", "Chicago", "", "sau@gmail.com" },
				{ "Test_Case_2", "Saurabh", "22", "Chicago", "3129763902", "" } };
		return dataset;
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
