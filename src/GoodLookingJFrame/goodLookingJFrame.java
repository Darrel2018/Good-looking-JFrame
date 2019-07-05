package GoodLookingJFrame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class goodLookingJFrame extends Canvas {
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JPanel mPanel, sidePanel, topPanel, sideIconPanel;
	
	public goodLookingJFrame(){
		
		frame = new JFrame();
		mPanel = new JPanel();
		sidePanel = new JPanel();
		topPanel = new JPanel();
		sideIconPanel = new JPanel();
		
		createView();
	}
	
	public void createView(){
		
		frame.getContentPane().add(mPanel);
		sidePanel.setSize(new Dimension(265, 550));
		sidePanel.setLayout(null);
		
		topPanel.setSize(new Dimension(630, 130));
		topPanel.setLocation(265, 70);
			
		sideIconPanel.setBounds(0, 80, 265, 50);
		
		frame.add(sidePanel);
		frame.add(topPanel);
		
		sidePanel.add(sideIconPanel);
		
		sidePanel.setBackground(getColor(76, 0, 153));
		topPanel.setBackground(getColor(122, 72, 221));
		sideIconPanel.setBackground(getColor(76, 150, 153));
	}
	
	private Color getColor(int r, int g, int b){
		Color color = new Color(r, g, b);
		return color;
	}
	
	public static void main(String[] args){
		goodLookingJFrame JF = new goodLookingJFrame();
		
		JF.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JF.frame.add(JF);
		JF.frame.setTitle("Good Looking Frame");
		JF.frame.setSize(900, 550);
		JF.frame.setLocationRelativeTo(null);
		JF.frame.setResizable(false);
		
		JF.frame.setVisible(true);
	}
}
