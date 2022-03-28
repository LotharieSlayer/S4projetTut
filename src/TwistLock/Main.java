package TwistLock;

import java.io.IOException;

public class Main {
    private static Main instance;
    public Main() throws IOException
	{
		instance = this;
    }

/**
 * Démarrage
 * @param args Fichier à prendre en paramètre (si c'est Exemple1.algo, alors ce sera Exemple1 à entrer)
 * @throws Exception
 */
	public static void main (String[] args) throws Exception{
		new Main();
	}
}