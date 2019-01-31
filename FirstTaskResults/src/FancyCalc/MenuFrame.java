package FancyCalc;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class MenuFrame 
{
	JFrame frame = null;
	
	JRadioButton  buttonOne = null;
	JRadioButton buttonTwo = null;
	JRadioButton buttonThree = null;
	JRadioButton buttonFour = null;
	
	MenuFrame()
	{
		BufferedImage checked = null;
		try 
		{
			checked = ImageIO.read(new File("checkedButton.png"));
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
        Image unchecked = null;
		try 
		{
			unchecked = ImageIO.read(new File("uncheckedButton.png"));
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
		frame = new JFrame();
		
		GridLayout g = new GridLayout(4,1);
		frame.setLayout(g);
		
		buttonOne = new JRadioButton ("+");
		buttonOne.setFont(buttonOne.getFont().deriveFont(40.0f)); 	
		buttonOne.addActionListener(e->addChosen());
		buttonOne.setSelectedIcon(new ImageIcon(checked));
		buttonOne.setIcon(new ImageIcon(unchecked));
		buttonOne.setHorizontalTextPosition(JRadioButton.CENTER);
		buttonOne.setVerticalTextPosition(JRadioButton.CENTER);
		frame.add(buttonOne);
		
		buttonTwo = new JRadioButton("-");
		buttonTwo.addActionListener(e->subChosen());
		frame.add(buttonTwo);
		
		buttonThree = new JRadioButton("*");
		buttonThree.addActionListener(e->multiChosen());
		frame.add(buttonThree);
		
		buttonFour = new JRadioButton("/");
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
