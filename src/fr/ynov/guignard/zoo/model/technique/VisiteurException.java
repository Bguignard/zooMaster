package fr.ynov.guignard.zoo.model.technique;

public class VisiteurException extends Exception{

    private static final long serialVersionUID = 1L;

    public VisiteurException() {
        super("il y a un souci de nombre de visiteurs");
    }

    public VisiteurException(String s) {
        super(s);
    }

}
