 package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
//YouTube using SIKULIX
public class Sikulix_Youtube
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\\\Softwares\\\\BrowserDrivers\\\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.youtube.com");
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='search_query']")));
		driver.findElement(By.xpath("//*[@name='search_query']")).sendKeys("sikuli developer");
		driver.findElement(By.xpath("//button[contains(@id,'search')]/yt-icon")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Sikuli with Selenium Automation']")));
		driver.findElement(By.xpath("//a[@title='Sikuli with Selenium Automation']")).click();
		//Skip-add usin sikulix
		Thread.sleep(10000);
		Screen s = new Screen();
		if(s.exists("skipadd.PNG")!=null)
		{
		 s.click("skipadd.PNG");
		}
		s.click("pause.png");
		Thread.sleep(5000);
		s.click("play.png");
		s.mouseMove(200,200);
		s.mouseMove("sound.png");
		Match b = s.find("bubble.png");
		int x =b.getX();
		int y = b.getY();
		Location l = new Location(x-20,y);
		s.dragDrop(b,l);
		Location l1= new Location(x,y);
		s.dragDrop(b,l1);
		driver.close();
	}

}
                                                                                                              