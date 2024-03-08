package autorepairpark;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainParkWindow extends user.Client implements ActionListener{
	protected JFrame frame;
	protected JLabel titleLabel;

	protected JPanel leftSidebar_Panel;
	protected JPanel rightSidebar_Panel;  
	protected JPanel rightSidePanel_top;
	protected JPanel rightSidePanel_main; 

	protected JPanel addClient_Panel;

	public JButton barButton_addClient;
	public JButton barButton_showClients;
	public JButton barButton_clientInfo;
	public JButton barButton_showDoneProblems;
	public JButton barButton_showUndoneProblems;
	
	public MainParkWindow() {
		
		barButton_showClients        = configureBarButtons("List Clients");
		barButton_addClient          = configureBarButtons("Add Client");
		barButton_showDoneProblems   = configureBarButtons("Done Tasks");
		barButton_showUndoneProblems = configureBarButtons("Undone Tasks");
		barButton_clientInfo         = configureBarButtons("Client Info");
		
		rightSidePanel_top   = configure_rightSidePanel_Top();
		rightSidePanel_main  = configure_rightSidePanel_Main();
		
		leftSidebar_Panel  = configureLeftPanel ();
		rightSidebar_Panel = configureRightPanel();
		frame              = configureMainWindow();

		addClient_Panel = setAddClientWindow();
		
		barButton_addClient.addActionListener(this);
	}


	/* ====================== SETTING UP BAR BUTTONS ======================= */

	public JButton configureBarButtons(String textButton) {
		JButton button = new JButton(textButton);

		button.setBackground(new Color(214, 183, 148));
		button.setForeground(new Color(0x12356));
		button.setPreferredSize(new Dimension(120, 30));

		return button;
	}
	

	/* ====================== SETTING UP RIGHT PANEL ======================= */
	
	protected JPanel configure_rightSidePanel_Top() {
		JPanel panel = new JPanel();

		panel.setPreferredSize(new Dimension(50, 100));
		panel.setBackground(new Color(214, 183, 148));
		panel.setLayout(new BorderLayout());

		panel.add(configureTitleLabel("GOO AUTO REPAIR"));

		return panel;
	}
	
	protected JPanel configure_rightSidePanel_Main() {
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(100, 608));
		panel.setBackground(Color.GRAY);
		panel.setLayout(new BorderLayout(10, 10));

		return panel;
	}

	public JLabel configureTitleLabel(String title) {
		JLabel label = new JLabel();
		
		label.setText(title);
		label.setForeground(new Color(0x123456));
		label.setFont(new Font("Consolas", Font.BOLD, 50));
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		return label;
	}

	protected JPanel configureRightPanel() {
		JPanel panel = new JPanel();

		panel.setPreferredSize(new Dimension(745, 100));
		panel.setLayout(new BorderLayout(5, 5));
		
		panel.add(rightSidePanel_top, BorderLayout.NORTH);
		panel.add(rightSidePanel_main, BorderLayout.SOUTH);
		
		return panel;
	}


	/* ======================= SETTING UP LEFT PANEL ======================= */ 

	protected JPanel configureLeftPanel() {
		JPanel panel = new JPanel();

		panel.setPreferredSize(new Dimension(150, 100));
		panel.setBackground(new Color(0x123456));
		panel.setLayout(new FlowLayout());

		panel.add(barButton_addClient);
		panel.add(barButton_showClients);
		panel.add(barButton_showDoneProblems);
		panel.add(barButton_showUndoneProblems);
		panel.add(barButton_clientInfo);

		return panel;
	}

	
	/* ====================== SETTING UP MAIN WINDOW ====================== */ 
	
	protected JFrame configureMainWindow() {
		JFrame frame = new JFrame();

		frame.setTitle("Goog Auto Repair Park");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 750);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		frame.add(leftSidebar_Panel, BorderLayout.WEST);
		frame.add(rightSidebar_Panel, BorderLayout.EAST);
		
		return frame;
	}


	// ================== SETTING UP EVENTS FOR BAR BUTTONS ====================
	public JPanel setAddClientWindow() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Lbaelllll");

		label.setForeground(Color.RED);

		panel.setPreferredSize(new Dimension(400, 600));
		panel.setBackground(Color.WHITE);

		panel.add(label);

		return panel;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == barButton_addClient) {

			JPanel panel = setAddClientWindow();
			System.out.print("\n\nHello world!!");
			
			rightSidePanel_main.add(addClient_Panel, BorderLayout.SOUTH);
		}
	}

	@Override
	public void setName      () {}
	public void setClientCode() {}
	public void setEmail     () {}
	public void setBI        () {}
	public void setTell      () {}

	
	public static void main(String[] a) {
		new MainParkWindow();
	}
}


