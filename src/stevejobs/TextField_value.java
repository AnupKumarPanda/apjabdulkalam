package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextField_value
{
// getting user entered value in Text box using getAttribute("value")
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter google or gmail or Facebook");
		String s= sc.nextLine();
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		if(s.equals("gmail"))
		{
			driver.get("http://www.gmail.com"); 
			driver.findElement(By.name("identifier")).sendKeys("anupkumarpanda024");
			String txt = driver.findElement(By.name("identifier")).getAttribute("value");
			System.out.println(txt+"-->Gmail");
		}
		else if (s.equals("Facebook"))
		{
			driver.get("https://www.facebook.com/");
			driver.findElement(By.id("email")).sendKeys("anupkumarpanda");
			String txt = driver.findElement(By.id("email")).getAttribute("value");
			System.out.println(txt+"-->Facebook");
		}
		else 
		{
			driver.get("https://www.google.com/");
			driver.findElement(By.name("q")).sendKeys("anupkumarpanda");
			String txt = driver.findElement(By.name("q")).getAttribute("value");
			System.out.println(txt+"-->Google");
		}
			
		driver.close();
	}	
	
}
