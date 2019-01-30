package DigitToString;

import java.util.Scanner;

public class UserInput 
{
	public static Scanner userinput = new Scanner(System.in);
	
	public static int getUserInt()
	{
		System.out.println("Please input a number between 0 to 9999");
		
		if(userinput.hasNext())
		{
			if(userinput.hasNextInt())
			{
				int num = userinput.nextInt();
				if((num >= 0) && (num <= 9999))
				{				
					return num;
				}
			}
		}
		
		userinput.next();
		System.out.println("Incorrect value added, please input only a number between 0 to 9999");
		return getUserInt();
	}
}
