package fr.ynov.vincensini.zoo.modele.technique;

public class CageException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CageException()
	{
		super("La cage est deja occupee");
	}
	public CageException(String msg)
	{
		super(msg);
	}

}