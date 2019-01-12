package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;
//Check the cookie availability of a site
public class Cookie_Test 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Delete all Existing cookies 
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		driver.get("http://www.way2sms.com/");
		Thread.sleep(2000);
		//Cookies Testing
		if(driver.manage().getCookies().size()!=0)
		{
			System.out.println("Cookies Test is passed");
		}
		else
		{
			System.out.println("Cookies Test is failed");
		}
		Thread.sleep(2000);
		driver.close();
	 }

}
 