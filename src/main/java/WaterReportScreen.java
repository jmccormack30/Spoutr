package main.java;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.util.List;

public class WaterReportScreen extends JPanel {

	AppImage logo;
	AppImage banner;
	Object[] columns;
	Object[][] data;
	JTable table;
	DefaultTableModel model2;
	public static int numRows = 0;
	Model model = new Model();

	public WaterReportScreen() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(476, 800));
        add(Box.createVerticalStrut(106));

		logo = new AppImage("../resources/logo.png", 44, 585);
		banner = new AppImage("../resources/banner.png", 0, 0);

        JButton back = new JButton("Back");
		back.addActionListener(new BackListener("Back"));
        back.setMinimumSize(new Dimension(175, 50));
        back.setPreferredSize(new Dimension(175, 50));
        back.setMaximumSize(new Dimension(175, 50));
        back.setFont(new Font("Verdana", Font.BOLD, 18));

		JPanel panel1 = new JPanel();
		panel1.setMinimumSize(new Dimension(476, 314));
		panel1.setPreferredSize(new Dimension(476, 314));
		panel1.setMaximumSize(new Dimension(476, 314));
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

		JPanel panel2 = new JPanel();
		panel2.setMinimumSize(new Dimension(476, 80));
		panel2.setPreferredSize(new Dimension(476, 80));
		panel2.setMaximumSize(new Dimension(476, 80));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

		model2 = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model2);
		table.setPreferredSize(new Dimension(476, 314));
		model2.addColumn("<html><b>Location</b></html>");
		model2.addColumn("<html><b>Latitude</b></html>");
		model2.addColumn("<html><b>Longitude</b></html>");
		model2.addColumn("<html><b>Type</b></html>");
		model2.addColumn("<html><b>Condition</b></html>");
		panel1.add(new JScrollPane(table));
		add(panel1);
		add(Box.createVerticalStrut(20));
		panel2.add(back);
		add(panel2);
	}

	/** Fills the WaterReport graph with all the data from all Water Reports */
	public void fillData() {
		List<WaterReport> allReports = model.allReports;
		if (model2.getRowCount() > 0) {
			for (int i = model2.getRowCount() - 1; i > -1; i--) {
				model2.removeRow(i);
			}
		}
		numRows = 0;
		for (WaterReport wp: allReports) {
			String lat = Double.toString(wp.getLatitude());
			String lon = Double.toString(wp.getLongitude());
			Object[] temp = new Object[]{wp.getLocationString(), lat, lon, wp.getType(), wp.getCondition()};
			model2.addRow(temp);
			numRows++;
		}
		for (int i = 1; i < 20 - numRows; i++) {
			model2.addRow(new Object[]{"", "", "", "", ""});
		}
	}

	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		banner.draw(g);
		logo.draw(g);
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

	public class CellRenderer extends DefaultTableCellRenderer {

		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
													   int column) {
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

			this.setValue(table.getValueAt(row, column));
			this.setFont(this.getFont().deriveFont(Font.BOLD));
			return this;
		}
	}
}