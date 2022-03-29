package TwistLock.gui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.event.*;
import java.awt.GridLayout;

import TwistLock.Main;

public class FrameSelectionCoin extends JFrame implements ActionListener{

    private ButtonGroup choixNbJ = new ButtonGroup();
    private JRadioButton un = new JRadioButton("coin 1");
    private JRadioButton deux = new JRadioButton("coin 2");
    private JRadioButton trois = new JRadioButton("coin 3");
    private JRadioButton quatre = new JRadioButton("coin 4");

    private JButton valider;

    private Main instance;

    private int ligne;
    private int colonne;
    private int numCoin;

    public FrameSelectionCoin(Main instance, int ligne, int colonne){

        this.instance = instance;
        this.ligne = ligne;
        this.colonne = colonne;

        int widthFrame = 1280;
        int heightFrame = 720;
        
        setSize(widthFrame, heightFrame);
		setTitle ("Séléction du coin");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        setLayout(new GridLayout(5,1));

        valider = new JButton("valider");

        add(new JLabel("Coin que vous souhaitez"));
        un.setSelected(true);
        choixNbJ.add(un);
        deux.addItemListener( this::radioButtons_itemStateChanged );
        choixNbJ.add(deux);
        deux.addItemListener( this::radioButtons_itemStateChanged );
        choixNbJ.add(trois);
        trois.addItemListener( this::radioButtons_itemStateChanged );
        choixNbJ.add(quatre);
        quatre.addItemListener( this::radioButtons_itemStateChanged );

        add(un);
        add(deux);
        add(trois);
        add(quatre);

        add(valider);
        valider.addActionListener(this);

        setVisible(true);
    }
    void radioButtons_itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        if (source == deux) numCoin = 1;
        if (source == deux) numCoin = 2;
        if (source == trois) numCoin = 3;
        if (source == quatre) numCoin = 4;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == valider){
            if(numCoin == 0) numCoin = 1;
            instance.setCapture(ligne, colonne, numCoin);
            this.dispose();
        }
        
    }
    
}
