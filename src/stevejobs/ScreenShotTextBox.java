package stevejobs;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotTextBox
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mercurytravels.co.in/");
		//find list of text box in page
		List<WebElement> lt = driver.findElements(By.xpath("//input[@type='text']"));
		for(int j=0;j<lt.size();j++)
		{
			if(lt.get(j).isDisplayed())
			{
			int x = lt.get(j).getLocation().getX();
			int y = lt.get(j).getLocation().getY();
			int w = lt.get(j).getSize().getWidth();
			int h = lt.get(j).getSize().getHeight();
			//get page Screen shot
			File ss = driver.getScreenshotAs(OutputType.FILE); //take screen shot of page 
			BufferedImage Fimg = ImageIO.read(ss); //import java.awt.image.BufferedImage
			BufferedImage Ess = Fimg.getSubimage(x,y,w,h); // Crop the image
			ImageIO.write(Ess,"png",ss); //Save crop image to file again
			File dest = new File("ScreenShotTextBox_img"+j+".png");
			FileUtils.copyFile(ss,dest);
			}
						
		 }
		
		driver.close();
	}
}
		



