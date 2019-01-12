package stevejobs;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class New {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com");
		driver.manage().window().maximize();
		Duration d = Duration.of(10,ChronoUnit.SECONDS);
		FluentWait fw= new FluentWait(driver).pollingEvery(2,TimeUnit.SECONDS).withTimeout(10,TimeUnit.SECONDS);
	
	}

}
