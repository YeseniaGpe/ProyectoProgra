package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class QueryData {
    ConexionBD conectarBD = new ConexionBD();

    public QueryData(){
    }

    public void numberQuery(String entidad, int sexo, String filtro){
        String numeroQ = "0";

        System.out.println("Entidad: "+entidad);
        System.out.println("Sexo: "+ sexo);
        System.out.println("filtro: "+ filtro);

        int claveEntidad=0;

        for(int i=1;i<Entidad.hmEntidades.size();i++) {
            if(Entidad.hmEntidades.get(i)==entidad){
                System.out.println(Entidad.hmEntidades.get(i));
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
                numeroQ= String.valueOf(rs.getInt(1));
            }

            conectarBD.DesconexionBD();

        }catch(Exception e){
            System.out.println("Error al ejecutar query.");
            conectarBD.DesconexionBD();
        }

        //return numeroQ;
    }

    public void arrayQuery(String entidad, int sexo){

        try{
            conectarBD = new ConexionBD();
            Connection conn = conectarBD.getConn();

            HashMap<Integer, String> hashMapRangos = new HashMap<>();
            HashMap<Integer, String> hashMapEdades = new HashMap<>();

            hashMapRangos.put(1,"20 and 29");
            hashMapRangos.put(2,"30 and 39");
            hashMapRangos.put(3,"40 and 49");
            hashMapRangos.put(4,"50 and 59");
            hashMapRangos.put(5,"60 and 69");
            hashMapRangos.put(6,"70 and 100");

            for (int i = 1;i<7;i++){
                String queryDatosCovid = "select count(*) from datoscovid where entidad = "
                        + entidad + " and sexo = " + sexo +" and edad between "+hashMapRangos.get(i)+" ";

                PreparedStatement qStatement = conn.prepareStatement(queryDatosCovid);
                ResultSet rs = qStatement.executeQuery();

                while(rs.next()){
                    hashMapEdades.put(i, String.valueOf(rs.getInt(1)));
                }
            }

            for(int i=1;i<7;i++){
                System.out.println(hashMapEdades.get(i));
            }

            conectarBD.DesconexionBD();

        }catch(Exception e){
            System.out.println("Error al ejecutar query.");
            conectarBD.DesconexionBD();
        }

        //return numeroQ;
    }
}