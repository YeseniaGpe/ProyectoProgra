package Vista;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PanelGrafica {
    public String tituloGrafica;
    public HashMap<Integer,Integer> alturaGrafica;
    public ArrayList<String> tituloBarras;
    public String estado;
    public int sexo;
    public String filtro;

    public PanelGrafica(String nombreFiltro, HashMap<Integer,Integer> conteoPersonas,
                        ArrayList<String> nombreDatos, String entidad, int genero, String filtro) {
       this.tituloGrafica = nombreFiltro;
       this.alturaGrafica = conteoPersonas;
       this.tituloBarras = nombreDatos;
       this.estado = entidad;
       this.sexo = genero;
       this.filtro = filtro;
    }

    public JPanel createDataset(String tituloGrafica, HashMap<Integer,Integer> alturaGrafica, ArrayList<String> tituloBarras) {
        final String serie = "Series 1";
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(int contador=0; contador<alturaGrafica.size();contador++) {
            dataset.addValue(alturaGrafica.get(contador+1), serie, tituloBarras.get(contador));
        }

        JFreeChart grafico = ChartFactory.createBarChart(tituloGrafica, null,
                "Número de personas", dataset, PlotOrientation.VERTICAL, true,
                true, false);

        ChartUtilities.applyCurrentTheme(grafico);

        CategoryPlot categoryPlot = grafico.getCategoryPlot();
        BarRenderer anchoMaximo = (BarRenderer) categoryPlot.getRenderer();
        anchoMaximo.setMaximumBarWidth(.1);

        ChartPanel chartPanel = new ChartPanel(grafico);
        chartPanel.setPreferredSize(new Dimension(440,300));
        return chartPanel;
    }

    public JPanel panelEtiquetasGrafica(String estado, int sexo, String filtro) {
        JLabel etiquetaEstado;
        JLabel etiquetaSexo = null;
        JLabel etiquetaFiltro;

        //Requerido para presentar la fuente preferida para mejorar la experiencia del usuario.
        Font fuenteEtiquetas = new Font("Calibri", 5, 16);

        if(estado.equals("ENTIDAD")){
            estado = "Todas las entidades federativas";
        }
        etiquetaEstado = new JLabel(estado + ".",SwingConstants.LEFT);


        if (sexo == 1) {
            etiquetaSexo = new JLabel("Población de Mujeres.",SwingConstants.LEFT);
        } else if (sexo == 2) {
            etiquetaSexo = new JLabel("Población de Hombres.",SwingConstants.LEFT);
        }
        if (filtro.equals("Edad")) {
            etiquetaFiltro = new JLabel("Rango de edades.",SwingConstants.LEFT);
        } else {
            etiquetaFiltro = new JLabel("Número de casos con " + filtro + ".",SwingConstants.LEFT);
        }

        etiquetaEstado.setFont(fuenteEtiquetas);
        if (etiquetaSexo != null) {
            etiquetaSexo.setFont(fuenteEtiquetas);
        }
        etiquetaFiltro.setFont(fuenteEtiquetas);

        JPanel panelEtiquetas = new JPanel();
        panelEtiquetas.setPreferredSize(new Dimension(400,80));
        panelEtiquetas.setLayout(new GridLayout(3,0));
        panelEtiquetas.add(etiquetaEstado);
        panelEtiquetas.add(etiquetaSexo);
        panelEtiquetas.add(etiquetaFiltro);
        return panelEtiquetas;

    }
}
