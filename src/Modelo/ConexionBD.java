package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    private Connection conn;

    public ConexionBD(){
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/pruebapoo";
        conn = null;

        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);

            if (conn != null){
                System.out.println("Conexión exitosa");
            }
        }catch (Exception e){
            System.out.println("Abre conexión");
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void DesconexionBD(){
        conn = null;
        System.out.println("Cierra conexión");
    }
}