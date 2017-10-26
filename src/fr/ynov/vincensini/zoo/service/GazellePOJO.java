package fr.ynov.vincensini.zoo.service;

import java.io.Serializable;

public class GazellePOJO implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private int id;
private int idAnimal;
private int lgCornes;
	public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getIdAnimal() {
	return idAnimal;
}
public void setIdAnimal(int idAnimal) {
	this.idAnimal = idAnimal;
}
public int getLgCornes() {
	return lgCornes;
}
public void setLgCornes(int lgCornes) {
	this.lgCornes = lgCornes;
}
	public GazellePOJO() {
		// TODO Auto-generated constructor stub
	}

}
