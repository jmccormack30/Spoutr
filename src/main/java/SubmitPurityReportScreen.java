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
import javax.swing.JComboBox;
import javax.swing.ListCellRenderer;
import javax.swing.JList;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class SubmitPurityReportScreen extends JPanel {

	AppImage logo;
	AppImage banner;
	public static JComboBox waterReports = new JComboBox();
	public static JComboBox purity;
	JTextField virusPPM;
	JTextField containmentPPM;
	Model model = new Model();

	public SubmitPurityReportScreen() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(476, 800));
        add(Box.createVerticalStrut(106));

		logo = new AppImage("../resources/logo.png", 44, 585);
		banner = new AppImage("../resources/banner.png", 0, 0);

		JLabel label = new JLabel("Water Report: ");
		label.setFont(new Font("Verdana", Font.PLAIN, 20));
        label.setForeground(Color.BLACK);

		Border border6 = BorderFactory.createLineBorder(Color.BLACK, 1);
		waterReports.setBorder(border6);
		waterReports.setBackground(Color.WHITE);
		waterReports.setMinimumSize(new Dimension(212, 40));
        waterReports.setPreferredSize(new Dimension(212, 40));
        waterReports.setMaximumSize(new Dimension(212, 40));
        waterReports.setFont(new Font("Verdana", Font.PLAIN, 18));
		waterReports.setRenderer(new ComboBoxRenderer());

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
		panel3.setMinimumSize(new Dimension(400, 70));
		panel3.setPreferredSize(new Dimension(400, 70));
		panel3.setMaximumSize(new Dimension(400, 70));
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));

		JPanel panel4 = new JPanel();
		panel4.setMinimumSize(new Dimension(400, 50));
		panel4.setPreferredSize(new Dimension(400, 50));
		panel4.setMaximumSize(new Dimension(400, 50));
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel panel5 = new JPanel();
		panel5.setMinimumSize(new Dimension(400, 50));
		panel5.setPreferredSize(new Dimension(400, 50));
		panel5.setMaximumSize(new Dimension(400, 50));
		panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton back = new JButton("Back");
		back.addActionListener(new BackListener("Back"));
        back.setMinimumSize(new Dimension(175, 50));
        back.setPreferredSize(new Dimension(175, 50));
        back.setMaximumSize(new Dimension(175, 50));
        back.setFont(new Font("Verdana", Font.BOLD, 18));

        JButton submit = new JButton("Submit");
		submit.addActionListener(new SubmitListener("Submit"));
        submit.setMinimumSize(new Dimension(175, 50));
        submit.setPreferredSize(new Dimension(175, 50));
        submit.setMaximumSize(new Dimension(175, 50));
        submit.setFont(new Font("Verdana", Font.BOLD, 18));

		String[] p = new String[3];
		p[0] = "Safe";
		p[1] = "Treatable";
		p[2] = "Unsafe";

		purity = new JComboBox(p);
		Border border5 = BorderFactory.createLineBorder(Color.BLACK, 1);
		purity.setBorder(border5);
		purity.setBackground(Color.WHITE);
		purity.setMinimumSize(new Dimension(212, 40));
        purity.setPreferredSize(new Dimension(212, 40));
        purity.setMaximumSize(new Dimension(212, 40));
        purity.setFont(new Font("Verdana", Font.PLAIN, 18));
		purity.setRenderer(new ComboBoxRenderer());

        JLabel label2 = new JLabel("Purity: ");
        label2.setFont(new Font("Verdana", Font.PLAIN, 20));
        label2.setForeground(Color.BLACK);

		JLabel label3 = new JLabel("Virus PPM: ");
		label3.setFont(new Font("Verdana", Font.PLAIN, 20));
        label3.setForeground(Color.BLACK);

		JLabel label4 = new JLabel("Containment PPM: ");
		label4.setFont(new Font("Verdana", Font.PLAIN, 20));
        label4.setForeground(Color.BLACK);

		virusPPM = new JTextField();
        virusPPM.setMinimumSize(new Dimension(120,39));
        virusPPM.setPreferredSize(new Dimension(120, 39));
        virusPPM.setMaximumSize(new Dimension(120, 39));
        Border border4 = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border empty4 = new EmptyBorder(6,6,6,6);
        CompoundBorder line4 = new CompoundBorder(border4, empty4);
        virusPPM.setBorder(line4);
        virusPPM.setFont(new Font("Verdana", Font.PLAIN, 18));

		containmentPPM = new JTextField();
        containmentPPM.setMinimumSize(new Dimension(120,39));
        containmentPPM.setPreferredSize(new Dimension(120, 39));
        containmentPPM.setMaximumSize(new Dimension(120, 39));
        containmentPPM.setBorder(line4);
        containmentPPM.setFont(new Font("Verdana", Font.PLAIN, 18));

		panel1.add(label); panel1.add(waterReports);
		panel2.add(label2); panel2.add(purity);
		panel3.add(back); panel3.add(submit);
		panel4.add(label3); panel4.add(virusPPM);
		panel5.add(label4); panel5.add(containmentPPM);
		add(panel1);
		add(Box.createVerticalStrut(20));
		add(panel2);
		add(Box.createVerticalStrut(20));
		add(panel4);
		add(Box.createVerticalStrut(19));
		add(panel5);
		add(Box.createVerticalStrut(26));
		add(panel3);
	}

	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		logo.draw(g);
		banner.draw(g);
	}

	public class BackListener implements ActionListener {
		private String name;

		public BackListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			App.homeB = true;
			App.running = false;
		}
	}

	public class SubmitListener implements ActionListener {
		private String name;

		public SubmitListener(String className) {
			name = className;
		}

		public void actionPerformed(ActionEvent e) {
			String date = new SimpleDateFormat("MM/dd/yyyy - HH:mm:ss").format(Calendar.getInstance().getTime());
			int virusPPMint = Integer.parseInt(virusPPM.getText());
			int containmentPPMint = Integer.parseInt(containmentPPM.getText());
			String wpString = waterReports.getSelectedItem().toString();
			WaterReport temp = model.getReport(wpString);
			PurityReport newPReport = new PurityReport(App.user, date, purity.getSelectedItem().toString(),
						virusPPMint, containmentPPMint, temp);
			model.submitPurityReport(newPReport);
			App.homeB = true;
			App.running = false;
		}
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