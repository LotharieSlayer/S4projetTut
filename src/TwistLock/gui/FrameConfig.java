package TwistLock.gui;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.event.*;
import java.awt.GridLayout;

import TwistLock.Main;

public class FrameConfig extends JFrame implements ActionListener{

    private JTextField portS = new JTextField();
    private JTextField pseudoJ = new JTextField();
    private JTextField ip = new JTextField();

    private ButtonGroup choixNet = new ButtonGroup();
    private JRadioButton client = new JRadioButton("client");
    private JRadioButton serveur = new JRadioButton("serveur");

    private int port;

    private JButton valider;

    private Main instance;

    private String pseudo;
    private String adresseIP;
    private String net;

    public FrameConfig(Main instance){

        this.instance = instance;

        int widthFrame = 400;
        int heightFrame = 350;
        
        setSize(widthFrame, heightFrame);
		setTitle ("Configuration");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocation(750, 300);

        setLayout(new GridLayout(10,1));

        valider = new JButton("valider");

        add(new JLabel("Choix network"));
        serveur.setSelected(true);
        net = "serveur";

        choixNet.add(serveur);
        add(serveur);
        serveur.addItemListener( this::radioButtons_itemStateChanged );

        choixNet.add(client);
        add(client);
        client.addItemListener( this::radioButtons_itemStateChanged );
        


        add(new JLabel("Nom du joueur"));
        add(pseudoJ);

        add(new JLabel("Port du serveur"));
        add(portS);

        add(new JLabel("Adresse IP"));
        add(ip);
        ip.setEditable(false);

        add(valider);
        valider.addActionListener(this);

        setVisible(true);
    }

    void radioButtons_itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        if (source == serveur) { ip.setEditable(false); net = "serveur"; }
        if (source == client) { ip.setEditable(true); net = "client"; }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        boolean valide = true;
        if(portS.getText().equals("")) {
            portS.setText("veuillez entrer le port d'un serveur");
            valide = false;
        }
        else{ port = Integer.parseInt(portS.getText()); }

        if(pseudoJ.getText().equals("")){
            pseudoJ.setText("Un pseudo ne peut pas être vide");
            valide = false;
        }
        else{ pseudo = pseudoJ.getText(); }

        if(net.equals("client")){
            if(pseudoJ.getText().equals("")){
                pseudoJ.setText("Entrez une adresse IP valide");
                valide = false;
            }
            else{
                adresseIP = ip.getText();
                instance.setIP(adresseIP);
            }
            
        }
        if(valide){
            instance.setPort(port);
            instance.setPseudo(pseudo);
            //instance.lancerFrameJeu();
            this.dispose();
        }
        
    }
}
