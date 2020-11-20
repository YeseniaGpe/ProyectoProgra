package Prueba;

import Controlador.EjecutarEventos;

public class Main {
    public static void main(String[] args) {
        Vista.Ventana ventanaPrincipal = new Vista.Ventana();
        ventanaPrincipal.setVisible(true);

        //Agrega accion de mostrar grafica.
        EjecutarEventos ejecutaEvento = new EjecutarEventos(ventanaPrincipal.panelIzquierdo);
    }
}
