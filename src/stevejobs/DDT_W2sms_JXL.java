package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;

public class DDT_W2sms_JXL 
{
	public static void main(String[] args) throws Exception
	{
		//Open Excel file for Reading
		File f = new File("DDT_w2sms_JXL.xls");
		Workbook rwb= Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);
		int nour=rsh.getRows();
		int nouc=rsh.getColumns();
		//Open same Excel File for Writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0);
		WritableCellFormat cf =new WritableCellFormat();
		cf.setAlignment(Alignment.JUSTIFY);
		cf.setWrap(true);
		//Create Result Column
		SimpleDateFormat sf =new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
 		Date d = new Date();
 		String cname=sf.format(d);
 		Label l=new Label(nouc,0,cname,cf);
		wsh.addCell(l);
		ChromeDriver driver =null;
		for(int i=1;i<nour;i++)
		{
			try 
			{
				//Launch Site
				System.setProperty("webdriver.chrome.driver","D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("http://www.way2sms.com");
				driver.manage().window().maximize();
				WebDriverWait w=new WebDriverWait(driver,20);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
				//Do Login
				String mbno= rsh.getCell(0,i).getContents();
				String mbnoc= rsh.getCell(1,i).getContents();
				String pwd= rsh.getCell(2,i).getContents();
				String pwdc= rsh.getCell(3,i).getContents();
				driver.findElement(By.name("mobileNo")).sendKeys(mbno);
				driver.findElement(By.name("password")).sendKeys(pwd);
				driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
				Thread.sleep(5000);
				//Validation
				if(mbno.length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
				//here password is valid or invalid is does not matters as userid is invalid it will never check the password,hence,password condition is not required
				{
					Label l1=new Label(nouc,i,"Blank Mobile no  test passed",cf);
					wsh.addCell(l1);
				}
				else if(mbno.length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
				{
					Label l2=new Label(nour,i,"wrong size mobile no teste passed",cf);
					wsh.addCell(l2);
				}
				else if(mbnoc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[text()='Invalid Mobile Number']")).isDisplayed())
				{
					Label l3=new Label(nour,i,"invalid mobile no test passed",cf);
					wsh.addCell(l3);
				}
				else if(mbnoc.equalsIgnoreCase("valid")&& pwd.length()==0 && driver.findElement(By.xpath("(//*[text()='Enter password'])[1]")).isDisplayed())
				{
					Label l4=new Label(nour,i,"Blank password test passed",cf);
					wsh.addCell(l4);
				}
				else if( mbnoc.equalsIgnoreCase("valid") && pwdc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
				{

					Label l5=new Label(nour,i,"invalid password test passed",cf);
					wsh.addCell(l5);
				}
				else if(mbnoc.equalsIgnoreCase("valid") && pwdc.equalsIgnoreCase("valid") && driver.findElement(By.xpath("//span[text()='Send SMS']")).isDisplayed())
				{
					Label l5=new Label(nour,i,"valid data Login test passed",cf);
					wsh.addCell(l5);
				}
				else
			 	{
			 		String fname=sf.format(d)+".png";
			 		File src =driver.getScreenshotAs(OutputType.FILE);
			 		File dest =new File(fname);
			 		FileHandler.copy(src,dest);
			 		Label l6=new Label(nour,i,"Test Failed and see Screenshot:"+fname,cf);
					wsh.addCell(l6);
			  	}
			 	
		    }//try block close
		    catch(Exception ex)
		     {
		    	Label l7=new Label(nour,i,ex.getMessage());
				wsh.addCell(l7);
			 }
			//Close Sitre
		  	driver.quit();
		}
		//Save File
		wwb.write();
		rwb.close();
		wwb.close();
	}

}
