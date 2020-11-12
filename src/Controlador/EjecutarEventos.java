package Controlador;

import Modelo.QueryData;
import Vista.PanelControl;
import Vista.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjecutarEventos implements ActionListener{
    PanelControl ventana = new PanelControl();
    //Ventana ventana = new Ventana();

    public EjecutarEventos(PanelControl ventana){
        this.ventana = ventana;
        this.ventana.  botonMostrarGrafico.addActionListener(this);

        System.out.println("Hola Yesenia");
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
    }
}
