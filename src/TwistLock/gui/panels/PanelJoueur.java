package TwistLock.gui.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import TwistLock.Main;

import java.awt.Color;
import java.awt.Graphics;

public class PanelJoueur extends JPanel{
    private JLabel nom;
    private JLabel couleur;

    public PanelJoueur(Main instance, String coul){
        nom = new JLabel("caca");
        couleur = new JLabel(coul);
        add(nom);
        add(couleur);
    }

    public void paint(Graphics g){
    
        g.drawLine(10, 10, 1160, 840);
        g.setColor(new Color(255,105,180));
        g.fillOval(10, 10, 10, 10);
        g.fillOval(50, 60, 10, 10);
        g.fillOval(200, 100, 10, 10);
        g.fillOval(300, 400, 10, 10);
        g.fillOval(1170, 850, 10, 10);
        
    }
}
