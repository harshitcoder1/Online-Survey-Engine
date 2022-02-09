package web;
import java.sql.*;

public class UserDao 
{

	private Connection connection ;
	private PreparedStatement preparedStatement ;
	private ResultSet resultSet ;
	/*private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://mydbinstance.cyk6nb5eflwa.ap-south-1.rds.amazonaws.com:3309/online_survey_system";
	private static final String USER="root";
	private static final String PASSWORD="awsrdsmysql";*/
	private String query;
	
	public UserDao() 
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
	
	
	public int insertData(User user)
	{
		query ="insert into user (name , email_id , phone_no , username , password , security_question, security_answer) values(?,?,?,?,?,?,?)";
		try 
		{
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,user.getName());
			preparedStatement.setString(2,user.getEmail_id());
			preparedStatement.setLong(3,user.getPhone_no());
			preparedStatement.setString(4,user.getUsername());
			preparedStatement.setString(5,user.getPassword());
			preparedStatement.setString(6,user.getSecurity_question());
			preparedStatement.setString(7,user.getSecurity_answer());
			int i =preparedStatement.executeUpdate();
			return i;
		} 
		catch (SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			return -1;
		}
	}
	
	public String getPassword(String username)
	{
		String password;
		query = "Select password from user where username = ?";
		try 
		{
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				password = resultSet.getString(1);
			}
			else
			{
				password = null;
			}
		}
		catch (SQLException e) 
		{
			System.out.println(e);
			e.printStackTrace();
			password = null;
		}
		return password;
	}

	public int changePassword(String username , String password)
	{
		query =" update user set password = ? where username = ?";
		try 
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, username);
			int i = preparedStatement.executeUpdate();
			return i ;
		}
		catch (SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			return -1;
		}
	}
	
	
	public String[] getSecurityQuestionAndAnswer(String username)
	{
		String security[] = new String[2];
		String query = "Select security_question,security_answer from user where username = ?";
		try 
		{
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setString(1, username);
			 resultSet = preparedStatement.executeQuery();
			 if(resultSet.next())
			 {
				 security[0]=resultSet.getString(1);
				 security[1]=resultSet.getString(2);
			 }
			 else
			 {
				security = null;
			 }
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			security = null;
		}
		return security;
	}
	
	public int getId(String username)
	{
		int id;
		query = "Select user_id from user where username = ?";
		try
		{
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				id = resultSet.getInt(1);
			}
			else
			{
				id = -1;
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			id = -1;
		}
		return id;
	}
	
	/*public void closeConnection()
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
	}*/
}
