package stevejobs;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
// WINDOW HANDLEING 
public class WindowHandling
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.irctc.com/displayServlet");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[text()='E-Catering']")).click();
		driver.findElement(By.xpath("//*[text()='E-TICKET AGENT LOCATOR']")).click();
		driver.findElement(By.xpath("(//a[@href='http://www.irctctourism.com'])[2]/img")).click();
		//driver.findElement(By.xpath("//div[contains(text(),'glory by winning')]")).click();
		//get window handles by using set class(java.util)
		Set<String> swh = driver.getWindowHandles();
		// Capture all window handles by set
		Iterator<String> it = swh.iterator();
		String window1 = it.next();
		String window2 = it.next();
		String window3 = it.next();
		String window4 = it.next();
		System.out.println("the size of windows opened by object is:"+swh.size());
		driver.switchTo().window(window2);
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(window4);
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(window1);
		driver.findElement(By.linkText("HOME")).click();
		driver.switchTo().window(window3);
		driver.close();
	 }
}

