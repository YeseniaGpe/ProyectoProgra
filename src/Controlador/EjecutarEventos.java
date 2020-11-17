package Controlador;

import Modelo.QueryData;
import Vista.PanelControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjecutarEventos implements ActionListener{
    PanelControl ventana = new PanelControl();

    public EjecutarEventos(PanelControl ventana){
        this.ventana = ventana;
        this.ventana.botonMostrarGrafico.addActionListener(this);
        this.ventana.elegirEstado.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        //System.out.println("Boton presionado");
        //System.out.println(e.getSource());

        if (e.getSource()== ventana.botonMostrarGrafico){
            try {
                System.out.println(ventana.elegirEstado.getSelectedItem());
                System.out.println(ventana.sexoFemenino.isSelected());
                System.out.println(ventana.sexoMasculino.isSelected());
                System.out.println("Inicia Ejecutar Evento");
                QueryData queryData = new QueryData();
                queryData.numberQuery("9", "1", "obesidad");
                queryData.arrayQuery("9", "1");
            }catch (Exception ex){
                System.out.println("Error Ejecutar Evento");
            }

        }
    }
}
