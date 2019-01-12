package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_isDisplayed 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com"); 
		WebElement e = driver.findElement(By.name("q"));
		if(e.isDisplayed())
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
		driver.close();
	}

}
