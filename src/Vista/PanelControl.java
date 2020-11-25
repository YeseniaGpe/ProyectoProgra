package Vista;

import Modelo.Entidad;
import javax.swing.*;
import java.awt.*;

public class PanelControl extends JPanel {
    //En esta sección declaramos atributos de la clase
    static JPanel segundoSubPanel;
    public JComboBox <String> elegirEstado;
    public ButtonGroup grupoSexo;
    static JLabel etiquetaSexo;
    static JRadioButton sexoFemenino;
    static JRadioButton sexoMasculino;
    static JRadioButton sexoAmbos;
    static JLabel etiquetaFiltro;
    public ButtonGroup grupoFiltro;
    static JRadioButton EPOC;
    static JRadioButton asma;
    static JRadioButton hipertension;
    static JRadioButton obesidad;
    static JRadioButton edad;
    static JRadioButton ninguno;
    public JButton botonMostrarGrafico;
    public JButton botonMostrarArchivo;

    //Inicio del constructor de la clase
    public PanelControl() {

        //LLamado a lista con los estados
        Entidad listaEstados = new Entidad();

        //Declaración del panel y sus componentes
        JPanel panelVacio =new JPanel();
        panelVacio.setPreferredSize(new Dimension(350,20));

        botonMostrarGrafico = new JButton("Mostrar gráfico");
        botonMostrarGrafico.setPreferredSize(new Dimension(160,20));

        botonMostrarArchivo = new JButton("Mostrar conclusiones");
        botonMostrarArchivo.setPreferredSize(new Dimension(160,20));

        JPanel panelDos =new JPanel();
        panelDos.setPreferredSize(new Dimension(420,30));

        segundoSubPanel = new JPanel();
        segundoSubPanel.setPreferredSize(new Dimension(350,300));

        //Se llena la lista de estados en el ComboBox desde el HashMap hmEntidades
        elegirEstado = new JComboBox<>();
        elegirEstado.setPreferredSize(new Dimension(350,20));
        try {
            elegirEstado.removeAllItems();
            for(int contador = 0; contador< listaEstados.hmEntidades.size(); contador++) {
                elegirEstado.addItem(listaEstados.hmEntidades.get(contador));
            }
        }catch (Exception exCombo) {
            JOptionPane.showMessageDialog(null,"Por favor, valida la conexión a la " +
                    "base de datos","Atención",JOptionPane.WARNING_MESSAGE);
        }

        //Requerido para dar el formato deseado a la tipografía
        Font fuenteTitulos = new Font("Arial", 1, 20);
        Font fuenteOpciones = new Font("Arial",4,14);

        //Declara y añade botones de grupoSexo
        grupoSexo =new ButtonGroup();

        etiquetaSexo = new JLabel("Sexo");
        sexoFemenino = new JRadioButton("Femenino",false);
        sexoMasculino = new JRadioButton("Masculino",false);
        sexoAmbos = new JRadioButton("Ambos",false);

        grupoSexo.add(sexoFemenino);
        grupoSexo.add(sexoMasculino);
        grupoSexo.add(sexoAmbos);


        //Declara y añade botones de grupoFiltro
        grupoFiltro = new ButtonGroup();

        etiquetaFiltro = new JLabel("Filtro");
        EPOC = new JRadioButton("EPOC",false);
        asma = new JRadioButton("Asma",false);
        hipertension = new JRadioButton("Hipertensión",false);
        obesidad = new JRadioButton("Obesidad",false);
        edad = new JRadioButton("Edad",false);
        ninguno = new JRadioButton("Ninguno",false);

        grupoFiltro.add(EPOC);
        grupoFiltro.add(asma);
        grupoFiltro.add(hipertension);
        grupoFiltro.add(obesidad);
        grupoFiltro.add(edad);
        grupoFiltro.add(ninguno);

        //Da formato a la tipografía de todos los elementos del panel
        etiquetaSexo.setFont(fuenteTitulos);
        etiquetaFiltro.setFont(fuenteTitulos);
        sexoFemenino.setFont(fuenteOpciones);
        sexoMasculino.setFont(fuenteOpciones);
        sexoAmbos.setFont(fuenteOpciones);
        EPOC.setFont(fuenteOpciones);
        asma.setFont(fuenteOpciones);
        hipertension.setFont(fuenteOpciones);
        obesidad.setFont(fuenteOpciones);
        edad.setFont(fuenteOpciones);
        ninguno.setFont(fuenteOpciones);

        //Añade los elementos del primer SubPanel
        segundoSubPanel.setLayout(new GridLayout(10,2));
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(etiquetaSexo);
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(sexoFemenino);
        segundoSubPanel.add(sexoMasculino);
        segundoSubPanel.add(sexoAmbos);
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(etiquetaFiltro);
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(EPOC);
        segundoSubPanel.add(asma);
        segundoSubPanel.add(hipertension);
        segundoSubPanel.add(obesidad);
        segundoSubPanel.add(edad);
        segundoSubPanel.add(ninguno);
        segundoSubPanel.add(new JLabel());
        segundoSubPanel.add(new JLabel());

        //Añade los elementos del segundo SubPanel
        panelDos.add(botonMostrarGrafico,BorderLayout.WEST);
        panelDos.add(botonMostrarArchivo,BorderLayout.EAST);

        //Añade los elementos del panelControl
        this.add(panelVacio,BorderLayout.NORTH);
        this.add(elegirEstado);
        this.add(segundoSubPanel,BorderLayout.CENTER);
        this.add(panelDos);
    }
}
