 package com.test.SimpleFramework.simpleFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

//Initializing variables and properties
//Author -- Vasanth K

public class Base {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String destFile;

//	public Base(WebDriver driver) {
//		
//		this.driver = driver;
//		PageFactory.initElements(driver , this);
//	}

	public void initialization(String browserName) {
		
		ChromeOptions co = new ChromeOptions();
		co.setBrowserVersion("122");
		
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				
				driver = new ChromeDriver(co);
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else {
				throw new IllegalArgumentException("Invalid browser name: " + browserName);
			}
		} catch (Exception e) {
			System.out.println("Unable to initialize WebDriver: " + e.getMessage());
			System.exit(1);
		}
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		System.out.println("Browser initialized");
		//return new HomePage();
	}

	public static void tearDown() {
		if (driver != null) {
			driver.close();
			System.out.println("Browser closed");
		}
	}

}
