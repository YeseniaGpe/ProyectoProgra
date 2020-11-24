package Vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public PanelControl panelIzquierdo;
    public static JPanel panelDerecho;


    public Ventana() {
        super("COVID-19 en México");
        setSize(900,430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(400,200);

        panelIzquierdo  = new PanelControl();
        panelDerecho = new JPanel();

        setLayout(new GridLayout(1,2));


        this.add(panelIzquierdo);
        this.add(panelDerecho);
    }
}