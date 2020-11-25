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
    //Se crean los atributos de la clase
    static String tituloGrafica;
    static HashMap<Integer,Integer> alturaGrafica;
    static ArrayList<String> tituloBarras;
    static String estado;
    static int sexo;
    public String filtro;

    //Constructor PanelGrafica
    public PanelGrafica(String nombreFiltro, HashMap<Integer,Integer> conteoPersonas,
                        ArrayList<String> nombreDatos, String entidad, int genero, String filtro) {
       tituloGrafica = nombreFiltro;
       alturaGrafica = conteoPersonas;
       tituloBarras = nombreDatos;
       estado = entidad;
       sexo = genero;
       this.filtro = filtro;
    }

    //Método que crea la gráfica de barras
    public JPanel createDataset(String tituloGrafica, HashMap<Integer,Integer> alturaGrafica, ArrayList<String> tituloBarras) {
        final String serie = "Series 1";
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        //Genera las barras en la gráfica a partir del HashMap
        for(int contador=0; contador<alturaGrafica.size();contador++) {
            dataset.addValue(alturaGrafica.get(contador+1), serie, tituloBarras.get(contador));
        }

        //Genera la gráfica a partir de los parámetros del filtro
        if(filtro.equals("Ninguno")) {
            tituloGrafica = "Datos sin filtro";
        }
        JFreeChart grafico = ChartFactory.createBarChart(tituloGrafica, null,
                "Número de personas", dataset, PlotOrientation.VERTICAL, true,
                true, false);

        ChartUtilities.applyCurrentTheme(grafico);

        CategoryPlot categoryPlot = grafico.getCategoryPlot();
        BarRenderer anchoMaximo = (BarRenderer) categoryPlot.getRenderer();
        anchoMaximo.setMaximumBarWidth(.1);

        //Crea un chartPanel y le añade el gráfico para que el método lo retorne
        ChartPanel chartPanel = new ChartPanel(grafico);
        chartPanel.setPreferredSize(new Dimension(440,330));
        return chartPanel;
    }

    //Crea un panel que contiene la descripción de la gráfica
    public JPanel panelEtiquetasGrafica(String estado, int sexo, String filtro) {
        JLabel etiquetaEstado;
        JLabel etiquetaSexo;
        JLabel etiquetaFiltro;

        //Requerido para presentar la fuente preferida para mejorar la experiencia del usuario.
        Font fuenteEtiquetas = new Font("Calibri", 5, 16);

        //Dibuja los títulos y etiquetas necesarios para la descripción
        if(filtro.equals("Ninguno")) {
            tituloGrafica = "Datos sin filtro";
        }

        if(estado.equals("ENTIDAD")){
            estado = "Todas las entidades federativas";
        }
        etiquetaEstado = new JLabel(estado + ".",SwingConstants.LEFT);


        if (sexo == 1) {
            etiquetaSexo = new JLabel("Población de Mujeres.",SwingConstants.LEFT);
        } else if (sexo == 2) {
            etiquetaSexo = new JLabel("Población de Hombres.",SwingConstants.LEFT);
        } else {
            etiquetaSexo = new JLabel("Población de Hombres y Mujeres",SwingConstants.LEFT);
        }

        if (filtro.equals("Edad")) {
            etiquetaFiltro = new JLabel("Rango de edades.",SwingConstants.LEFT);
        } else if(!filtro.equals("Ninguno")){
            etiquetaFiltro = new JLabel("Número de casos con " + filtro + ".",SwingConstants.LEFT);
        } else {
            etiquetaFiltro = new JLabel("Datos sin filtro");
        }

        etiquetaEstado.setFont(fuenteEtiquetas);
        etiquetaSexo.setFont(fuenteEtiquetas);
        etiquetaFiltro.setFont(fuenteEtiquetas);

        //Integra las etiquetas al panel
        JPanel panelEtiquetas = new JPanel();
        panelEtiquetas.setPreferredSize(new Dimension(400,80));
        panelEtiquetas.setLayout(new GridLayout(3,0));
        panelEtiquetas.add(etiquetaEstado);
        panelEtiquetas.add(etiquetaSexo);
        panelEtiquetas.add(etiquetaFiltro);
        return panelEtiquetas;

    }
}
