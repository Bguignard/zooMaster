package fr.ynov.vincensini.zoo.service;

import java.io.Serializable;

public class CagePOJO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAnimal;
	private int x;
	private int y;
	private String codeAnimal;
	private String nom;
	private int age;
	private double poids;
	private GazellePOJO gaz;
	public CagePOJO() {
		// TODO Auto-generated constructor stub
	}
	public GazellePOJO getGaz() {
		return gaz;
	}
	public void setGaz(GazellePOJO gaz) {
		this.gaz = gaz;
	}
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getCodeAnimal() {
		return codeAnimal;
	}
	public void setCodeAnimal(String codeAnimal) {
		this.codeAnimal = codeAnimal;
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
		this.age = age;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	

}
