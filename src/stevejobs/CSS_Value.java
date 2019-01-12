package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS_Value
{

	public static void main(String[] args) throws Exception
	{
	 //Launch site
      System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
	  ChromeDriver driver = new ChromeDriver();
	  driver.get("http://www.way2sms.com/");
	  driver.manage().window().maximize();
	 /*WebElement e2 = driver.switchTo().activeElement();
	  e2.sendKeys("9778005334");*/
	  //Checking clear() method
	 WebElement e1 =driver.findElement(By.name("mobileNo"));
	  e1.sendKeys("9438415832");
	  Thread.sleep(2000);
	  e1.clear();
	  Thread.sleep(2000);
	 //get attribute
	 String x = e1.getAttribute("id");
	 System.out.println("The attribute is: "+x);
	 //get text and tag name
	 String y = driver.findElement(By.xpath("//a[@class='active']")).getText();
	 System.out.println("The Text is: "+y);
	 String z = driver.findElement(By.xpath("//a[@class='active']")).getTagName();
	 System.out.println("The Tag name is: "+z);
	//get CSS Value
	 String w= driver.findElement(By.xpath("//*[text()=' Register ']")).getCssValue("background");
	 System.out.println("The CSS Value is: "+w);
	 Thread.sleep(3000);
	 driver .close();
	}

}
