package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolTip_Test 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/css/css_tooltip.asp");
		WebDriverWait w = new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("w3schools")));
		//First type of Tool-Tip
		String s1 =driver.findElement(By.xpath("//*[@title='Home']")).getAttribute("title");
		System.out.println(s1);
		String s2 =driver.findElement(By.linkText("HTML")).getText();
		System.out.println(s2);
		String s3 =driver.findElement(By.xpath("//*[@title='Tutorials']")).getText();
		System.out.println(s3);
		//2nd type where tooltip is invisible in source code until it is selected in page
		Actions a = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath("//div[contains(text(),'Top')]"));
		a.moveToElement(e1).clickAndHold().build().perform();
		WebElement e2= driver.findElement(By.xpath("//div[contains(text(),'Top')]/span"));
		String s4= e2.getText();
		a.release().build().perform();
		System.out.println(s4);
		driver.close();
	}

}
