package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//count no of row and column in gmail
public class Gmail_MailCount
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Login in G-mail website
		driver.get("http://www.gmail.com"); 
		driver.findElement(By.name("identifier")).sendKeys("anupkupanda123");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("anup@mikun93");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	    Thread.sleep(5000);
	    //Count the no of rows and columns in first page(using conventional Techniique)
	    List<WebElement> rl = driver.findElements(By.xpath("(//table)[4]/tbody/tr"));
	    int x = rl.size();
	    //List<WebElement> cl = rl.get(0).findElements(By.tagName("td"));// using tag name
	    List<WebElement> cl = driver.findElements(By.xpath("(//table)[4]/tbody/tr[1]/td"));//Alternate way using x-psth directly
	    int y = cl.size();
	    System.out.println("the no of rows present is:"+x);
	    System.out.println("the no of columns present is:"+y);
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
