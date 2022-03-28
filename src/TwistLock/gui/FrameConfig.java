package TwistLock.gui;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ItemEvent;
import java.awt.Color;

import TwistLock.Main;

public class FrameConfig extends JFrame{

    private ButtonGroup choixNbJ = new ButtonGroup();
    private JRadioButton deux = new JRadioButton("2 joueurs");
    private JRadioButton trois = new JRadioButton("3 joueurs");
    private JRadioButton quatre = new JRadioButton("4 joueurs");

    private int nbJoueurs;

    public FrameConfig(Main instance){
        add(new JLabel("Nombre de joueurs"));
        deux.setSelected(true);
        choixNbJ.add(deux);
        deux.addItemListener( this::radioButtons_itemStateChanged );
        choixNbJ.add(trois);
        trois.addItemListener( this::radioButtons_itemStateChanged );
        choixNbJ.add(quatre);
        quatre.addItemListener( this::radioButtons_itemStateChanged );
    }
    void radioButtons_itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        if (source == deux) nbJoueurs = 2;
        if (source == trois) nbJoueurs = 3;
        if (source == quatre) nbJoueurs = 4;
    }
}
