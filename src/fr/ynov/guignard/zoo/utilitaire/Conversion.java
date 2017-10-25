package fr.ynov.guignard.zoo.utilitaire;

import fr.ynov.guignard.zoo.model.metier.Animal;
import fr.ynov.guignard.zoo.model.metier.Cage;
import fr.ynov.guignard.zoo.model.metier.Gazelle;
import fr.ynov.guignard.zoo.service.CagePojo;
import fr.ynov.guignard.zoo.service.GazellePojo;

public class Conversion {
    public static Cage PojoToCage(CagePojo pojo){
        Cage ret = null;
        Class<?> laClasse = null;
        ret = new Cage(pojo.getX(), pojo.getY());
        Animal tmp = null;


        try {
            if(pojo.getCodeAnimal() != null){
                laClasse = Class.forName(pojo.getCodeAnimal());
                try {
                    tmp = (Animal)laClasse.newInstance();
                    tmp.setNom(pojo.getNom());
                    if(pojo.getCodeAnimal().equals("Gazelle")) {
                        ((Gazelle)tmp).setLgCornes(((GazellePojo)pojo).getLgCornes());
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return ret;
    }
}
