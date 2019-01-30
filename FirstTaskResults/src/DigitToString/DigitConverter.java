package DigitToString;

public class DigitConverter 
{
	String[] words;
	
	public void digitToWords(int digit)
	{
		String word = "" + digit;
		words = word.split("");
	
		convertAndOutput(words.length);
	}
	
	private void convertAndOutput(int length)
	{
		switch(length)
		{
			case 1:
			if(Integer.parseInt(words[0]) == 0)
			{
				System.out.println("zero");
			}
			else
			{
				System.out.println(convertToEnglishNumber(words[0]));
			}
			break;
			case 2:
			System.out.println(twosCheck(0, 1));
			break;
			case 3:
			System.out.println(threesCheck(0, 1, 2));
			break;
			case 4:
			foursCheck();
			break;
		}
	}
	
	private String foursCheck()
	{
		String combo = "";	
		combo = convertToEnglishNumber(words[0]) + " thousand";
		if(Integer.parseInt(words[1]) == 0) 
		{
			if(Integer.parseInt(words[2]) == 0) 
			{
				if(Integer.parseInt(words[3]) == 0) 
				{
					System.out.println(combo);
				}
				else
				{
					System.out.println(combo + " and " + convertToEnglishNumber(words[3]));
				}
			}
			else
			{
				combo += " " + twosCheck(2, 3);
				System.out.println(combo);
			}
		}
		else
		{
			combo += " " + threesCheck(1, 2, 3);
			System.out.println(combo);
		}
		
		return combo;
	}
	
	private String threesCheck(int indexOne, int indexTwo, int indexThree)
	{
		String combo = "";	
		combo = convertToEnglishNumber(words[indexOne]) + " hundred";
		
		if(Integer.parseInt(words[indexTwo]) == 0) 
		{
			if(Integer.parseInt(words[indexThree]) != 0) 
			{
				combo = (combo + " and " + convertToEnglishNumber(words[indexThree]));
			}
		}
		else
		{	
			combo += " and " + twosCheck(indexTwo, indexThree);
		}
		return combo;
	}
	
	private String twosCheck(int indexOne, int indexTwo)
	{
		String word = "";
		
		if ((Integer.parseInt(words[indexOne]) == 1) && (Integer.parseInt(words[indexTwo]) > 0))
		{
			word = (convertToEnglishNumberSpecialSet(words[indexTwo]));
		}
		else if(Integer.parseInt(words[indexTwo]) == 0)
		{
			word = (convertToEnglishNumberTens(words[indexOne]));
		}
		else
		{
			word = (convertToEnglishNumberTens(words[indexOne]) + " " + convertToEnglishNumber(words[indexTwo]));
		}
		return word;
	}
	
 	private String convertToEnglishNumber(String word)
	{
		String newWord = "";
		switch(word)
		{
			case "1":
			newWord = "one"	;
			break;
			case "2":
			newWord = "two"	;
			break;
			case "3":
			newWord = "three";
			break;
			case "4":
			newWord = "four";
			break;
			case "5":
			newWord = "five";
			break;
			case "6":
			newWord = "six";
			break;
			case "7":
			newWord = "seven";
			break;
			case "8":
			newWord = "eight";
			break;
			case "9":
			newWord = "nine";
			break;
		}
		
		return newWord;
	}
	
	private String convertToEnglishNumberTens(String word)
	{
		String newWord = "";
		switch(word)
		{
			case "1":
			newWord = "Ten";
			break;
			case "2":
			newWord = "Twenty";
			break;
			case "3":
			newWord = "Thirty";
			break;
			case "4":
			newWord = "Fourty";
			break;
			case "5":
			newWord = "fifty";
			break;
			case "6":
			newWord = "sixity";
			break;
			case "7":
			newWord = "seventy";
			break;
			case "8":
			newWord = "eighty";
			break;
			case "9":
			newWord = "ninety";
			break;
		}
		
		return newWord;
	}
	
	private String convertToEnglishNumberSpecialSet(String word)
	{
		String newWord = "";
		switch(word)
		{
			case "1":
			newWord = "eleven";
			break;
			case "2":
			newWord = "tweleve";
			break;
			case "3":
			newWord = "thirteen";
			break;
			case "4":
			newWord = "fourteen";
			break;
			case "5":
			newWord = "fifteen";
			break;
			case "6":
			newWord = "sixteen";
			break;
			case "7":
			newWord = "seventeen";
			break;
			case "8":
			newWord = "eighteen";
			break;
			case "9":
			newWord = "nineteen";
			break;
		}
		
		return newWord;
	}
}
