package functions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class5 {
	

	WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	}
	@Test
	public void windowHandle() throws InterruptedException {
//	   System.out.println(driver.getTitle());
		String handle=driver.getWindowHandle();
//		System.out.println(handle);
		
		driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("xpath");
		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
		
		Thread.sleep(3000);
		
//		System.out.println(driver.getTitle());
		String handle1=driver.getWindowHandle();
//		System.out.println(handle1);
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/ol[1]/li[2]/div/div/div[1]/a/h3/span")).click();
			Thread.sleep(2000);
//		System.out.println(driver.getTitle());
//		String handle2=driver.getWindowHandle();
//		System.out.println(handle1);		
	
		
	Set<String>handles=driver.getWindowHandles();
	System.out.println(handles);		
		
	for(String i:handles) {
		System.out.println(i);
		driver.switchTo().window(i);
		driver.switchTo().window(handle);  //to get back to any other window
	}System.out.println(driver.getTitle());
	
	}

}
