package com.webdriver.testeg;


import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


@Listeners(ListenersTest1.class)

public class Reports1 {

	WebDriver driver;

	ExtentReports extentreports;

	ExtentSparkReporter sparkReporter;

	ExtentTest testCase;

	@BeforeClass
	public void beforeclass() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\skarthika\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver=new ChromeDriver();

		extentreports=new ExtentReports();

		sparkReporter=new ExtentSparkReporter("C:\\Users\\skarthika\\git\\selenium_grid\\Selenium24thAug\\src\\test\\resources\\Reports\\spark1.html");


		extentreports.attachReporter(sparkReporter);




	}
	@Test
	public void r1() throws IOException {

		sparkReporter.config().setTheme(Theme.DARK);

		sparkReporter.config().setDocumentTitle("TestScriptValidation-TestLeaf");

		extentreports.setSystemInfo("Environment","Production");

		testCase=extentreports.createTest("Validate Title of the Application");

		testCase.log(Status.INFO,"Provide url of the application");

		driver.get("https://leafground.com/");

		testCase.log(Status.INFO,"get the title from the application");

		String actualtitle=driver.getTitle();

		testCase.log(Status.INFO, "give the expected title");

		String exptitle="DashBoardsf";

		testCase.log(Status.INFO,"Validate the testCase");

		if(exptitle.equalsIgnoreCase(actualtitle)) {

			System.out.println("Title are same");

			testCase.log(Status.PASS,"Title matching");
		}

		else {
			System.out.println("Title not same");

			testCase.log(Status.FAIL,"Title not same");
			
			TakesScreenshot ts=(TakesScreenshot) driver;
			
			File Source=ts.getScreenshotAs(OutputType.FILE);
			
			File dest=new File("C:\\Users\\skarthika\\git\\selenium_grid\\Selenium24thAug\\src\\test\\resources\\Reports\\screen1.jpeg");
			
			FileHandler.copy(Source, dest);
			
			testCase.addScreenCaptureFromPath("C:\\Users\\skarthika\\git\\selenium_grid\\Selenium24thAug\\src\\test\\resources\\Reports\\screen1.png");
			
			
		}


	}

	@Test

	public void test2() {
		testCase=extentreports.createTest("Validate email address");

		testCase.log(Status.INFO,"Identify the element");

		driver.findElement(By.id("email")).sendKeys("Karthika");

		testCase.log(Status.INFO,"Get Attribute of email address field");

		String val=	driver.findElement(By.id("email")).getAttribute("placeholder");

		if(val.equalsIgnoreCase("E-mail Address")) {
			testCase.log(Status.PASS,"Email address field validates with teh attribute value");
		}
		
		
  fail("failed");


	}
	
	@Test(dependsOnMethods="test2")
	public void test3() {
		System.out.println("Test3");
	}

	@AfterClass

	public void after() {
		extentreports.flush();
		driver.quit();
	}

}
