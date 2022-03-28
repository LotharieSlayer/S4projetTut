package TwistLock.gui;

import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Dimension;

import TwistLock.Main;
import TwistLock.gui.panels.PanelLabel;
import TwistLock.gui.panels.PanelTablier;
import TwistLock.gui.panels.PanelJoueurGauche;

import javax.swing.JFrame;

/**
 * Frame du graphique avec les robots.
 */
public class FrameJeu extends JFrame {
	
    public FrameJeu(Main instance){

        // IMPORTS
        PanelJoueurGauche pnlJouG = new PanelJoueurGauche(instance) ;
        PanelTablier pnlTabl = new PanelTablier(instance) ;
        PanelLabel pnlLab = new PanelLabel(instance);

        // INIT
        int widthFrame = 1280;
        int heightFrame = 720;

        System.out.println(widthFrame);
        System.out.println(heightFrame);
        setLocation(widthFrame / 10, heightFrame / 10);
		setSize(widthFrame,heightFrame);
		setResizable(false);
		setTitle ("TwiwtLock");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible(true);

        // EDIT PNL
        pnlJouG.setPreferredSize(new Dimension(widthFrame*1/5, heightFrame*4/5)); // pnl gauche
        pnlTabl.setPreferredSize(new Dimension(widthFrame*3/5, heightFrame*4/5)); // pnl Tablier
        pnlLab.setPreferredSize(new Dimension(widthFrame, heightFrame*1/5)); // pnl Tablier

        System.out.println(widthFrame*3/4);
        System.out.println(widthFrame*1/4);

        // ADD
        add(pnlJouG, BorderLayout.WEST);
        add(pnlTabl, BorderLayout.CENTER);
        add(pnlLab, BorderLayout.SOUTH);

    }
}
// Implémenter GraphPanel.java
// Créer une autre class capable de get toutes les trames étant diffusé sur le port ayant la position du robot/des robots