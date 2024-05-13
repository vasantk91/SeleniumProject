package CustomizedListners;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.SimpleFramework.simpleFramework.*;

public class ExtentManager extends Base {

	private static ExtentReports extent;
	public static String fileName;
	private static final ThreadLocal<ExtentTest> extentTestMap = new ThreadLocal<ExtentTest>();

	public static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);

		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Vasant K");
		extent.setSystemInfo("Organization", "SimpleFrame");
		extent.setSystemInfo("Build no", "OR-21");

		return extent;
	}

	public static void captureScreenshot() {
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			destFile = "F:\\MyFiles\\Selenium\\My Project\\simpleFramework\\Screenshots\\" + fileName;
			FileUtils.copyFile(screenshot, new File(destFile));
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		System.setProperty("org.uncommons.reportng.escape-output", "false");

	}
	/*
	 * public static synchronized ExtentTest createTest(String testName) {
	 * ExtentTest test = extent.createTest(testName); extentTestMap.set(test);
	 * return test; }
	 */

}
