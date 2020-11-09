package Vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        super("Covid-19 en México");
        setSize(800,430);
        setResizable(true);
        setLocation(400,200);

        PanelControl panelIzquierdo  = new PanelControl();
        PanelGrafica panelDerecho = new PanelGrafica();

        setLayout(new GridLayout(1,2));

        this.add(panelIzquierdo);
        this.add(panelDerecho);
    }
}
