package stevejobs;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class VoiceAutomation_Google
{

	public static void main(String[] args) throws Exception 
	{
		//Get Text
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Text");
		String s= sc.nextLine();
		//Launch Website
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeOptions co =new ChromeOptions();
		co.addArguments("__use_fake_ui_for_media_stream=1");
		ChromeDriver driver = new ChromeDriver(co);
		WebDriverWait wait =new WebDriverWait(driver,20);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='voice_search_button']")));
		driver.findElement(By.xpath("//div[@class='voice_search_button']")).click();
		Thread.sleep(3000);
		//Java Robot
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		//Send Voice
		System.setProperty("mbrola.base","D:\\Softwares\\Selenium\\ex\\mbrola");
		VoiceManager vm =VoiceManager.getInstance();
		Voice v = vm.getVoice("mbrola_us1");
		v.allocate();
		v.speak(s);
		v.deallocate();

	}

}
