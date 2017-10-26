package fr.ynov.vincensini.zoo.modele.technique;

/**
 * Exception pour les animaux qui ne sont pas mangeables
 * @author vincensini
 * @version 1.0
 */
public class BeurkException extends Exception {

	private static final long serialVersionUID = 1L;

	public BeurkException() {
		super("ce n'est pas bon");
	}

	public BeurkException(String s) {
		super(s);
	}

}
