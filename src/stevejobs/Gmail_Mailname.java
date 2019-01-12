package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail_Mailname //Print all the Mail Senders Name  
{
	public static void main(String[] args)throws Exception
	{

		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Login in G-mail website
		driver.get("http://www.gmail.com"); 
		driver.findElement(By.name("identifier")).sendKeys("anupkumarpanda024");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("***********");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	    Thread.sleep(5000);
	    List<WebElement> rl = driver.findElements(By.xpath("(//table)[4]/tbody/tr"));
	    int x = rl.size();
	    for(int i=1;i<=x;i++)
	    {
	    	String s = driver.findElement(By.xpath("(//table)[4]/tbody/tr["+i+"]/td[5]/div[2]/span")).getText();
	    	System.out.println(s);
	    }
	  //Sign out
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//div[@class='bBe']")).click();
	    driver.findElement(By.xpath("//a[contains(@aria-label,'Google Account')]")).click();
	    WebDriverWait w = new WebDriverWait(driver,20);
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
	    driver.findElement(By.linkText("Sign out")).click();
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	    driver.close();
	}

}
