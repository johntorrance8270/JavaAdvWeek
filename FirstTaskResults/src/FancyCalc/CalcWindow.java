package FancyCalc;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JFrame;

public abstract class CalcWindow 
{
	JFrame frame = null;
	Button buttonCalc = null;
	TextField T1, T2, T3;
	int numOne, numTwo;
	
	CalcWindow(String windowName, String buttonText, int numOne, int numTwo)
	{
		this.numOne = numOne;
		this.numTwo = numTwo;
		
		frame = new JFrame(windowName);
		GridLayout g = new GridLayout(4,2);
		frame.setLayout(g);
		
		Label lib = new Label("First: ");
		frame.add(lib);
		
		T1 = new TextField(10);
		T1.setText("" + numOne);
		frame.add(T1);
		
		Label lib2 = new Label("Second: ");
		frame.add(lib2);
		
		T2 = new TextField(10);
		T2.setText("" + numTwo);	
		frame.add(T2);
		
		Label lib3 = new Label("");
		frame.add(lib3);
		
		buttonCalc = new Button(buttonText);
		buttonCalc.addActionListener(e->response());
		frame.add(buttonCalc);
		
		Label lib4 = new Label("Result: ");
		frame.add(lib4);
		
		T3 = new TextField(10);
		frame.add(T3);
		
		frame.setSize(600, 600);
		frame.setVisible(true);
	}
	
	public JFrame getFrame()
	{
		return this.frame;
	}
	
	 abstract protected void response();
}
