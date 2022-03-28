package TwistLock.utils;

public class Cellule {
	
	private final int NB_COIN = 4;

	private int value;

	private int[]     tabCoin;
	private Boolean[] tabCoinCapturer;
	private String[]  tabJoueurCapture;


	public Cellule() {
		this.value = (int) (Math.random() * 50 + 5);

		this.tabCoin = new int[NB_COIN];

		for (int i = 0; i < tabCoin.length; i++) {
			tabCoin[i] = i;
		}

		this.tabCoinCapturer = new Boolean[NB_COIN];
		for (int i = 0; i < tabCoin.length; i++) {
			tabCoinCapturer[i] = false;
		}

		this.tabJoueurCapture = new String[NB_COIN];
	}

	//détermine si le coin en question est capturé ou non
	public Boolean coinCapture (int coin) {
		if ( this.tabJoueurCapture[coin-1] != null) { return true; }
		return false;
	}

	//stock le pseudo de la prise de capture
	public void captureCoin(String pseudo, int coin) {
		tabJoueurCapture[coin-1] = pseudo;
	}

	public Boolean cellulePleine() {
		for (int i = 0; i < tabCoin.length; i++) {
			if ( this.tabJoueurCapture[i] == null )
				return false;
		}
		return true;
	}	

	public int getValue  (              ) { return this.value;      }
	public int getCoin   (final int coin) { return tabCoin[coin];   }
	public Boolean[] getTabCoinCapturer() { return tabCoinCapturer; }
}
