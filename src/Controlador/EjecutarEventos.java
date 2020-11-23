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
    public HashMap<Integer,Integer> valoresTabla = new HashMap<>();
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
                     recorrerBotonesSexo.hasMoreElements();) {
                    AbstractButton botonAyudaSexo = recorrerBotonesSexo.nextElement();
                    if (botonAyudaSexo.isSelected()) {
                        if(botonAyudaSexo.getText() == "Masculino") {
                            sexoElegido = 2;
                        }
                        else if(botonAyudaSexo.getText() == "Femenino"){
                            sexoElegido = 1;
                        }
                    }
                }
                for (Enumeration<AbstractButton> recorrerBotonesFiltro = ventana.grupoPadecimiento.getElements();
                     recorrerBotonesFiltro.hasMoreElements();) {

                    AbstractButton botonAyudaFiltro = recorrerBotonesFiltro.nextElement();

                    if (botonAyudaFiltro.isSelected()) {
                        filtroElegido = botonAyudaFiltro.getText();
                    }
                }
                if(filtroElegido != "Edad") {
                    if(filtroElegido=="Hipertensión") {
                        filtroElegido = "Hipertension";
                    }
                    nombresColumnas.clear();
                    nombresColumnas.add("");
                    valoresTabla = queryData.numberQuery(estadoElegido, sexoElegido, filtroElegido);

                }
                else {
                    int edad = 20;
                    String ayudaCrearEtiquetas;
                    nombresColumnas.clear();
                    while (edad < 100) {
                        ayudaCrearEtiquetas = edad + "-" + (edad + 10);
                        edad = edad + 10;
                        nombresColumnas.add(ayudaCrearEtiquetas);
                    }
                    valoresTabla = queryData.arrayQuery(estadoElegido, sexoElegido);
                }
                graficoBarras = new PanelGrafica(filtroElegido,valoresTabla,nombresColumnas,estadoElegido,sexoElegido,filtroElegido);
                Ventana.panelDerecho.updateUI();
                Ventana.panelDerecho.removeAll();
                Ventana.panelDerecho.repaint();
                Ventana.panelDerecho.add(graficoBarras.panelEtiquetasGrafica(estadoElegido,sexoElegido,filtroElegido));
                Ventana.panelDerecho.add(graficoBarras.createDataset(filtroElegido,valoresTabla,nombresColumnas));

            } catch (Exception exce) {
                System.out.println("Error en los eventos");
            }
        }

    }
}