package DigitToString;

public class DigitConverterNumeric 
{
	public void digitToWords(int digit)
	{
		String answer = "";
		
		if(digit == 0)
		{
			answer = "zero";
		}
		
		if(digit >= 1000)
		{
			answer = convertToEnglishNumber(digit/1000) + " thousand ";
			digit -= ((digit /1000) * 1000);
		}
		if(digit>= 100)
		{
			answer += convertToEnglishNumber(digit/100) + " hundred ";
			digit -= ((digit /100) * 100);
		}
		if(digit>= 20)
		{
			answer += convertToEnglishNumberTens(digit/10) + " ";
			digit -= ((digit /10) * 10);
		}
		if(digit > 0)
		{
			answer += convertToEnglishNumber(digit) + " ";
		}
		
		System.out.println(answer + " \n");
	}
	
	private String convertToEnglishNumberTens(int num)
	{
		String newWord = "";
		switch(num)
		{
			case 2:
			newWord = "Twenty";
			break;
			case 3:
			newWord = "Thirty";
			break;
			case 4:
			newWord = "Fourty";
			break;
			case 5:
			newWord = "fifty";
			break;
			case 6:
			newWord = "sixity";
			break;
			case 7:
			newWord = "seventy";
			break;
			case 8:
			newWord = "eighty";
			break;
			case 9:
			newWord = "ninety";
			break;
		}
		
		return newWord;
	}
	
 	private String convertToEnglishNumber(int num)
	{
		String newWord = "";
		switch(num)
		{
			case 1:
			newWord = "one"	;
			break;
			case 2:
			newWord = "two"	;
			break;
			case 3:
			newWord = "three";
			break;
			case 4:
			newWord = "four";
			break;
			case 5:
			newWord = "five";
			break;
			case 6:
			newWord = "six";
			break;
			case 7:
			newWord = "seven";
			break;
			case 8:
			newWord = "eight";
			break;
			case 9:
			newWord = "nine";
			break;
			case 10:
			newWord = "ten";
			break;
			case 11:
			newWord = "eleven";
			break;
			case 12:
			newWord = "tweleve";
			break;
			case 13:
			newWord = "thirteen";
			break;
			case 14:
			newWord = "fourteen";
			break;
			case 15:
			newWord = "fifteen";
			break;
			case 16:
			newWord = "sixteen";
			break;
			case 17:
			newWord = "seventeen";
			break;
			case 18:
			newWord = "eighteen";
			break;
			case 19:
			newWord = "nineteen";
			break;
		}
		
		return newWord;
	}
}
