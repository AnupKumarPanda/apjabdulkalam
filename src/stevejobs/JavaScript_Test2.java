package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_Test2
{
	
	public static void main(String[] args) throws Exception
    {
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        //Fill an Element
        JavascriptExecutor js= (JavascriptExecutor)driver;
        WebElement e1 = driver.findElement(By.name("email"));
        js.executeScript("arguments[0].value='anupkumarpanda024@gmail.com';",e1);//arguments[0] here '0' is index bcz there is only one Element
        //Hilite an Element
        WebElement e2 = driver.findElement(By.name("pass"));
        js.executeScript("arguments[0].style.border='3px dotted red';",e2);
        Thread.sleep(3000);
        //Click  on an Element
        WebElement e3 = driver.findElement(By.xpath("//input[@value='Log In']"));
        js.executeScript("arguments[0].click();",e3);
        //Scroll to bottom
        driver.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(3000); //Scroll to up
        driver.executeScript("window.scrollTo(document.body.scrollHeight,0);");
        Thread.sleep(3000);
        //Scroll to Spexcific Element
        WebElement e4 =driver.findElement(By.partialLinkText("Account security"));
        driver.executeScript("arguments[0].scrollIntoView();",e4);
        Thread.sleep(3000);
        //Creatibn=ng Alert(Way-1)
        driver.executeScript("window.alert('your facebook is blocked');");
        driver.close();

	}

}
