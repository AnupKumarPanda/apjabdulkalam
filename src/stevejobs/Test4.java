package stevejobs;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Test4
{
	public static void main(String[] args)
	{
		OperaOptions oo = new OperaOptions();
		oo.setBinary("C:\\Users\\Mikun\\AppData\\Local\\Programs\\Opera\\54.0.2952.71\\opera.exe");
		System.setProperty("webdriver.opera.driver","D:\\Softwares\\BrowserDrivers\\operadriver_win64\\operadriver.exe");
    	OperaDriver driver = new OperaDriver(oo);
		driver.get("https://www.google.com/");
	}

}
