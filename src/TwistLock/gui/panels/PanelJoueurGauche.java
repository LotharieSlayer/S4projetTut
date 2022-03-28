package TwistLock.gui.panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;


import TwistLock.Main;

public class PanelJoueurGauche extends JPanel{

    private PanelJoueur joueur1;
    private PanelJoueur joueur3;

    public PanelJoueurGauche(Main instance){
        
        if( instance.getNbJoueurs()>2){
            setLayout(new GridLayout(2,1));
            joueur1 = new PanelJoueur(instance, "rouge");
            joueur3 = new PanelJoueur(instance, "bleu");
            add(joueur1);
            add(joueur3);
        }
        else{
            joueur1 = new PanelJoueur(instance, "rouge");
            add(joueur1, BorderLayout.CENTER);
        }
    }
}