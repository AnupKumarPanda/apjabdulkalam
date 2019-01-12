package stevejobs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DDT_W2sms_Notepad
{

	public static void main(String[] args) throws Exception 
	{
		
		//Open Text file for Reading
		File f =new File("DDT_W2sms_Notepad.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		//Create HTML file for Report
		ExtentReports er= new ExtentReports("DDT_W2sms_Notepad.html",false);
		ExtentTest et = er.startTest("way2sms login test");
		//Data Driven Testing
		ChromeDriver driver =null;
		String l="";//in case of String "" represents null
		while((l=br.readLine())!=null)
		{
			try 
			{
				String[] p=l.split(",");
				//Launch Site
				System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("http://www.way2sms.com/");
				driver.manage().window().maximize();
				WebDriverWait w=new WebDriverWait(driver,20);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
				//Do Login
				driver.findElement(By.name("mobileNo")).sendKeys(p[0]);
				driver.findElement(By.name("password")).sendKeys(p[2]);
				driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
				Thread.sleep(5000);
				//Validation
				if(p[0].length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
				//here password is valid or invalid is does not matters as userid is invalid it will never check the password,hence,password condition is not required
				{
					et.log(LogStatus.PASS,"Blank Mobile no  test passed");
				}
				else if(p[0].length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"wrong size mobile no teste passed");
				}
				else if(p[1].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[text()='Invalid Mobile Number']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"invalid mobile no test passed");
				}
				else if(p[1].equalsIgnoreCase("valid")&& p[2].length()==0 && driver.findElement(By.xpath("(//*[text()='Enter password'])[1]")).isDisplayed())
				{
					et.log(LogStatus.PASS,"Blank password test passed");
				}
				else if( p[1].equalsIgnoreCase("valid") && p[3].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
				{
					et.log(LogStatus.PASS,"invalid password test passed");
				}
				else if(p[1].equalsIgnoreCase("valid") && p[3].equalsIgnoreCase("valid") && driver.findElement(By.xpath("//span[text()='Send SMS']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"valid data Login test passed");
				}
				else
			 	{
			 		SimpleDateFormat sf =new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			 		Date d = new Date();
			 		String fname=sf.format(d)+".png";
			 		File src =driver.getScreenshotAs(OutputType.FILE);
			 		File dest =new File(fname);
			 		FileHandler.copy(src,dest);
			 		et.log(LogStatus.FAIL," Test Failed"+et.addScreenCapture(fname));
			 		
			  	}
			 	//Close Sitre
			 	driver.close();
		    }//try block close
		 catch(Exception ex)
		 {
			 et.log(LogStatus.ERROR,ex.getMessage());
			 driver.close();
		 }
	 }
	//close text file
		br.close();
		fr.close();
	//Save Result
	 er.endTest(et);
	 er.flush();
	}
}