package FancyCalc;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MenuFrame 
{
	JFrame frame = null;
	
	Button buttonOne = null;
	Button buttonTwo = null;
	Button buttonThree = null;
	Button buttonFour = null;
	
	MenuFrame()
	{
		frame = new JFrame();
		
		GridLayout g = new GridLayout(4,1);
		frame.setLayout(g);
		
		buttonOne = new Button("+");
		buttonOne.addActionListener(e->addChosen());
		frame.add(buttonOne);
		
		buttonTwo = new Button("-");
		buttonTwo.addActionListener(e->subChosen());
		frame.add(buttonTwo);
		
		buttonThree = new Button("*");
		buttonThree.addActionListener(e->multiChosen());
		frame.add(buttonThree);
		
		buttonFour = new Button("/");
		buttonFour.addActionListener(e->divideChosen());
		frame.add(buttonFour);
		
		frame.setSize(600, 600);
		frame.setVisible(true);
	}
	
	private void addChosen()
	{
		AddCalc addCalc = new AddCalc("Addition", "+", 7, 8);
		
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		frame = addCalc.getFrame();
	}
	
	private void subChosen()
	{
		SubCalc subCalc = new SubCalc("Subtraction", "-", 7, 10);
		
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		frame = subCalc.getFrame();
	}
	
	private void multiChosen()
	{
		MultiCalc multiCalc = new MultiCalc("Multiplication", "*", 3, 6);
		
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		frame = multiCalc.getFrame();
	}
	
	private void divideChosen()
	{
		DivideCalc divideCalc = new DivideCalc("Division", "/", 8, 8);
		
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		frame = divideCalc.getFrame();
	}
}
