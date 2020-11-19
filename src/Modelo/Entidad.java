package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class Entidad {
    public static HashMap<Integer, String> hmEntidades;
    ConexionBD conexionBD;

    public Entidad(){
        hmEntidades = new HashMap<>();

        try {
            //Abrir conexion
            conexionBD = new ConexionBD();

            Connection conn = conexionBD.getConn();

            String queryEntidad = "SELECT Entidad_Clave, Entidad_Nombre FROM entidadcat";


            //Ejecuto query para traer la lista de entidades
            PreparedStatement qStatement = conn.prepareStatement(queryEntidad);
            ResultSet rs = qStatement.executeQuery();

            int i = 0;

            while(rs.next()){
                //System.out.println("Revisa resultado de query"+String.valueOf(i));
                //System.out.println(rs.getInt(1));
                //System.out.println(rs.getString(2));
                hmEntidades.put(i,rs.getString(2));
                i++;
            }

            System.out.println(i);


            //hmEntidades.put(0, "Jalisco");
            //hmEntidades.put(1, "Merida");
            //hmEntidades.put(2, "CDMX");
            //hmEntidades.put(3, "Oaxaca");



            //Cerrar conexion
        }catch (Exception e){

        }
    }
}
