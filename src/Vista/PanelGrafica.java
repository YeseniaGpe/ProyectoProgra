package Vista;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;

public class PanelGrafica {
    public String tituloGrafica;
    public int alturaGrafica;
    public String nombreDatos;


    public PanelGrafica(String etiquetaTitulo, int numeroPersonas) {
       this.tituloGrafica = etiquetaTitulo;
       this.alturaGrafica = numeroPersonas;


    }

    public JPanel createDataset(String etiquetaTitulo, int alturaGrafica) {
        final String serie = "Series 1";
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(alturaGrafica, serie, "");

        JFreeChart grafico = ChartFactory.createBarChart(etiquetaTitulo, nombreDatos,
                "Número de personas", dataset, PlotOrientation.VERTICAL, true,
                true, false);

        ChartUtilities.applyCurrentTheme(grafico);

        CategoryPlot categoryPlot = grafico.getCategoryPlot();
        BarRenderer anchoMaximo = (BarRenderer) categoryPlot.getRenderer();
        anchoMaximo.setMaximumBarWidth(.1);


        ChartPanel chartPanel = new ChartPanel(grafico);
   //     chartPanel.setPreferredSize(new Dimension(400,430));
        return chartPanel;
    }

}
