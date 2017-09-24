package main.java;

import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import java.awt.Graphics;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class TitleScreen extends JPanel {

	AppImage logo;
	AppImage banner;
	JTextField username;
	JPasswordField password;
	Model model = new Model();

	public TitleScreen() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(476, 800));
        add(Box.createVerticalStrut(117));

		logo = new AppImage("../resources/logo.png", 44, 585);
		banner = new AppImage("../resources/banner.png", 0, 0);

        username = new JTextField();
        username.setMinimumSize(new Dimension(270,39));
        username.setPreferredSize(new Dimension(270, 39));
        username.setMaximumSize(new Dimension(270, 39));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border empty = new EmptyBorder(6,6,6,6);
        CompoundBorder line = new CompoundBorder(border, empty);
        username.setBorder(line);
        username.setFont(new Font("Verdana", Font.PLAIN, 18));

        JLabel label = new JLabel("Username: ");
        label.setFont(new Font("Verdana", Font.BOLD, 20));
        label.setForeground(Color.BLACK);

        JPanel labelPanel = new JPanel();
		labelPanel.setMinimumSize(new Dimension(470, 360));
		labelPanel.setPreferredSize(new Dimension(470, 360));
		labelPanel.setMaximumSize(new Dimension(470, 360));
        labelPanel.add(label);
        labelPanel.add(username);
        labelPanel.add(Box.createVerticalStrut(30));

        password = new JPasswordField();
        password.setMinimumSize(new Dimension(266,39));
        password.setPreferredSize(new Dimension(266, 39));
        password.setMaximumSize(new Dimension(266, 39));
        Border border2 = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border empty2 = new EmptyBorder(6,6,6,6);
        CompoundBorder line2 = new CompoundBorder(border2, empty2);
        password.setBorder(line2);
        password.setFont(new Font("Verdana", Font.PLAIN, 18));
		password.setEchoChar('*');

        JLabel label2 = new JLabel("Password: ");
        label2.setFont(new Font("Verdana", Font.BOLD, 20));
        label2.setForeground(Color.BLACK);

        labelPanel.add(label2);
        labelPanel.add(password);

        JButton login = new JButton("Login");
		login.addActionListener(new LoginListener("Login"));
        login.setMinimumSize(new Dimension(175, 50));
        login.setPreferredSize(new Dimension(175, 50));
        login.setMaximumSize(new Dimension(175, 50));
        login.setFont(new Font("Verdana", Font.BOLD, 18));
        labelPanel.add(login);

        labelPanel.add(Box.createVerticalStrut(80));

        JButton register = new JButton("Register");
		register.addActionListener(new RegisterListener("Register"));
        register.setMinimumSize(new Dimension(175, 50));
        register.setPreferredSize(new Dimension(175, 50));
        register.setMaximumSize(new Dimension(175, 50));
        register.setFont(new Font("Verdana", Font.BOLD, 18));
        labelPanel.add(register);

        add(labelPanel, BorderLayout.CENTER);
	}

	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		logo.draw(g);
		banner.draw(g);
	}

	public class LoginListener implements ActionListener {
		private String name;

		public LoginListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			String tempUsername = username.getText();
			String tempPassword = new String(password.getPassword());
			if(model.validateLogin(tempUsername, tempPassword)) {
				App.user = model.getUser(tempUsername, tempPassword);
				App.homeB = true;
				App.running = false;
			} else {
				password.setText("");
				JOptionPane.showMessageDialog(null, "Login Failed");
				password.requestFocusInWindow();
			}
		}
	}

	public class RegisterListener implements ActionListener {
		private String name;

		public RegisterListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			App.registerB = true;
			App.running = false;
		}
	}

	/** Refreshes the screen when the screen is loaded */
	public void refreshScreen() {
		username.setText("");
		password.setText("");
	}
}