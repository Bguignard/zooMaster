package fr.ynov.vincensini.zoo.stockage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import fr.ynov.vincensini.zoo.service.CagePOJO;

public class DaoFactory {
	public final static String FICHIER="acces.properties";
	private static DaoFactory instance = new DaoFactory();
	private DaoFactory() {

	}
	public static DaoFactory getInstance() {
		return instance;
	}
	@SuppressWarnings("unchecked")
	public Dao<CagePOJO> getDao(){
		Class<?> laClasse = null;
		try {
			laClasse = Class.forName(getNomDao());
			return (Dao<CagePOJO>) laClasse.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
//		return new DaoDur();
		return null;
	}
	private String getNomDao()
	{
		String ret = "";
		Properties prop = null;
		prop = new Properties();
		try {
			prop.load(new FileInputStream(FICHIER));
			ret = prop.getProperty("package")+prop.getProperty("dao");
		} catch (FileNotFoundException e) {
			// FIXME Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}