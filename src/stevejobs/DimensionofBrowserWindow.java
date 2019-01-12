package stevejobs;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class DimensionofBrowserWindow
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		// Get size of Browser window
		int w = driver.manage().window().getSize().getWidth();
		int h = driver.manage().window().getSize().getHeight();
		System.out.println("The Width and Height of the window is:"+w+" & "+h );
		//Change the size of browser window
		Dimension d = new Dimension(500,300);
		driver.manage().window().setSize(d);
		Thread.sleep(3000);		
		//get the position of browser window
		int x = driver.manage().window().getPosition().getX();
		int y = driver.manage().window().getPosition().getY();
		System.out.println("The X and Y Coordinates of the window is:"+x+" & "+y );
		//Change the position of browser window
		Point p = new Point(400,300);
		driver.manage().window().setPosition(p);
		Thread.sleep(3000);	
		driver.close();
	}

}
