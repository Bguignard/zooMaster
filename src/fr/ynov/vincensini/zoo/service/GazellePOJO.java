package fr.ynov.vincensini.zoo.service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="gazelle")
public class GazellePOJO implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
@Id
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
