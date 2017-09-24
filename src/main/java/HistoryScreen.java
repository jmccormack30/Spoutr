package main.java;

import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ListCellRenderer;
import javax.swing.JList;
import java.awt.FlowLayout;

public class HistoryScreen extends JPanel {

    AppImage logo;
    AppImage banner;
    public static JComboBox waterReports = new JComboBox();
    Model model = new Model();

    public HistoryScreen() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(476, 800));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(Box.createVerticalStrut(106));

        logo = new AppImage("../resources/logo.png", 44, 585);
        banner = new AppImage("../resources/banner.png", 0, 0);

        JPanel panel1 = new JPanel();
        panel1.setMinimumSize(new Dimension(400, 60));
        panel1.setPreferredSize(new Dimension(400, 60));
        panel1.setMaximumSize(new Dimension(400, 60));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel panel2 = new JPanel();
        panel2.setMinimumSize(new Dimension(400, 80));
        panel2.setPreferredSize(new Dimension(400, 80));
        panel2.setMaximumSize(new Dimension(400, 80));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        Border border5 = BorderFactory.createLineBorder(Color.BLACK, 1);
        waterReports.setBorder(border5);
        waterReports.setBackground(Color.WHITE);
        waterReports.setMinimumSize(new Dimension(212, 40));
        waterReports.setPreferredSize(new Dimension(212, 40));
        waterReports.setMaximumSize(new Dimension(212, 40));
        waterReports.setFont(new Font("Verdana", Font.PLAIN, 18));
        waterReports.setRenderer(new ComboBoxRenderer());

        JLabel label2 = new JLabel("Water Report: ");
        label2.setFont(new Font("Verdana", Font.BOLD, 20));
        label2.setForeground(Color.BLACK);

        JButton back = new JButton("Back");
        back.addActionListener(new BackListener("Back"));
        back.setMinimumSize(new Dimension(175, 50));
        back.setPreferredSize(new Dimension(175, 50));
        back.setMaximumSize(new Dimension(175, 50));
        back.setFont(new Font("Verdana", Font.BOLD, 18));

        JButton view = new JButton("View");
        view.addActionListener(new ViewListener("View"));
        view.setMinimumSize(new Dimension(175, 50));
        view.setPreferredSize(new Dimension(175, 50));
        view.setMaximumSize(new Dimension(175, 50));
        view.setFont(new Font("Verdana", Font.BOLD, 18));

        panel1.add(label2);
        panel1.add(waterReports);
        add(panel1);
        add(Box.createVerticalStrut(20));
        panel2.add(back);
        panel2.add(view);
        add(panel2);
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

    public class ViewListener implements ActionListener {
        private String name;

        public ViewListener(String className) {
            name = className;
        }

        public void actionPerformed(ActionEvent e) {
            String s = (String) waterReports.getSelectedItem();

            HistoryGraph.report = model.getReport(s);
            App.historyReportB = true;
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
            setText(value.toString());
            setFont(list.getFont());
            this.setBorder(new EmptyBorder(5,5,5,5));
            return this;
        }
    }
}