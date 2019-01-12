package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class mercurychrome {

	public static void main(String[] args) throws InterruptedException
	{
		// Launching mercury tours site 
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com");
       //click register link
        driver.findElement(By.linkText("REGISTER")).click();
        // filling the registration form
        driver.findElement(By.name("firstName")).sendKeys("abdul");
        driver.findElement(By.name("lastName")).sendKeys("kalam");
        driver.findElement(By.name("phone")).sendKeys("9000624323");
        driver.findElement(By.name("userName")).sendKeys("apj@abdulkalam.com");
        driver.findElement(By.name("address1")).sendKeys("mosque street");
        driver.findElement(By.name("address2")).sendKeys("Dhanushkioti road");
        driver.findElement(By.name("city")).sendKeys("Rameswaram");
        driver.findElement(By.name("state")).sendKeys("Tamilnadu");
        driver.findElement(By.name("postalCode")).sendKeys("600032");
      //Drop down automation 
        WebElement e = driver.findElement(By.name("country"));
        Select s = new Select(e);
        s.selectByVisibleText("INDIA");
        //Automation of further elements
        driver.findElement(By.name("email")).sendKeys("anup");
        driver.findElement(By.name("password")).sendKeys("batch241");
        driver.findElement(By.name("confirmPassword")).sendKeys("batch241");
        driver.findElement(By.name("register")).click();
        //Sleep for 5 sec
        Thread.sleep(5000);
        driver.close();
                
	}

}
