package Vista;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;

public class PanelGrafica {

    public PanelGrafica() {

    }

    public JPanel createDataset() {
        final String serie = "Series 1";
        ;
        final String speed = "Speed";
        final String speed2 = "Speed 2";
        final String speed3 = "Speed 3";
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, serie, speed);
        dataset.addValue(5.0, serie, speed2);
        dataset.addValue(4.0, serie, speed3);

        JFreeChart grafico = ChartFactory.createBarChart("titulo", "Category",
                "Score", dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartUtilities.applyCurrentTheme(grafico);
        ChartPanel chartPanel = new ChartPanel(grafico);
        // chartPanel.setPreferredSize(new Dimension(400,430));
        return chartPanel;
    }

}
