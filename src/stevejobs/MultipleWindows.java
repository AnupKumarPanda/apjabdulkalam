package stevejobs;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows
{
public static void main(String[] args) throws Exception 
	{
	  //Launch site
      System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
	  ChromeDriver driver = new ChromeDriver();
	  driver.get("http://www.sentia.in/");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("(//img[contains(@class,'img-responsive')])[3]")).click();
	  driver.findElement(By.xpath("(//*[contains(@href,'transportfeesentia1')])[1]")).click();	  
	  driver.findElement(By.xpath("(//*[contains(@href,'paymentOptionsGroup')])[3]")).click();	   
	  //Get  browser Window/Tabs handles
	  
	  ArrayList<String> a = new ArrayList<String>(driver.getWindowHandles());
	  for(int i=0;i<a.size();i++)
	  {
		  System.out.println(a.get(i));
	  }
	  Thread.sleep(5000);
	  //Switch to second window and close 
	  driver.switchTo().window(a.get(1));
	  driver.close();
	  Thread.sleep(5000);
	//Switch to first window and close 
	  driver.switchTo().window(a.get(0));
	  driver.close();
	  Thread.sleep(5000);
	//Switch to third window and close 
	  driver.switchTo().window(a.get(2));
	  driver.close();
	}

}
