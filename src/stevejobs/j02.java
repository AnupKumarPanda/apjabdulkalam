package stevejobs;

import java.io.FileOutputStream;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.biff.LabelRecord;

public class j02 {

	public static void main(String[] args)throws Exception {

		FileOutputStream fo=new FileOutputStream("j02.xls");
		WritableWorkbook wwb=Workbook.createWorkbook(fo);
		WritableSheet ws=wwb.createSheet("Result", 1);
		int a=30;
		int b=40;
		int c =a*b;
		int d=a+b;
		
		Label l=new Label(0,0,"C value is "+c);
		Label l1=new Label(0, 1, "D value is "+d);
		ws.addCell(l);
		ws.addCell(l1);
		wwb.write();
		wwb.close();
	}

}
