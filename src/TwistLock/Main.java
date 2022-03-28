package TwistLock;

import java.io.IOException;

import TwistLock.gui.FrameJeu;
import TwistLock.utils.Joueur;
import TwistLock.utils.Plateau;
import TwistLock.gui.FramePseudo;

public class Main {

    private static Main instance;
	private Plateau plateau;
	private int nbJoueurs = 4;
	private Joueur[] tabJoueurs;
    

    public Main() throws IOException
	{
		instance = this;
		FramePseudo fp = new FramePseudo(instance);
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

	public String getPseudoJoueur(int numJoueur)
	{
		return this.tabJoueurs[numJoueur-1].getPseudo();
	}

	public int getPionsRestants(int numJoueur)
	{
		return this.tabJoueurs[numJoueur-1].getPionsRestants();
	}

	public void setJoueurs(Joueur[] tabJ){
		this.tabJoueurs = tabJ;
		if(tabJoueurs[0] != null)
			System.out.println(tabJoueurs[0].getPseudo());
		if(tabJoueurs[1] != null)
			System.out.println(tabJoueurs[1].getPseudo());
		if(tabJoueurs[2] != null)
			System.out.println(tabJoueurs[2].getPseudo());
		if(tabJoueurs[3] != null)
			System.out.println(tabJoueurs[3].getPseudo());
		plateau = new Plateau(instance);
		FrameJeu frame = new FrameJeu(instance);
	}
}