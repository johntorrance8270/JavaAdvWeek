package BetterCalc;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calc extends JFrame
{
	List<Button> calcButtons = new ArrayList<Button>();
	JTextField display = new JTextField(70);
	
	Calc()
	{
		display.setFont(new Font("Arial", Font.PLAIN, 40));
		display.setHorizontalAlignment(SwingConstants.CENTER);
		
		createButtonsInOrder();
		
		Panel p1 = new Panel();
		p1.add(display);
		
		Panel p2 = new Panel();
		GridLayout g = new GridLayout(4,4);
		p2.setLayout(g);
		
		for(Button b : calcButtons)
		{
			p2.add(b);
		}
		
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		
		this.setSize(800, 800);
		this.setVisible(true);
	}
	
	private void createButtonsInOrder()
	{
		final int numberOfButtons = 16;
		String operatorDelim = "op";
		int padding = 0;
		
		for(int i = 0; i < numberOfButtons; i++)
		{
			String buttonName = ((i!=0) && ((i+1) % 4 == 0)) ? (operatorDelim + ++padding) : "" + (i-padding);			
			calcButtons.add(new Button(buttonName));
		}
		
		buttonSorting(operatorDelim);
		
		for(int u = 0; u < numberOfButtons; u++)
		{
			calcButtons.get(u).setFont(new Font("Arial", Font.PLAIN, 40));
			
			if((calcButtons.get(u).getLabel().equals("C")) || (calcButtons.get(u).getLabel().equals("="))) continue;
			
			numberButtonPressSetup(u);
		}
	}

	private void operatorClear()
	{
		display.setText("");
	}
	
	public static boolean isDouble(String s)
	{
		
	  if(s.equals(".")) return true;
		
	  try 
	  { 
	      Double.parseDouble(s); 
	  } 
	  catch(NumberFormatException e) 
	  { 
	      return false; 
	  }
	  
	  return true;
	}
	
	public void containsAllIntegers(List<String> calculationList, List<String> operatorList)
	{
	   boolean prevWasNumber = false;
	   String[] newArray = display.getText().split("");
	   
	   String newPart = "";
	   int count = 0;
	   
	   for (String part : newArray)
	   {
	      if (!isDouble(part))
	      {
	         if(!prevWasNumber)
	         {
	        	 count++;
	        	 if((part.equals("+")) || (part.equals("-")))
	        	 {
	        		 if(count <= 2) newPart = part;
	        	 }
	         }
	         else
	         {
	        	 operatorList.add(part);
	        	 calculationList.add(newPart);
	        	 newPart = "";
	        	 prevWasNumber = false;
	         }
	      }
	      else
	      {
	    	  newPart += part;
	    	  prevWasNumber = true;
	    	  count = 0;
	      }
	   }
	   
	   if(prevWasNumber)
	   {
		   calculationList.add(newPart);
	   }
	}
	
	private void operatorEqual() 
	{
		//String[] calculation = display.getText().split("[-+*/]");			
		List<String> calculationList = new ArrayList<String>();// = new ArrayList<String>(Arrays.asList(calculation));
		//calculationList.removeAll(Arrays.asList(null, ""));
		
		//String[] operators = display.getText().split("[0-9]+");
		List<String> operatorsList = new ArrayList<String>();// = new ArrayList<String>(Arrays.asList(operators));
		//operatorsList.removeAll(Arrays.asList(null, ""));
		
		containsAllIntegers(calculationList, operatorsList);
		
		String result = "";
		
		try 
		{	
			if((calculationList.size() <= 1) || (operatorsList.size() <= 0)) 
			{
				operatorClear();
			}
			else
			{			
				switch(operatorsList.get(0))
				{
					case "+":
					result = "" + (Double.parseDouble(calculationList.get(0)) + Double.parseDouble(calculationList.get(1))); 
					break;
					
					case "-":
					result = "" + (Double.parseDouble(calculationList.get(0)) - Double.parseDouble(calculationList.get(1))); 
					break;
					
					case "*":
					result = "" + (Double.parseDouble(calculationList.get(0)) * Double.parseDouble(calculationList.get(1))); 
					break;
					
					case "/":
					if(calculationList.get(1).equals("0")) 
					{
						operatorClear();
					}
					else
					{
						result = "" + (Double.parseDouble(calculationList.get(0)) / Double.parseDouble(calculationList.get(1))); 
					}
					break;
				}
			}
		}
		catch(ArithmeticException e)
		{
			System.out.println("You tried to kill my Calc!!!");
		}
		catch(Exception e)
		{
			System.out.println("I wonder what you did");
		}
		
		display.setText(result);
	}
	
	private void numberButtonPressSetup(int index)
	{
		calcButtons.get(index).addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Button button = (Button) e.getSource();
				String newScreenMsg = display.getText();
				
				display.setText(newScreenMsg += button.getLabel());
			}
		});
	}
	
	private void buttonSorting(String operatorDelim)
	{
		for(Button b : calcButtons)
		{
			if(b.getLabel().contains(operatorDelim))
			{
				int operatorOrder = Integer.parseInt(b.getLabel().substring(2, 3));			
				switch(operatorOrder)
				{
					case 1:
					b.setLabel("+");
					break;
					case 2:
					b.setLabel("-");
					break;
					case 3:
					b.setLabel("*");
					break;
					case 4:
					b.setLabel("/");
					break;
				}			
			}
			else if(b.getLabel().contains("10"))
			{
				b.setLabel("C");
				b.addActionListener(e->operatorClear());
			}
			else if(b.getLabel().contains("11"))
			{
				b.setLabel("=");
				b.addActionListener(e->operatorEqual());
			}
		}
	}
}
