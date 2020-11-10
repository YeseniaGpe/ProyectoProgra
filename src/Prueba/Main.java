package Prueba;

import Modelo.ConexionBD;
import Vista.Ventana;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConexionBD conectar = new ConexionBD();
        // Temporal -- Conexion a Base de Datos.
        ConexionBD bdConectar = new ConexionBD();
        Connection conn = bdConectar.getConn();
        bdConectar.DesconexionBD();
        conn = bdConectar.getConn();
        // Termina Temporal


        Vista.Ventana ventanaPrincipal = new Vista.Ventana();
        ventanaPrincipal.setVisible(true);


    }
}
