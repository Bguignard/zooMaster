package fr.ynov.vincensini.zoo.modele.metier;

/**
 * classe concrete
 * @author stagiaire
 * @version 1.0
 * 
 *
 */
public class Singe extends Animal {
		
	public Singe()
	{
	    this("SSSSS",1,30);
	}
	/**
	 * 
	 * @param n nom
	 * @param a age
	 * @param p poids
	 */
	public Singe(String n, int a, double p)
	{
		super(n,a,p);
	}
	@Override
	public void manger()
	{
		setPoids(getPoids()+1.4); 
	}
	@Override
	public void courir()
	{
		
	}
	@Override
	public void dormir()
	{
		setPoids(getPoids()-0.8); 
				
	}
	@Override
	public void sauter()
	{
		
	}

	
	
	
}
