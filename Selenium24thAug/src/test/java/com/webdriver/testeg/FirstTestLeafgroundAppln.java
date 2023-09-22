package com.webdriver.testeg;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTestLeafgroundAppln {
	WebDriver driver;
	JavascriptExecutor js;


	@BeforeClass
	public  void bf() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\skarthika\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver =new ChromeDriver();

		driver.get("https://leafground.com/dashboard.xhtml");

		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.navigate().to("https://leafground.com/dashboard.xhtml");
	}
	@Test
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

	@Test(enabled=false)

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


	@Test(enabled=false)

	public void waitstt() {
		driver.navigate().to("https://leafground.com/waits.xhtml;jsessionid=node04tinz709f9212ji8ijkypxmf470520.node0");

		driver.findElement(By.id("j_idt87:j_idt89")).click();

		driver.findElement(By.id("j_idt87:j_idt90")).click();


		driver.findElement(By.id("j_idt87:j_idt92")).click();


		FluentWait var1=new FluentWait(driver);

		var1.withTimeout(Duration.ofSeconds(20))
		.pollingEvery(Duration.ofSeconds(5))
		.ignoring(Exception.class);

		var1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt87:j_idt93")));



		WebDriverWait var=new WebDriverWait(driver,Duration.ofSeconds(20));

		var.until(ExpectedConditions.alertIsPresent());

		//System.out.println(status);


	}

	@Test(enabled=false)
	public void alerts1() throws InterruptedException, IOException {
		driver.navigate().to("https://leafground.com/alert.xhtml");

		driver.findElement(By.id("j_idt88:j_idt91")).click();

		Alert alert1=driver.switchTo().alert();

		System.out.println(alert1.getText());
		
		

		alert1.accept();

		driver.findElement(By.id("j_idt88:j_idt93")).click();

		driver.switchTo().alert().dismiss();

		driver.findElement(By.id("j_idt88:j_idt104")).click();

		Alert alert2=	driver.switchTo().alert();

		alert2.sendKeys("HCL");

		alert2.accept();


		driver.findElement(By.id("j_idt88:j_idt95")).click();

		driver.findElement(By.id("j_idt88:j_idt98")).click();

		driver.findElement(By.id("j_idt88:j_idt100")).click();

		Thread.sleep(10000);

		//((JavascriptExecutor)driver).executeScript("document.querySelector('.ui-icon-closethick',':before').click()");


		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt101']/div[1]/a/span")).click();


	}

	@Test (enabled=false)
	public void frames1() {
		driver.navigate().to("https://leafground.com/frame.xhtml");

		driver.switchTo().frame(0);

		driver.findElement(By.id("Click")).click();

		driver.switchTo().defaultContent();

		WebElement el=driver.findElement(By.xpath("//*[@src=\"page.xhtml\"]"));

		driver.switchTo().frame(el);

		driver.switchTo().frame("frame2");

		driver.findElement(By.id("Click")).click();

		//driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		List<WebElement> frames=driver.findElements(By.tagName("iframe"));

		System.out.println(frames.size());








	}


	@Test(enabled=false)
	public void auth1() throws InterruptedException, AWTException {
		driver.navigate().to("https://leafground.com/auth.xhtml");

		//driver.findElement(By.id("j_idt88:j_idt90")).click();

		driver.get("http://leafground.com:8090/login");

		String username="admin";

		StringSelection sec=new StringSelection(username);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sec, null);

		Robot r1=new Robot();

		r1.keyPress(KeyEvent.VK_CONTROL);

		r1.keyPress(KeyEvent.VK_V);

		String pswd="testleaf";

		StringSelection sec1=new StringSelection(pswd);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sec1, null);

		r1.keyRelease(KeyEvent.VK_V);

		r1.keyRelease(KeyEvent.VK_CONTROL);

		r1.keyPress(KeyEvent.VK_TAB);

		r1.keyRelease(KeyEvent.VK_TAB);


		r1.keyPress(KeyEvent.VK_CONTROL);

		r1.keyPress(KeyEvent.VK_V);

		r1.keyRelease(KeyEvent.VK_V);

		r1.keyRelease(KeyEvent.VK_CONTROL);

		r1.keyPress(KeyEvent.VK_ENTER);

		r1.keyRelease(KeyEvent.VK_ENTER);







		//	driver.get("http://admin:testleaf@leafground.com:8090/login");

		//Thread.sleep(1000);

		//	String msg=driver.findElement(By.tagName("body")).getText();

		//System.out.println(msg);


	}


	@Test(enabled=false)
	public void windows() {
		driver.navigate().to("https://leafground.com/window.xhtml;jsessionid=node010qifmvoiuqdj27a5hwgj1hjg474068.node0");

		System.out.println(driver.getTitle());

		driver.findElement(By.id("j_idt88:new")).click();

		Set<String> windowvalues=driver.getWindowHandles();


		Iterator<String> iter=windowvalues.iterator();

		String w1=iter.next();

		String w2=iter.next();

		System.out.println(w1);

		System.out.println(w2);

		driver.switchTo().window(w2);


		System.out.println(driver.getTitle());

		driver.close();
		driver.switchTo().window(w1);

		System.out.println(driver.getTitle());


	}


	@Test(enabled=false)
	public void drag1() throws InterruptedException {
		driver.navigate().to("https://leafground.com/drag.xhtml");

		Actions act=new Actions(driver);

		WebElement source= driver.findElement(By.id("form:conpnl_header"));

		act.dragAndDropBy(source,250,0).perform();

		WebElement source1=	driver.findElement(By.id("form:drag_content"));

		WebElement dest=driver.findElement(By.id("form:drop_content"));

		act.dragAndDrop(source1, dest).perform();


		WebElement columdrag=driver.findElement(By.xpath("//*[@id=\"form:j_idt94:j_idt95\"]"));

		WebElement columndrop=driver.findElement(By.xpath("//*[@id=\"form:j_idt94:j_idt97\"]"));

		act.dragAndDrop(columdrag, columndrop).perform();

		Thread.sleep(10000);




		WebElement el=driver.findElement(By.xpath("//*[@id=\"form:logo\"]"));

		act.clickAndHold(el).moveByOffset(150, 0).perform();

		driver.navigate().to("https://www.hcltech.com/");

		WebElement ind=driver.findElement(By.linkText("Industries"));
		act.moveToElement(ind).perform();






	}


	@Test(enabled=false)
	public void table() {

		driver.navigate().to("https://leafground.com/table.xhtml");

		List<WebElement> rows=driver.findElements(By.xpath("//*[@role='grid']/tbody/tr"));

		System.out.println(rows.size());

		List<WebElement> column=driver.findElements(By.xpath("//*[@role='grid']/tbody/tr/td"));

		System.out.println(column.size());

		for(WebElement column1 :column) {

			System.out.println(column1.getText());
		}

		driver.findElement(By.xpath("//*[@role='grid']/thead/tr[1]/th[4]")).click();





	}

	@Test(enabled=false)
	public void list() {

		driver.navigate().to("https://leafground.com/list.xhtml;jsessionid=node0hzdex8v6oc0x1ay9mutz2fbrw478461.node0");

		List<WebElement> list1=driver.findElements(By.xpath("//ul[@class='ui-widget-content ui-picklist-list ui-picklist-source ui-corner-bottom ui-sortable']/li"));

		System.out.println(list1.size());


		for(WebElement ele:list1) {

			if(ele.getText().equalsIgnoreCase("Paris")) {

				ele.click();

			}
		}

		driver.findElement(By.xpath("//*[@title='Add']")).click();

		List<WebElement> list2=driver.findElements(By.xpath("//*[@class='ui-widget-content ui-orderlist-list ui-corner-bottom ui-sortable']/li"));


		Actions act2=new Actions(driver);

		act2.keyDown(Keys.CONTROL)
		.click(list2.get(0))
		.click(list2.get(2))
		.click(list2.get(4)).build().perform();

	}

	@Test(enabled=false)
	public void fileuploadanddownload() throws AWTException, InterruptedException {
		driver.navigate().to("https://leafground.com/file.xhtml");

		driver.findElement(By.id("j_idt88:j_idt89_input")).sendKeys("C:\\Users\\skarthika\\OneDrive - HCL Technologies Ltd\\All backup1\\Desktop\\Hands-on - Selenium 24th Aug 2023.txt");


		driver.findElement(By.id("j_idt93:j_idt95")).click();

		File fi=new File("C:\\Users\\skarthika\\Downloads");

		File[] listfiles=	fi.listFiles();

		for(File search: listfiles) {

			if(search.getName().equalsIgnoreCase("TestLeaf Logo (17).png")) {

				System.out.println("File downloaded");
			}
		}

		/*driver.navigate().to("https://www.adobe.com/in/acrobat/online/word-to-pdf.html");

		//js.executeScript("scroll(0,750)");

		driver.findElement(By.id("lifecycle-nativebutton")).click();

		Robot r1=new Robot();

		String filepath="C:\\Users\\skarthika\\OneDrive - HCL Technologies Ltd\\All backup1\\Desktop\\Javascript.docx";

		StringSelection sec=new StringSelection(filepath);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sec,null);

		Thread.sleep(10000);

		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_V);
		r1.keyRelease(KeyEvent.VK_V);
		r1.keyRelease(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);

		 */


	}

	@Test(enabled=false)
	public void screenshot() throws IOException, AWTException {

		driver.navigate().to("https://leafground.com/charts.xhtml");

		TakesScreenshot ts=(TakesScreenshot) driver;

		File Source=	ts.getScreenshotAs(OutputType.FILE);

        File dest=new File("src//test//resources//screen1.png");
        
        FileHandler.copy(Source, dest);
        
        
        Robot r1=new Robot();
        
        
       java.awt.Dimension di= Toolkit.getDefaultToolkit().getScreenSize();
        
        Rectangle rect=new Rectangle(di);
        
       BufferedImage source= r1.createScreenCapture(rect);
       
       File dest1=new File("src//test//resources//screen2.png");
       
       ImageIO.write(source,"png",dest1);
       
       
       
       
        
        


	}

	@AfterClass

	public void af() {
		//driver.close();
	}
}
