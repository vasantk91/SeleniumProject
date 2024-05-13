package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.SimpleFramework.simpleFramework.Base;

public class LoginPage extends Base {
	// Page Factory - OR:

	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement verifyLink;

	@FindBy(xpath = "//a[normalize-space()='Log in']")
	WebElement verifyLoginLink;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='Password'] ")
	WebElement Password;

	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement logOutButton;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions:

	

	public void VerifyLogin(String username, String password) {
		verifyLoginLink.click();
		userName.sendKeys(username);
		Password.sendKeys(password);
		loginButton.click();
		boolean isLoginSuccessful = logOutButton.isDisplayed();
		assertEquals(isLoginSuccessful, true);

	}

}
