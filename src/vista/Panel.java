package vista;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private Image worldMap = new ImageIcon(getClass().getResource("/images/archivoCorrupto.png")).getImage();

    public Panel(){
        this.setVisible(true);
        this.setSize(500,250);
        this.setBackground(Color.darkGray);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(worldMap,100,0,null);
    }

}
