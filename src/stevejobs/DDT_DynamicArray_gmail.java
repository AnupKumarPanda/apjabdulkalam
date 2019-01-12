package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class DDT_DynamicArray_gmail
{
	public static void main(String[] args)throws Exception
	{
		//Get Test data in Static Array
		ArrayList<String> uid = new ArrayList<String>();
		ArrayList<String> cs = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the Array");
		int noi =Integer.parseInt(sc.nextLine());
		for(int i =0;i<noi;i++)
		{
			System.out.println("Enter the Uid");
			uid.add(sc.nextLine());
			System.out.println("Enter the Criteria");
			cs.add(sc.nextLine());
		}
		//Create Html Report
		ExtentReports er =new  ExtentReports("DDT_DynamicArray_gmail.html",false);
		ExtentTest et=er.startTest("Gmail UID Testing using Dynamic Arrays");
		//Data Driven Testing
		 for(int i=0;i<noi;i++)
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
				 	driver.findElement(By.name("identifier")).sendKeys(uid.get(i));
				 	w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
				 	driver.findElement(By.xpath("//*[text()='Next']")).click();
				 	Thread.sleep(5000);
				 	//Validation
				 	if(uid.get(i).length()==0 && driver.findElement(By.xpath("//*[contains(text(),'Enter an email')]")).isDisplayed())
				 	{
				 		et.log(LogStatus.PASS,"Blank UID Test Passed");
				  	}
				 	else if(cs.get(i).equalsIgnoreCase("invalid")&& driver.findElement(By.xpath("(//*[contains(text(),'your Google Account')])[2]")).isDisplayed())
				 	{
				 		et.log(LogStatus.PASS,"Invalid UID Test Passed");
				 	}
				 	else if(cs.get(i).equalsIgnoreCase("valid") && driver.findElement(By.name("password")).isDisplayed())
				 	{
				 		et.log(LogStatus.PASS,"Valid UID Test Passed");
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
				 SimpleDateFormat sf =new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			 		Date d = new Date();
			 		String fname=sf.format(d)+".png";
			 		File src =driver.getScreenshotAs(OutputType.FILE);
			 		File dest =new File(fname);
			 		FileHandler.copy(src,dest);
			 		et.log(LogStatus.ERROR,ex.getMessage()+et.addScreenCapture(fname));
				    driver.close();
			 }
		 }//for loop close
		 //Save Result
		 er.endTest(et);
		 er.flush();
	}
	
}
