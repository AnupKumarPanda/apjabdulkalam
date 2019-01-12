package stevejobs;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class JavaRobot_Calci
{
	//JAVA ROBOT 
	public static void main(String[] args) throws Exception
	{
		//Launch calculator app in computer
		Runtime.getRuntime().exec("calc.exe");
		Thread.sleep(5000);
		//Send 1st input to clipBoard
		StringSelection x = new StringSelection("345");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x,null);
		//Send clipboard data to windows
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		//Click Add
		r.keyPress(KeyEvent.VK_ADD);
		r.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(5000);
		//Send 2nd input to clip board
		StringSelection y = new StringSelection("2010");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(y, null);
		//Send clipboard data to window
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		//Click '='
		r.keyPress(KeyEvent.VK_EQUALS);
		r.keyRelease(KeyEvent.VK_EQUALS);
		Thread.sleep(5000);
		//Get Output
		r.keyPress(KeyEvent.VK_CONTEXT_MENU);
		r.keyRelease(KeyEvent.VK_CONTEXT_MENU);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		String z = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		System.out.println(z);
		//close window
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_ALT);
	}

}
