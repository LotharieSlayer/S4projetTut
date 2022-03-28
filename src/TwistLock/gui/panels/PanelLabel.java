package TwistLock.gui.panels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import TwistLock.Main;


public class PanelLabel extends JPanel{
    private JLabel label;
    private JLabel image;

    public PanelLabel(Main instance){

        image = new JLabel("C'est au tour de Lothaire", new ImageIcon("./res/labels/j1.png"), SwingConstants.CENTER);
        add(image);
    }
}
