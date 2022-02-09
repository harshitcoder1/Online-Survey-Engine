package web;
import java.sql.*;
import java.util.ArrayList;


public class QuestionDao 
{
	private Connection connection ;
	private PreparedStatement preparedStatement ;
	private ResultSet resultSet ;
	/*private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://mydbinstance.cyk6nb5eflwa.ap-south-1.rds.amazonaws.com:3309/online_survey_system";
	private static final String USER="root";
	private static final String PASSWORD="awsrdsmysql";*/
	private String query;

	public QuestionDao()
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
	
	
	public int insertData(Questions question) 
	{
		int i;
		query ="insert into question_list (question,survey_id) values(?,?)";
		try 
		{
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, question.getQuestion());
			preparedStatement.setInt(2, question.getSurveyId());
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
	
	public ArrayList<Questions> getData(int surveyId)
	{
		ArrayList<Questions> arrayList = new ArrayList<>();
		Questions questions;
		query = "select * from question_list where survey_id = ? ";
		try
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, surveyId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				questions = new Questions();
				questions.setQuestionId(resultSet.getInt(1));
				questions.setQuestion(resultSet.getString(2));
				questions.setSurveyId(resultSet.getInt(3));
				questions.setOptionCount(resultSet.getInt(4));
				arrayList.add(questions);
			}
		}
		catch (SQLException e) 
		{
			System.out.println(e);
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public int getQuestionId(Questions question) 
	{
		int id;
		query ="Select question_id from question_list where question =? and survey_id = ? ";
		try
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, question.getQuestion());
			preparedStatement.setInt(2, question.getSurveyId());
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
	
	public void updateOptionCount(int questionId)
	{
		query ="update question_list set option_count = option_count+1 where question_id = ? ";
		try 
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, questionId);
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
