package fr.ynov.vincensini.zoo.stockage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import fr.ynov.vincensini.zoo.service.CagePOJO;
import fr.ynov.vincensini.zoo.service.GazellePOJO;

public class DaoJDBCImpl extends DaoJDBC<CagePOJO> {
	@Override
	public List<CagePOJO> lireTous() {
		List<CagePOJO> ret = null;
		Statement stmt = null;
		ResultSet rs =null;
		try 
		{
			stmt = (Statement) getCon().createStatement();
			rs = stmt.executeQuery("SELECT * " +"from animal as gauche left join gazelle as droite on gauche.idAnimal=droite.idAnimal ORDER BY gauche.idAnimal ASC;");
			ret = new Vector<CagePOJO>();
			if(rs != null)
			{
				while(rs.next())
				{
					ret.add(resultSetToPOJO(rs));
				}
			}
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ret;
	}
	
	public DaoJDBCImpl() {
		super();
	}

	private CagePOJO resultSetToPOJO(ResultSet rs)
	{
		CagePOJO tmp = null;
		GazellePOJO tmpGaz = null;

		tmp = new CagePOJO();
		try {
			tmp.setX(rs.getInt("x"));
			tmp.setY(rs.getInt("y"));
			tmp.setIdAnimal(rs.getInt("idAnimal"));
			
			if(rs.getString("codeAnimal")!=null)
			{
				tmp.setNom(rs.getString("nom"));
				tmp.setAge(rs.getInt("age"));
				tmp.setPoids(rs.getDouble("poids"));
				tmp.setCodeAnimal(rs.getString("codeAnimal"));
				
				if(rs.getString("codeAnimal").equals("Gazelle"))
				{
					tmpGaz = new GazellePOJO();
					tmpGaz.setId(rs.getInt("id"));
					tmpGaz.setIdAnimal(tmp.getIdAnimal());
					tmpGaz.setLgCornes(rs.getInt("lgCornes"));
					tmp.setGaz(tmpGaz);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tmp;
	}

	@Override
	public CagePOJO lire(int id) {
		Statement stmt = null;
		ResultSet rs =null;
		CagePOJO ret = null;
		try 
		{
			stmt = (Statement) getCon().createStatement();
			rs = stmt.executeQuery("SELECT * " +"from animal as gauche left join gazelle as droite on gauche.idAnimal=droite.idAnimal WHERE gauche.idAnimal = "+id+";");
			if(rs != null)
			{
				while(rs.next())
				{
					ret =resultSetToPOJO(rs);
				}
			}
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ret;
	}
	@Override
	public void inserer(CagePOJO obj) {
		Statement st = null;
		int idAnimal = 0;
		int lg = 0;
		String req = "INSERT INTO animal ";
		
		req += valeurs(obj);
		try {
			st = getCon().createStatement();
			st.execute(req);
			if(obj.getGaz() != null)
			{
					idAnimal = obj.getGaz().getIdAnimal();
					lg = obj.getGaz().getLgCornes();
					req = "INSERT INTO gazelle VALUES(NULL,'"+idAnimal+"','"+lg+",);";
					st.execute(req);
			}
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(int id, CagePOJO obj) {
		PreparedStatement preparedStatement =null;
		String updateAnimal = "UPDATE animal SET x= ?, y= ?, age = ?, poids = ?, nom = ?, codeAnimal = ? WHERE animal.idAnimal = ?;";
		String updateGazelle = "UPDATE gazelle SET lgCornes = ? WHERE gazelle.idAnimal = ?;";
		try
		{
			getCon().setAutoCommit(false);
			preparedStatement= getCon().prepareStatement(updateAnimal);
			preparedStatement.setInt(1, obj.getX());
			preparedStatement.setInt(2, obj.getY());
			preparedStatement.setInt(3, obj.getAge());
			preparedStatement.setDouble(4, obj.getPoids());
			preparedStatement.setString(5, obj.getNom());
			preparedStatement.setString(6, obj.getCodeAnimal());
			preparedStatement.setInt(7, obj.getIdAnimal());
			preparedStatement .executeUpdate();	
			if(obj.getGaz() != null)
			{
				preparedStatement.close();	
				preparedStatement = getCon().prepareStatement(updateGazelle);
				preparedStatement.setInt(1, obj.getGaz().getLgCornes());
				preparedStatement.setInt(2, obj.getIdAnimal());
				preparedStatement.executeUpdate();
				
			}else
			{
				preparedStatement.close();
				//la gazelle avant dans la cage
				String req = "SELECT * FROM gazelle WHERE idAnimal = ? ;";
				preparedStatement = getCon().prepareStatement(req);
				preparedStatement.setInt(1, obj.getIdAnimal());
				if(preparedStatement.execute())
				{
					preparedStatement.close();
					//on doit supprimer
					req = "DELETE FROM gazelle WHERE idAnimal= ?;";
					preparedStatement = getCon().prepareStatement(req);
					preparedStatement.setInt(1, obj.getIdAnimal());
					preparedStatement.execute();
				}
			}
			getCon().commit();
		}
		catch(SQLException e)
		{
			 e.printStackTrace();
			 try {
				getCon().rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	}
	@Override
	public void effacer(int id) {
		Statement st = null;
		String req = "";

		CagePOJO obj = lire(id);
		req = "DELETE FROM animal WHERE idAnimal = '"+id+"';";
		try {
			st = getCon().createStatement();
			st.execute(req);
			if (obj.getGaz() != null)
			{
				req = "DELETE FROM gazelle WHERE idAnimal = '"+id+"';";
				st.execute(req);
			}
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String valeurs(CagePOJO obj)
	{
		String ret = " VALUES( NULL";
		ret+=",'"+obj.getCodeAnimal()+"','"+obj.getNom()+"','"+obj.getAge()+"','"+obj.getPoids()+"','"+obj.getX()+"','"+obj.getY();
		ret+="');";
		return ret;
	}
}
