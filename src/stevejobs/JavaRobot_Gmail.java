package stevejobs;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//Gmail using JAVA Robot
public class JavaRobot_Gmail
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Login in G-mail website
		driver.get("http://www.gmail.com"); 
		driver.findElement(By.name("identifier")).sendKeys("*********");//Enter UserId
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("*********");//Enter Password
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	    Thread.sleep(5000);
	    WebDriverWait w = new WebDriverWait(driver,100);
	    w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Compose']")));
	    driver.findElement(By.xpath("//*[text()='Compose']")).click();
	    driver.findElement(By.xpath("//div[@class='bBe']")).click();//closeing Notification
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
	    driver.findElement(By.name("to")).sendKeys("acharysomanath@gmail.com");
	    driver.findElement(By.name("subjectbox")).sendKeys("greetings");
	    driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("Good evengin Achasry\nKana Karuchu\nBhala achu ki\nHau bye");
	    driver.findElement(By.xpath("(//input[@name='Filedata']/preceding::div)[last()-1]")).click();
	    Thread.sleep(5000);
	    //Select the required item from computer
	    StringSelection x= new StringSelection("F:\\Personals Files\\Brahmakamala\\DSC00064.JPG");//Enter Path of Your Required file
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x,null);
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_CONTROL);
	    Thread.sleep(5000);
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	    w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@role='progressbar']")));
	    driver.findElement(By.xpath("//div[text()='Send']")).click();
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'No thanks')]")));
	    driver.findElement(By.xpath("//div[@class='bBe']")).click();
	    driver.findElement(By.xpath("//a[contains(@aria-label,'Google Account')]")).click();
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
	    driver.findElement(By.linkText("Sign out")).click();
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	    driver.close();
	}

}
