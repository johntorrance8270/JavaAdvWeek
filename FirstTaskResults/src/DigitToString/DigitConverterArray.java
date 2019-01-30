package DigitToString;

public class DigitConverterArray 
{
	String[] one = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "eighteen", "nineteen"};
	String[] ty = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	public void digitToWords(int digit)
	{
		String answer = "";
		
		if(digit == 0)
		{
			answer = "zero";
		}
		
		if(digit >= 1000)
		{
			answer = one[(digit/1000)] + " thousand ";
			digit -= ((digit /1000) * 1000);
		}
		if(digit>= 100)
		{
			answer += one[(digit/100)] + " hundred ";
			digit -= ((digit /100) * 100);
		}
		if(digit>= 20)
		{
			answer += ty[(digit/10)] + " ";
			digit -= ((digit /10) * 10);
		}
		if(digit > 0)
		{
			answer += one[(digit)] + " ";
		}
		
		System.out.println(answer + " \n");
	}
}
