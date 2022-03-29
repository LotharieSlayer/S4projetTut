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
        boolean valide = true;
        if(e.getSource() == valider){
            for(int cpt = 0; cpt < tf.length; cpt++){
                if(tf[cpt].getText().equals("") || tf[cpt].getText() == null){
                    tf[cpt].setText("Un pseudo ne peut pas être vide");
                    valide = false;
                }
                else{
                    for(JTextField jtf:tf){
                        if(tf[cpt].getText().equals(jtf.getText()) && tf[cpt] != jtf){
                            jtf.setText("Les pseudos ne peuvent pas être identique");
                            tf[cpt].setText("Les pseudos ne peuvent pas être identique");
                            valide=false;
                        }
                    }
                }
                if(valide){
                    joueurs[cpt]=Joueur.creerJoueur(tf[cpt].getText());
                }
            }
            if(valide){
                instance.setJoueurs(joueurs);
                instance.lancerFrameJeu();
                this.dispose();
            }
        }
        
    }
}
