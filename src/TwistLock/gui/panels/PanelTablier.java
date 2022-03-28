package TwistLock.gui.panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

import TwistLock.Main;
import TwistLock.gui.RectangleButton;

public class PanelTablier extends JPanel{

    private JLabel label;
    private JButton[][] rectangleButton = new JButton[10][7];
    private JLabel[][] rectangleLabel= new JLabel[10][7];
    public PanelTablier(Main instance){
        //setLayout(new GridLayout(2,1));
        for(int i = 0; i < 10 ; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                rectangleButton[i][j] = RectangleButton.rectangle(i, j, String.valueOf(instance.getValeurCelulle(i, j)));
                add(rectangleButton[i][j]);
            }
        }
    }
}

