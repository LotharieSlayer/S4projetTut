package TwistLock.utils;

import TwistLock.Main;

public class Plateau {

	private static int LIGNE   = 10;
	private static int COLONNE = 7;

	private Cellule[][] plateau;

	public Plateau(Main instance) {
		plateau = new Cellule[LIGNE][COLONNE];

		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[0].length; j++) {
				plateau[i][j] = new Cellule();
			}
		}
	}

	public Cellule[][] getPlateau() {
		return plateau;
	}

	public Cellule getCelluleAt(final int ligne,final int colonne) {
		if(  (ligne >= 0 && colonne >= 0) && (ligne <= LIGNE && colonne <= COLONNE) ){
			return plateau[ligne][colonne];
		}
		return null;
	}

	public void captureCoinCellule(int ligne, int colonne, final String pseudo, final int coin) {
		if(isFull()){return;}

		Cellule[] tabcCellules = getCelluleAutour(ligne, colonne, coin);
		for (int i = 0; i < 4; i++) {
			tabcCellules[i].captureCoin(pseudo, i+1);
		}
	}

	private Cellule[] getCelluleAutour(final int ligne, final int colonne,final int coin) {
		Cellule[] tabCellules = new Cellule[4];
		switch (coin) {
			case 1:
				if(getCelluleAt(ligne  , colonne  ) != null ) tabCellules[0] = getCelluleAt(ligne  , colonne  );
				if(getCelluleAt(ligne  , colonne-1) != null ) tabCellules[1] = getCelluleAt(ligne  , colonne-1);
				if(getCelluleAt(ligne-1, colonne-1) != null ) tabCellules[2] = getCelluleAt(ligne-1, colonne-1);
				if(getCelluleAt(ligne-1, colonne  ) != null ) tabCellules[3] = getCelluleAt(ligne-1, colonne  );
				break;
			case 2:
				if(getCelluleAt(ligne  , colonne+1) != null ) tabCellules[0] = getCelluleAt(ligne  , colonne+1);
				if(getCelluleAt(ligne  , colonne  ) != null ) tabCellules[1] = getCelluleAt(ligne  , colonne  );
				if(getCelluleAt(ligne-1, colonne  ) != null ) tabCellules[2] = getCelluleAt(ligne-1, colonne  );
				if(getCelluleAt(ligne-1, colonne+1) != null ) tabCellules[3] = getCelluleAt(ligne-1, colonne+1);
				break;
			case 3:
				if(getCelluleAt(ligne+1, colonne+1) != null ) tabCellules[0] = getCelluleAt(ligne+1, colonne+1);
				if(getCelluleAt(ligne+1, colonne  ) != null ) tabCellules[1] = getCelluleAt(ligne+1, colonne  );
				if(getCelluleAt(ligne  , colonne  ) != null ) tabCellules[2] = getCelluleAt(ligne  , colonne  );
				if(getCelluleAt(ligne  , colonne+1) != null ) tabCellules[3] = getCelluleAt(ligne  , colonne+1);
				break;
			case 4:
				if(getCelluleAt(ligne+1, colonne  ) != null ) tabCellules[0] = getCelluleAt(ligne+1, colonne  );
				if(getCelluleAt(ligne+1, colonne-1) != null ) tabCellules[1] = getCelluleAt(ligne+1, colonne-1);
				if(getCelluleAt(ligne  , colonne-1) != null ) tabCellules[2] = getCelluleAt(ligne  , colonne-1);
				if(getCelluleAt(ligne  , colonne  ) != null ) tabCellules[3] = getCelluleAt(ligne  , colonne  );
				break;
		}
		return tabCellules;
	}

	public boolean isFull() {
		for (Cellule[] cellules : plateau) {
			for (Cellule cellule : cellules) {
				if(!cellule.cellulePleine()){
					return false;
				}
			}
		}
		return true;
	}
}