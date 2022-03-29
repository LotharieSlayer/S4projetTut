package TwistLock.gui;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Dimension;

/*--------------------------------------------*/
/* Classe PlaneteButton                       */
/*--------------------------------------------*/
public class RectangleButton
{
    /**
	 * Permet l'affichage de chaque bouton.
	 * @param x Position X en int
	 * @param y Position Y en int
	 * @param image L'image de la planète qui sera sur le bouton.
	 */
    public static JButton rectangle(int x, int y, String value)
    {
        Icon icon              = new ImageIcon("./res/img/rectangle.png");
        JButton btn            = new JButton(value,icon);
 
        btn.setHorizontalTextPosition(SwingConstants.CENTER);
        btn.setBounds(x,y,34,34       );
        btn.setOpaque(false           );
        btn.setContentAreaFilled(false); //Transparence
        btn.setBorderPainted(false    );
        btn.setFocusPainted(false     );
        btn.setPreferredSize(new Dimension (icon.getIconWidth(), icon.getIconHeight()));
        btn.setVisible(true);

        return btn;
    }
}