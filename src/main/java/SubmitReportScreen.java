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

public class SubmitReportScreen extends JPanel {

	AppImage logo;
	AppImage banner;
	JTextField latitude;
	JTextField longitude;
	JTextField location;
	JComboBox waterType, waterCondition;
	Model model = new Model();

	public SubmitReportScreen() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(476, 800));
		setAlignmentX(Component.LEFT_ALIGNMENT);

		logo = new AppImage("../resources/logo.png", 44, 585);
		banner = new AppImage("../resources/banner.png", 0, 0);

		JPanel panel1 = new JPanel();
		panel1.setMinimumSize(new Dimension(400, 50));
		panel1.setPreferredSize(new Dimension(400, 50));
		panel1.setMaximumSize(new Dimension(400, 50));
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel panel5 = new JPanel();
		panel5.setMinimumSize(new Dimension(400, 50));
		panel5.setPreferredSize(new Dimension(400, 50));
		panel5.setMaximumSize(new Dimension(400, 50));
		panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

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
		panel4.setMinimumSize(new Dimension(400, 80));
		panel4.setPreferredSize(new Dimension(400, 80));
		panel4.setMaximumSize(new Dimension(400, 80));
		panel4.setLayout(new FlowLayout());

		JPanel panel6 = new JPanel();
		panel6.setMinimumSize(new Dimension(400, 50));
		panel6.setPreferredSize(new Dimension(400, 50));
		panel6.setMaximumSize(new Dimension(400, 50));
		panel6.setLayout(new FlowLayout(FlowLayout.LEFT));

        latitude = new JTextField();
        latitude.setMinimumSize(new Dimension(200,39));
        latitude.setPreferredSize(new Dimension(200, 39));
        latitude.setMaximumSize(new Dimension(200, 39));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border empty = new EmptyBorder(6,6,6,6);
        CompoundBorder line = new CompoundBorder(border, empty);
        latitude.setBorder(line);
        latitude.setFont(new Font("Verdana", Font.PLAIN, 18));

		longitude = new JTextField();
		longitude.setMinimumSize(new Dimension(200,39));
		longitude.setPreferredSize(new Dimension(200, 39));
		longitude.setMaximumSize(new Dimension(200, 39));
		longitude.setBorder(line);
		longitude.setFont(new Font("Verdana", Font.PLAIN, 18));

		location = new JTextField();
		location.setMinimumSize(new Dimension(270,39));
		location.setPreferredSize(new Dimension(270, 39));
		location.setMaximumSize(new Dimension(270, 39));
		location.setBorder(line);
		location.setFont(new Font("Verdana", Font.PLAIN, 18));

		JLabel label4 = new JLabel("Longitude: ");
		label4.setFont(new Font("Verdana", Font.BOLD, 20));
		label4.setForeground(Color.BLACK);

		JLabel label5 = new JLabel("Location: ");
		label5.setFont(new Font("Verdana", Font.BOLD, 20));
		label5.setForeground(Color.BLACK);

        JLabel label = new JLabel("Latitude: ");
        label.setFont(new Font("Verdana", Font.BOLD, 20));
        label.setForeground(Color.BLACK);

		JLabel label2 = new JLabel("Water Type: ");
		label2.setFont(new Font("Verdana", Font.BOLD, 20));
        label2.setForeground(Color.BLACK);

		JLabel label3 = new JLabel("Water Condition: ");
		label3.setFont(new Font("Verdana", Font.BOLD, 20));
        label3.setForeground(Color.BLACK);

		String[] types = new String[6];
		types[0] = "Well";
		types[1] = "Stream";
		types[2] = "River";
		types[3] = "Spring";
		types[4] = "Bottled";
		types[5] = "Lake";
		waterType = new JComboBox(types);
		Border border6 = BorderFactory.createLineBorder(Color.BLACK, 1);
		waterType.setBorder(border6);
		waterType.setBackground(Color.WHITE);
		waterType.setMinimumSize(new Dimension(237, 45));
        waterType.setPreferredSize(new Dimension(237, 45));
        waterType.setMaximumSize(new Dimension(237, 45));
        waterType.setFont(new Font("Verdana", Font.PLAIN, 18));
		waterType.setRenderer(new ComboBoxRenderer());

		String[] types2 = new String[4];
		types2[0] = "Waste";
		types2[1] = "Treatable Clear";
		types2[2] = "Treatable Muddy";
		types2[3] = "Potable";
		waterCondition = new JComboBox(types2);;
		waterCondition.setBorder(border6);
		waterCondition.setBackground(Color.WHITE);
		waterCondition.setMinimumSize(new Dimension(184, 45));
        waterCondition.setPreferredSize(new Dimension(184, 45));
        waterCondition.setMaximumSize(new Dimension(184, 45));
        waterCondition.setFont(new Font("Verdana", Font.PLAIN, 18));
		waterCondition.setRenderer(new ComboBoxRenderer());

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new CancelListener("Cancel"));
        cancel.setMinimumSize(new Dimension(175, 50));
        cancel.setPreferredSize(new Dimension(175, 50));
        cancel.setMaximumSize(new Dimension(175, 50));
        cancel.setFont(new Font("Verdana", Font.BOLD, 18));

        JButton submit = new JButton("Submit");
		submit.addActionListener(new SubmitListener("Login"));
        submit.setMinimumSize(new Dimension(175, 50));
        submit.setPreferredSize(new Dimension(175, 50));
        submit.setMaximumSize(new Dimension(175, 50));
        submit.setFont(new Font("Verdana", Font.BOLD, 18));

		add(Box.createVerticalStrut(112));
		panel6.add(label5);
		panel6.add(location);
		add(panel6);
		add(Box.createVerticalStrut(15));
		panel1.add(label);
		panel1.add(latitude);
		add(panel1);
		add(Box.createVerticalStrut(15));
		panel5.add(label4);
		panel5.add(longitude);
		add(panel5);
		add(Box.createVerticalStrut(15));
		panel2.add(label2);
		panel2.add(waterType);
		add(panel2);
		add(Box.createVerticalStrut(20));
		panel3.add(label3);
		panel3.add(waterCondition);
		add(panel3);
		add(Box.createVerticalStrut(30));
		panel4.add(cancel); panel4.add(submit);
		add(panel4);
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
			WaterReport waterReport = new WaterReport(App.user, date, location.getText().toString(), waterType.getSelectedItem().toString(),
																								waterCondition.getSelectedItem().toString(),
										Double.parseDouble(latitude.getText().toString()), Double.parseDouble(longitude.getText().toString()));
			model.submitReport(waterReport);
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