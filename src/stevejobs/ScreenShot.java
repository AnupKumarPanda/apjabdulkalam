package stevejobs;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		//find element and get X,Y co-ordinates,width,Height
		WebElement e = driver.findElement(By.xpath("//img[@alt='Google'][@id='hplogo']"));
		int x = e.getLocation().getX();
		int y = e.getLocation().getY();
		int w = e.getSize().getWidth();
		int h = e.getSize().getHeight();
		System.out.println(x);
		System.out.println(y);
		System.out.println(w);
		System.out.println(h);
		//get page Screen shot
		File ss = driver.getScreenshotAs(OutputType.FILE); //take screen shot of page 
		BufferedImage Fimg = ImageIO.read(ss); //import java.awt.image.BufferedImage
		BufferedImage Ess = Fimg.getSubimage(x,y,w,h); // Crop the image
		ImageIO.write(Ess,"png",ss); //Save crop image to file again
		File dest = new File("ScreenShotimg.png"); //Creating file in hard disk
		FileUtils.copyFile(ss,dest);
		Thread.sleep(3000);
		driver.close();
	}

}
