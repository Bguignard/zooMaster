package fr.ynov.guignard.zoo.model.technique;

public class OccupantException extends Exception{

    private static final long serialVersionUID = 1L;

    public OccupantException() {
        super("il y a un souci d'occupation de la cage");
    }

    public OccupantException(String s) {
        super(s);
    }

}
