package Modelo;

import java.util.ArrayList;

public class Entidad {
    ArrayList <String> listaEntidades;

    public Entidad(){
    listaEntidades = new ArrayList<>();
            listaEntidades.add("Jalisco");
            listaEntidades.add("Merida");
            listaEntidades.add("CDMX");
            listaEntidades.add("Oaxaca");
    }

    public ArrayList<String> getListaEntidades() {
        return listaEntidades;
    }
}
