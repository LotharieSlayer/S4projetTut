package TwistLock.utils;

import java.util.HashMap;

public class Cellule {
	
	private final int NB_COIN = 4;

	private boolean isCaptured;
	private Joueur  captureby;

	private int   value;

	private int[] tabCoin;

	private Joueur[] tabJoueurCapture;

	public Cellule() {
		this.isCaptured = false;
		this.value = (int) (Math.random() * 50 + 5);

		this.tabCoin = new int[NB_COIN];

		for (int i = 0; i < tabCoin.length; i++) {
			tabCoin[i] = i;
		}

		this.tabJoueurCapture = new Joueur[NB_COIN];
	}

	//détermine si le coin en question est capturé ou non
	public Boolean coinCapture (int coin) {
		if ( this.tabJoueurCapture[coin-1] != null) { return true; }
		return false;
	}

	//stock le pseudo de la prise de capture
	public void captureCoin(Joueur joueur, int coin) {
		tabJoueurCapture[coin-1] = joueur;
	}

	public Boolean cellulePleine() {
		for (int i = 0; i < tabCoin.length; i++) {
			if ( this.tabJoueurCapture[i] == null )
				return false;
		}
		return true;
	}	

	public boolean isCaptured() {
		return isCaptured;
	}

	public void captureBy(Joueur joueur) {
		if(!isCaptured) {
			isCaptured = true;
			captureby  = joueur;
			captureby.addPoints(value);
		}
	}

	public int getValue  (              ) { return this.value;      }
	public int getCoin   (final int coin) { return tabCoin[coin];   }
	public Joueur coinCaptureBy (final int coin) {return tabJoueurCapture[coin];}

	public void setToNeutral() {
		captureby.removePoints(value);
		captureby = null;
		isCaptured = false;
	}
}
