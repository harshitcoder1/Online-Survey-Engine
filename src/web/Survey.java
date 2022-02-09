package web;
import java.sql.Date;

public class Survey 
{

	private int surveyId ;
	private String surveyName ;
	private Date dateOfCreation ;
	private int adminId ;
	private String description;
	private int questionCount;
	private int totalOptionCount;
	private String surveyCategory;
	
	
	public String getSurveyCategory() 
	{
		return surveyCategory;
	}

	public void setSurveyCategory(String surveyCategory) 
	{
		this.surveyCategory = surveyCategory;
	}

	public int getQuestionCount() 
	{
		return questionCount;
	}

	public void setQuestionCount(int questionCount) 
	{
		this.questionCount = questionCount;
	}

	public int getTotalOptionCount() 
	{
		return totalOptionCount;
	}

	public void setTotalOptionCount(int totalOptionCount) 
	{
		this.totalOptionCount = totalOptionCount;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getSurveyId() 
	{
		return surveyId;
	}
	
	public void setSurveyId(int surveyId) 
	{
		this.surveyId = surveyId;
	}
	
	public String getSurveyName() 
	{
		return surveyName;
	}
	
	public void setSurveyName(String surveyName) 
	{
		this.surveyName = surveyName;
	}
	
	public Date getDateOfCreation() 
	{
		return dateOfCreation;
	}
	
	public void setDateOfCreation(Date dateOfCreation)
	{
		this.dateOfCreation = dateOfCreation;
	}
	
	public int getAdminId()
	{
		return adminId;
	}
	
	public void setAdminId(int adminId)
	{
		this.adminId = adminId;
	}
}
