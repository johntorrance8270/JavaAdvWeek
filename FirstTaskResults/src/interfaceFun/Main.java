package interfaceFun;

import java.util.ArrayList;
import java.util.List;

public class Main 
{
	public static void main(String[] args) 
	{
		/*
		One ref = new Two();
		ref.go();
		Two to = (Two)ref;
		to.nextGo();	
		
		List<Interface> usefulList = new ArrayList<Interface>();
		usefulList.add(ref);
		usefulList.add(to);
		
		usefulList.get(0).doTask();
		usefulList.get(1).doTask();
		
		List<AbstractTest> usefulListTwo = new ArrayList<AbstractTest>();
		
		usefulListTwo.add(ref);
		usefulListTwo.add(to);
		
		usefulListTwo.get(0).testFoo();
		
		drawSomething(new One());
		drawSomething(usefulListTwo.get(1));
		
		SingletonExample singularOne = SingletonExample.createObject();
		SingletonExample singularTwo = SingletonExample.createObject();
		SingletonExample singularThree = SingletonExample.createObject();
		SingletonExample singularFour = SingletonExample.createObject();
		
		System.out.println(singularOne.getObjectId());
		System.out.println(singularTwo.getObjectId());
		System.out.println(singularThree.getObjectId());
		System.out.println(singularFour.getObjectId());
		*/
		
		One localVsThis = new One();
		//System.out.println(localVsThis.getRefExample());
		
		localVsThis.setRefExample(50);
		//System.out.println(localVsThis.getRefExample());
		
		
		Bank bank = new Bank();
		bank.getDollarAmount(1);
		bank.setDollar(50);
		bank.getDollarAmount(1);
		
		Bank fakeBank = new Bank();
		fakeBank.getDollarAmount(1);
		fakeBank.setDollar(65);
		fakeBank.getDollarAmount(1);
		
		bank.getDollarAmount(1);
	}
	
	public static void drawSomething(AbstractTest ref)
	{
		ref.doTask();
	}
}
