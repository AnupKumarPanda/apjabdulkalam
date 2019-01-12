package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//Select Class,Multi Select drop down programs
public class Dropdown_M 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.switchTo().frame("iframeResult");
		WebElement e = driver.findElement(By.name("cars"));
		Select s = new Select(e);
		if(s.isMultiple())
		{
			System.out.println("multiselect");
			Thread.sleep(2000);
			//Get all the options in multi-select drop down
			List<WebElement> l =s.getOptions();
			System.out.println("the size of drop down is:"+l.size());
			for(int i=0;i<l.size();i++)
			{
			System.out.println(l.get(i).getText());	
			}
			
		}
		else
		{
			System.out.println("not multiselect");
		}
		driver.switchTo().defaultContent();
		driver.close();
	}

}
