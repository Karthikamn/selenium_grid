package functionality;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import elements.LoginElements;

public class Loginfn {

	@Test


	public void login1() throws IOException {

		WebDriver  driver;
		FileInputStream fc=new FileInputStream("C:\\Users\\skarthika\\git\\selenium_grid\\Selenium24thAug\\src\\test\\resources\\Config.properties");

		Properties prop=new Properties();

		prop.load(fc);

		String bname=prop.getProperty("browsername");

		String  bpath=prop.getProperty("browserpath");

		String epath=prop.getProperty("excelpath");
		
		String us=prop.getProperty("us");
		
		String URL=prop.getProperty("url");

		if(bname.equalsIgnoreCase("chrome")) {


			System.setProperty("webdriver.chrome.driver",bpath);

			driver =new ChromeDriver();

		}

		else if(bname.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",bpath);

			driver =new FirefoxDriver();

		}


		else if(bname.equalsIgnoreCase("Safari")) {

			System.setProperty("webdriver.safari.driver",bpath);

			driver =new SafariDriver();
		}

		else {
			System.setProperty("webdriver.edge.driver",bpath);

			driver =new EdgeDriver();
		}
	/*	FileInputStream fi=new FileInputStream(epath);
		XSSFWorkbook w1=new XSSFWorkbook(fi);

		XSSFSheet s1=w1.getSheetAt(0);

		for(int i=1;i<=s1.getLastRowNum();i++) {

			XSSFRow r1=s1.getRow(i);

			String us1=	r1.getCell(0).getStringCellValue();

*/

			driver.get(URL);

			//LoginElements el=new LoginElements();

			PageFactory.initElements(driver,LoginElements.class);



			LoginElements.us.sendKeys(us);

			LoginElements.continuebtn.click();
			
			
			File f1=new File("C:\\\\Users\\\\skarthika\\\\git\\\\selenium_grid\\\\Selenium24thAug\\\\src\\\\test\\\\resources\\\\cookies.data");
			
			
			try {
				
				f1.createNewFile();
				
				FileWriter fw=new FileWriter(f1);
				
				BufferedWriter bw=new BufferedWriter(fw);
				
				for( Cookie ck :driver.manage().getCookies()) {
					
					bw.write((ck.getName()+";"+ ck.getDomain() +";" +ck.getPath() +";"+ ck.getValue() +";"+ ck.getExpiry() +";"+ck.isSecure()));
					
					bw.newLine();
					
					Cookie ck2=new Cookie("session-id-time","2325480304l"); // name, session id value
					
					driver.manage().addCookie(ck2);
					
					
					driver.manage().deleteAllCookies();
					
					driver.manage().deleteCookie(ck2);

					driver.manage().deleteCookieNamed("session-id-time");
					
					
				}
				
				bw.close();
				
				fw.close();
				
				
			}
			
			
			catch(Exception e) {
				
				System.out.println(e);
			}


		}
	}


