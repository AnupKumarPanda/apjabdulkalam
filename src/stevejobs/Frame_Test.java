package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame_Test
{
	// Switching to Frame
	public static void main(String[] args) throws Exception
	{
		//Launch site
	      System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		  ChromeDriver driver = new ChromeDriver();
		  driver.get("https://jqueryui.com/checkboxradio/");
		  driver.manage().window().maximize();
		  driver.switchTo().frame(0);
		  driver.findElement(By.xpath("(//span[@class='ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank'])[1]")).click();
		  driver.findElement(By.xpath("(//label[text()='4 Star']/span)[1]")).click();
		  driver.switchTo().defaultContent();
		  Thread.sleep(2000);
		  driver.close();
		 
	}

}
