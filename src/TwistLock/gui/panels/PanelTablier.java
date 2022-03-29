package TwistLock.gui.panels;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

import TwistLock.Main;
import TwistLock.gui.FrameSelectionCoin;
import TwistLock.gui.buttons.RectangleButton;
import TwistLock.utils.Joueur;

public class PanelTablier extends JPanel implements ActionListener{

    private Main instance;

    private RectangleButton[][] rectangleButton = new RectangleButton[10][7];
    public PanelTablier(Main instance){
        this.instance = instance;
        JPanel pnlVide = new JPanel();
        PanelGrille pnlGrille = new PanelGrille();
        pnlVide.setPreferredSize(new Dimension(0,0));
        pnlGrille.setLayout(new GridLayout(10,7));
        pnlGrille.setSize(new Dimension(680, 720*4/5));


        for(int i = 0; i < 10 ; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                rectangleButton[i][j] = new RectangleButton(instance, i, j, String.valueOf(instance.getValeurCelulle(i, j)));
                rectangleButton[i][j].addActionListener(this);
                pnlGrille.add(rectangleButton[i][j]);
            }
        }

        add(pnlGrille, BorderLayout.CENTER);
        add(pnlVide, BorderLayout.EAST);
        add(pnlVide, BorderLayout.WEST);
        System.out.println(pnlGrille.getSize());
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

      
    public void maj() {
        //Mettre des trucs pour maj la grille (notamment les rectangles ou faut changer )

        for (int i = 0; i < rectangleButton.length; i++) {
            for (int j = 0; j < rectangleButton[i].length; j++) {
                int ligne = rectangleButton[i][j].getNbX();
                int colonne = rectangleButton[i][j].getNbY();

                if(instance.getCelluleAt(ligne, colonne).isCaptured())
                {
                    int numJoueur = instance.getCelluleAt(ligne, colonne).getCaptureby().getNumJoueur();
                    rectangleButton[ligne][colonne].setIcon(new ImageIcon("../res/img/rectangle-j" + numJoueur + ".png"));
                }
                else
                    rectangleButton[ligne][colonne].setIcon(new ImageIcon("../res/img/rectangle.png"));
            }
        }   
    }

    class PanelGrille extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            try {
                g.drawImage(ImageIO.read(new File("../res/img/rond-rouge.png")), 70, this.getHeight()/16, null);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

