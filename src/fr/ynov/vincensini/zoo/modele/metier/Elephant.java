package fr.ynov.vincensini.zoo.modele.metier;

public class Elephant extends Animal {

	public Elephant() {
		// TODO Auto-generated constructor stub
	}

	public Elephant(String n, int a, double p) {
		super(n, a, p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void manger() {
	setPoids(getPoids()+300);

	}

	@Override
	public void dormir() {
		// TODO Auto-generated method stub

	}

}
