package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cache1
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		WebDriverWait w = new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.findElement(By.name("q")).sendKeys("Steve jobs");
		Thread.sleep(5000);
		//Select 4th item in cache
		Actions a = new Actions(driver);
		for(int i=1;i<=4;i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
		}
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(10000);
		driver.close();
	}

}
