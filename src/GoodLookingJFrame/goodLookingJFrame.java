package GoodLookingJFrame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * GoodLookingJFrame is an attempt to create a decent looking JFrame.
 * This application utilizes swings tools to create the GUI
 * 
 * @author Darrel2018
 * @version 0.3
 * @since 7/6/2019
 *
 */

public class goodLookingJFrame extends Canvas {
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JPanel mPanel, sidePanel, topPanel, sideIconPanel1, sideIconPanel2;
	private JLabel sideIcon, employeeBenifitsLabel, sideIcon2, giftsAIncetives;
	
	public goodLookingJFrame(){
		
		frame = new JFrame();
		mPanel = new JPanel();
		topPanel = new JPanel();
		
		createView();
	}
	
	public void createView(){
		
		frame.getContentPane().add(mPanel);
		
		topPanel.setSize(new Dimension(630, 130));
		topPanel.setLocation(265, 70);
		
		frame.add(createSidePanel());
		frame.add(topPanel);
		
		
		topPanel.setBackground(getColor(122, 72, 221));
	}
	
	private Color getColor(int r, int g, int b){
		Color color = new Color(r, g, b);
		return color;
	}
	
	private JPanel createSidePanel(){
		sidePanel = new JPanel();
		
		sidePanel.setSize(new Dimension(265, 550));
		sidePanel.setLayout(null);
		sidePanel.setBackground(getColor(76, 0, 153));
		
		// adding components
		sidePanel.add(createSideIconPanel(0, 120, getColor(85, 65, 118), "Employee Benifits"));
		sidePanel.add(createSideIconPanel(0, 170, getColor(64, 43, 100), "Gifts & incentives"));
		
		return sidePanel;
	}
	
	private JPanel createSideIconPanel(int x, int y, Color color, String text){
		
		sideIconPanel1 = new JPanel();
		sideIcon = new JLabel();
		employeeBenifitsLabel = new JLabel();
		
		sideIconPanel1.setBounds(x, y, 265, 50);
		sideIconPanel1.setLayout(null);
		
		sideIcon.setIcon(new ImageIcon("res\\images\\home.png"));
		sideIcon.setBounds(30, 15, 15, 15);
		
		employeeBenifitsLabel.setText(text);
		employeeBenifitsLabel.setFont(new Font("Segoe UI", 2, 14));
		employeeBenifitsLabel.setBounds(60, -3, 130, 50);
		
		sideIconPanel1.add(sideIcon);
		sideIconPanel1.add(employeeBenifitsLabel);
		sideIconPanel1.setBackground(color);
		employeeBenifitsLabel.setForeground(getColor(240, 240, 240));
		
		return sideIconPanel1;
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