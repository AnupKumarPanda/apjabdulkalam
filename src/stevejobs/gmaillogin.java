package stevejobs;


	import org.openqa.selenium.By;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class gmaillogin
	{
		public static void main(String[] args) throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			//opening mail website
			driver.get("http://www.gmail.com"); 
			driver.findElement(By.name("identifier")).sendKeys("acharysomanath");
		
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			//driver.findElement(By.name("password")).sendKeys("******");
			Thread.sleep(5000);
			driver.findElement(By.name("password")).sendKeys("");
			//driver.findElement(By.xpath("//input[@type='password']")).sendKeys("*********");
		    driver.findElement(By.xpath("//span[text()='Next']")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//*[text()='Compose']")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.name("to")).sendKeys("anupkumarpanda94@gmail.com");
		    driver.findElement(By.name("subjectbox")).sendKeys("wishings");
		    driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Hi sir.\n How are you in Heaven sir.\nHappy Independance dzy sir.\n Good Bye sir.");
		    Thread.sleep(5000);
		    //driver.findElement(By.xpath("//div[@role='button'][@class = 'bBe']")).click();
		    driver.findElement(By.xpath("//div[contains(@data-tooltip,'Send')]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//span[@class='gb_9a gbii']")).click();
		    driver.findElement(By.linkText("Sign out")).click();
		    driver.close();
		}
	}


