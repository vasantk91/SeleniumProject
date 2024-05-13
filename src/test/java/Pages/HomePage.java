package Pages;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.test.SimpleFramework.simpleFramework.Base;

public class HomePage extends Base {
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
	
	@FindBy(xpath="//a[@class='ico-account']")
	WebElement myAccountLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	// Actions:

	public void verifyMyAccountLink(String TCID, String pageTitle) {
		String expectedTitle = pageTitle;

		myAccountLink.click();
		String title = driver.getTitle();
		System.out.println("Page title is :"+ title);
		assertEquals(title, expectedTitle);

	}

	/*public void VerifyLogin(String username, String password) {
		verifyLoginLink.click();
		userName.sendKeys(username);
		Password.sendKeys(password);
		loginButton.click();

	}*/

}
