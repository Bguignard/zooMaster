package fr.ynov.guignard.zoo.controller;

import fr.ynov.guignard.zoo.model.metier.Animal;

import java.util.Vector;

public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
    private Vector<Animal> lesCages;

}
