package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class Entidad {
    //Atributo tipo HashMap con clave y nombre de entidad.
    private static HashMap<Integer, String> hmEntidades;

    //Clave de entidad
    private static int claveEntidad;

    //Atributo tipo ConexionBD para interactuar con la BD.
    ConexionBD conexionBD;

    //Constructor de objeto Entidad. Genera lista de entidades.
    public Entidad(){
        //Crea instancia de arreglo hashmap para entidad.
        hmEntidades = new HashMap<>();

        try {
            //Abre conexión a la BD.
            conexionBD = new ConexionBD();
            conexionBD.abreConexion();

            //Obtiene ID de conexión a la BD.
            Connection conn = conexionBD.getConexion();//ConexionBD.getConn();//conexionBD.getConn();

            //Query para obtener lista de entidades.
            String queryEntidad = "SELECT Entidad_Clave, Entidad_Nombre FROM entidadcat";

            //Ejecuta query.
            PreparedStatement qStatement = conn.prepareStatement(queryEntidad);
            ResultSet rs = qStatement.executeQuery();

            //Alimenta lista de entidad.
            int i = 1;
            hmEntidades.put(0,"ENTIDAD");
            while(rs.next()){
                hmEntidades.put(i,rs.getString(2));
                i++;
            }

            //Termina conexion con BD.
            conexionBD.cierraConexion();

        }catch (Exception e){
            //Notifica en línea de comando de una excepción.
            JOptionPane.showMessageDialog(null,"Por favor, " +
                    "valida la conexión a la BD.","Atención", JOptionPane.WARNING_MESSAGE);

            //En caso de que exista conexíón abierta a la BD aquí se cierra.
            conexionBD.cierraConexion();
        }
    }

    public static HashMap<Integer, String> getHmEntidades() {
        new Entidad();
        return hmEntidades;
    }

    //Método para obtener la clave de entidad a partir de su nombre.
    public static int getClaveEntidad(String entidad) {
        //Inicializa clave de entidad.
        claveEntidad = 0;

        //Valida dato de la entidad.
        if(!entidad.equals("ENTIDAD")){
            for (int i = 1; i < Entidad.hmEntidades.size(); i++) {
                //Encuentra la clave de la entidad a partir de su nombre.
                if (Entidad.hmEntidades.get(i).equals(entidad)) {
                    claveEntidad = i;
                }
            }
        }

        return claveEntidad;
    }
}