package juegoCraps;

import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame {
    //atributos

    //metodos

    public GUI() {
        intGUI();
        //configurar ventana
        this.setTitle("Mi presentación");
        this.setSize(600, 540);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void intGUI() {
    }


    public static void main(String[] args) {
        // Ejecución del programa

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                GUI presentacion = new GUI();
            }

        });
    }
}
