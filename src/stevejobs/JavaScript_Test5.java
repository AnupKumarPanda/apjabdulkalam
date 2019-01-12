package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_Test5 
{
	public static void main(String[] args) throws Exception
	{

		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.freecrm.com");
        driver.manage().window().maximize();
        //Change the background color of an element
        WebElement e = driver.findElement(By.xpath("//input[@value='Login']"));
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.backgroundColor='rgb(200,0,0)';",e);
        //Flashing the selected item
        for(int i=1;i<=100;i++)
        {
        	 js.executeScript("arguments[0].style.backgroundColor='rgb(0,200,0)';",e);
        	 Thread.sleep(20);
        	 js.executeScript("arguments[0].style.backgroundColor='rgb(200,0,0)';",e);
        	 Thread.sleep(20);
        }
        //Referesh the browser page using swd
        driver.navigate().refresh();
        Thread.sleep(3000);
        //Referesh the browser page using JavaScript
        js.executeScript("history.go(0)");
        //Get Title of the page using JS
        String title =js.executeScript("return document.title;").toString();
        System.out.println(title);
        //Get Text of Entire Text of page
        String pg_txt=js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(pg_txt);
	}

}
