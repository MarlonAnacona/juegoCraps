package juegoCraps;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    //atributos
    private static final String MENSAJE_INICIO="BIENVENIDO A CRAPS \n"
            +"Oprime el boton lanzar para iniciar el juego"+
            "\n si tu tiro de salida es 7 u 11 ganas con natural"
            +"\nSi tu tio de salida es 2,3 u 12 pierdes con craps"
            +"\nSi sacas cualquier otro valor estableceras punto"
            +"\n Estado en punto podras seguir  lanzando dados"
            +"\npero ahora ganarás si sacas  nuevamente el valor de punto"
            +"\n sin que previamente hayas sacado 7";
    private Header headerProject;
    private JLabel dado1,dado2;
    private  JButton lanzar;
    private JPanel panelDados,panelResultados;
    private ImageIcon imagendDado;
    private  JTextArea mensajeSalida,resultadosDados;
    private JSeparator separador;
    private Escucha escucha;
    private modelCraps modelCraps;
    //metodos

    public GUI() {
        intGUI();
        //configurar ventana
        this.setTitle("Juego Craps");
        this.pack();
        this.setResizable(true);
        //this.setSize(600, 540);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void intGUI() {
    //create listener object or control object
        escucha= new Escucha();
        modelCraps=new modelCraps();
        //set up Jcomponents
        headerProject= new Header("Mesa Juego craps",Color.black);
        this.add(headerProject,BorderLayout.NORTH);


        imagendDado= new ImageIcon(getClass().getResource("/resources/dado.png"));
        dado1= new JLabel(imagendDado);
        dado2= new JLabel(imagendDado);

        lanzar =new JButton("lanzar");
        lanzar.addActionListener(escucha);

        panelDados= new JPanel();
        panelDados.setPreferredSize(new Dimension(300,180));
        panelDados.setBorder(BorderFactory.createTitledBorder("Tus dados "));

        panelDados.add(dado1);
        panelDados.add(dado2);
        panelDados.add(lanzar);
        this.add(panelDados,BorderLayout.CENTER);

        mensajeSalida= new JTextArea(7,31);
        mensajeSalida.setText(MENSAJE_INICIO);
        //mensajeSalida.setBorder(BorderFactory.createTitledBorder("Que debes hacer "));
        JScrollPane scrrol= new JScrollPane(mensajeSalida);

        panelResultados=new JPanel();
        panelResultados.setBorder(BorderFactory.createTitledBorder("Que debes hacer "));
        panelResultados.add(scrrol);
        panelResultados.setPreferredSize(new Dimension(370,180));
        this.add(panelResultados ,BorderLayout.EAST);
        resultadosDados= new JTextArea(4,31);
        separador= new JSeparator();
        separador.setPreferredSize(new Dimension(320,7));
        separador.setBackground(Color.BLUE);

    }


    public static void main(String[] args) {
        // Ejecución del programa

        EventQueue.invokeLater(()-> {


                GUI presentacion = new GUI();


        });

    }

    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            modelCraps.calcularTiro();
            int[] caras= modelCraps.getCaras();
            imagendDado= new ImageIcon(getClass().getResource("/resources/"+caras[0]+".png"));
            dado1.setIcon(imagendDado);
            imagendDado= new ImageIcon(getClass().getResource("/resources/"+caras[1]+".png"));
            dado2.setIcon(imagendDado);
            modelCraps.determinarJuego();

            panelResultados.removeAll();
            panelResultados.setBorder(BorderFactory.createTitledBorder("Resultados "));
            panelResultados.add(resultadosDados);
            panelResultados.add(separador);
            panelResultados.add(mensajeSalida);
            resultadosDados.setText(modelCraps.getEstadoToString()[0]);
            mensajeSalida.setRows(4);
            mensajeSalida.setText(modelCraps.getEstadoToString()[1]);
        revalidate();
        repaint();

        }
    }
}
