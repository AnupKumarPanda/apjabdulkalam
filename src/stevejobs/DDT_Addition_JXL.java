package stevejobs;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;

public class DDT_Addition_JXL
{

	public static void main(String[] args) throws Exception 
	{
		//Open Excel file for Reading
		File f =new File("DDT_Addition_JXL.xls");
		Workbook rwb =Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);
		int nour=rsh.getRows();
		//Open same Excel file for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh =wwb.getSheet(0);
		//Data driven from Second row as 1st row contains names of the columns
		for(int i=1;i<nour;i++)
		{
			int x =Integer.parseInt(rsh.getCell(0,i).getContents());
			int y = Integer.parseInt(rsh.getCell(1,i).getContents());
			int z =x+y;
			//As z is int hence we use Number class
			Number n =new Number(2,i,z);// Add import jxl.write.Number
			wsh.addCell(n);
		}
		System.out.println("Execution is Completed");
		//Save Excel File
		wwb.write(); //Save
		rwb.close();
		wwb.close();
	}

}
