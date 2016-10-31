package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	public static void main(String[] args)
	{
		
		final String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=Demo-Database;user=user;password=Pass123456";
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			System.out.println("Connected");
			con.close();
			System.out.println("Connection Closed");
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex.getMessage());
		}
	}

	/*public void main(String[] args)  throws  ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=Demo-Database;user=user;password=Pass123456";
        Connection con = DriverManager.getConnection(connectionURL);

        System.out.println("You are connected ");
        System.out.println(con);
	}
	*/
}
