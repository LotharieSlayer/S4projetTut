package TwistLock.gui.panels;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

import TwistLock.Main;
import TwistLock.gui.FrameSelectionCoin;
import TwistLock.gui.buttons.RectangleButton;

public class PanelTablier extends JPanel implements ActionListener{

    private Main instance;

    private RectangleButton[][] rectangleButton = new RectangleButton[15][15];
    public PanelTablier(Main instance){
        this.instance = instance;
        JPanel pnlVide = new JPanel();
        JPanel pnlGrille = new JPanel();
        pnlVide.setPreferredSize(new Dimension(0,0));
        pnlGrille.setLayout(new GridLayout(10,7));

        for(int i = 0; i < 10 ; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                rectangleButton[i][j] = new RectangleButton(instance,i, j, String.valueOf(instance.getValeurCelulle(i, j)));
                rectangleButton[i][j].addActionListener(this);
                pnlGrille.add(rectangleButton[i][j]);
            }
        }

        add(pnlGrille, BorderLayout.CENTER);
        add(pnlVide, BorderLayout.EAST);
        add(pnlVide, BorderLayout.WEST);
    }

    public void actionPerformed(ActionEvent e) {

        //this.instance.captureCoineCellule(i, j, this.instance.getNumJoueurEnCours(), 1);
        
        for (int i = 0; i < rectangleButton.length; i++) {
            for (int j = 0; j < rectangleButton[i].length; j++) {
            if(e.getSource() == rectangleButton[i][j]){
                int ligne = rectangleButton[i][j].getNbX();
                int colonne = rectangleButton[i][j].getNbY();
                    
                //ligne colonne point
                FrameSelectionCoin frameSelectionCoin = new FrameSelectionCoin(instance, ligne, colonne);
            }
            }
        }            
    }

    /*@Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    try {
            g.drawImage(ImageIO.read(new File("../res/img/rond-rouge.png")), 0, 0, null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
}

