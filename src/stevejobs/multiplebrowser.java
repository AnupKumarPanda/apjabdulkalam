package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class multiplebrowser {

	public static void main(String[] args) 
	{
	WebDriver driver = null;
	Scanner sc = new Scanner(System.in);
	String x = sc.nextLine();
	if(x.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com/");
	}
    else if(x.equals("firefox"))
	{
    	System.setProperty("webdriver.gecko.driver","D:\\Softwares\\BrowserDrivers\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    driver.get("https://www.google.com/");
	}
    else if(x.equals("ie"))
    {
    	System.setProperty("webdriver.ie.driver","D:\\Softwares\\BrowserDrivers\\iedriverserver.exe");
		driver = new InternetExplorerDriver();
		driver.get("https://www.google.com/");
    }
    else if(x.equals("opera"))
    {
    	OperaOptions oo = new OperaOptions();
		oo.setBinary("C:\\Users\\Mikun\\AppData\\Local\\Programs\\Opera\\54.0.2952.71\\opera.exe");
		System.setProperty("webdriver.opera.driver","D:\\Softwares\\BrowserDrivers\\operadriver_win64\\operadriver.exe");
    	driver = new OperaDriver(oo);
		driver.get("https://www.google.com/");
    }
    else 
    {
    	System.out.println("Enter valid browser name");
    	System.exit(0);
    }
		driver.close();
	}
}
