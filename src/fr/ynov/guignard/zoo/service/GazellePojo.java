package fr.ynov.guignard.zoo.service;

import java.io.Serializable;

public class GazellePojo implements Serializable {
    private int id;
    private int idAnimal;
    private int lgCornes;
    private static final long serialVersionUID = 1L;


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
}
