package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Entidad {
    public static HashMap<Integer, String> hmEntidades;

    public Entidad(){
        hmEntidades = new HashMap<>();
            hmEntidades.put(0,"Jalisco");
            hmEntidades.put(1,"Merida");
            hmEntidades.put(2,"CDMX");
            hmEntidades.put(3,"Oaxaca");
    }
}
