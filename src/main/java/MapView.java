package main.java;

import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MapView extends JPanel {

    AppImage banner;
    Model model = new Model();
    public static User user;
    public static AppMap appmap;

    public MapView() {
        setPreferredSize(new Dimension(476, 800));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.LEFT_ALIGNMENT);

        appmap = App.appmap;

        JButton back = new JButton("Back");
        back.addActionListener(new BackListener("Back"));
        back.setMinimumSize(new Dimension(175, 50));
        back.setPreferredSize(new Dimension(175, 50));
        back.setMaximumSize(new Dimension(175, 50));
        back.setFont(new Font("Verdana", Font.BOLD, 18));
        back.setAlignmentX(CENTER_ALIGNMENT);

        add(appmap);
        add(back);
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
}