package functions;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHooverOver {

	By PRODUCT_FIELD=By.xpath("//span[contains(text(),'Products')]");
	By NETWORKING_FIELD=By.xpath("//a[(text()='Networking')]");
	By HOME_FIELD=By.xpath("//a[(text()='Networking')]/parent::li/descendant::a[3]");
	By SERVICES_FIELD=By.xpath("//span[contains(text(),'Services')]");
	By SEARCH_FIELD=By.linkText("input[id='mh-search-input']");
	
WebDriver driver;
	
	@Before
	 public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.dell.com/en-us");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	}
	@Test
	public void HooverOver() throws InterruptedException {
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(PRODUCT_FIELD)).build().perform();		
		action.moveToElement(driver.findElement(NETWORKING_FIELD)).build().perform();
		action.moveToElement(driver.findElement(HOME_FIELD)).build().perform();
		//action.clickAndHold(driver.findElement(HOME_FIELD)).build().perform();
		action.dragAndDrop(driver.findElement(SERVICES_FIELD), driver.findElement(SEARCH_FIELD));		
		action.sendKeys(Keys.ENTER).build().perform();
		
		//Scroll up and down
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("scroll(0,5000)");
//		Thread.sleep(2000);
//		js.executeScript("scroll(0,0)");
		
	}
		
}
