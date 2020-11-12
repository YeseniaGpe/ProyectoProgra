package Vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        super("COVID-19 en México");
        setSize(900,430);
        setResizable(true);
        setLocation(400,200);

        PanelControl panelIzquierdo  = new PanelControl();
        //PanelGrafica grafico = new PanelGrafica();
        JPanel panelDerecho = new JPanel();



        setLayout(new GridLayout(1,2));

        this.add(panelIzquierdo);
       this.add(panelDerecho);
    }
}