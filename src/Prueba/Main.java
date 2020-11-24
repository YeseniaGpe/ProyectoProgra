package Prueba;

import Controlador.EjecutarEventos;

public class Main {
    public static void main(String[] args) {
        Vista.Ventana ventanaPrincipal = new Vista.Ventana();
        ventanaPrincipal.setVisible(true);

        //Agrega acción de mostrar gráfica.
        EjecutarEventos ejecutaEvento = new EjecutarEventos(ventanaPrincipal.panelIzquierdo);
    }
}
