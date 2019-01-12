package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test1
{
	public static void main(String[] args)
	{
		//System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.com/");

	}

}
