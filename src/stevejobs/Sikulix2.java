package stevejobs;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Button;
import org.sikuli.script.Key;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;
//sikuli automating  operatioins
public class Sikulix2 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cutm.ac.in/");
		Screen s = new Screen();
		s.wheel(Button.WHEEL_DOWN,5);
		Thread.sleep(5000);
		s.wheel(Button.WHEEL_UP,5);
		Thread.sleep(5000);
		s.doubleClick("F:\\Personals Files\\ANUP\\java programs\\Workplace\\apjabdulkalam\\Test50\\logo.png");
		//Take full Screen-shot
		ScreenImage si1= s.capture();
		BufferedImage bi1= si1.getImage();
		File f = new File("F:\\Personals Files\\ANUP\\java programs\\Workplace\\apjabdulkalam\\Test50\\fullimage.png");
	    ImageIO.write(bi1,"png",f);
	   //Take Region Screen-shot
	    Thread.sleep(5000);
	    Region r = new Region(100,100,500,600);
	    ScreenImage si2= s.capture(r);
	  	BufferedImage bi2= si2.getImage();
	  	File f1 = new File("F:\\Personals Files\\ANUP\\java programs\\Workplace\\apjabdulkalam\\Test50\\Regionimage.png");
	    ImageIO.write(bi2,"png",f1);
	    //close using siklux
	    s.keyDown(Key.ALT);
	    s.keyDown(Key.F4);
	    s.keyUp(Key.F4);
	    s.keyUp(Key.ALT);
	}
	

}
