package fr.ynov.vincensini.zoo.vue;

/**
 * 
 * @author stagiaire
 * @version
 */
public class Ville {
private Zoo []lesZoos;
public Ville() {
	lesZoos = new Zoo[2];
	init();
}
	private void init() {
		lesZoos[0] = new Zoo();
		lesZoos[1] = new Zoo();
}
	/**
	 * 
	 */
	public void afficher() {
		for (Zoo z : lesZoos) {
			z.afficher();
		}
	}
	/**
	 * 
	 * @param args les arguments de la ligne de commande
	 */
	public static void main(String[] args) {
		Ville v = null;
		
		v = new Ville();
		v.afficher();
	}

}
