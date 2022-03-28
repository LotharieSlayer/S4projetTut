package TwistLock.gui.panels;

import javax.swing.JPanel;
import java.awt.GridLayout;


import TwistLock.Main;

public class PanelJoueurDroite extends JPanel{

    private PanelJoueur joueur2;
    private PanelJoueur joueur4;

    public PanelJoueurDroite(Main instance){
        setLayout(new GridLayout(2,1));
        joueur2 = new PanelJoueur(instance, "vert");
        joueur4 = new PanelJoueur(instance, "jaune");
        add(joueur2);
        add(joueur4);
    }
}