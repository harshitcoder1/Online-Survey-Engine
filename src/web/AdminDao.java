package web;
import java.sql.*;

public class AdminDao 
{

	private Connection connection ;
	private PreparedStatement preparedStatement ;
	private ResultSet resultSet ;
	/*private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://mydbinstance.cyk6nb5eflwa.ap-south-1.rds.amazonaws.com:3309/online_survey_system";
	private static final String USER="root";
	private static final String PASSWORD="awsrdsmysql";*/
	private String query;
	
	
	public AdminDao() 
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
	
	public int insertData(Admin admin)
	{
		int i;
		query ="insert into admin (name , email_id , phone_no , username , password , security_question , security_answer) values(?,?,?,?,?,?,?)";
		try 
		{
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, admin.getName());
			preparedStatement.setString(2, admin.getEmail_id());
			preparedStatement.setLong(3, admin.getPhone_no());
			preparedStatement.setString(4, admin.getUsername());
			preparedStatement.setString(5,admin.getPassword());
			preparedStatement.setString(6, admin.getSecurity_question());
			preparedStatement.setString(7, admin.getSecurity_answer());
			i =preparedStatement.executeUpdate();
		} 
		catch (SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			i = -1;
		}
		return i;
	}
		
		
	public int changePassword(String username , String password)
	{
		query =" update admin set password = ? where username = ?";
		try 
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, username);
			int i =preparedStatement.executeUpdate();
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
		query = "Select security_question,security_answer from admin where username = ?";
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
			System.out.println(e);
			e.printStackTrace();
			security = null;
		}
		return security;
	}
	
	
	public String getPassword(String username)
	{
		String password;
		query = "Select password from admin where username = ?";
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
	
	public int getId(String username)
	{
		int id;
		query = "Select admin_id from admin where username = ?";
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
	



