package stevejobs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_Test1
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        //Fill an Element
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('email').value='Anup';");
        //Hilite an Element
        js.executeScript("document.getElementById('pass').style.border='2px solid red';");
        Thread.sleep(3000);
        //Click  on an Element
        js.executeScript("document.getElementById('u_0_2').click();");
        //Creatibn=ng Alert(Way-2)
        driver.executeScript("alert('your facebook is blocked');");
        Thread.sleep(5000);
        driver.close();
	}  

}
