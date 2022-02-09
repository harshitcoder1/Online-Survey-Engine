package web;
import java.sql.*;
import java.util.ArrayList;

public class OptionDao 
{

	private Connection connection ;
	private PreparedStatement preparedStatement ;
	private ResultSet resultSet ;
	/*private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://mydbinstance.cyk6nb5eflwa.ap-south-1.rds.amazonaws.com:3309/online_survey_system";
	private static final String USER="root";
	private static final String PASSWORD="awsrdsmysql";*/
	private String query;
	
	public OptionDao() 
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
	
	
	public int insertData(Options option) 
	{
		int i;
		query ="insert into option_list (option_name,question_id) values(?,?)";
		try 
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, option.getOption());
			preparedStatement.setInt(2, option.getQuestionId());
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

	public ArrayList<Options> getData(int questionId)
	{
		ArrayList<Options> arrayList = new ArrayList<>();
		Options options;
		query = "select * from option_list where question_id = ? order by answer_count desc";
		try
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, questionId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				options = new Options();
				options.setOptionId(resultSet.getInt(1));
				options.setOption(resultSet.getString(2));
				options.setQuestionId(resultSet.getInt(3));
				options.setAnswerCount(resultSet.getInt(4));
				arrayList.add(options);
			}
		}
		catch (SQLException e) 
		{
			System.out.println(e);
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public int getOptionId(String option , int questonId ) 
	{
		int id;
		query ="Select option_id from option_list where option_name =? and question_id = ? ";
		try
		{
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, option);
			preparedStatement.setInt(2, questonId);
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
		catch (SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			id = -1;
		}
		return id;
	}
	
	
	public void updateAnswerCount(int optionId) 
	{
		query ="update option_list set answer_count = answer_count+1 where option_id = ? ";
		try 
		{
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, optionId);
			preparedStatement.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
			e.printStackTrace();
		}
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
