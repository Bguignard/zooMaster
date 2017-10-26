package fr.ynov.vincensini.zoo.modele.metier;

import fr.ynov.vincensini.zoo.modele.technique.BeurkException;

/**
 * classe de base de tous les animaux
 * @author vincensini
 * @version 1.0
 *
 */
public abstract class Animal implements Individu {
	private String nom;
	private int age;
	private double poids;
	
	public Animal()
	{
		nom = "AAAAA";
		age = 2;
		poids = 30;
	}
/**
 * 
 * @param n nom 
 * @param a age
 * @param p poids
 */
	public Animal(String n, int a, double p)
	{
		setNom(n);
		setAge(a);
		setPoids(p);
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age > 0 && age < 99) {
			this.age = age;
		}
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double p) {
		if (p > 0 )
		{
			poids = p;
		}
	}
	
	public String toString() {
		return String.join(" ","je suis un(e)",getClass().getSimpleName(),"je m'appelle",nom,"j'ai "+age,"je pèse "+poids,"kg");
	}
	
	@Override
	public String crier()
	{
		return "...";
		
	}
	@Override
	public void manger(Mangeable m) throws BeurkException {
		 throw new BeurkException();
	}
	@Override
	public void sauter() {
		System.out.println("BONG BONG");
	}
	@Override
	public void courir() {
		System.out.println("OUH OUH");
	}
	
	
	
}
