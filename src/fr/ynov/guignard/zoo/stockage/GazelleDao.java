package fr.ynov.guignard.zoo.stockage;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import static fr.ynov.guignard.zoo.controller.Manager.mysql;

public class GazelleDao implements Serializable {
    public ResultSet getById(int idGazelle) throws SQLException {
        return mysql.select("select * FROM gazelle WHERE id");
    }
    public ResultSet getAll(int idGazelle) throws SQLException {
        return mysql.select("select * FROM gazelle");
    }
}
