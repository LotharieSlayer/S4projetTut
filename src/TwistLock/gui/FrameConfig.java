package TwistLock.gui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.event.*;
import java.awt.GridLayout;

import TwistLock.Main;

public class FrameConfig extends JFrame implements ActionListener{

    private ButtonGroup choixNbJ = new ButtonGroup();
    private JRadioButton deux = new JRadioButton("2 joueurs");
    private JRadioButton trois = new JRadioButton("3 joueurs");
    private JRadioButton quatre = new JRadioButton("4 joueurs");

    private JButton valider;

    private Main instance;

    private int nbJoueurs;

    public FrameConfig(Main instance){

        this.instance = instance;

        int widthFrame = 1280;
        int heightFrame = 720;
        
        setSize(widthFrame, heightFrame);
		setTitle ("Nombre de joueurs");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        setLayout(new GridLayout(5,1));

        valider = new JButton("valider");

        add(new JLabel("Nombre de joueurs"));
        deux.setSelected(true);
        choixNbJ.add(deux);
        deux.addItemListener( this::radioButtons_itemStateChanged );
        choixNbJ.add(trois);
        trois.addItemListener( this::radioButtons_itemStateChanged );
        choixNbJ.add(quatre);
        quatre.addItemListener( this::radioButtons_itemStateChanged );
        add(deux);
        add(trois);
        add(quatre);

        add(valider);
        valider.addActionListener(this);

        setVisible(true);
    }
    void radioButtons_itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        if (source == deux) nbJoueurs = 2;
        if (source == trois) nbJoueurs = 3;
        if (source == quatre) nbJoueurs = 4;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == valider){
            if(nbJoueurs == 0) nbJoueurs = 2;
            instance.setNbJoueurs(nbJoueurs);
            instance.lancerFramePseudo();
            this.dispose();
        }
        
    }
    
}
