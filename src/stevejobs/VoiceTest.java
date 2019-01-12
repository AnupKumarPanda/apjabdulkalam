package stevejobs;

import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class VoiceTest
{
	public static void main(String[] args)
	{
	System.setProperty("mbrola.base","D:\\Softwares\\Selenium\\ex\\mbrola");
	//get Text
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your message");
	String x = sc.nextLine();
	//Convert text in to Voice
	VoiceManager vm = VoiceManager.getInstance();
	Voice v = vm.getVoice("mbrola_us1");
	//Voice v = vm.getVoice("kevin");
	v.allocate();
	v.speak(x);
	v.deallocate();
	
	}

}
