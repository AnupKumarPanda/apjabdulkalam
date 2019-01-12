package stevejobs;


import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver","D:\\Softwares\\BrowserDrivers\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
	    driver.get("https://www.gmail.com/");
		//driver.get("http://www.newtours.demoaut.com/");
	   
	}

}
