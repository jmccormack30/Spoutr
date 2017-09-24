package main.java;

import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

public class HomeScreen extends JPanel {

	AppImage logo;
	AppImage banner;
	JLabel welcome;
	Model model = new Model();
	public static User user;

	public HomeScreen() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(476, 800));
        add(Box.createVerticalStrut(75));

		logo = new AppImage("../resources/logo.png", 44, 585);
		banner = new AppImage("../resources/banner.png", 0, 0);

		JButton sReport = new JButton("Submit Report");
		sReport.addActionListener(new SubmitReportListener("Submit Report"));
    	sReport.setMinimumSize(new Dimension(225, 50));
        sReport.setPreferredSize(new Dimension(225, 50));
        sReport.setMaximumSize(new Dimension(225, 50));
        sReport.setFont(new Font("Verdana", Font.BOLD, 16));

		JButton sPurityReport = new JButton("Submit Purity Report");
		sPurityReport.addActionListener(new SubmitPurityReportListener("Submit Purity Report"));
        sPurityReport.setMinimumSize(new Dimension(225, 50));
        sPurityReport.setPreferredSize(new Dimension(225, 50));
        sPurityReport.setMaximumSize(new Dimension(225, 50));
        sPurityReport.setFont(new Font("Verdana", Font.BOLD, 16));

		JButton viewWaterReports = new JButton("View Water Reports");
		viewWaterReports.addActionListener(new ViewWaterReportsListener("View Water Reports"));
    	viewWaterReports.setMinimumSize(new Dimension(225, 50));
        viewWaterReports.setPreferredSize(new Dimension(225, 50));
        viewWaterReports.setMaximumSize(new Dimension(225, 50));
        viewWaterReports.setFont(new Font("Verdana", Font.BOLD, 16));

		JButton viewPurityReports = new JButton("View Purity Reports");
		viewPurityReports.addActionListener(new ViewPurityReportsListener("View Purity Reports"));
    	viewPurityReports.setMinimumSize(new Dimension(225, 50));
        viewPurityReports.setPreferredSize(new Dimension(225, 50));
        viewPurityReports.setMaximumSize(new Dimension(225, 50));
        viewPurityReports.setFont(new Font("Verdana", Font.BOLD, 16));

		JButton map = new JButton("View Map");
		map.addActionListener(new MapListener("View Map"));
    	map.setMinimumSize(new Dimension(225, 50));
        map.setPreferredSize(new Dimension(225, 50));
        map.setMaximumSize(new Dimension(225, 50));
        map.setFont(new Font("Verdana", Font.BOLD, 16));

		JButton history = new JButton("History Report");
		history.addActionListener(new HistoryListener("History Report"));
		history.setMinimumSize(new Dimension(225, 50));
		history.setPreferredSize(new Dimension(225, 50));
		history.setMaximumSize(new Dimension(225, 50));
		history.setFont(new Font("Verdana", Font.BOLD, 16));

		JButton settings = new JButton("Settings");
		settings.addActionListener(new SettingsListener("Settings"));
        settings.setMinimumSize(new Dimension(225, 50));
        settings.setPreferredSize(new Dimension(225, 50));
        settings.setMaximumSize(new Dimension(225, 50));
        settings.setFont(new Font("Verdana", Font.BOLD, 16));

		JButton logout = new JButton("Logout");
		logout.addActionListener(new LogoutListener("Logout"));
        logout.setMinimumSize(new Dimension(225, 50));
        logout.setPreferredSize(new Dimension(225, 50));
        logout.setMaximumSize(new Dimension(225, 50));
        logout.setFont(new Font("Verdana", Font.BOLD, 16));

		JPanel labelPanel = new JPanel();
		labelPanel.setMinimumSize(new Dimension(470, 75));
		labelPanel.setPreferredSize(new Dimension(470, 75));
		labelPanel.setMaximumSize(new Dimension(470, 75));

		welcome = new JLabel("Welcome, null!");
		welcome.setFont(new Font("Verdana", Font.BOLD, 18));
		welcome.setHorizontalAlignment(SwingConstants.LEFT);

		labelPanel.add(welcome);
		labelPanel.add(Box.createVerticalStrut(77));

		JPanel secondPanel = new JPanel();
		secondPanel.setMinimumSize(new Dimension(470, 375));
		secondPanel.setPreferredSize(new Dimension(470, 375));
		secondPanel.setMaximumSize(new Dimension(470, 375));

        secondPanel.add(sReport);
        secondPanel.add(Box.createVerticalStrut(30));
		secondPanel.add(sPurityReport);
		secondPanel.add(Box.createVerticalStrut(30));
		secondPanel.add(viewWaterReports);
		secondPanel.add(Box.createVerticalStrut(30));
		secondPanel.add(viewPurityReports);
		secondPanel.add(Box.createVerticalStrut(30));
		secondPanel.add(map);
		secondPanel.add(Box.createVerticalStrut(30));
		secondPanel.add(history);
		secondPanel.add(Box.createVerticalStrut(30));
		secondPanel.add(settings);
		secondPanel.add(Box.createVerticalStrut(30));
		secondPanel.add(logout);

		add(labelPanel, BorderLayout.CENTER);
		add(secondPanel, BorderLayout.CENTER);
	}

	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		logo.draw(g);
		banner.draw(g);
	}

	public class LogoutListener implements ActionListener {
		private String name;

		public LogoutListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			App.loginB = true;
			App.running = false;
		}
	}

	public class SettingsListener implements ActionListener {
		private String name;

		public SettingsListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			App.settingsB = true;
			App.running = false;
		}
	}

	public class HistoryListener implements ActionListener {
		private String name;

		public HistoryListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			if (App.user.getAccountType().equals("Manager") || App.user.getAccountType().equals("Admin")) {
				App.historyB = true;
				App.running = false;
			} else {
				JOptionPane.showMessageDialog(null, "You must be a manager to view the History Report!");
			}
		}
	}

	public class ViewWaterReportsListener implements ActionListener {
		private String name;

		public ViewWaterReportsListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			App.waterreportB = true;
			App.running = false;
		}
	}

	public class ViewPurityReportsListener implements ActionListener {
		private String name;

		public ViewPurityReportsListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			if (user.getAccountType().equals("Manager") || user.getAccountType().equals("Admin")) {
				App.viewpreportB = true;
				App.running = false;
			} else {
				JOptionPane.showMessageDialog(null, "You must be a manager to view purity reports!");
			}
		}
	}

	public class SubmitReportListener implements ActionListener {
		private String name;

		public SubmitReportListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			App.reportB = true;
			App.running = false;
		}
	}

	public class MapListener implements ActionListener {
		private String name;

		public MapListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			App.mapB = true;
			App.running = false;
		}
	}

	public class SubmitPurityReportListener implements ActionListener {
		private String name;

		public SubmitPurityReportListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			if (user.getAccountType().equals("User")) {
				JOptionPane.showMessageDialog(null, "As a User, you cannot submit a purity report");
			} else {
				App.purityreportB = true;
				App.running = false;
			}
		}
	}

	public void refreshScreen() {
		welcome.setText("Welcome, " + user.getName() + "!");
	}
}