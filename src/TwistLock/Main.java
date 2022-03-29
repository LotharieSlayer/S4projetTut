package TwistLock;

import java.io.IOException;

import TwistLock.gui.FrameConfig;
import TwistLock.gui.FrameJeu;
import TwistLock.utils.Joueur;
import TwistLock.utils.Plateau;
import TwistLock.gui.FramePseudo;

public class Main {

    private static Main instance;
	private Plateau plateau;
	private int nbJoueurs;
	private Joueur[] tabJoueurs;
	private Joueur joueurActuel;
	private int numJoueurEnCours;
    

    public Main() throws IOException
	{
		instance = this;
		this.plateau = new Plateau(instance);
		FrameConfig fc = new FrameConfig(instance);
		/*FramePseudo fp = new FramePseudo(instance);
		plateau = new Plateau(instance);
		FrameJeu frame = new FrameJeu(instance);*/
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

	public int getNumJoueurEnCours()
	{
		return numJoueurEnCours;
	}

	public void captureCoineCellule(int ligne, int colonne, Joueur joueur, int coin){
		plateau.captureCoinCellule(ligne, colonne, joueur, coin);
	}

	public void setNbJoueurs(int nbJoueurs){ this.nbJoueurs = nbJoueurs; }

	public void lancerFramePseudo(){
		FramePseudo fp = new FramePseudo(instance);
	}

	public void lancerFrameJeu(){
		FrameJeu fj = new FrameJeu(instance);
	}

	public void setJoueurs(Joueur[] tabJ){
		this.tabJoueurs = tabJ;
		for(int cpt = 0; cpt < tabJ.length; cpt++)
			if(tabJoueurs[cpt] != null)
				System.out.println(tabJoueurs[cpt].getPseudo());
		
		numJoueurEnCours = 1;
		joueurActuel = tabJoueurs[0];
	}

	public void joueurSuivant () {
        for (int i = 0; i < this.tabJoueurs.length; i++) {
            if ( this.joueurActuel.getPseudo().equals(this.tabJoueurs[i].getPseudo())) {
                if ( i == this.tabJoueurs.length-1 ) { this.joueurActuel = tabJoueurs[0];   }
                else                                 { this.joueurActuel = tabJoueurs[i+1]; }
				return;
            }
        }
    }

	public boolean verifFinPartie() {
		if(plateau.isFull()) {
			return true;
		}

		for (int i = 0; i < tabJoueurs.length; i++) {
			if(tabJoueurs[i].getPionsRestants() > 0) {
				return false;
			}
		}
		return true;
	}

	public void setCapture(int ligne, int colonne, int numCoin) {
		if(verifFinPartie()) {
			System.out.println("la partie est fini");
			return;
		}
		plateau.captureCoinCellule(ligne, colonne, joueurActuel, numCoin);
		System.out.println(joueurActuel);
		if(verifFinPartie()) {
			System.out.println("la partie est fini");
			return;
		}
		do {
			joueurSuivant();
		} while (joueurActuel.getPionsRestants() == 0);
	}
}