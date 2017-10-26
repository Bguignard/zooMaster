package fr.ynov.vincensini.zoo.modele.metier;

import java.io.Serializable;
import java.util.StringJoiner;

import fr.ynov.vincensini.zoo.modele.technique.CageException;
import fr.ynov.vincensini.zoo.modele.technique.PorteException;

public class Cage implements Serializable{
	private int x;
	private int y;
	private boolean ouverte;
	private Animal occupant;
	public Cage() {
		// TODO Auto-generated constructor stub
	}

	public Cage(int x, int y) {
		this.x = x;
		this.y = y;
		ouverte = true;
		occupant = null;
	}

	@Override
	public String toString() {
		StringJoiner s = null;
		s = new StringJoiner(" ");
		s.add("cage [").add(""+x).add(",").add(""+y).add("] " );
		if(occupant != null)
		{
			s.add(occupant.toString());
		}
		else
		{
			s.add(" VIDE ");
		}
		return s.toString();
	}
	public void entrer(Animal a) throws PorteException, CageException
	{
		if(!ouverte)
		{
			throw new PorteException();
		}
		if(occupant == null)
		{
			occupant = a;
		}
		else
		{
			throw new CageException();
		}
	}
	public Animal sortir()  throws PorteException
	{
		Animal tmp = null;
		
		if(!ouverte)
		{
			throw new PorteException();
		}
		tmp = occupant;
		occupant = null; // pour vider!!!!
		return tmp;
	}
	public boolean isOuverte()
	{
		return ouverte;
	}
	public void fermer()
	{
		ouverte = false;
	}
	public void ouvrir()
	{
		ouverte = true;
	}

	public Animal getOccupant() {
		return occupant;
	}

}
