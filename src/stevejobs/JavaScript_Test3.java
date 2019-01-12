package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_Test3 
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http:google.com");
        driver.manage().window().maximize();
        //Disable an Element
        WebElement e = driver.findElement(By.name("q"));
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('disabled','true');",e);
        Thread.sleep(5000);
        //Enabling the disabled Element
        js.executeScript("arguments[0].removeAttribute('disabled');",e);
        
	}

}
