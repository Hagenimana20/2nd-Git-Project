package functions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Practice {

WebDriver driver;
By DROP_DOWN_FIELD=By.xpath("//select[@id='searchDropdownBox']");
By SEARCH_FIELD=By.xpath("//input[@id='nav-search-submit-button']");
By BABY_STORE_FIELD=By.xpath("//h1[text()='The Baby Store']");

	@Before
	 public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver=new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");
}
	@Test
	public void DropDownPractice() throws InterruptedException {		
		Select sel=new Select(driver.findElement(DROP_DOWN_FIELD));
		sel.selectByVisibleText("Baby");
		driver.findElement(SEARCH_FIELD).click();
		Thread.sleep(3000);
		String xy=driver.findElement(BABY_STORE_FIELD).getText();
		
		Assert.assertEquals("Not available", xy, "The Baby Store");
		
	}
	
	@After
	public void TearDown() {
		driver.close();
		driver.quit();
	}
	
}
