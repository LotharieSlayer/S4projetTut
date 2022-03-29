package TwistLock.gui.panels;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import TwistLock.Main;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class PanelJoueur extends JPanel{
    private JLabel nom;
    private JLabel couleur;
    private JLabel[] twistLock = new JLabel[20];
    private String forme;
    private int numJoueur;
    private Main instance;
    private String coul;

    private JLabel points = new JLabel();
    private JPanel pnlInfo = new JPanel();
    private JPanel pnlPoints = new JPanel();

    public PanelJoueur(Main instance, String coul){
        this.instance = instance;
        this.coul = coul;

        Border lineborder = BorderFactory.createLineBorder(Color.black, 1); 
        setBorder(lineborder);
        setLayout(new BorderLayout());

        pnlInfo.setLayout(new BorderLayout());
        pnlPoints.setLayout(new GridLayout(2,10));

        // pnlInfo

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
        pnlInfo.add(nom);
        for(int i = 0; i < instance.getPionsRestants(numJoueur) ; i++)
        {
            twistLock[i] = new JLabel(new ImageIcon("../res/img/rond-j" + numJoueur + ".png"), SwingConstants.CENTER);
            pnlPoints.add(twistLock[i]);
        }

        points.setText("Score : " + String.valueOf(instance.getScoreJoueur(numJoueur)));

        add(pnlInfo, BorderLayout.NORTH);
        add(pnlPoints, BorderLayout.CENTER);
        add(points, BorderLayout.SOUTH);

        
    }

    public void maj() {

        pnlPoints.removeAll();
        for(int i = 0; i < instance.getPionsRestants(numJoueur) ; i++)
        {
            twistLock[i] = new JLabel(new ImageIcon("../res/img/rond-j" + numJoueur + ".png"), SwingConstants.CENTER);
            pnlPoints.add(twistLock[i]);
        }
        points.setText("Score : " + String.valueOf(instance.getScoreJoueur(numJoueur)));
        add(points, BorderLayout.SOUTH);

    }
}
