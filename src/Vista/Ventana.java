package Vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public PanelControl panelIzquierdo;
    public PanelGrafica graficoBarras;


    public Ventana() {
        super("COVID-19 en México");
        setSize(900,430);
        setResizable(true);
        setLocation(400,200);

        panelIzquierdo  = new PanelControl();
        graficoBarras = new PanelGrafica();

        setLayout(new GridLayout(1,2));

        this.add(panelIzquierdo);
        this.add(graficoBarras.createDataset());
    }
}