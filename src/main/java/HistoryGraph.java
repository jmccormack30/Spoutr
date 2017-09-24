package main.java;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class HistoryGraph extends JPanel {

    AppImage logo;
    AppImage banner;
    XYDataset ds;
    JFreeChart chart;
    JPanel panel2;
    JButton back;
    public static WaterReport report;
    Model model = new Model();

    public HistoryGraph() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(476, 800));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(Box.createVerticalStrut(74));

        logo = new AppImage("../resources/logo.png", 44, 585);
        banner = new AppImage("../resources/banner.png", 0, 0);

        JPanel panel1 = new JPanel();
        panel1.setMinimumSize(new Dimension(400, 60));
        panel1.setPreferredSize(new Dimension(400, 60));
        panel1.setMaximumSize(new Dimension(400, 60));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel2 = new JPanel();
        panel2.setMinimumSize(new Dimension(400, 80));
        panel2.setPreferredSize(new Dimension(400, 80));
        panel2.setMaximumSize(new Dimension(400, 80));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        back = new JButton("Back");
        back.addActionListener(new BackListener("Back"));
        back.setMinimumSize(new Dimension(175, 50));
        back.setPreferredSize(new Dimension(175, 50));
        back.setMaximumSize(new Dimension(175, 50));
        back.setFont(new Font("Verdana", Font.BOLD, 18));

        ds = createDataset();
        chart =
                ChartFactory.createXYLineChart("History Graph",
                        "", "", ds, PlotOrientation.VERTICAL, true, true,
                        false);
        // Create an NumberAxis
        NumberAxis xAxis = new NumberAxis();
        xAxis.setTickUnit(new NumberTickUnit(1));
        xAxis.setUpperBound(10);
        // Assign it to the chart
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainAxis(xAxis);
        XYLineAndShapeRenderer renderer =
                (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);

        // for y-axis
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(0, 100);
        rangeAxis.setTickUnit(new NumberTickUnit(5));

        ChartPanel panel = new ChartPanel(chart);
        panel.setMinimumSize(new Dimension(476, 615));
        panel.setPreferredSize(new Dimension(476, 615));
        panel.setMaximumSize(new Dimension(476, 615));
        add(panel);
        add(Box.createVerticalStrut(18));
        panel2.add(back);
        add(panel2);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        banner.draw(g);
    }

    private XYDataset createDataset() {

        DefaultXYDataset ds = new DefaultXYDataset();

        double[][] data = {{},{}};
        double[][] data2 = {{},{}};

        ds.addSeries("Virus PPM", data);
        ds.addSeries("Containment PPM", data2);

        return ds;
    }

    public class BackListener implements ActionListener {
        private String name;

        public BackListener(String className) {
            name = className;
        }

        public void actionPerformed(ActionEvent e) {
            App.historyReportB = true;
            App.running = false;
        }
    }

    public void refreshGraph() {
        double[] virus = model.getVirusArray(report);
        double[] containment = model.getContainmentArray(report);
        double[] xaxis1 = new double[virus.length];
        double[] xaxis2 = new double[containment.length];
        for (int i = 0; i < xaxis1.length; i++) {
            xaxis1[i] = i;
        }
        for (int i = 0; i < xaxis2.length; i++) {
            xaxis2[i] = i;
        }
        double[][] array1 = {xaxis1, virus};
        double[][] array2 = {xaxis2, containment};
        DefaultXYDataset temp = new DefaultXYDataset();
        temp.addSeries("Virus PPM", array1);
        temp.addSeries("Containment PPM", array2);
        ds = temp;
        chart =
                ChartFactory.createXYLineChart(report.getLocationString(),
                        "", "", ds, PlotOrientation.VERTICAL, true, true,
                        false);
        // Create an NumberAxis
        NumberAxis xAxis = new NumberAxis();
        xAxis.setTickUnit(new NumberTickUnit(1));
        xAxis.setUpperBound(array1[1].length + 2);
        // Assign it to the chart
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainAxis(xAxis);
        XYLineAndShapeRenderer renderer =
                (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);

        // for y-axis
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(0, 100);
        rangeAxis.setTickUnit(new NumberTickUnit(5));

        ChartPanel panel = new ChartPanel(chart);
        panel.setMinimumSize(new Dimension(476, 615));
        panel.setPreferredSize(new Dimension(476, 615));
        panel.setMaximumSize(new Dimension(476, 615));
        this.removeAll();
        add(Box.createVerticalStrut(74));
        add(panel);
        add(Box.createVerticalStrut(18));
        panel2.add(back);
        add(panel2);
    }
}