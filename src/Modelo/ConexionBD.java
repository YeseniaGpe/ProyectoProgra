package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/pruebapoo";

    public ConexionBD(){
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

    public static Connection getConn() {
        return conn;
    }

    public void DesconexionBD(){
        conn = null;
        System.out.println("Cierra conexión");
    }
}