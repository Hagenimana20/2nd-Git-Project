package functions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class DropDown {
	WebDriver driver;
	
	By USER_NAME_FIELD=By.id("username");
	By PASWORD_FIELD=By.id("password");
	By LOGIN_FIELD=By.name("login");
	By CUSTOMER_FIELD=By.xpath("//span[contains(text(),'Customers')]");
	By ADD_CUSTOMER=By.xpath("//a[contains(text(),'Add Customer')]");
	By COMPANY_FIELD=By.xpath("//*[@id=\"cid\"]");
	By FULL_NAME_FIELD=By.xpath("//input[@id='account']");
	By DASHBOARD_FIELD=By.xpath("//h2[contains(text(),' Dashboard ')]");
	 
	@Before
	 public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@Test
	 public void login() throws InterruptedException {
		
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_FIELD).click();
		
		String Dashboard_Header=driver.findElement(DASHBOARD_FIELD).getText();		
		Assert.assertEquals("WRONG PAGE", "Dashboard",Dashboard_Header );
		
//		driver.findElement(DASHBOARD_FIELD).isDisplayed();
//		Assert.assertTrue("Page not Displayed", false);
		
		
		driver.findElement(CUSTOMER_FIELD).click();
		driver.findElement(ADD_CUSTOMER).click();
		driver.findElement(FULL_NAME_FIELD).sendKeys("Hagenimana");		
		
	Select sel=new Select(driver.findElement(COMPANY_FIELD));
	sel.selectByVisibleText("CPS");
		
	
	//Print all the elements in dropDown Option
	
		WebElement element=driver.findElement(COMPANY_FIELD);
		Select select= new Select(element);
		List<WebElement> list=select.getOptions();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
		}			
	}
	@After
		public void TearDown() {
		driver.close();
		driver.quit();
	}	
	
}
