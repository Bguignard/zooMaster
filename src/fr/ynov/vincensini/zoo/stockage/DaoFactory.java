package fr.ynov.vincensini.zoo.stockage;

import fr.ynov.vincensini.zoo.service.CagePOJO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DaoFactory {

	public final static String FICHIER = "acces.properties";
	private static DaoFactory instance = new DaoFactory();
	private DaoFactory() {

	}
	public static DaoFactory getInstance() {
		return instance;
	}
	public Dao<CagePOJO> getDao(){
		Class<?> laClasse = null;
		try{
			laClasse = Class.forName(getNomDao());
			return (Dao<CagePOJO>) laClasse.newInstance();
		}
		catch(ClassNotFoundException | IllegalAccessException | InstantiationException e){
			e.printStackTrace();
		}
//		return new DaoDur();
//		return new DaoJDBCImpl();
		return null;
	}
	private String getNomDao(){
		String ret = "";
		Properties properties = null;
		properties = new Properties();
		try{
			properties.load(new FileInputStream(FICHIER));
			ret = properties.getProperty("package")+ properties.getProperty("dao");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
}