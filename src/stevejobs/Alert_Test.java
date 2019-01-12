package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_Test
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		//driver.switchTo().frame("iframeResult");// frame using name
		/*WebElement e = driver.findElement(By.xpath("//iframe[@id='iframeResult']")); 
		driver.switchTo().frame(e);*/ // frame using xpatrh(wb element)
		WebElement e = driver.findElement(By.name("iframeResult"));
		driver.switchTo().frame(e);// fame using By. methods
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		String x = driver.switchTo().alert().getText();// to get alert text		
	    System.out.println(x);
	    driver.switchTo().alert().accept();
	    Thread.sleep(5000);
	    driver.switchTo().defaultContent();
	    driver.close();
	
	}

}