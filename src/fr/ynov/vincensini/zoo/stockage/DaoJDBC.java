package fr.ynov.vincensini.zoo.stockage;

import java.sql.*;

public abstract class DaoJDBC<T> implements Dao<T> {

	private Connection con;
	public final static String DRIVER = "com.mysql.jdbc.Driver";
	public final static String DEST = "jdbc:mysql://localhost:3306/zoo";
	public final static String LOGIN = "root";
	public final static String PSWD = "";
	 
	public DaoJDBC()
	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		
		try {
			con = ((Connection) DriverManager.getConnection(DEST,LOGIN, PSWD));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return con;
	}

}