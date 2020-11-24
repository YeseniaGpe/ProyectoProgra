package Controlador;

import Modelo.QueryData;
import Vista.PanelControl;
import Vista.PanelGrafica;
import Vista.Ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

public class EjecutarEventos implements ActionListener{
    public PanelControl ventana;
    public PanelGrafica graficoBarras;
    public String estadoElegido = null;
    public int sexoElegido = 0;
    public String filtroElegido = null;
    public QueryData queryData = new QueryData();
    public HashMap valoresTabla = new HashMap<>();
    public ArrayList<String> nombresColumnas = new ArrayList<>();

    public EjecutarEventos(PanelControl ventana){
        this.ventana = ventana;
        this.ventana.botonMostrarGrafico.addActionListener(this);
        this.ventana.elegirEstado.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()== ventana.botonMostrarGrafico) {
            try {
                estadoElegido = ventana.elegirEstado.getSelectedItem().toString();
                for (Enumeration<AbstractButton> recorrerBotonesSexo = ventana.grupoSexo.getElements();
                     recorrerBotonesSexo.hasMoreElements(); ) {
                    AbstractButton botonAyudaSexo = recorrerBotonesSexo.nextElement();
                    if (botonAyudaSexo.isSelected()) {
                        if (botonAyudaSexo.getText().equals("Masculino")) {
                            sexoElegido = 2;
                        } else if (botonAyudaSexo.getText().equals("Femenino")) {
                            sexoElegido = 1;
                        }
                    }
                }
                for (Enumeration<AbstractButton> recorrerBotonesFiltro = ventana.grupoPadecimiento.getElements();
                     recorrerBotonesFiltro.hasMoreElements(); ) {

                    AbstractButton botonAyudaFiltro = recorrerBotonesFiltro.nextElement();

                    if (botonAyudaFiltro.isSelected()) {
                        filtroElegido = botonAyudaFiltro.getText();
                    }
                }
                if (!filtroElegido.equals("Edad")) {
                    if (filtroElegido.equals("Hipertensión")) {
                        filtroElegido = "Hipertension";
                    }
                    nombresColumnas.clear();
                    nombresColumnas.add("");
                    valoresTabla = queryData.numberQuery(estadoElegido, sexoElegido, filtroElegido);

                } else {
                    int edad = 20;
                    String ayudaCrearEtiquetas;
                    nombresColumnas.clear();
                    while (edad < 70) {
                        ayudaCrearEtiquetas = edad + "-" + (edad + 9);
                        edad = edad + 10;
                        nombresColumnas.add(ayudaCrearEtiquetas);
                    }
                    nombresColumnas.add("70-100");
                    valoresTabla = queryData.arrayQuery(estadoElegido, sexoElegido);
                }

                if(estadoElegido.equals("ENTIDAD") || filtroElegido==null) {
                    nombresColumnas = null;
                    Ventana.panelDerecho.add(graficoBarras.createDataset(filtroElegido,valoresTabla,nombresColumnas));
                }

                graficoBarras = new PanelGrafica(filtroElegido,valoresTabla,nombresColumnas,estadoElegido,sexoElegido,filtroElegido);
                Ventana.panelDerecho.updateUI();
                Ventana.panelDerecho.removeAll();
                Ventana.panelDerecho.repaint();
                Ventana.panelDerecho.add(graficoBarras.panelEtiquetasGrafica(estadoElegido,sexoElegido,filtroElegido));
                Ventana.panelDerecho.add(graficoBarras.createDataset(filtroElegido,valoresTabla,nombresColumnas));



            } catch (Exception exce) {
                Ventana.panelDerecho.updateUI();
                Ventana.panelDerecho.removeAll();
                Ventana.panelDerecho.repaint();
                JOptionPane.showMessageDialog(null,"Por favor, valida los datos ingresados","Atención", JOptionPane.WARNING_MESSAGE);

            }
        }

    }
}