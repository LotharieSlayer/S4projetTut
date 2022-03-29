package TwistLock.gui.panels;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import TwistLock.Main;

import java.awt.Color;
import java.awt.Graphics;

public class PanelJoueur extends JPanel{
    private JLabel nom;
    private JLabel couleur;
    private JLabel[] twistLock = new JLabel[20];
    private String forme;
    private int numJoueur;

    public PanelJoueur(Main instance, String coul){
        Border lineborder = BorderFactory.createLineBorder(Color.black, 1); 
        setBorder(lineborder);
        switch(coul){
            case "rouge":
                forme="carre";
                numJoueur=1;
                break;
            case "vert":
                forme="triangle";
                numJoueur=2;
                break;
            case "bleu":
                forme="rond";
                numJoueur=3;
                break;
            case "jaune":
                forme="etoile";
                numJoueur=4;
                break;
        }
        nom = new JLabel(instance.getPseudoJoueur(numJoueur), new ImageIcon("../res/img/" + forme + ".png"), SwingConstants.CENTER);
        add(nom);
        //setLayout(new GridLayout(2,1));
        for(int i = 0; i < instance.getPionsRestants(numJoueur) ; i++)
        {
            twistLock[i] = new JLabel(new ImageIcon("../res/img/rond-" + coul + ".png"), SwingConstants.CENTER);
            add(twistLock[i]);
        }
    }

    /*public void paint(Graphics g){
    
        g.drawLine(10, 10, 1160, 840);
        g.setColor(new Color(255,105,180));
        g.fillOval(10, 10, 10, 10);
        g.fillOval(50, 60, 10, 10);
        g.fillOval(200, 100, 10, 10);
        g.fillOval(300, 400, 10, 10);
        g.fillOval(1170, 850, 10, 10);
        
    }*/
}
