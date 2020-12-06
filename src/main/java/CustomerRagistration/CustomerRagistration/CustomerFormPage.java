package main.java.CustomerRagistration.CustomerRagistration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerFormPage {
	WebDriver driver;
	@FindBy(xpath = "//input[@name='cname']")
	WebElement customerName;
	@FindBy(xpath = "//input[@name='age']")
	WebElement age;
	@FindBy(xpath = "//input[@name='address']")
	WebElement address;
	@FindBy(xpath = "//input[@name='phonenumber']")
	WebElement phoneNumber;
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='submit']")
	WebElement submitButton;
	@FindBy(xpath = "//input[@id='reset']")
	WebElement resetButton;
	@FindBy(xpath = "//div[@id='message']")
	WebElement errorMessage;

	public CustomerFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(submitButton));
		System.out.println("Customer Form Page is loaded.");
		// TestCustomerDisplay.getNavigationScreen(driver);
	}

	public void setCustomerName(String customerName) {
		new WebDriverWait(driver, 120).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOfElementLocated(By.name("cname")));
		this.customerName.click();
		this.customerName.clear();
		this.customerName.sendKeys(customerName);
	}

	public void setAge(String age) {
		new WebDriverWait(driver, 120).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOfElementLocated(By.name("age")));
		this.age.click();
		this.age.clear();
		this.age.sendKeys(age);
	}

	public void setAddress(String address) {
		new WebDriverWait(driver, 120).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOfElementLocated(By.name("address")));
		this.address.click();
		this.address.clear();
		this.address.sendKeys(address);
	}

	public void setPhoneNumber(String phoneNumber) {
		new WebDriverWait(driver, 120).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOfElementLocated(By.name("phonenumber")));
		this.phoneNumber.click();
		this.phoneNumber.clear();	
		this.phoneNumber.sendKeys(phoneNumber);
	}

	public void setEmail(String email) {
		new WebDriverWait(driver, 120).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		this.email.click();
		this.email.clear();
		this.email.sendKeys(email);
	}

	public void submitForm() {
		new WebDriverWait(driver, 120).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		this.submitButton.click();
	}

	public void clickResetBtton() {
		new WebDriverWait(driver, 120).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(By.id("reset")));
		this.resetButton.click();
	}

	public String getErrorMessage() {
		new WebDriverWait(driver, 120).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		return this.errorMessage.getText();
	}

	public boolean retryingFindClick(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

}
