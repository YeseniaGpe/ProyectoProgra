package Controlador;

import Controlador.EjecutarEventos;
import Modelo.Entidad;

public class Main {
    public static void main(String[] args) {
        //Genera interfaz de usuario del sistema.
        Vista.Ventana ventanaPrincipal = new Vista.Ventana();
        ventanaPrincipal.setVisible(true);

        //Requerido para habilitar monitoreo de eventos.
        EjecutarEventos ejecutaEvento = new EjecutarEventos(ventanaPrincipal.panelIzquierdo);

    }
}
