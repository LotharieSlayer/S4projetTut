package TwistLock.gui.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

import TwistLock.Main;

public class PanelTablier extends JPanel{

    private JLabel label;

    public PanelTablier(Main instance){
        // GridLayout grid = new GridLayout(1,2);
        label = new JLabel("pipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipipi");
        add(label);
    }
}
