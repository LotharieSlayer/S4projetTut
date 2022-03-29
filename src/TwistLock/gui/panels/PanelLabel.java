package TwistLock.gui.panels;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

import TwistLock.Main;




public class PanelLabel extends JPanel{
    private JLabel label;
	private Image image;
	private Main instance;

    public PanelLabel(Main instance){

		this.instance = instance;
        label = new JLabel("C'est au tour de " + instance.getPseudoJoueur(instance.getNumJoueurEnCours()));

		/*try {
			String fName = "../../../res/fonts/Montserrat-Bold.ttf";
			InputStream is = PanelLabel.class.getResourceAsStream(fName);
			System.out.println(PanelLabel.class.getResourceAsStream(fName));
			System.out.println(is);
			Font font = Font.createFont(Font.TRUETYPE_FONT, is);
			label.setFont(new Font("Montserrat-Bold", Font.PLAIN, 18));
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		add(label);


    }

	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
            g.drawImage(ImageIO.read(new File("../res/labels/j" + instance.getNumJoueurEnCours() + ".png")), 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}