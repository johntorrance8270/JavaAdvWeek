package DigitToString;

public class Main 
{
	public static void main(String[] args) 
	{
		System.out.println("My ver ");
		DigitConverter digit = new DigitConverter();
		digit.digitToWords(UserInput.getUserInt());
		System.out.println("");
		
		System.out.println("Numeric ver  ");
		DigitConverterNumeric digitNum = new DigitConverterNumeric();
		digitNum.digitToWords(UserInput.getUserInt());
		
		System.out.println("Array ver ");
		DigitConverterArray digitArray = new DigitConverterArray();
		digitArray.digitToWords(UserInput.getUserInt());
	}

}
