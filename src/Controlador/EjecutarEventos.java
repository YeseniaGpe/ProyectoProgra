package Controlador;

import Modelo.QueryData;
import Vista.PanelControl;
import Modelo.Entidad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjecutarEventos implements ActionListener{
    PanelControl ventana = new PanelControl();
    Entidad listaEstados = new Entidad();

    //Ventana ventana = new Ventana();

    public EjecutarEventos(PanelControl ventana){
        this.ventana = ventana;
        this.listaEstados = listaEstados;
        this.ventana.botonMostrarGrafico.addActionListener(this);
        this.ventana.elegirEstado.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("Boton presionado");
        //System.out.println(e.getSource());

        if (e.getSource()== ventana.botonMostrarGrafico){
            try {
                System.out.println("Inicia Ejecutar Evento");
                QueryData queryData = new QueryData();
                queryData.numberQuery("9", "1", "obesidad");
                queryData.arrayQuery("9", "1");
            }catch (Exception ex){
                System.out.println("Error Ejecutar Evento");
            }
        }
        else if(e.getSource() == ventana.elegirEstado) {
            try {
                ventana.elegirEstado.removeAllItems();
                for(int contador=0; contador<listaEstados.listaEntidades.size();contador++) {
                    ventana.elegirEstado.addItem(listaEstados.listaEntidades.get(contador).getListaEntidades());
                }
            }catch (Exception exCombo) {
                System.out.println("Error al leer los estados desde la base de datos");
            }
        }
    }
}
