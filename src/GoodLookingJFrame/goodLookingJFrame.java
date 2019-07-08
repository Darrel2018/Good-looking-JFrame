package GoodLookingJFrame;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 * 
 * GoodLookingJFrame is an attempt to create a decent looking JFrame.
 * This application utilizes swings tools to create the GUI
 * 
 * @author Darrel2018
 * @version 0.4
 * @since 7/6/2019
 *
 */

public class goodLookingJFrame extends Canvas {
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JPanel mPanel, sidePanel, topPanel, sideIconPanel1;
	private JLabel sideIcon, sideIconText, textLabel;
	JTable table;
	
	public goodLookingJFrame(){
		
		frame = new JFrame();
		
		createView();
	}
	
	public void createView(){
		
		frame.add(createSidePanel());
		frame.add(createTopPanel());
		frame.add(createMainPanel());
		
	}
	
	private Color getColor(int r, int g, int b){
		Color color = new Color(r, g, b);
		return color;
	}
	
	private JPanel createMainPanel(){
		
		mPanel = new JPanel();
		mPanel.setLayout(new BorderLayout());
		mPanel.setSize(new Dimension(610, 247));
		mPanel.setLocation(285, 275);
		mPanel.setBackground(getColor(255, 255, 255));
		
		String[] columnNames = {"DATE", "REF .NO", "PARTICULARS"};
		String[][] data = {
				{"1", "2", "3"},
				{"3", "2", "1"},
				{"2", "1", "3"}};
		
		table = new JTable(data, columnNames);
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		
		table.setFillsViewportHeight(true);
		
		table.setCellSelectionEnabled(false);
		table.setAutoCreateRowSorter(true);
		table.setAutoCreateColumnsFromModel(true);
		
		JTableHeader head = table.getTableHeader();
		head.setBorder(BorderFactory.createLineBorder(getColor(255, 255, 255)));
		head.setBackground(getColor(255, 255, 255));
		
		table.setGridColor(getColor(255, 255, 255));
		
		TableColumn column = null;
		for(int i = 0; i < 3; i++){
			column = table.getColumnModel().getColumn(i);
			column.setResizable(false);
		}
		
		mPanel.add(jsp, BorderLayout.CENTER);
		
		return mPanel;
	}
	
	private JPanel createTopPanel(){
		topPanel = new JPanel();
		
		topPanel.setSize(new Dimension(630, 130));
		topPanel.setLayout(null);
		topPanel.setLocation(265, 70);
		
		topPanel.add(createTextLabel(20, 10, "Adminstrations/Funding/", 
				new Font("Segoe UI", 2, 14), 170));
		
		topPanel.add(createTextLabel(20, 60, "Transaction History for _____________________", 
				new Font("Segoe UI", 0, 24), 460));
		
		topPanel.setBackground(getColor(122, 72, 221));
		
		return topPanel;
	}
	
	private JLabel createTextLabel(int x, int y, String text, Font font, int textWidth){
		textLabel = new JLabel();
		
		textLabel.setText(text);
		textLabel.setFont(font);
		textLabel.setBounds(x, y, textWidth, 50);
		
		textLabel.setForeground(getColor(240, 240, 240));
		
		return textLabel;
	}
	
	private JPanel createSidePanel(){
		sidePanel = new JPanel();
		JSeparator sep = new JSeparator();
		sep.setBounds(5, 90, 255, 10);
		
		sidePanel.setSize(new Dimension(265, 550));
		sidePanel.setLayout(null);
		sidePanel.setBackground(getColor(76, 0, 153));
		
		// adding components
		sidePanel.add(createTextLabel(20, 30, "Good-Looking-Frame", new Font("Segoe UI", 1, 18), 180));
		sidePanel.add(sep);
		sidePanel.add(createSideIconPanel(0, 120, getColor(85, 65, 118), "Employee Benifits", "res\\images\\home.png"));
		sidePanel.add(createSideIconPanel(0, 170, getColor(64, 43, 100), "Gifts & incentives", "res\\images\\gift.png"));
		sidePanel.add(createSideIconPanel(0, 220, getColor(64, 43, 100), "Comming Soon", "res\\images\\plus.png"));
		sidePanel.add(createSideIconPanel(0, 270, getColor(76, 0, 153), "Administration", "res\\images\\user.png"));
		sidePanel.add(createSideIconPanel(0, 320, getColor(76, 0, 153), "Document Store", "res\\images\\document.png"));
		
		return sidePanel;
	}
	
	private JPanel createSideIconPanel(int x, int y, Color color, String text, String iconPath){
		
		sideIconPanel1 = new JPanel();
		sideIcon = new JLabel();
		sideIconText = new JLabel();
		
		sideIconPanel1.setBounds(x, y, 265, 50);
		sideIconPanel1.setLayout(null);
		
		sideIcon.setIcon(new ImageIcon(iconPath));
		sideIcon.setBounds(30, 15, 15, 15);
		
		sideIconText.setText(text);
		sideIconText.setFont(new Font("Segoe UI", 2, 14));
		sideIconText.setBounds(60, -3, 130, 50);
		
		sideIconPanel1.add(sideIcon);
		sideIconPanel1.add(sideIconText);
		sideIconPanel1.setBackground(color);
		sideIconText.setForeground(getColor(240, 240, 240));
		
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