package interfaceFun;

public class Bank 
{
	static int Dollar;
	
	static
	{
		Dollar = 95;
	}
	
	public void setDollar(int newAmount)
	{
		Dollar = newAmount;
	}
	
	public void getDollarAmount(int currency)
	{
		System.out.println(Dollar*currency);
	}
}