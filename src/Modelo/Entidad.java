package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class Entidad {
    public static HashMap<Integer, String> hmEntidades;
    ConexionBD conexionBD;

    public Entidad(){
        hmEntidades = new HashMap<>();

        try {
            conexionBD = new ConexionBD();
            Connection conn = conexionBD.getConn();
            String queryEntidad = "SELECT Entidad_Clave, Entidad_Nombre FROM entidadcat";

            PreparedStatement qStatement = conn.prepareStatement(queryEntidad);
            ResultSet rs = qStatement.executeQuery();

            int i = 0;

            while(rs.next()){
                hmEntidades.put(i,rs.getString(2));
                i++;
            }

            conexionBD.DesconexionBD();

        }catch (Exception e){
            System.out.println("Error al recuperar lista de entidades de la BD.");
        }
    }
}