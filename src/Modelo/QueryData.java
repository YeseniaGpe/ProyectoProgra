package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class QueryData {
    ConexionBD conectarBD = new ConexionBD();

    public QueryData(){
    }

    public HashMap numberQuery(String entidad, int sexo, String filtro){
        HashMap<Integer,Integer> numeroQ = new HashMap<>();
        //int numeroQ = 0;

        System.out.println("Entidad: "+entidad);
        System.out.println("Sexo: "+ sexo);
        System.out.println("filtro: "+ filtro);

        int claveEntidad=0;

        for(int i=1;i<Entidad.hmEntidades.size();i++) {
            if(Entidad.hmEntidades.get(i)==entidad){
                claveEntidad=i;
            }
        }

        try{
            conectarBD = new ConexionBD();
            Connection conn = conectarBD.getConn();
            String queryDatosCovid = "select count(*) from datoscovid where entidad = "
                    + claveEntidad + " and sexo = " + sexo +" and "+ filtro+" = 1";

            System.out.println(queryDatosCovid);

            PreparedStatement qStatement = conn.prepareStatement(queryDatosCovid);
            ResultSet rs = qStatement.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt(1));
                numeroQ.put(1,rs.getInt(1));
            }

            conectarBD.DesconexionBD();

        }catch(Exception e){
            System.out.println("Error al ejecutar query.");
            conectarBD.DesconexionBD();
        }

        return numeroQ;
    }

    public HashMap arrayQuery(String entidad, int sexo) {

        HashMap<Integer, Integer> hashMapEdades = null;
        try {
            conectarBD = new ConexionBD();
            Connection conn = conectarBD.getConn();

            int claveEntidad = 0;

            for (int i = 1; i < Entidad.hmEntidades.size(); i++) {
                if (Entidad.hmEntidades.get(i) == entidad) {
                    System.out.println(Entidad.hmEntidades.get(i));
                    claveEntidad = i;
                }
            }

            HashMap<Integer, String> hashMapRangos = new HashMap<>();
            hashMapEdades = new HashMap<>();

            hashMapRangos.put(1, "20 and 29");
            hashMapRangos.put(2, "30 and 39");
            hashMapRangos.put(3, "40 and 49");
            hashMapRangos.put(4, "50 and 59");
            hashMapRangos.put(5, "60 and 69");
            hashMapRangos.put(6, "70 and 100");

            for (int i = 1; i < 7; i++) {
                String queryDatosCovid = "select count(*) from datoscovid where entidad = "
                        + claveEntidad + " and sexo = " + sexo + " and edad between " + hashMapRangos.get(i);

                System.out.println(queryDatosCovid);

                PreparedStatement qStatement = conn.prepareStatement(queryDatosCovid);
                ResultSet rs = qStatement.executeQuery();

                while (rs.next()) {
                    hashMapEdades.put(i, rs.getInt(1));
                }
            }

            for (int i = 1; i < 7; i++) {
                System.out.println(hashMapEdades.get(i));
            }

            conectarBD.DesconexionBD();

        } catch (Exception e) {
            System.out.println("Error al ejecutar query.");
            conectarBD.DesconexionBD();
        }

        return hashMapEdades;
    }
}