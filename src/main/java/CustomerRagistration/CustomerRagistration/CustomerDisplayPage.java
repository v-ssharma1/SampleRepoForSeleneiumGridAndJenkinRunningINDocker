package main.java.CustomerRagistration.CustomerRagistration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerDisplayPage {
	@FindBy(xpath = "//h2[contains(text(),'Registered Succesfully')]")
	WebElement successMessage;
	@FindBy(xpath = "//td[contains(text(),'Customer Name')]/following-sibling::td")
	WebElement name;
	@FindBy(xpath = "//td[contains(text(),'Age')]/following-sibling::td")
	WebElement age;
	@FindBy(xpath = "//td[contains(text(),'Address')]/following-sibling::td")
	WebElement address;
	@FindBy(xpath = "//td[contains(text(),'Phone number')]/following-sibling::td")
	WebElement phoneNumber;
	@FindBy(xpath = "//td[contains(text(),'Email')]/following-sibling::td")
	WebElement email;

	public CustomerDisplayPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		//TestCustomerDisplay.getNavigationScreen(driver);
	}

	public String getTitle() {
		return this.successMessage.getText();
	}

	public String getName() {
		return this.name.getText();
	}

	public String getAge() {
		return this.age.getText();
	}

	public String getEmail() {
		return this.email.getText();
	}

	public String getAddress() {
		return this.address.getText();
	}

	public String getPhoneNumber() {
		return this.phoneNumber.getText();
	}
}
