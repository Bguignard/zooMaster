package fr.ynov.vincensini.zoo.modele.technique;

public class PorteException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PorteException()
	{
		super("Impossible, la porte est fermée");
	}
}