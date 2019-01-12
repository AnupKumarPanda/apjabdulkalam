package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider_Test 
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com//slider");
		//Horizontal Slider
		driver.switchTo().frame(0);
		WebElement e1 = driver.findElement(By.xpath("//*[@id='slider']/span"));
		Actions a = new Actions(driver);
		a.dragAndDropBy(e1, 250,0).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e1, -250,0).build().perform();
		//Vertical Slider
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Vertical slider")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		WebElement e2 = driver.findElement(By.xpath("//*[@id='slider-vertical']/span"));
		a.dragAndDropBy(e2,0,200).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e2,0,400).build().perform();
		driver.close();
	}

}
