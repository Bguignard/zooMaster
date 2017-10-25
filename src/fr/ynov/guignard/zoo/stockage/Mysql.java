package fr.ynov.guignard.zoo.stockage;

import java.sql.*;

public class Mysql {
    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo");
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("la requete");
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}
