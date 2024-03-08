package user;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import autorepairpark.MainParkWindow;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener{
	public JFrame frame;
	public JPanel loginPanel;
	public JPanel loginPanelContainer;
	public JButton submitButton;
	public JLabel titleLabel;

	protected JTextField field_username;
	protected JPasswordField field_password;

	public Login() {
		field_username = configureUsernameField();
		field_password = configurePasswordField();
		
		submitButton = configureSubmitButton();
		titleLabel   = configureTitleLabel();
		loginPanel   = setLoginLayout();
		frame        = setFrameLayout(loginPanelContainer);

		submitButton.addActionListener(this);
	}	

	public JTextField configureUsernameField() {
		JTextField field = new JTextField();

		field.setForeground(new Color(0x123456));
		field.setFont(new Font("Consolas", Font.BOLD, 14));
		field.setBorder(null);
		
		return field;
	}
	
	public JPasswordField configurePasswordField() {
		JPasswordField field = new JPasswordField();

		field.setForeground(new Color(0x123456));
		field.setFont(new Font("Consolas", Font.BOLD, 14));
		field.setBorder(null);
		
		return field;
	}
	
	public JButton configureSubmitButton() {
		JButton button = new JButton();

		button.setText("Submit");
		button.setFont(new Font("Consolas", Font.PLAIN, 15));
		button.setBackground(new Color(214, 183, 148));
		button.setForeground(new Color(0x123456));
		button.setBorder(null);

		return button;
	}
	
	public JLabel configureTitleLabel() {
		JLabel label = new JLabel();

		label.setText("Login");
		label.setFont(new Font("Consolas", Font.PLAIN, 40));
		label.setForeground(new Color(0x123456));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setSize(200, 30);
		
		return label;
	}
	
	
	/* ================================ SETTING UP THE LOGIN WINDOW ================================ */
	
	public JPanel setLoginLayout() {
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		
		panel.setBackground(new Color(214, 183, 148));
		panel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		panel.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		panel.setPreferredSize(new Dimension(280, 250));
		panel.setLayout(new BorderLayout(0, 10));
		
		panel2.setPreferredSize(new Dimension(250, 200));
		panel2.setLayout(null);
		
		field_username.setBounds(20, 40, 240, 30);
		field_password.setBounds(20, 80, 240, 30);
		submitButton.setBounds(170, 120, 90, 30);
		
		panel2.add(field_username);
		panel2.add(field_password);
		panel2.add(submitButton);
		
		panel.add(titleLabel, BorderLayout.NORTH);
		panel.add(panel2, BorderLayout.SOUTH);
		
		return panel;
	}
	
	
	/* ================================ SETTING UP THE JFRAME WINDOW ================================ */
	
	public JFrame setFrameLayout(JPanel panel) {
		JFrame frame = new JFrame();
		
		frame.setTitle("Auto Repair Park");
		frame.setResizable(false);
		frame.setSize(new Dimension(500, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(0x123456));

		frame.add(loginPanel);

		return frame;
	}	
	

	public static void main(String[] a) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == submitButton) {
			String username = field_username.getText();
			String password = new String(field_password.getPassword());

			if(username.equals("auto") && password.equals("password")) {
				frame.dispose();
				new MainParkWindow();
			} 
			else {
				JOptionPane.showMessageDialog(loginPanel, "Authentication Failed!!", "Authentication", JOptionPane.OK_OPTION);
			}
			
		}
	}
}
