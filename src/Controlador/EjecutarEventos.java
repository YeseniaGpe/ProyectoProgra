package Controlador;

import Modelo.QueryData;
import Vista.PanelControl;
import Vista.PanelGrafica;
import Vista.Ventana;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Objects;

//Detecta eventos de interfaz gráfica.
public class EjecutarEventos implements ActionListener{

    //Instancias para interactuar con componente VISTA.
    public PanelControl ventana;
    public PanelGrafica graficoBarras;
    public HashMap<Integer, Integer> valoresTabla = new HashMap<>();
    public ArrayList<String> nombresColumnas = new ArrayList<>();

    //Inicializa variables comunes.
    public String   estadoElegido = null,
                    filtroElegido = null,
                    sexo = null;
    public int sexoElegido = 0;

    //Instancias para interactuar con componente MODELO.
    public QueryData queryData = new QueryData();

    //Constructor EjecutarEventos.
    public EjecutarEventos(PanelControl ventana){
        this.ventana = ventana;
        this.ventana.botonMostrarGrafico.addActionListener(this);
        this.ventana.elegirEstado.addActionListener(this);
    }

    //Detecta eventos de componente VISTA.
    public void actionPerformed(ActionEvent e){

        //Confirma evento de boton -Mostrar Gráfica- de VISTA.
        if(e.getSource()== ventana.botonMostrarGrafico) {
            try {
                //Recupera el nombre de la entidad seleccionada.
                estadoElegido = Objects.requireNonNull(ventana.elegirEstado.getSelectedItem()).toString();

                //Recupera el valor del sexo seleccionado.
                for (Enumeration<AbstractButton> recorrerBotonesSexo = ventana.grupoSexo.getElements();
                     recorrerBotonesSexo.hasMoreElements();) {

                    AbstractButton botonAyudaSexo = recorrerBotonesSexo.nextElement();

                    if (botonAyudaSexo.isSelected()) {
                        sexo = botonAyudaSexo.getText();

                        if (sexo.equals("Masculino")) {
                            sexoElegido = 2;
                            sexo="Hombres";
                        } else if (sexo.equals("Femenino")) {
                            sexoElegido = 1;
                            sexo = "Mujeres";
                        }
                    }
                }

                //Recupera el valor del filtro seleccionado.
                for (Enumeration<AbstractButton> recorrerBotonesFiltro = ventana.grupoPadecimiento.getElements();
                     recorrerBotonesFiltro.hasMoreElements();) {

                    AbstractButton botonAyudaFiltro = recorrerBotonesFiltro.nextElement();

                    if (botonAyudaFiltro.isSelected()) {
                        filtroElegido = botonAyudaFiltro.getText();
                    }
                }

                //Limpia etiquetas de columnas pre-existentes.
                nombresColumnas.clear();

                //Agrega etiquetas para las columnas de la gráfica por Padecimiento.
                if(!filtroElegido.equals("Edad")) {
                    nombresColumnas.add("");

                } else {
                    //Agrega etiquetas para las columnas de la gráfica por Edad.
                    int edad = 20;
                    String ayudaCrearEtiquetas;

                    while (edad < 70) {
                        ayudaCrearEtiquetas = edad + "-" + (edad + 9);
                        edad = edad + 10;
                        nombresColumnas.add(ayudaCrearEtiquetas);
                    }

                    nombresColumnas.add("70-100");
                }

                //Obtiene valores para presentar en gráfica.
                valoresTabla = queryData.arrayQuery(estadoElegido, sexoElegido, filtroElegido);

                //Actualiza gráfica en panel derecho de VISTA.
                graficoBarras = new PanelGrafica(filtroElegido,valoresTabla,nombresColumnas,estadoElegido,sexoElegido,filtroElegido);
                Ventana.panelDerecho.updateUI();
                Ventana.panelDerecho.removeAll();
                Ventana.panelDerecho.repaint();
                Ventana.panelDerecho.add(graficoBarras.panelEtiquetasGrafica(estadoElegido,sexoElegido,filtroElegido));
                Ventana.panelDerecho.add(graficoBarras.createDataset(filtroElegido,valoresTabla,nombresColumnas));

            } catch (Exception exception) {
                //Limpia panel derecho de VISTA.
                Ventana.panelDerecho.updateUI();
                Ventana.panelDerecho.removeAll();
                Ventana.panelDerecho.repaint();


                //Notifica al usuario que valide su selección.
                JOptionPane.showMessageDialog(null,"Por favor, " +
                        "valida los datos seleccionados.","Atención", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}