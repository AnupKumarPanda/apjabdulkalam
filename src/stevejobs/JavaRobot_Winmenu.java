package stevejobs;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaRobot_Winmenu

{
	//Automating WinMenu using  JavaRobot
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumhq.org");
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		
		//Right click on the link
		WebElement e = driver.findElement(By.linkText("Download"));
		Actions a = new Actions(driver);
		a.contextClick(e).build().perform();
		Thread.sleep(5000);
		
		//Automate WinMenu
		Robot r = new Robot();
		for(int i=1;i<=2;i++)
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(3000);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		driver.quit();
	}
}