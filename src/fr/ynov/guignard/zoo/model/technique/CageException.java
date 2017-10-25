package fr.ynov.guignard.zoo.model.technique;

public class CageException extends Exception{

    private static final long serialVersionUID = 1L;

    public CageException() {
        super("La porte a un mauvais état");
    }

    public CageException(String s) {
        super(s);
    }

}
