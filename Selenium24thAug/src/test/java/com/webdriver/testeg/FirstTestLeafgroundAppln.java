package com.webdriver.testeg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTestLeafgroundAppln {
	WebDriver driver;
	JavascriptExecutor js;


	@BeforeClass
	public  void bf() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\skarthika\\eclipse-workspace\\Selenium24thAug\\src\\test\\resources\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver =new ChromeDriver();

		driver.get("https://leafground.com/dashboard.xhtml");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	@Test(enabled=false)
	public void dashboard() {



		String exptitle="Dashboard1";

		String actttitle= driver.getTitle();

		Assert.assertEquals(exptitle,actttitle);





	}

	@Test(enabled=false)

	public void textbox() throws InterruptedException {

		driver.manage().window().maximize();
		driver.navigate().to("https://leafground.com/input.xhtml");
		/*driver.findElement(By.id("j_idt88:name")).sendKeys("Karthika");
		driver.findElement(By.name("j_idt88:j_idt91")).sendKeys("India");
		WebElement disableelement=driver.findElement(By.cssSelector("input[class=\"ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all ui-state-disabled\"]"));

		boolean status=disableelement.isEnabled();

		if(status==false) {

			System.out.println("Text box is disabled");
		}

		else

			System.out.println("textbox is enabled");

		String msg=driver.findElement(By.id("j_idt88:j_idt97")).getAttribute("value");

		System.out.println(msg);

		driver.findElement(By.id("j_idt106:thisform:age")).sendKeys(Keys.ENTER);

		Thread.sleep(10000);

		String text_err=driver.findElement(By.id("j_idt106:thisform:j_idt110_error-detail")).getText();

		System.out.println(text_err);

		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div[1]/div/form/div[8]/div/div/div[1]/span[1]/span[1]/span[1]")).click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//span[@data-value='monospace']")).click();

		 */

		Point location_value=driver.findElement(By.id("j_idt106:float-input")).getLocation();

		Thread.sleep(10000);

		driver.findElement(By.id("j_idt106:float-input")).click();

		Point new_location_value=driver.findElement(By.id("j_idt106:float-input")).getLocation();

		if(location_value!=new_location_value) {
			System.out.println("Label position changed");
		}

		else {
			System.out.println("Label position is not changed");
		}

		driver.findElement(By.id("j_idt106:auto-complete_input")).sendKeys("Karthika");

		Thread.sleep(10000);


		driver.findElement(By.xpath("//ul[@class=\"ui-autocomplete-items ui-autocomplete-list ui-widget-content ui-widget ui-corner-all ui-helper-reset\"]/li[3]")).click();


		driver.findElement(By.id("j_idt106:j_idt116_input")).sendKeys("29/08/2017");
	}


	@Test(enabled=false)
	public void datepicker() {

		driver.navigate().to("https://demo.automationtesting.in/Datepicker.html");

		js=(JavascriptExecutor) driver;

		js.executeScript("document.getElementById('datepicker1').value='29/08/2017'");

		js.executeScript("document.getElementById('datepicker2').value='29/08/2017'");



	}

	@Test(enabled=false)
	public void btns() throws InterruptedException {
		driver.navigate().to("https://leafground.com/button.xhtml");
		js=(JavascriptExecutor) driver;

		String title=js.executeScript("return document.title").toString();

		System.out.println(title);

		driver.findElement(By.id("j_idt88:j_idt90")).click();

		String new_title=js.executeScript("return document.title").toString();

		System.out.println(new_title);

		Assert.assertNotEquals(title, new_title);

		driver.navigate().back();

		//js.executeScript("window.history.back()");


		Point location=driver.findElement(By.id("j_idt88:j_idt94")).getLocation();

		int x=location.getX();


		int y=location.getY();

		System.out.println(x);

		System.out.println(y);

		String colour=driver.findElement(By.id("j_idt88:j_idt96")).getCssValue("color");

		System.out.println(colour);

		String hex_value=Color.fromString(colour).asHex();

		System.out.println(hex_value);


		Dimension size=driver.findElement(By.id("j_idt88:j_idt98")).getSize();

		int h=size.getHeight();

		int w=size.getWidth();

		System.out.println(h);

		System.out.println(w);


		WebElement	el=driver.findElement(By.id("j_idt88:j_idt100"));

		String baction=el.getCssValue("background-color");

		System.out.println(baction);

		String beforehovering=Color.fromString(baction).asHex();

		System.out.println(beforehovering);

		Actions act=new Actions(driver);

		act.moveToElement(el).perform();

		Thread.sleep(10000);

		String aaction=el.getCssValue("background-color");

		System.out.println(aaction);

		String afterHovering=Color.fromString(aaction).asHex();

		System.out.println(afterHovering);


		Assert.assertNotEquals(baction, aaction);

		driver.findElement(By.id("j_idt88:j_idt102:imageBtn")).click();

		js.executeScript("document.getElementById('j_id1:javax.faces.ViewState:4').click");


		List<WebElement> btns=driver.findElements(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[2]/div[4]/button"));

		System.out.println("Count of buttons is"+ btns.size());

	}

	@Test(enabled=false)

	public void checkboxes() throws InterruptedException {
		driver.navigate().to("https://leafground.com/checkbox.xhtml");

		driver.findElement(By.xpath("//*[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")).click();

		boolean checkboxselection=driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt89_input\"]")).isSelected();

		if(checkboxselection==true) {
			System.out.println("checkbox is selected");
		}

		driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt91\"]/div[2]")).click();

		Thread.sleep(1000);

		String value1=driver.findElement(By.xpath("//*[@class=\"ui-growl-message\"]/span")).getText();

		if(value1.equalsIgnoreCase("checked")) {

			System.out.println("notifiying that check box is selected");
		}


		List<WebElement> checkboxes=driver.findElements(By.xpath("//*[@id=\"j_idt87:basic\"]/tbody/tr/td/div/div[2]"));

		for (WebElement chk  :checkboxes) {

			chk.click();
		}

		driver.findElement(By.xpath("//*[@id='j_idt87:j_idt100']/div[2]")).click();

		driver.findElement(By.xpath("//*[@class=\"ui-selectcheckboxmenu-trigger ui-state-default ui-corner-right\"]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@class='ui-selectcheckboxmenu-items ui-selectcheckboxmenu-list ui-widget-content ui-widget ui-corner-all ui-helper-reset']/li[3]/div/div[2]")).click();


	}

	@Test( enabled=false)

	public void radiobtns() {

		driver.navigate().to("https://leafground.com/radio.xhtml");

		driver.findElement(By.xpath("//*[@id=\"j_idt87:console1\"]/tbody/tr/td[2]/div/div[2]")).click();

		List<WebElement>radios=driver.findElements(By.xpath("//*[@id='j_idt87:console2']/tbody/tr/td/div/div[1]/input"));

		for(WebElement r1:radios) {

			System.out.println(r1.isSelected());

			if(r1.isSelected()) {

				System.out.println("default radio buttons");
			}
		}



	}


	@Test(enabled=false)
	public void links() {

		driver.navigate().to("https://leafground.com/link.xhtml;jsessionid=node01nn0awitwl7j31f1mwd8fpyfu3466601.node0");

		driver.findElement(By.linkText("Go to Dashboard")).click();

		String act=driver.getTitle();

		String exp="Dashboard";

		if(act.equalsIgnoreCase(exp)) {
			System.out.println("You are in the dashboard page");
		}

		driver.navigate().back();

		String desturl=driver.findElement(By.linkText("Find the URL without clicking me.")).getAttribute("href");

		System.out.println(desturl);

		driver.findElement(By.linkText("Broken?")).click();

		String exptitle="Error 404 /lists.xhtml Not Found in ExternalContext as a Resource";

		String acttitle=driver.getTitle();

		if(exptitle.equalsIgnoreCase(acttitle)) {

			System.out.println("It is broken link");
		}

		driver.navigate().back();

		List<WebElement>links=	driver.findElements(By.tagName("a"));


		WebElement explink=driver.findElement(By.linkText("Go to Dashboard"));


		String duplicatelinktext=explink.getText();

		//System.out.println(duplicatelinktext);

		for(WebElement link:links) {

			String textofeachlink=link.getText();

			//System.out.println(textofeachlink);

			if(duplicatelinktext.equalsIgnoreCase(textofeachlink)) {
				System.out.println("it is a duplicate link");

				break;
			}


		}

		System.out.println(links.size());

		List<WebElement>layoutlinks=driver.findElements(By.xpath("//*[@id=\"j_idt87\"]/div/div/div/div/div/a"));

		System.out.println(layoutlinks.size());


		driver.findElement(By.xpath("//*[@id='j_idt13']")).click();



	}

	@Test

	public void dropdown() throws InterruptedException {

		driver.navigate().to("https://leafground.com/select.xhtml");

		Select drop=new Select(driver.findElement(By.xpath("//*[@class=\"ui-selectonemenu\"]")));

		drop.selectByVisibleText("Playwright");

		drop.selectByIndex(3);

		boolean output=drop.isMultiple();

		System.out.println(output);


		driver.findElement(By.xpath("//*[@class=\"ui-selectonemenu-trigger ui-state-default ui-corner-right\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"j_idt87:country_items\"]/li[4]")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"j_idt87:city\"]/div[3]")).click();
		
		Thread.sleep(1000);
		
		List<WebElement> lists=driver.findElements(By.xpath("//*[@id='j_idt87:city_items']/li"));
		
		for(WebElement li:lists) {
			
			if(li.getText().equalsIgnoreCase("Chennai")) {
				
				li.click();
			}
		}
		
		
		driver.findElement(By.xpath("//*[@id=\"j_idt87:auto-complete\"]/button")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@class=\"ui-autocomplete-items ui-autocomplete-list ui-widget-content ui-widget ui-corner-all ui-helper-reset\"]/li[3]")).click();
		
		


	}


	@AfterClass

	public void af() {
		//driver.close();
	}
}
