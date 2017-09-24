package main.java;

import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JComboBox;
import javax.swing.ListCellRenderer;
import javax.swing.JList;

public class RegisterScreen extends JPanel {

	AppImage logo;
	AppImage banner;
	JTextField firstname;
	JTextField lastname;
	JTextField email;
	JTextField username;
	JPasswordField password;
	JComboBox accountType;
	Model model = new Model();

	public RegisterScreen() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(476, 800));
        add(Box.createVerticalStrut(117));

		logo = new AppImage("../resources/logo.png", 44, 585);
		banner = new AppImage("../resources/banner.png", 0, 0);

        firstname = new JTextField();
        firstname.setMinimumSize(new Dimension(270,39));
        firstname.setPreferredSize(new Dimension(270, 39));
        firstname.setMaximumSize(new Dimension(270, 39));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border empty = new EmptyBorder(6,6,6,6);
        CompoundBorder line = new CompoundBorder(border, empty);
        firstname.setBorder(line);
        firstname.setFont(new Font("Verdana", Font.PLAIN, 18));

        JLabel label = new JLabel("First Name: ");
        label.setFont(new Font("Verdana", Font.BOLD, 20));
        label.setForeground(Color.BLACK);

        JPanel labelPanel = new JPanel();
		labelPanel.setMinimumSize(new Dimension(470, 360));
		labelPanel.setPreferredSize(new Dimension(470, 360));
		labelPanel.setMaximumSize(new Dimension(470, 360));
        labelPanel.add(label);
        labelPanel.add(firstname);
        labelPanel.add(Box.createVerticalStrut(30));

		JLabel label2 = new JLabel("Last Name: ");
		label2.setFont(new Font("Verdana", Font.BOLD, 20));
		label2.setForeground(Color.BLACK);

		lastname = new JTextField();
        lastname.setMinimumSize(new Dimension(270,39));
        lastname.setPreferredSize(new Dimension(270, 39));
        lastname.setMaximumSize(new Dimension(270, 39));
        Border border2 = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border empty2 = new EmptyBorder(6,6,6,6);
        CompoundBorder line2 = new CompoundBorder(border2, empty2);
        lastname.setBorder(line);
        lastname.setFont(new Font("Verdana", Font.PLAIN, 18));

		labelPanel.add(label2);
		labelPanel.add(lastname);
		labelPanel.add(Box.createVerticalStrut(30));

		JLabel label4 = new JLabel("       Email: ");
		label4.setFont(new Font("Verdana", Font.BOLD, 20));
		label4.setForeground(Color.BLACK);

		email = new JTextField();
        email.setMinimumSize(new Dimension(270,39));
        email.setPreferredSize(new Dimension(270, 39));
        email.setMaximumSize(new Dimension(270, 39));
        Border border4 = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border empty4 = new EmptyBorder(6,6,6,6);
        CompoundBorder line4 = new CompoundBorder(border4, empty4);
        email.setBorder(line);
        email.setFont(new Font("Verdana", Font.PLAIN, 18));
		labelPanel.add(label4);
		labelPanel.add(email);
		labelPanel.add(Box.createVerticalStrut(30));

		JLabel label5 = new JLabel("Username: ");
		label5.setFont(new Font("Verdana", Font.BOLD, 20));
		label5.setForeground(Color.BLACK);

		username = new JTextField();
        username.setMinimumSize(new Dimension(270,39));
        username.setPreferredSize(new Dimension(270, 39));
        username.setMaximumSize(new Dimension(270, 39));
        Border border5 = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border empty5 = new EmptyBorder(6,6,6,6);
        CompoundBorder line5 = new CompoundBorder(border5, empty5);
        username.setBorder(line5);
        username.setFont(new Font("Verdana", Font.PLAIN, 18));
		labelPanel.add(label5);
		labelPanel.add(username);
		labelPanel.add(Box.createVerticalStrut(30));

        password = new JPasswordField();
        password.setMinimumSize(new Dimension(266,39));
        password.setPreferredSize(new Dimension(266, 39));
        password.setMaximumSize(new Dimension(266, 39));
        Border border3 = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border empty3 = new EmptyBorder(6,6,6,6);
        CompoundBorder line3 = new CompoundBorder(border3, empty3);
        password.setBorder(line3);
        password.setFont(new Font("Verdana", Font.PLAIN, 18));
		password.setEchoChar('*');

        JLabel label3 = new JLabel("Password: ");
        label3.setFont(new Font("Verdana", Font.BOLD, 20));
        label3.setForeground(Color.BLACK);

        labelPanel.add(label3);
        labelPanel.add(password);
		labelPanel.add(Box.createVerticalStrut(30));

		String[] types = new String[4];
		types[0] = "User";
		types[1] = "Worker";
		types[2] = "Manager";
		types[3] = "Admin";
		accountType = new JComboBox(types);
        accountType.setFont(new Font("Verdana", Font.BOLD, 18));
		accountType.setRenderer(new ComboBoxRenderer());

		Border border6 = BorderFactory.createLineBorder(Color.BLACK, 1);
		accountType.setBorder(border6);
		accountType.setBackground(Color.WHITE);
		accountType.setMinimumSize(new Dimension(266, 40));
		accountType.setPreferredSize(new Dimension(266, 40));
		accountType.setMaximumSize(new Dimension(266, 40));

		JLabel label6 = new JLabel("   Account: ");
		label6.setFont(new Font("Verdana", Font.BOLD, 20));
        label6.setForeground(Color.BLACK);
		labelPanel.add(label6);
		labelPanel.add(accountType);
		labelPanel.add(Box.createVerticalStrut(30));

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new CancelListener("Cancel"));
        cancel.setMinimumSize(new Dimension(175, 50));
        cancel.setPreferredSize(new Dimension(175, 50));
        cancel.setMaximumSize(new Dimension(175, 50));
        cancel.setFont(new Font("Verdana", Font.BOLD, 18));

        JButton register = new JButton("Register");
		register.addActionListener(new RegisterListener("Register"));
        register.setMinimumSize(new Dimension(175, 50));
        register.setPreferredSize(new Dimension(175, 50));
        register.setMaximumSize(new Dimension(175, 50));
        register.setFont(new Font("Verdana", Font.BOLD, 18));

		labelPanel.add(cancel);
		labelPanel.add(Box.createVerticalStrut(80));
        labelPanel.add(register);

        add(labelPanel, BorderLayout.CENTER);
	}

	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		logo.draw(g);
		banner.draw(g);
	}

	public class CancelListener implements ActionListener {
		private String name;

		public CancelListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			App.loginB = true;
			App.running = false;
		}
	}

	public class RegisterListener implements ActionListener {
		private String name;

		public RegisterListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			if (firstname.getText().length() < 3 || lastname.getText().length() < 3) {
				JOptionPane.showMessageDialog(null, "Name must be longer");
			} else if (firstname.getText().length() > 13 || lastname.getText().length() > 13) {
				JOptionPane.showMessageDialog(null, "Name must be shorter");
			} else if (!email.getText().contains("@") || email.getText().length() < 7) {
				JOptionPane.showMessageDialog(null, "Invalid email address");
			} else if (username.getText().length() < 3) {
				JOptionPane.showMessageDialog(null, "Username must be longer");
			} else if (password.getText().length() < 3) {
				JOptionPane.showMessageDialog(null, "Password must be longer");
			} else {
				if (model.addUser(firstname.getText() + " " + lastname.getText(), email.getText(),
				username.getText(), password.getText(), accountType.getSelectedItem().toString())) {
					App.user = model.getUser(username.getText(), password.getText());
					App.running = false;
					App.homeB = true;
				} else {
					//do nothing
				}
			}
		}
	}

	/** Refreshes the input fields when screen is loaded */
	public void refreshScreen() {
		firstname.setText("");
		lastname.setText("");
		email.setText("");
		username.setText("");
		password.setText("");
		accountType.setSelectedItem("User");
	}

	public class ComboBoxRenderer extends JLabel implements ListCellRenderer {
    	private boolean colorSet;
    	private Color selectionBackgroundColor;

    	public ComboBoxRenderer() {
        	setOpaque(true);
        	setHorizontalAlignment(LEFT);
        	setVerticalAlignment(CENTER);
        	colorSet = false;
        	selectionBackgroundColor = Color.red; // Have to set a color, else a compiler error will occur
    	}

    	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        	// Check if color is set (only runs the first time)
        	if(!colorSet) {
            	// Set the list' background color to original selection background of the list
            	selectionBackgroundColor = list.getSelectionBackground();
            	// Do this only one time since the color will change later
            	colorSet = true;
        	}

        	// Set the list' background color to white (white will show once selection is made)
        	list.setSelectionBackground(Color.white);

        	// Check which item is selected
        	if(isSelected) {
            	// Set background color of the item your cursor is hovering over to the original background color
            	setBackground(selectionBackgroundColor);
        	} else {
            	// Set background color of all other items to white
            	setBackground(Color.white);
        	}

        	// Do nothing about the text and font to be displayed
        	setText((String)value);
        	setFont(list.getFont());
			this.setBorder(new EmptyBorder(5,5,5,5));
        	return this;
    	}
	}
}