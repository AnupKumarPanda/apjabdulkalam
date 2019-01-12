package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cache2
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		WebDriverWait w = new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.findElement(By.name("q")).sendKeys("Abdul kalam");
		Thread.sleep(5000);
		//Get Count of items in Cache
		List<WebElement> l = driver.findElements(By.xpath("//*[@role='listbox']/li"));
		int s = l.size()-2; // last two items are buttons
		int flag = 0;
		
		Actions a = new Actions(driver);
		for (int i=1;i<=s;i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(5000);
			String x = driver.findElement(By.xpath("(//*[@role='listbox']/li)["+i+"]")).getText();
			//System.out.println(x);
			if(x.equalsIgnoreCase("abdul kalam books"))
			{
				a.sendKeys(Keys.ENTER).build().perform();
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("No item matched");
		}
		else
		{
			System.out.println("Item found and selected");
		}
		Thread.sleep(5000);
		driver.close();
	}
		
}
