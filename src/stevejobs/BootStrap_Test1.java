package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BootStrap_Test1 
{
	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Actions a = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath("(//div[@class='ui dropdown'])[1]"));
		a.moveToElement(e1).click().build().perform();
		Thread.sleep(5000);
		//Get all the items in  dropdown and display
		List<WebElement> l = driver.findElements(By.xpath("//div[contains(@class,'menu transition visible')]/div"));
		System.out.println("the dropdowmn size is:"+l.size());
		for(WebElement x : l )
		{
			System.out.println(x.getText());
		}
		//Select 2nd from the list
		a.click(l.get(1)).build().perform();
		Thread.sleep(5000);
		WebElement e2=driver.findElement(By.xpath("(//div[contains(@class,'ui selection dropdown')])[1]"));
		a.click(e2).build().perform();
		Thread.sleep(3000);
		List<WebElement> l1 = driver.findElements(By.xpath("(//div[contains(@class,'ui selection dropdown')])[1]/child::div[2]/div"));	
		a.click(l1.get(0)).build().perform();
		//MultiSelect DropDown in BootStrap
		WebElement e3 =driver.findElement(By.xpath("//div[contains(@class,'ui fluid search dropdown')]"));
		a.click(e3).build().perform();
		Thread.sleep(6000);
		//driver.findElement(By.xpath("(//div[contains(@class,'menu transition visible')]/div)[3]")).click();
		List<WebElement> l2 = driver.findElements(By.xpath("//div[contains(@class,'menu transition visible')]/div"));
		Thread.sleep(3000);
		System.out.println("\n THE LIST OF ITEMS IN MULTISELECT:");
		for(WebElement y : l2 )
		{
			System.out.println(y.getText());
		}
		//select multiple items (4,6,8,10)
		l2.get(3).click();
		l2.get(5).click();
		l2.get(7).click();
		l2.get(9).click();
		Thread.sleep(5000);
		//Get all selected items
		List<WebElement> l3 = driver.findElements(By.xpath("//div[contains(@class,'ui fluid search dropdown selection')]/a"));
		System.out.println("\n THE LIST OF SELECTED ITEMS ARE ");
		for(WebElement z: l3 )
		{
			System.out.println(z.getText());
		}
		
	}

}
