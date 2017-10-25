package fr.ynov.guignard.zoo.model.metier;

public final class Gazelle extends Animal implements Mangeable{
	private int lgCornes;
		
	/**
	 * classe concrete
	 * @author stagiaire
	 * @version 1.0
	 * 
	 *
	 */
	public Gazelle()
	{
		this("GGGGG",1,30,10);
		lgCornes = 20;
	}
	/**
	 * 
	 * @param n nom
	 * @param a age
	 * @param p poids
	 * @param lg longueur des cornes
	 */
	public Gazelle(String n, int a, double p, int lg) 
	{
		super(n,a,p);
		setLgCornes(lg);
	}

	public int getLgCornes() {
		return lgCornes;
	}

	public void setLgCornes(int lgCornes) {
		this.lgCornes = lgCornes;
	}
	@Override
	public void manger()
	{
		setPoids(getPoids()+0.8);
	}
	@Override
	public void courir()
	{
		setPoids(getPoids()-0.2);
	}
	@Override
	public void dormir()
	{
		setPoids(getPoids()-0.4);
				
	}
	@Override
	public void finalize()
	{
		System.out.println("Arghhhhhh!!!! je meurs!");
	}
	
	@Override
	public String toString() {
		return String.join(" ",super.toString(),"et mes cornes mesurent " + lgCornes ,"cm");
	}
}
