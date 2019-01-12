package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DDT_HashMap_Gmail 
{
	public static void main(String[] args)
	{
		HashMap<String,String> pwd = new HashMap<String,String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the test data");
		int noi =Integer.parseInt(sc.nextLine());
		for(int i =0;i<noi;i++)
		{
			System.out.println("Enter password");
			String x= sc.nextLine();
			System.out.println("Enter the Criteria");
			String y =sc.nextLine();
			pwd.put(x,y);
		}
		//Create Html Report
		ExtentReports er =new  ExtentReports("DDT_HashMap_Gmail.html",false);
		ExtentTest et=er.startTest("Gmail UID Testing using HAshg Map");
		//Data Driven Testing
		 for(Map.Entry e: pwd.entrySet())
		 {
			 ChromeDriver driver=null; 
			 try {
				 	//Launch Site
				 	System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
				 	driver = new ChromeDriver();
				 	driver.manage().window().maximize();
				 	driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");
				 	WebDriverWait w = new WebDriverWait(driver,20);
				 	w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
				 	//Enter userid and click Next
				 	driver.findElement(By.name("identifier")).sendKeys("acharysomanath");
				  	w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
				  	driver.findElement(By.xpath("//*[text()='Next']")).click();
				 	w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
				 	driver.findElement(By.name("password")).sendKeys((String)e.getKey());
				 	w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
				 	driver.findElement(By.xpath("//*[text()='Next']")).click();
				 	Thread.sleep(5000);
				 	//Validation
				 	if(((String)e.getKey()).length()==0 && driver.findElement(By.xpath("//*[text()='Enter a password']")).isDisplayed())
				 	{
				 		et.log(LogStatus.PASS,"Blank PWD Test Passed");
				  	}
				 	else if(((String)e.getValue()).equalsIgnoreCase("invalid")&& driver.findElement(By.xpath("//*[contains(text(),'Wrong password. Try again')]")).isDisplayed())
				 	{
				 		et.log(LogStatus.PASS,"Invalid PWD Test Passed");
				 	}
				 	else if((((String)e.getValue()).equalsIgnoreCase("valid")) && driver.findElement(By.xpath("//*[text()='Compose']")).isDisplayed())
				 	{
				 		et.log(LogStatus.PASS,"Valid PWD Test Passed");
				 	}
				 	else
				 	{
				 		SimpleDateFormat sf =new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
				 		Date d = new Date();
				 		String fname=sf.format(d)+".png";
				 		File src =driver.getScreenshotAs(OutputType.FILE);
				 		File dest =new File(fname);
				 		FileHandler.copy(src,dest);
				 		et.log(LogStatus.FAIL,"UID Test Failed"+et.addScreenCapture(fname));
				 		
				  	}
				 	//Close Sitre
				 	driver.close();
			    }//try block close
			 catch(Exception ex)
			 {
				 et.log(LogStatus.ERROR,ex.getMessage());
				 driver.close();
			 }
		 }//for loop close
		 //Save Result
		 er.endTest(et);
		 er.flush();
	}
	

	


	}


