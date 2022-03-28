package TwistLock.utils;

public class Joueur {
	
	private int points;
	private int nbPionsRestants;

	private String pseudo;

	public static Joueur creerJoueur(String pseudo) {
		pseudo = pseudo.replaceAll("[ \t]", "");
		if(pseudo == null || pseudo.equals("")){return null;}
		return new Joueur(pseudo);
	}

	private Joueur(String pseudo) {
		this.pseudo = pseudo;

		this.points           = 0;
		this.nbPionsRestants  = 20;
	}

	public int getPionsRestants() {
		return nbPionsRestants;
	}

	public void addPoints(int points) {
		this.points += points;
	}

	public void removePoints(int points) {
		this.points -= points;
	}

	public Boolean retraitPions() {
		if(nbPionsRestants == 0) return false;
		nbPionsRestants--;
		return true;
	}

	public String getPseudo() {
		return pseudo;
	}

	@Override
	public String toString() {
		return "[joueur " + pseudo +" {points = " + points + ", pions restant = " + nbPionsRestants + "}]";
	}
}
