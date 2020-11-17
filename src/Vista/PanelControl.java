package Vista;

import Controlador.EjecutarEventos;

import javax.swing.*;
import java.awt.*;

public class PanelControl extends JPanel {
    public JPanel segundoSubPanel;
    public JComboBox <String> elegirEstado;
    public ButtonGroup grupoSexo;
    public JLabel etiquetaSexo;
    public JRadioButton sexoFemenino;
    public JRadioButton sexoMasculino;
    public JLabel etiquetaPadecimiento;
    public ButtonGroup grupoPadecimiento;
    public JRadioButton EPOC;
    public JRadioButton asma;
    public JRadioButton hipertension;
    public JRadioButton obesidad;
    public JRadioButton edad;
    public JButton botonMostrarGrafico;

    public PanelControl() {

        JPanel panelVacio =new JPanel();
        panelVacio.setPreferredSize(new Dimension(350,20));

        botonMostrarGrafico = new JButton("Mostrar gráfico");
        botonMostrarGrafico.setPreferredSize(new Dimension(300,20));

        JPanel panelVacioDos =new JPanel();
        panelVacioDos.setPreferredSize(new Dimension(350,20));

        segundoSubPanel = new JPanel();
        segundoSubPanel.setPreferredSize(new Dimension(350,300));

        elegirEstado = new JComboBox<String>();
        elegirEstado.setPreferredSize(new Dimension(350,20));

        Font fuenteTitulos = new Font("Arial", 1, 20);
        Font fuenteOpciones = new Font("Arial",4,14);

        grupoSexo =new ButtonGroup();
        etiquetaSexo = new JLabel("Sexo");
        sexoFemenino = new JRadioButton("Femenino",false);
        sexoMasculino = new JRadioButton("Masculino",false);

        grupoSexo.add(sexoFemenino);
        grupoSexo.add(sexoMasculino);

        grupoPadecimiento = new ButtonGroup();
        etiquetaPadecimiento = new JLabel("Padecimiento");
        EPOC = new JRadioButton("EPOC",false);
        asma = new JRadioButton("Asma",false);
        hipertension = new JRadioButton("Hipertensión",false);
        obesidad = new JRadioButton("Obesidad",false);
        edad = new JRadioButton("Edad",false);

        etiquetaSexo.setFont(fuenteTitulos);
        etiquetaPadecimiento.setFont(fuenteTitulos);
        sexoFemenino.setFont(fuenteOpciones);
        sexoMasculino.setFont(fuenteOpciones);
        EPOC.setFont(fuenteOpciones);
        asma.setFont(fuenteOpciones);
        hipertension.setFont(fuenteOpciones);
        obesidad.setFont(fuenteOpciones);
        edad.setFont(fuenteOpciones);
        
        grupoPadecimiento.add(EPOC);
        grupoPadecimiento.add(asma);
        grupoPadecimiento.add(hipertension);
        grupoPadecimiento.add(obesidad);
        grupoPadecimiento.add(edad);

        segundoSubPanel.setLayout(new GridLayout(9,2));
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(etiquetaSexo);
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(sexoFemenino);
        segundoSubPanel.add(sexoMasculino);
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(etiquetaPadecimiento);
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(EPOC);
        segundoSubPanel.add(asma);
        segundoSubPanel.add(hipertension);
        segundoSubPanel.add(obesidad);
        segundoSubPanel.add(edad);
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(new JLabel());

        this.add(panelVacio,BorderLayout.NORTH);
        this.add(elegirEstado);
        this.add(segundoSubPanel,BorderLayout.CENTER);
        this.add(botonMostrarGrafico);
        this.add(panelVacioDos);
    }
}
