package q2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorGUI
{
	private final int WIDTH = 350, HEIGHT = 100, FONT_SIZE = 20;
	private final int NUM_COLORS = 5;
	private JPanel primary;
	private Color [] color = new Color[NUM_COLORS];
	private JRadioButton [] colorButton = new JRadioButton[NUM_COLORS];
	private JLabel heading;

	// ------------------------------------------------------------------
	//  Sets up a GUI with a label at the top and a set of radio buttons
	//  that control the background color of the panel.
	// ------------------------------------------------------------------
	public ColorGUI ()
	{
		// Set up heading and colors
		heading = new JLabel ("Choose the background color!");
		heading.setFont (new Font ("Helvetica", Font.BOLD, FONT_SIZE));

		color[0] = Color.yellow;
		color[1] = Color.cyan;
		color[2] = Color.red;
		color[3] = Color.green;
		color[4] = Color.magenta;
		
		colorButton[0] = new JRadioButton("Yellow", true);
		colorButton[1] = new JRadioButton("Cyan");
		colorButton[2] = new JRadioButton("Red");
		colorButton[3] = new JRadioButton("Green");
		colorButton[4] = new JRadioButton("Magenta");

		// Set up the panel
		primary = new JPanel ();
		primary.add (heading);
		primary.setBackground (Color.yellow);
		primary.setPreferredSize (new Dimension (WIDTH, HEIGHT));

		// Instantiate a ButtonGroup object and a ColorListener object
		ButtonGroup group = new ButtonGroup();
		ColorListener listener = new ColorListener();

		// Group the radio buttons, add a ColorListener to each,
		// set the background color of each and add each to the panel.
		for (int i = 0; i < NUM_COLORS; i++)
		{
			group.add(colorButton[i]);
			colorButton[i].setBackground(Color.white);
			colorButton[i].addActionListener(listener);
			primary.add(colorButton[i]);
		}
	}


	// --------------------------------------------------------------
	//  Returns the primary panel containing the GUI.
	// --------------------------------------------------------------
	public JPanel getPanel()
	{
		return primary;
	}


	// **************************************************************
	//   Represents the listener for the radio buttons.
	// **************************************************************
	private class ColorListener implements ActionListener
	{
		// --------------------------------------------------------
		//  Updates the background color of the panel based on
		//  which radio button is selected.
		// --------------------------------------------------------
		public void actionPerformed (ActionEvent event)
		{
			for (int i = 0; i < NUM_COLORS; i++)
				if (colorButton[i].isSelected())
					primary.setBackground(color[i]);
		}
	}

}
