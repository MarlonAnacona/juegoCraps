package juegoCraps;

import javax.swing.*;
import java.awt.*;

public class Header extends JLabel {
    public Header(String GUI, Color colorFondo) {
        {

            this.setText(GUI);
            this.setBackground(colorFondo);

            this.setForeground(Color.white);
            this.setFont(new Font(Font.DIALOG, Font.BOLD + Font.ITALIC, 24));
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setOpaque(true);

        }
    }
}