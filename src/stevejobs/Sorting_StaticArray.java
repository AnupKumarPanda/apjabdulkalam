package stevejobs;

import java.util.Scanner;

public class Sorting_StaticArray 
{
	public static void main(String[] args)
	{
	     //Declare a Static Array
		int[] a =new int[5];
		//Fill the Array 
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Array Elements");
		for(int i=0;i<5;i++)
		{
			a[i]=sc.nextInt();
		}
		//Sorting
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(a[j]>a[j+1])
				{
					int temp=0;
					temp = a[j];
					a[j]=a[j+1];
					a[j+1]= temp;
				}
			}
		
		}
		//Access Data in Array
		for(int i= 0;i<5;i++)
		{
			System.out.println(a[i]);
		}
	}

}
