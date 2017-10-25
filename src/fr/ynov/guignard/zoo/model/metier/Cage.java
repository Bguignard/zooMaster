package fr.ynov.guignard.zoo.model.metier;

import fr.ynov.guignard.zoo.model.technique.BeurkException;
import fr.ynov.guignard.zoo.model.technique.CageException;
import fr.ynov.guignard.zoo.model.technique.OccupantException;

public class Cage {
    private Animal occupant;
    private boolean ouverte;
    private int x;
    private int y;

    @Override
    public String toString() {
        return "Cage{" +
                "occupant=" + occupant +
                ", ouverte=" + ouverte +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public Cage(int X, int Y){
        this.x = X;
        this.y = Y;
    }

    public void entrer(Animal animal) throws CageException, OccupantException {
        //test si la cage est pleine
        if (this.estOccupee()) {
            throw new OccupantException();
        }
        //test si la cage est fermée
        if (!this.ouverte) {
            throw new CageException();
        }
        this.occupant = animal;
    }
    public Animal sortir() throws CageException, OccupantException {
        //test si il y a un occupant
        if (!this.estOccupee()) {
            throw new OccupantException();
        }

        //test si la porte est ouverte
        if (!this.ouverte) {
            throw new CageException();
        }
        Animal oc = this.occupant;
        this.occupant = null;
        return oc;
    }
    public void donnerAManger() throws OccupantException {
        //
        if (!this.estOccupee()) {
            throw new OccupantException();
        }
        this.occupant.manger();
    }
    public void donnerAManger(Mangeable a) throws OccupantException {
        //
        if (!this.estOccupee()) {
            throw new OccupantException();
        }
        try {
            this.occupant.manger(a);
        } catch (BeurkException e) {
            e.printStackTrace();
        }
    }

    private boolean estOccupee(){
        return this.occupant != null;
    }

    public boolean isOuverte() {
        return ouverte;
    }

    public Animal getOccupant() {
        return occupant;
    }

    public void setOccupant(Animal occupant) {
        this.occupant = occupant;
    }

    public void setOuverte(boolean ouverte) {
        this.ouverte = ouverte;
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
}
