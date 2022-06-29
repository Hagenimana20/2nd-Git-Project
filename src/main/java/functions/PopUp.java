package functions;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUp {
	WebDriver driver;
	
	@Before
	 public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		Thread.sleep(2000);
		String Alert_Text=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println();
	}
}
