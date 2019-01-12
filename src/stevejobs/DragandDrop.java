package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop 
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com//droppable");
		driver.switchTo().frame(0);
		WebElement e1 =driver.findElement(By.id("draggable"));
		WebElement e2 =driver.findElement(By.id("droppable"));
		Actions a = new Actions(driver);
		a.dragAndDrop(e1, e2).build().perform();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.close();
	}

}
