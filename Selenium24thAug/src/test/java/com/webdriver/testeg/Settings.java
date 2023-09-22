package com.webdriver.testeg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Settings {

	WebDriver driver;

	@BeforeClass
	public  void bf() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\skarthika\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");



	}

	@Test
	public void settingseg()
	{

		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://badssl.com/");

		//driver.findElement(By.linkText("wrong.host")).click();



	}


}
