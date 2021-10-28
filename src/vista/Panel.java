package vista;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    public Panel(){
        this.setVisible(true);
        this.setSize(500,50);
        this.setBackground(Color.darkGray);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setFont(new Font("Arial", 0, 20));
        g.setColor(Color.WHITE);
        g.drawString("CORRUPTOR DE ARCHIVOS",80,30);
    }

}
