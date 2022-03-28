package TwistLock.gui.panels;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.FontFormatException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

import TwistLock.Main;


public class PanelLabel extends JPanel{
    private JLabel label;
    private JLabel image;

    public PanelLabel(Main instance){

        image = new JLabel("C'est au tour de " + instance.getPseudoJoueur(instance.getNumJoueurEnCours()), new ImageIcon("./res/labels/j" + instance.getNumJoueurEnCours() + ".png"), SwingConstants.CENTER);

        /*String fName = "./res/font/Inter-Bold.ttf";
		InputStream fFont = PanelLabel.class.getResourceAsStream(fName);
		try 
		{
			Font font = Font.createFont(Font.TRUETYPE_FONT, fFont);
			Font smallFont = font.deriveFont(Font.PLAIN, 16);
			this.image.setFont(smallFont);
		}
		catch (IOException e)        { e.printStackTrace(); }
		catch (FontFormatException e){ e.printStackTrace(); }*/

        add(image);
    }
}
