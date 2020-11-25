package Vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    //Crea los atributos del Frame
    public PanelControl panelIzquierdo;
    public static JPanel panelDerecho;

    //Construye el Frame
    public Ventana() {
        super("COVID-19 en México :: Yesenia Oliva ::" +
                " Edgar Luque :: Mauricio Flores :: Programación Orientada a Objetos :: Otoño 2020");
        setSize(900,460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocation(400,200);

        panelIzquierdo  = new PanelControl();
        panelDerecho = new JPanel();

        //Acomoda e inserta los paneles en el Frame
        setLayout(new GridLayout(1,2));
        this.add(panelIzquierdo);
        this.add(panelDerecho);
    }
}