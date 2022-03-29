package TwistLock.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.event.*;

import TwistLock.Main;
import TwistLock.utils.Joueur;

public class FramePseudo extends JFrame implements ActionListener{

    private JTextField[] tf;
    private Joueur[] joueurs;
    private JButton  valider;
    private Main instance;

    public FramePseudo(Main instance){

        tf = new JTextField[instance.getNbJoueurs()];
        joueurs = new Joueur[instance.getNbJoueurs()];
        valider = new JButton("valider");
        this.instance = instance;

        int widthFrame = 1280;
        int heightFrame = 720;

        setSize(widthFrame, heightFrame);
		setTitle ("Pseudo");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        setLayout(new GridLayout(instance.getNbJoueurs()*2+1,1));

        for(int cpt = 1; cpt <= instance.getNbJoueurs(); cpt++){
            add(new JLabel("joueur n°" + cpt));
            tf[cpt-1] = new JTextField();
            add(tf[cpt-1]);
        }

        add(valider);
        valider.addActionListener(this);

        

		setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == valider){
            for(int cpt = 0; cpt < tf.length; cpt++){
                joueurs[cpt]=Joueur.creerJoueur(tf[cpt].getText());
            }
            instance.setJoueurs(joueurs);
            instance.lancerFrameJeu();
            this.dispose();
        }
        
    }
}
