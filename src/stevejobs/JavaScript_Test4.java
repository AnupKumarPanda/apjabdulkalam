package stevejobs;





import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_Test4
{
	public static void main(String[] args) throws Exception
	{

		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
        driver.manage().window().maximize();
        //Get items(invisible) of a drop-down without open
        JavascriptExecutor js= (JavascriptExecutor)driver;
        List<WebElement> l = driver.findElements(By.xpath("(//*[@class='ui dropdown'])[1]/div[2]/div"));
        System.out.println("The s]ize of list is: "+l.size());
        for(WebElement e: l)
        {
        	js.executeScript("var x = arguments[0].textContent; window.alert(x);",e);
        	//While writing multiple Javascript command in singe statement semicolon(;) is mandetory between them
        	String y =driver.switchTo().alert().getText();
        	System.out.println(y);
        	Thread.sleep(3000);
        	driver.switchTo().alert().dismiss();
        	
        }
        driver.close();

	}

}
