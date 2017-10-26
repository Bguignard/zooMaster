package fr.ynov.guignard.zoo.stockage;

import fr.ynov.guignard.zoo.service.CagePojo;
import fr.ynov.guignard.zoo.service.GazellePojo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import static fr.ynov.guignard.zoo.controller.Manager.mysql;

public class DaoCage implements Serializable {
    public CagePojo getById(int idCage) throws SQLException {
        ResultSet res = mysql.select("select * FROM cage WHERE id=" + idCage);
        CagePojo cp = new CagePojo();
        cp.setIdAnimal(res.getInt("idanimal"));
        cp.setX(res.getInt('x'));
        cp.setY(res.getInt('y'));
        cp.setCodeAnimal(res.getString("codeanimal"));
        cp.setCodeAnimal(res.getString("nom"));
        cp.setAge(res.getInt("age"));
        cp.setPoids(res.getDouble("poids"));
        return cp;
    }

    public Vector<CagePojo> getAll() throws SQLException {
        Vector<CagePojo> vg = new Vector<CagePojo>();
        ResultSet res =  mysql.select("select * FROM cage");
        while(res.next()){
            CagePojo cp = new CagePojo();
            cp.setIdAnimal(res.getInt("idanimal"));
            cp.setX(res.getInt('x'));
            cp.setY(res.getInt('y'));
            cp.setCodeAnimal(res.getString("codeanimal"));
            cp.setCodeAnimal(res.getString("nom"));
            cp.setAge(res.getInt("age"));
            cp.setPoids(res.getDouble("poids"));
            vg.add(cp);
        }
        return vg;
    }
    public void delete(CagePojo cage) throws SQLException {
        mysql.select("delete FROM cage WHERE id=" + cage.getIdAnimal());
    }
    public void update(CagePojo cage) throws SQLException {
        mysql.select("update FROM cage WHERE idanimal=" + cage.getIdAnimal());
    }
}
