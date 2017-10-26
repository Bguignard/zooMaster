package fr.ynov.guignard.zoo.stockage;

import java.sql.*;

public class DaoMysql {
    private static Statement mysqlStatement;
    private static Boolean flag = false;
    private static final String login = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/zoo";

    private Statement connect(){
        if (!flag){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url, login, password);
                flag = true;
                mysqlStatement = conn.createStatement();
                return mysqlStatement;
            }
            catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
        }
        else{
            return mysqlStatement;
        }
        return null;
    }
    public ResultSet select(String request) throws SQLException {
        return this.connect().executeQuery(request);
    }
    public void updateDelete(String request) throws SQLException {
       this.connect().executeQuery(request);
    }
}
