package ExceptionHandling;

public class CoolExceptionExample 
{
	public void tax(int salary, int absence) throws CustomExecption, Exception
	{
		float tax = 0;
		
		if(absence > 7)
		{
			CustomExecption e = new CustomExecption();
			throw e;
		}
	}
}
