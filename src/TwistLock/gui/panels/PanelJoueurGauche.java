package TwistLock.gui.panels;

import javax.swing.JPanel;
import java.awt.GridLayout;


import TwistLock.Main;

public class PanelJoueurGauche extends JPanel{

    private PanelJoueur joueur1;
    private PanelJoueur joueur3;

    public PanelJoueurGauche(Main instance){
        setLayout(new GridLayout(2,1));
        joueur1 = new PanelJoueur(instance);
        joueur3 = new PanelJoueur(instance);
        add(joueur1);
        add(joueur3);
    }
}