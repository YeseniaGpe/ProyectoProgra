package Prueba;

import Modelo.ConexionBD;
import Modelo.QueryData;
import Vista.Ventana;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        QueryData queryData = new QueryData();
        queryData.numberQuery("9","1","obesidad");

        queryData.arrayQuery("9","1");

        Vista.Ventana ventanaPrincipal = new Vista.Ventana();
        ventanaPrincipal.setVisible(true);
    }
}
