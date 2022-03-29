package TwistLock.gui.panels;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TwistLock.Main;
import TwistLock.gui.FrameSelectionCoin;
import TwistLock.gui.buttons.RectangleButton;

public class PanelTablier extends JPanel implements ActionListener{

    private Main instance;

    private RectangleButton[][] rectangleButton = new RectangleButton[10][7];
    public PanelTablier(Main instance){
        this.instance = instance;
        //setLayout(new GridLayout(2,1));
        for(int i = 0; i < 10 ; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                rectangleButton[i][j] = new RectangleButton(i, j, String.valueOf(instance.getValeurCelulle(i, j)));
                rectangleButton[i][j].addActionListener(this);
                add(rectangleButton[i][j]);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        //this.instance.captureCoineCellule(i, j, this.instance.getNumJoueurEnCours(), 1);
        
        for (int i = 0; i < rectangleButton.length; i++) {
            for (int j = 0; j < rectangleButton[i].length; j++) {
            if(e.getSource() == rectangleButton[i][j]){
                int ligne = rectangleButton[i][j].getNbY();
                int colonne = rectangleButton[i][j].getNbX();
                    
                //ligne colonne point
                FrameSelectionCoin frameSelectionCoin = new FrameSelectionCoin(instance, ligne, colonne);
            }
            }
        }            
    }
}

