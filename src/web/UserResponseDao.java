package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserResponseDao
{
	private Connection connection ;
	private PreparedStatement preparedStatement ;
	private ResultSet resultSet ;
	/*private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://mydbinstance.cyk6nb5eflwa.ap-south-1.rds.amazonaws.com:3309/online_survey_system";
	private static final String USER="root";
	private static final String PASSWORD="awsrdsmysql";*/
	private String query;
	
	public UserResponseDao() 
	{
		/*try 
		{
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,USER,PASSWORD); 
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}*/
		connection = DbConnection.getConnection();
	}
	
	public int insertData(UserResponse userResponse) 
	{
		int i;
		query ="insert into user_response (user_id,question_id,selected_option_id) values(?,?,?)";
		try 
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userResponse.getUserId());
			preparedStatement.setInt(2, userResponse.getQuestionId());
			preparedStatement.setInt(3, userResponse.getSelectedOptionId());
			i = preparedStatement.executeUpdate();
		} 
		catch (SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			i = -1;
		}
		return i;
	}
}
