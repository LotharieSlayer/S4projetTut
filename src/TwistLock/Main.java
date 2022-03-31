package TwistLock;

import java.io.IOException;
import java.util.ArrayList;

import TwistLock.gui.FrameConfig;
import TwistLock.gui.FrameJeu;
import TwistLock.utils.Cellule;
import TwistLock.utils.Joueur;
import TwistLock.utils.Plateau;
import TwistLock.gui.FramePseudo;
import TwistLock.gui.FrameVictoire;

public class Main {

    private static Main instance;
	private Plateau plateau;
	private int nbJoueurs;
	private Joueur[] tabJoueurs;
	private int numJoueurEnCours;
	private FrameJeu fj;
	private boolean enReseau;
	private String pseudo;
	private int port;
	private String adresseIP;

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

	public Cellule getCelluleAt(int ligne,int colonne)
	{
		return plateau.getCelluleAt(ligne, colonne);
	}

	public int getNumJoueurEnCours()
	{
		return numJoueurEnCours;
	}

	public void setNumJoueurEnCours(int num){
		this.numJoueurEnCours = num;
	}

	public void setPseudo(String pseudo){
		this.pseudo = pseudo;
	}
	
	public void setIP(String adresseIP){
		this.adresseIP = adresseIP;
	}
	
	public void setPort(int port){
		this.port = port;
	}

	public void captureCoineCellule(int ligne, int colonne, Joueur joueur, int coin){
		plateau.captureCoinCellule(ligne, colonne, joueur, coin);
	}

	public void setNbJoueurs(int nbJoueurs){ this.nbJoueurs = nbJoueurs; }

	public void lancerFramePseudo(){
		FramePseudo fp = new FramePseudo(instance);
	}

	public void lancerFrameJeu(){
		fj = new FrameJeu(instance);
	}

	public void setJoueurs(Joueur[] tabJ){
		this.tabJoueurs = tabJ;
		for(int cpt = 0; cpt < tabJ.length; cpt++)
			if(tabJoueurs[cpt] != null)
		
		numJoueurEnCours = 1;
	}

	public void joueurSuivant () {
        for (int i = 0; i < tabJoueurs.length; i++) {
            if ( tabJoueurs[numJoueurEnCours-1].getPseudo().equals(tabJoueurs[i].getPseudo())) {
                if ( i == tabJoueurs.length-1 ) { numJoueurEnCours = 1;   }
                else                            { numJoueurEnCours++;     }
				return;
            }
        }
    }

	public boolean isFinished() {
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

	public boolean enReseau(){
		return enReseau;
	}

	public void setEnReseau(boolean enReseau) {
		this.enReseau = enReseau;
	}

	public String getResultat() {
		String res = "";
		if(isFinished()) {
			ArrayList<Joueur> alJoueursVinqueurs = new ArrayList<>();
			int pointsMax = 0;

			for (Joueur joueur : tabJoueurs) {
				if(joueur.getPoints() > pointsMax) {
					pointsMax = joueur.getPoints();
				}
			}
	
			for (Joueur joueur : tabJoueurs) {
				if(joueur.getPoints() == pointsMax) {
					alJoueursVinqueurs.add(joueur);
				}
			}
	
			if(alJoueursVinqueurs.size() == 1) {
				res = "Le joueur " + alJoueursVinqueurs.get(0).getPseudo() + " remporte la partie";
				
			} else {
				 res = "Il y a égalité entre " + alJoueursVinqueurs.size() +" joueurs (";
				for (Joueur joueur : alJoueursVinqueurs) {
					res += joueur.getPseudo() + "|";
				}
				res = res.substring(0, res.length()-1) + ")";
			}
			return res;
		}
		return null;
	}

	public void setCapture(int ligne, int colonne, int numCoin) {
		if(enReseau) {
			//???
		} else {
			System.out.println();
		Joueur joueurActuel = tabJoueurs[numJoueurEnCours-1];

		if(isFinished()) {
			System.out.println(getResultat());
            FrameVictoire frameVictoire = new FrameVictoire(instance);
			return;
		}
		
        plateau.captureCoinCellule(ligne, colonne, joueurActuel, numCoin);
        System.out.println(joueurActuel);

		if(isFinished()) {
			System.out.println(getResultat());
            FrameVictoire frameVictoire = new FrameVictoire(instance);
			return;
		}
		
        do {
            joueurSuivant();
			joueurActuel = tabJoueurs[numJoueurEnCours-1];
        } while (joueurActuel.getPionsRestants() == 0);

		}

		fj.maj();
    }

	public int getNbLigne(){
		return plateau.getNbLigne();
	}

	public int getNbColonne(){
		return plateau.getNbColonne();
	}

	public int getScoreJoueur(int numJoueur) {
		return tabJoueurs[numJoueur-1].getPoints();
	}
}