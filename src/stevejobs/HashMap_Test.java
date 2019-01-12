package stevejobs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMap_Test
{
	public static void main(String[] args)
	{
		//Create HashMap
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		//Insert Data into HashMap
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Size of HashMap");
		int count =Integer.parseInt(sc.nextLine());
		for(int i=0;i<count; i++)
		{
			System.out.println("Enter the Key");
			int x= Integer.parseInt(sc.nextLine());
			System.out.println("Enter the Value");
			String y =sc.nextLine();
			hm.put(x,y);
		}
		//Get Data from HashMap
		for(Map.Entry e :hm.entrySet())
		{
			System.out.print(e.getKey());
			System.out.println(" "+e.getValue());
		}
	}
}
