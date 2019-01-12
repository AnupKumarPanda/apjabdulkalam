package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//Select Class,Multi Select drop-down programs
public class Dropdown_M2
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.switchTo().frame("iframeResult");
		WebElement e = driver.findElement(By.name("cars"));
		Select s = new Select (e);
		//Selection of more than one item
		Actions a = new Actions(driver);
		a.keyDown(Keys.CONTROL).click(s.getOptions().get(3)).click(s.getOptions().get(0)).keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(5000);
		//Deselect all
		s.deselectAll();
		//Select other items
		a.keyDown(Keys.CONTROL).click(s.getOptions().get(0)).click(s.getOptions().get(1)).click(s.getOptions().get(2)).keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(5000);
		//Deselect one by one 
		s.deselectByIndex(0);
		Thread.sleep(2000);
		s.deselectByValue("saab");
		Thread.sleep(2000);
		s.deselectByVisibleText("Opel");
		Thread.sleep(2000);
		driver.close();
	}

}
