package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    private Connection conn;

    //Constructor de conexion a BD.
    public ConexionBD(){
        //Atributos que definen los parámetros de la conexión a la BD.
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/pruebapoo";
        conn = null;

        try{
            //Ejecuta conexión a la base de datos.
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);

        }catch (Exception e){
            //Notifica en línea de comando de una excepción.
            JOptionPane.showMessageDialog(null,"Por favor, " +
                    "valida la conexión a la BD.","Atención", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Método para obtener el ID de una conexión a BD existente.
    public Connection getConn() {
        return conn;
    }

    //Método para cerrar una conexión a BD existente.
    public void DesconexionBD(){
        conn = null;
    }
}