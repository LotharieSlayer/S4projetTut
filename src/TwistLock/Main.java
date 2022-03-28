package TwistLock;

import java.io.IOException;

import TwistLock.gui.FrameJeu;
import TwistLock.utils.Joueur;
import TwistLock.utils.Plateau;

public class Main {

    private static Main instance;
	private Plateau plateau;
	private int nbJoueurs;
    

    public Main() throws IOException
	{
		instance = this;
		plateau = new Plateau(instance);
		FrameJeu frame = new FrameJeu(instance);
        
    }

/**
 * Démarrage
 * @param args Fichier à prendre en paramètre (si c'est Exemple1.algo, alors ce sera Exemple1 à entrer)
 * @throws Exception
 */
	public static void main (String[] args) throws Exception{
		new Main();
	}

	public int getNbJoueurs(){
		return this.nbJoueurs;
	}

	public int getValeurCelulle(int ligne, int colonne)
	{
		return plateau.getCelluleAt(ligne, colonne).getValue();
	}
}