package TwistLock.gui.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

import TwistLock.Main;


public class PanelLabel extends JPanel{
    private JLabel label;


    public PanelLabel(Main instance){
        label = new JLabel("C'est à joueur 1 de joueur");
        add(label);
    }
}
