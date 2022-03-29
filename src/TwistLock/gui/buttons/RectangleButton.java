package TwistLock.gui.buttons;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import TwistLock.Main;
import TwistLock.utils.Joueur;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Insets;

/*--------------------------------------------*/
/* Classe PlaneteButton                       */
/*--------------------------------------------*/
public class RectangleButton extends JButton
{
    private int x;
    private int y;


    /**
	 * Permet l'affichage de chaque bouton.
	 * @param x Position X en int
	 * @param y Position Y en int
	 * @param image L'image de la planète qui sera sur le bouton.
	 */
    public RectangleButton(Main instance, int x, int y, String value)
    {
        this.x = x;
        this.y = y;
        int numJoueur = 0;
        Icon icon;
       
        Joueur joueurCaptureCelulle = instance.getCelluleAt(x, y).getCaptureby();
        if(joueurCaptureCelulle != null)
        {
            numJoueur = instance.getCelluleAt(x, y).getCaptureby().getNumJoueur();
        }
        if(numJoueur == 0)
        {
            icon = new ImageIcon("../res/img/rectangle.png");
        }
        else
            icon = new ImageIcon("../res/img/rectangle-j" + numJoueur + ".png");
    
        this.setText(value);
        this.setIcon(icon);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setMargin(new Insets(0,0,0,0));
        this.setOpaque(false           );
        this.setContentAreaFilled(false); //Transparence
        this.setBorderPainted(false    );
        this.setFocusPainted(false     );
        this.setPreferredSize(new Dimension (icon.getIconWidth(), icon.getIconHeight()));
        this.setVisible(true);
    }

    public int getNbX() {
        return this.x;
    }
    
    public int getNbY() {
        return this.y;
    }
}