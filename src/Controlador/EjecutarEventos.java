package Controlador;

import Modelo.QueryData;
import Vista.PanelControl;
import Vista.PanelGrafica;
import Vista.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class EjecutarEventos implements ActionListener{
    PanelControl ventana;// = new PanelControl();
    public static PanelGrafica graficoBarras;

    public EjecutarEventos(PanelControl ventana){
        this.ventana = ventana;
        this.ventana.botonMostrarGrafico.addActionListener(this);
        this.ventana.elegirEstado.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()== ventana.botonMostrarGrafico) {
            String estadoElegido = null;
            int sexoElegido = 0;
            String filtroElegido = null;
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
                QueryData queryData = new QueryData();

                if(filtroElegido != "Edad") {
                    if(filtroElegido=="Hipertensión") {
                        filtroElegido = "Hipertension";
                    }
                    int ayudaQuery = queryData.numberQuery(estadoElegido, sexoElegido, filtroElegido);
                    graficoBarras = new PanelGrafica(filtroElegido,ayudaQuery);
                    Ventana.panelDerecho.updateUI();
                    Ventana.panelDerecho.removeAll();
                    Ventana.panelDerecho.repaint();

                    Ventana.panelDerecho.add(graficoBarras.createDataset(filtroElegido,ayudaQuery));

                }
                else {
                    queryData.arrayQuery(estadoElegido,sexoElegido);
                }


            } catch (Exception exce) {
                System.out.println("Error en los eventos");
            }
        }

    }
}