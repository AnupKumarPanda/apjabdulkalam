package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

public class Facebook
{

	public static void main(String[] args)throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement uid =driver.findElement(By.name("email"));
		WebElement pwd = driver.findElement(By.name("pass"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit'][@value='Log In']"));
		Actions a = new Actions(driver);
		a.sendKeys(uid,"somanathaaa@gmail.com").build().perform();
		a.sendKeys(pwd,"*********").build().perform();
		a.click(submit).build().perform();
		WebElement dc = driver.findElement(By.xpath("//div[@class='_3ixn']"));
		Thread.sleep(10000);
		Screen s =new Screen();
		s.click("Test19.png");
		Thread.sleep(5000);
		driver.findElement(By.id("userNavigationLabel")).click();
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Log Out']")));
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass")));
		//System.exit(0);
		driver.close();
		
		
	}

}
