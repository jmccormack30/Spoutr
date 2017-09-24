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
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;

public class SettingsScreen extends JPanel {

	AppImage logo;
	AppImage banner;
	Model model = new Model();
	public static User user;
	JTextField email;
	JTextField password;
	JLabel label, label2;

	public SettingsScreen() {
		setPreferredSize(new Dimension(476, 800));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentX(Component.LEFT_ALIGNMENT);

		logo = new AppImage("../resources/logo.png", 44, 585);
		banner = new AppImage("../resources/banner.png", 0, 0);

		label = new JLabel("null");
        label.setForeground(Color.BLACK);
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		label.setFont(new Font("Verdana", Font.PLAIN, 18));
		label.setAlignmentX(Component.LEFT_ALIGNMENT);

		label2 = new JLabel("null");
		label2.setFont(new Font("Verdana", Font.PLAIN, 18));
        label2.setForeground(Color.BLACK);
		label2.setAlignmentX(Component.LEFT_ALIGNMENT);

		JPanel panel1 = new JPanel();
		panel1.setMinimumSize(new Dimension(400, 50));
		panel1.setPreferredSize(new Dimension(400, 50));
		panel1.setMaximumSize(new Dimension(400, 50));
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel panel2 = new JPanel();
		panel2.setMinimumSize(new Dimension(400, 50));
		panel2.setPreferredSize(new Dimension(400, 50));
		panel2.setMaximumSize(new Dimension(400, 50));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel panel3 = new JPanel();
		panel3.setMinimumSize(new Dimension(400, 50));
		panel3.setPreferredSize(new Dimension(400, 50));
		panel3.setMaximumSize(new Dimension(400, 50));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel panel4 = new JPanel();
		panel4.setMinimumSize(new Dimension(400, 50));
		panel4.setPreferredSize(new Dimension(400, 50));
		panel4.setMaximumSize(new Dimension(400, 50));
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel panel5 = new JPanel();
		panel5.setMinimumSize(new Dimension(400, 100));
		panel5.setPreferredSize(new Dimension(400, 100));
		panel5.setMaximumSize(new Dimension(400, 100));
		panel5.setLayout(new FlowLayout());

		JPanel panel6 = new JPanel();
		panel6.setMinimumSize(new Dimension(400, 100));
		panel6.setPreferredSize(new Dimension(400, 100));
		panel6.setMaximumSize(new Dimension(400, 100));
		panel6.setLayout(new FlowLayout());

		JLabel label7 = new JLabel("<html><strong>Account: &nbsp; </strong></html>");
		label7.setFont(new Font("Verdana", Font.PLAIN, 18));
		label7.setForeground(Color.BLACK);
		label7.setAlignmentX(Component.LEFT_ALIGNMENT);

		JLabel label4 = new JLabel("<html><strong>Email: &nbsp; </strong></html>");
		label4.setFont(new Font("Verdana", Font.PLAIN, 18));
		label4.setForeground(Color.BLACK);
		label4.setAlignmentX(Component.LEFT_ALIGNMENT);

		email = new JTextField();
        email.setMinimumSize(new Dimension(300,39));
        email.setPreferredSize(new Dimension(300, 39));
        email.setMaximumSize(new Dimension(300, 39));
        Border border4 = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border empty4 = new EmptyBorder(6,6,6,6);
        CompoundBorder line4 = new CompoundBorder(border4, empty4);
        email.setBorder(line4);
        email.setFont(new Font("Verdana", Font.PLAIN, 18));
		email.setAlignmentX(Component.LEFT_ALIGNMENT);

		password = new JTextField();
        password.setMinimumSize(new Dimension(268,39));
        password.setPreferredSize(new Dimension(268, 39));
        password.setMaximumSize(new Dimension(268, 39));
        Border border3 = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border empty3 = new EmptyBorder(6,6,6,6);
        CompoundBorder line3 = new CompoundBorder(border3, empty3);
        password.setBorder(line3);
        password.setFont(new Font("Verdana", Font.PLAIN, 18));
		password.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel label3 = new JLabel("Password: ");
        label3.setFont(new Font("Verdana", Font.BOLD, 18));
        label3.setForeground(Color.BLACK);
		label3.setAlignmentX(Component.LEFT_ALIGNMENT);

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new CancelListener("Cancel"));
        cancel.setMinimumSize(new Dimension(175, 50));
        cancel.setPreferredSize(new Dimension(175, 50));
        cancel.setMaximumSize(new Dimension(175, 50));
        cancel.setFont(new Font("Verdana", Font.BOLD, 18));

        JButton save = new JButton("Save");
		save.addActionListener(new SaveListener("Save"));
        save.setMinimumSize(new Dimension(175, 50));
        save.setPreferredSize(new Dimension(175, 50));
        save.setMaximumSize(new Dimension(175, 50));
        save.setFont(new Font("Verdana", Font.BOLD, 18));

		add(Box.createVerticalStrut(112));
		panel1.add(label);
		add(panel1);
		panel2.add(label2);
		add(panel2);
		add(Box.createVerticalStrut(5));
		panel3.add(label4); panel3.add(email);
		add(panel3);
		add(Box.createVerticalStrut(10));
		panel4.add(label3); panel4.add(password);
		add(panel4);
		add(Box.createVerticalStrut(20));
		panel5.add(cancel); panel5.add(save);
		add(panel5);
	}

	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		logo.draw(g);
		banner.draw(g);
	}

	public class SaveListener implements ActionListener {
		private String name;

		public SaveListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			String tempEmail = email.getText();
			String tempPassword = password.getText();
			if (!tempEmail.contains("@") || tempEmail.length() < 7) {
				JOptionPane.showMessageDialog(null, "Invalid email address");
			} else if (password.getText().length() < 3) {
				JOptionPane.showMessageDialog(null, "Password must be longer");
			} else {
				model.updateUser(user.getUsername(), user.getPassword(), tempEmail, tempPassword);
				App.homeB = true;
				App.running = false;
			}
		}
	}

	public class CancelListener implements ActionListener {
		private String name;

		public CancelListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			App.homeB = true;
			App.running = false;
		}
	}

	/** Refreshes the screen when the screen is loaded */
	public void refreshScreen() {
		label.setText("<html><strong>Name: &nbsp; </strong>" + user.getName() + "</html>");
		label2.setText("<html><strong>Username: &nbsp; </strong>" + user.getUsername() + "</html>");
		label.setBounds(50, 300, 376, 45);
		label2.setBounds(50, 400, 376, 45);
		email.setText(user.getEmail());
		password.setText(user.getPassword());
	}
}