package Prueba;

import Controlador.EjecutarEventos;
import Modelo.ConexionBD;
import Modelo.QueryData;
import Vista.PanelControl;
import Vista.Ventana;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        PanelControl ventana = new PanelControl();


        Vista.Ventana ventanaPrincipal = new Vista.Ventana();
        ventanaPrincipal.setVisible(true);

        EjecutarEventos ejecutaEvento = new EjecutarEventos(ventanaPrincipal.panelIzquierdo);
    }
}
