package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class QueryData {
    //Atributos de la clase QueryData
    private HashMap<Integer, Integer> hashMapResultado;

    //Objeto ConexionBD utilizado por los métodos de esta clase.
    ConexionBD conectarBD;
    Connection conn;

    //Clave de entidad.
    int claveEntidad;

    //Constructor QueryData.
    public QueryData(){
    }

//    public HashMap<Integer, Integer> arrayQuery(String entidad, int sexo, String filtro) {
    public void arrayQuery(String entidad, int sexo, String filtro) {
        //HashMap que contiene resultado de ejecutar query.
        //HashMap<Integer, Integer> hashMapResultado;

        //Bandera de existencia. false -> No Existe.
        boolean bEntidad = false, bSexo = false;

        System.out.println("Entidad para query: " + entidad);

        //Query a ejecutar.
        String queryDatosCovid = "select count(*) from datoscovid ", queryEdades;

        //Obtiene clave de entidad.
        claveEntidad = Entidad.getClaveEntidad(entidad);

        //Valida dato de la entidad.
        if (claveEntidad != 0) {
            queryDatosCovid = queryDatosCovid.concat(" where entidad = " + claveEntidad + " ");

            //Bandera de existencia de entidad. true -> Existe.
            bEntidad = true;
        }

        //Valida dato de sexo.
        if (sexo == 1 || sexo == 2) {
            //Bandera de existencia de sexo. true -> Existe.
            bSexo = true;

            //Existe condicion previa en clausula WHERE?
            if (bEntidad) {
                //Se agrega AND a clausula WHERE
                queryDatosCovid = queryDatosCovid.concat("and sexo = " + sexo + " ");
            }
            else {
                //Agrega query valor sexo.
                queryDatosCovid = queryDatosCovid.concat("where sexo = " + sexo + " ");
            }

        }

        //Crea atributo hashmapResultado.
        hashMapResultado = new HashMap<>();

        if (!filtro.equals("")) {
            try {
                //Conecta con base de datos.
                conectarBD = new ConexionBD();
                conectarBD.abreConexion();

                //Obtiene ID de conexión.
                conn = conectarBD.getConexion();

                if (filtro.equals("Edad")) {

                    //HashMap con rangos de edades para queryEdades.
                    HashMap<Integer, String> hashMapRangos = new HashMap<>();
                    hashMapRangos.put(1, "20 and 29");
                    hashMapRangos.put(2, "30 and 39");
                    hashMapRangos.put(3, "40 and 49");
                    hashMapRangos.put(4, "50 and 59");
                    hashMapRangos.put(5, "60 and 69");
                    hashMapRangos.put(6, "70 and 100");

                    if(bEntidad || bSexo) {
                            queryDatosCovid = queryDatosCovid.concat(" and ");
                    }
                    else {
                            queryDatosCovid = queryDatosCovid.concat(" where ");
                    }

                    for (int i = 1; i < 7; i++) {
                        //Crea query de edades.
                        queryEdades = queryDatosCovid + "edad between " + hashMapRangos.get(i);

                        System.out.println(queryEdades);

                        //Ejecuta query de edades.
                        PreparedStatement qStatement = conn.prepareStatement(queryEdades);
                        ResultSet rs = qStatement.executeQuery();

                        //Guarda resultados de query en arreglo HashMap.
                        while (rs.next()) {
                            hashMapResultado.put(i, rs.getInt(1));
                        }
                    }

                }else{
                    //Elimina acento de Hipertensión para usar el texto en query de BD.
                    if (filtro.equals("Hipertensión")) {
                        filtro = "Hipertension";
                    }

             //       if(!filtro.equals("Ninguno")) {

                        //Valida si existe alguna condicion en clausula WHERE.
                        if (bEntidad || bSexo) {
                            if(!filtro.equals("Ninguno")) {
                                //Se agrega AND a clausula WHERE
                                queryDatosCovid = queryDatosCovid.concat("and ");
                            }
                        }
                        else {
                            if(!filtro.equals("Ninguno")) {
                                queryDatosCovid = queryDatosCovid.concat("where ");
                            }

                        }
                        if(!filtro.equals("Ninguno")) {
                            //Completa clausula WHERE.
                            queryDatosCovid = queryDatosCovid + filtro + " = 1;";
                        }


                    //Ejecuta query.
                    System.out.println(queryDatosCovid);
                    PreparedStatement qStatement = conn.prepareStatement(queryDatosCovid);
                    ResultSet rs = qStatement.executeQuery();

                    //Recupera uno a uno los registros devueltos por el query.
                    //Arma HashMap con respuesta.
                    while (rs.next()) {
                        System.out.println(rs.getInt(1));
                        hashMapResultado.put(1, rs.getInt(1));
                    }
                }


                //Termina conexión con based de datos.
                conectarBD.cierraConexion();

            } catch(Exception e) {
                //Notifica en línea de comando de una excepción.
                JOptionPane.showMessageDialog(null,"Por favor, " +
                        "valida la conexión a la BD.","Atención", JOptionPane.WARNING_MESSAGE);

                //En caso de que exista una conexión abierta a la BD aquí se cierra.
                conectarBD.cierraConexion();
            }
        }

        //return hashMapResultado;
    }

    public HashMap<Integer, Integer> getHashMapResultado() {
        return hashMapResultado;
    }
}