package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SurveyDao 
{

	private Connection connection ;
	private PreparedStatement preparedStatement ;
	private ResultSet resultSet ;
	/*private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://mydbinstance.cyk6nb5eflwa.ap-south-1.rds.amazonaws.com:3309/online_survey_system";
	private static final String USER="root";
	private static final String PASSWORD="awsrdsmysql";*/
	private String query;
	
	public SurveyDao()
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
	
	public int insertData(Survey survey)
	{
		int i;
		query ="insert into survey_list (survey_name , doc , admin_id , description , survey_category) values(?,?,?,?,?)";
		try 
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1 , survey.getSurveyName());
			preparedStatement.setDate(2 , survey.getDateOfCreation());
			preparedStatement.setInt(3 , survey.getAdminId());
			preparedStatement.setString(4, survey.getDescription());
			preparedStatement.setString(5, survey.getSurveyCategory());
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
	
	public ArrayList<Survey> getData()
	{
		ArrayList<Survey> arrayList = new ArrayList<>();
		Survey survey;
		query = "select * from survey_list order by survey_category asc,doc desc";
		try
		{
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				survey = new Survey();
				survey.setSurveyId(resultSet.getInt(1));
				survey.setSurveyName(resultSet.getString(2));
				survey.setDateOfCreation(resultSet.getDate(3));
				survey.setAdminId(resultSet.getInt(4));
				survey.setDescription(resultSet.getString(5));
				survey.setQuestionCount(resultSet.getInt(6));
				survey.setTotalOptionCount(resultSet.getInt(7));
				survey.setSurveyCategory(resultSet.getString(8));
				arrayList.add(survey);
			}
		}
		catch (SQLException e) 
		{
			System.out.println(e);
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public ArrayList<Survey> getData(int adminId)
	{
		ArrayList<Survey> arrayList = new ArrayList<>();
		Survey survey;
		query = "select * from survey_list where admin_id = ? order by survey_category asc,doc desc";
		try
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, adminId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				survey = new Survey();
				survey.setSurveyId(resultSet.getInt(1));
				survey.setSurveyName(resultSet.getString(2));
				survey.setDateOfCreation(resultSet.getDate(3));
				survey.setAdminId(resultSet.getInt(4));
				survey.setDescription(resultSet.getString(5));
				survey.setQuestionCount(resultSet.getInt(6));
				survey.setTotalOptionCount(resultSet.getInt(7));
				survey.setSurveyCategory(resultSet.getString(8));
				arrayList.add(survey);
			}
		}
		catch (SQLException e) 
		{
			System.out.println(e);
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public int getId(String surveyName , int adminId)
	{
		int id;
		query = "Select survey_id from survey_list where admin_id = ? and survey_name = ? ";
		try
		{
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, adminId);
			preparedStatement.setString(2, surveyName);
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
	
	public void updateQuestionCount(int surveyId)
	{
		query ="update survey_list set question_count = question_count+1 where survey_id = ? ";
		try 
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, surveyId);
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void updateTotalOptionCount(int surveyId)
	{
		query ="update survey_list set total_option_count = total_option_count+1 where survey_id = ? ";
		try 
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, surveyId);
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
