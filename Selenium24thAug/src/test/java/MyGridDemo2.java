

import java.net.MalformedURLException;

import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class MyGridDemo2 {

	WebDriver driver;


	@BeforeClass
	public  void bf() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\skarthika\\eclipse-workspace\\Selenium24thAug\\src\\test\\resources\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver =new ChromeDriver();
		
	}

		@Test

		public void testlogin() throws MalformedURLException, InterruptedException{

			DesiredCapabilities capabilities=new DesiredCapabilities();

			capabilities.setBrowserName("chrome");

			capabilities.setPlatform(Platform.LINUX);

			driver=new RemoteWebDriver(new URL("http://172.17.0.3:4444/wd/hub"),capabilities);

			driver.get("http://demowebshop.tricentis.com/login");

			String title=driver.getTitle();

			System.out.println(title);


			driver.findElement(By.id("Email")).sendKeys("rekhabr1@gmail.com");

			driver.findElement(By.name("Password")).sendKeys("rekhab");

			Thread.sleep(3000);


			driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();

			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.linkText("Log out")).click();

			driver.close();

		}


	}