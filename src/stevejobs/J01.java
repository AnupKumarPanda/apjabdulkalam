package stevejobs;

import java.io.FileInputStream;

import jxl.Sheet;
import jxl.Workbook;

public class J01 {

	public static void main(String[] args)throws  Exception {


		FileInputStream f=new FileInputStream("j01.xls");
		Workbook wb=Workbook.getWorkbook(f);
		Sheet s=wb.getSheet("Sheet1");
		System.out.println(s.getCell(0, 0).getContents());
		System.out.println(s.getCell(1, 0).getContents());
		
		/*System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(s.getCell(0, 0).getContents());
		
		driver.findElement(By.id(s.getCell(1,0).getContents())).sendKeys(s.getCell(2, 0).getContents());
		
		driver.findElement(By.id(s.getCell(3, 0).getContents())).sendKeys(s.getCell(4, 0).getContents());
		
		*/
		int rc=s.getRows();
		int cc=s.getColumns();
		System.out.println(rc);
		System.out.println(cc);
		
		for(int i=0;i<rc;i++) {
			for(int j=0;j<cc;j++) {
				System.out.println(s.getCell(j, i).getContents());
				

			}
		}
		
		/*for(int i=0;i<cc;i++) {
			for(int j=0;j<rc;j++) {
				String val=s.getCell(i, j).getContents();
				if(val.equals("abhi")) {
					System.out.println(i+"___"+j);
				}
			}
		}*/
	}

}
