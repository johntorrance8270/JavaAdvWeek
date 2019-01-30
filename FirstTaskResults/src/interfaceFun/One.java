package interfaceFun;

public class One extends AbstractTest implements Interface
{
	private int refExample = 10;
	
	public void setRefExample(int refExample)
	{
		this.refExample = refExample;
	}
	
	public int getRefExample()
	{
		return this.refExample;
	}
	
	public void go()
	{
		System.out.println("One");
	}

	@Override
	public void doTask() 
	{
		System.out.println("DoTask");
	}

	@Override
	public void undoTask() 
	{
		System.out.println("UndoTask");
	}

	@Override
	public void testTask() 
	{
		System.out.println("TestTask");
	}

	@Override
	public void testFoo() 
	{
		System.out.println("TestFoo");
	}
}