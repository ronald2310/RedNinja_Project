package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public void main(String[] args)  throws  ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=Demo-Database;user=user;password=Pass123456";
        Connection con = DriverManager.getConnection(connectionURL);

        System.out.println("You are connected ");
        System.out.println(con);
	}
}
