package stevejobs;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_url 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","D:\\Softwares\\BrowserDrivers\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();	
		driver.get("http://www.sentia.in/");
		//get page source code
		String x = driver.getPageSource();
		System.out.println(x);
		//get page Title
		String y = driver.getTitle();
		System.out.println(y);
		// get current url
		String z = driver.getCurrentUrl();
		System.out.println(z);
		driver.close();
	}

}
