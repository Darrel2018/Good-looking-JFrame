package GoodLookingJFrame;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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
 * 
 * @author Darrel2018
 * @version 0.4
 * @since 7/6/2019
 */

public class goodLookingJFrame extends Canvas {
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JPanel mPanel, sidePanel, topPanel, sideIconPanel1, prevPanel;
	private JLabel sideIcon, sideIconText, textLabel;
	private JTable table;
	private Point iClick;
	
	// Constructor
	public goodLookingJFrame(){
		frame = new JFrame();
		
		createView();
	}
	
	// Creates and adds panels to the frame
	public void createView(){
		
		frame.add(createSidePanel());
		frame.add(createTopPanel());
		frame.add(createMainPanel());
		frame.add(createExitPanel());
		createMovingFrame();
		
	}
	
	// Allows the frame to be moved
	private void createMovingFrame(){
		
		JPanel panel = new JPanel();
		
		panel.setSize(899, 550);
		frame.add(panel);
		
		frame.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e){
				iClick = e.getPoint();
				getComponentAt(iClick);
			}
		});
		
		frame.addMouseMotionListener(new MouseMotionListener() {
			int init_x, init_y, moved_x, moved_y, now_x, now_y;
			
			public void mouseMoved(MouseEvent e) {}
			
			public void mouseDragged(MouseEvent e) {
				
				init_x = frame.getLocation().x;
				init_y = frame.getLocation().y;
				
				moved_x = e.getX() - iClick.x;
				moved_y = e.getY() - iClick.y;
				
				now_x = init_x + moved_x;
				now_y = init_y + moved_y;
				
				frame.setLocation(now_x, now_y);
			}
		});
	}
	
	// Creates an exit panel so the user can exit the program
	private JPanel createExitPanel() {
		
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setSize(new Dimension(50, 50));
		panel.setLocation(850, 0);
		
		textLabel = createTextLabel(20, 0, "X", new Font("Segoe UI", 0, 24), 30, setColor(0, 0, 0));
		textLabel.addMouseListener(new MouseListener() {
			
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		panel.add(textLabel);
		
		return panel;
	}
	
	// Returns a color with the set R/G/B values
	private Color setColor(int r, int g, int b){
		Color color = new Color(r, g, b);
		return color;
	}
	
	// Creates the main panel where the table is created
	private JPanel createMainPanel(){
		
		mPanel = new JPanel();
		mPanel.setLayout(new BorderLayout());
		mPanel.setSize(new Dimension(580, 247));
		mPanel.setLocation(285, 275);
		mPanel.setBackground(setColor(255, 255, 255));
		
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
		head.setBorder(BorderFactory.createLineBorder(setColor(255, 255, 255)));
		head.setBackground(setColor(255, 255, 255));
		
		table.setRowSelectionAllowed(true);
		table.setSelectionBackground(setColor(122, 72, 221));
		table.setSelectionForeground(setColor(240, 240, 240));
		table.setShowGrid(false);
		
		table.setRowHeight(20);
		
		/*TableColumn column = null;
		for(int i = 0; i < 3; i++){
			column = table.getColumnModel().getColumn(i);
			column.setResizable(false);
		}*/
		
		frame.add(createComboBox(284, 240, 180, 10));
		frame.add(createComboBox(488, 240, 180, 10));
		
		mPanel.add(jsp, BorderLayout.CENTER);
		
		return mPanel;
	}
	
	// Returns drop down choice boxes
	private Choice createComboBox(int x, int y, int width, int height){
		
		Choice c = new Choice();
		
		c.add("1");
		c.add("2");
		c.add("3");
		c.add("4");
		
		c.setSize(new Dimension(width, height));
		c.setLocation(x, y);
		
		return c;
	}
	
	// Creates the top panel
	private JPanel createTopPanel(){
		topPanel = new JPanel();
		
		topPanel.setSize(new Dimension(630, 130));
		topPanel.setLayout(null);
		topPanel.setLocation(265, 70);
		
		topPanel.add(createTextLabel(20, 10, "Adminstrations/Funding/", 
				new Font("Segoe UI", 2, 14), 170, setColor(240, 240, 240)));
		
		topPanel.add(createTextLabel(20, 60, "Transaction History for _____________________", 
				new Font("Segoe UI", 0, 24), 460, setColor(240, 240, 240)));
		
		topPanel.setBackground(setColor(122, 72, 221));
		
		return topPanel;
	}
	
	// Returns a JLabel with the set location/font/width/color
	private JLabel createTextLabel(int x, int y, String text, Font font, int textWidth, Color color){
		textLabel = new JLabel();
		
		textLabel.setText(text);
		textLabel.setFont(font);
		textLabel.setBounds(x, y, textWidth, 50);
		
		textLabel.setForeground(color);
		
		return textLabel;
	}
	
	// Creates the side panel
	private JPanel createSidePanel(){
		
		sidePanel = new JPanel();
		JSeparator sep = new JSeparator();
		sep.setBounds(5, 90, 255, 10);
		
		sidePanel.setSize(new Dimension(265, 550));
		sidePanel.setLayout(null);
		sidePanel.setBackground(setColor(76, 0, 153));
		
		// creating components
		JPanel btn_EB = createSideIconPanel(0, 120, setColor(64, 43, 100), "Employee Benifits", "res\\images\\home.png");
		JPanel btn_GI = createSideIconPanel(0, 170, setColor(64, 43, 100), "Gifts & incentives", "res\\images\\gift.png");
		JPanel btn_CS = createSideIconPanel(0, 220, setColor(64, 43, 100), "Comming Soon", "res\\images\\plus.png");
		JPanel btn_A = createSideIconPanel(0, 270, setColor(76, 0, 153), "Administration", "res\\images\\user.png");
		JPanel btn_DS = createSideIconPanel(0, 320, setColor(76, 0, 153), "Document Store", "res\\images\\document.png");
		
		addListeners(btn_EB);
		addListeners(btn_GI);
		addListeners(btn_CS);
		
		// adding components
		sidePanel.add(createTextLabel(20, 30, "Good-Looking-Frame", new Font("Segoe UI", 1, 18), 180, setColor(240, 240, 240)));
		sidePanel.add(sep);
		sidePanel.add(btn_EB);
		sidePanel.add(btn_GI);
		sidePanel.add(btn_CS);
		sidePanel.add(btn_A);
		sidePanel.add(btn_DS);
		
		return sidePanel;
	}
	
	// this is used to add mouse listeners to buttons on the side panels
	private void addListeners(JPanel panel){
		
		panel.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {
				resetColor();
				prevPanel = panel;
				panel.setBackground(setColor(85, 65, 118));
			}
			
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
	}
	
	// resets the buttons color after clicking on another button
	private void resetColor(){
		if(prevPanel == null) prevPanel = new JPanel();
		prevPanel.setBackground(setColor(64, 43, 100));
	}
	
	// Returns a JPanel with a set icon and text values
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
		sideIconText.setForeground(setColor(240, 240, 240));
		
		return sideIconPanel1;
	}
	
	// ----====MAIN====----
	public static void main(String[] args){
		goodLookingJFrame JF = new goodLookingJFrame();
		
		JF.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JF.frame.add(JF);
		JF.frame.setTitle("Good Looking Frame");
		JF.frame.setSize(900, 550);
		JF.frame.setLocationRelativeTo(null);
		JF.frame.setResizable(false);
		JF.frame.setUndecorated(true);
		
		JF.frame.setVisible(true);
	}
}