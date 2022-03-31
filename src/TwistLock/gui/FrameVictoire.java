package TwistLock.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;


import TwistLock.Main;

/**
 * fenêtre qui permet de choisir le coin de la case choisi sur le plateau
 */
public class FrameVictoire extends JFrame{

    private Main instance;

    public FrameVictoire(Main instance){

        this.instance = instance;

        int widthFrame = 600;
        int heightFrame = 350;
        
        setSize(widthFrame, heightFrame);
		setTitle ("Résultats");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        add(new JLabel(instance.getResultat()));

        setVisible(true);
    }
    
}
