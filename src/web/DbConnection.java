package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	//private static DbConnection dbConnection;
	private static final String DRIVER="com.mysql.jdbc.Driver";
	//private static final String URL="jdbc:mysql://mydbinstance.cyk6nb5eflwa.ap-south-1.rds.amazonaws.com:3309/online_survey_system";
	private static final String URL="jdbc:mysql://localhost:3306/online_survey_system";
	private static final String USER="root";
	//private static final String PASSWORD="awsrdsmysql";
	private static final String PASSWORD="";
	private static Connection connection ;
	
	/*private DbConnection() {
		try 
		{
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,USER,PASSWORD); 
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public static DbConnection getInstance() {
		if(dbConnection==null)
		{
			dbConnection = new DbConnection();
	
		}
		return dbConnection;
	}*/
	
	public static Connection getConnection() 
	{
		return connection;
	}
	
	public static void createConnection()
	{
		if(connection!=null)
		{
			closeConnection();
	
		}
		try 
		{
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,USER,PASSWORD); 
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public static void closeConnection()
	{
		try 
		{
			connection.close();
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
