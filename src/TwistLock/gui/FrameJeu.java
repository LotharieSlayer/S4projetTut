package TwistLock.gui;

import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Dimension;

import TwistLock.Main;
import TwistLock.gui.panels.PanelLabel;
import TwistLock.gui.panels.PanelTablier;
import TwistLock.gui.panels.PanelJoueurDroite;
import TwistLock.gui.panels.PanelJoueurGauche;

import javax.swing.JFrame;

/**
 * FrameJeu permet d'afficher les informations de la partie ainsi que le plateau du jeu
 */
public class FrameJeu extends JFrame {
    private PanelLabel pnlLab;
    private PanelTablier pnlTabl;
    private PanelJoueurGauche pnlJouG;
    private PanelJoueurDroite pnlJouD;


	/**
     * Constructeur de FrameJeu
     * @param instance Implémentation de l'instance dans FrameJeu
     */
    public FrameJeu(Main instance){

        // IMPORTS
        this.pnlJouG = new PanelJoueurGauche(instance) ;
        this.pnlJouD = new PanelJoueurDroite(instance) ;
        this.pnlTabl = new PanelTablier(instance) ;
        this.pnlLab = new PanelLabel(instance);

        // INIT
        int widthFrame = 1280;
        int heightFrame = 720;
        setLocation(widthFrame / 10, heightFrame / 10);
		setSize(widthFrame,heightFrame);
		setResizable(false);
		setTitle ("TwistLock");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible(true);

        // EDIT PNL
        pnlJouG.setPreferredSize(new Dimension(300, heightFrame*4/5)); // pnl gauche
        pnlLab.setPreferredSize (new Dimension(widthFrame*3/5, heightFrame*1/5)); // pnl Label
        pnlJouD.setPreferredSize(new Dimension(300, heightFrame*4/5)); // pnl droite

        // ADD
        add(pnlJouG, BorderLayout.WEST);
        add(pnlTabl, BorderLayout.CENTER);
        add(pnlLab, BorderLayout.SOUTH);
        add(pnlJouD, BorderLayout.EAST);

    }

    public void maj() {
        this.repaint();
        this.pnlLab.maj();
        this.pnlTabl.maj();
        this.pnlJouG.maj();
        this.pnlJouD.maj();
    }
}