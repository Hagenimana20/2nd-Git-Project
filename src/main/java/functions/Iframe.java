package functions;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {
WebDriver driver;
	
	@Before
	 public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@Test
	public void frame() {
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("java.awt.event")).click();	
		
		driver.switchTo().defaultContent();		
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("/html/body/div/ul[1]/li[2]/a/span")).click();
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//a[contains(text(),'NO_ORIENTATION')]")).click();
		
		
				
		
		
		
	}

}
