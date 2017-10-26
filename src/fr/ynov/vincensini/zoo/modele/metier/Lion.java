package fr.ynov.vincensini.zoo.modele.metier;
/**
 * classe concrete
 * @author stagiaire
 * @version 1.0
 * 
 *
 */
public final class Lion extends Animal {
	
	public Lion()
	{	
		this("LLLLL",1,30);
	}
	
	public Lion(String n, int a, double p)
	{
		super(n,a,p);
	}
	@Override		
	public void manger()
	{
		setPoids(getPoids()+2.1);
	}
	@Override
	public void manger(Mangeable m)
	{
		if (m != null)
		{
			setPoids(getPoids()+(m.getPoids()/3));
		}
	}
	@Override
	public String crier()
	{
		return "Je rugis rhoaaaa";
	}
	@Override
	public void dormir()
	{
		setPoids(getPoids()-1);
	}
	
	@Override
	public void sauter()
	{
		setPoids(getPoids()-0.7);
	}

	
	

}
