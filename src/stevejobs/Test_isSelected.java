package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_isSelected
{
//Checking isSelected() method
	public static void main(String[] args) throws InterruptedException
	{
	//Launch site
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
        driver.manage().window().maximize();
        driver.findElement(By.partialLinkText("Flights")).click();
        Thread.sleep(2000);
        try
        {
        	WebElement e = driver.findElement(By.xpath("(//input[@name='tripType'])[2]"));
        	//e.click();
        	if(e.isDisplayed())
        	{
        		System.out.println("Is displayed");
        		if(e.isEnabled())
        		{
        			System.out.println("Is Enabled");
        			if(e.isSelected())
        			{
        				System.out.println("Is Selected");
        			}
        			else 
        			{
        				System.out.println("Is not Selected");
        			}
        			
        		}
        		else
        		{
        			System.out.println("Is Disabled");
        		}
        	}
        	else
        	{
        		System.out.println("Is Hidden");
        	}
        	
        }
        catch(Exception ex)
        {
        	System.out.println("Exception occured");
        }
	//close of site
        driver.close();
	}

}
