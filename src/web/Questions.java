package web;

public class Questions {

	private int questionId;
	private String question ;
	private int surveyId ;
	private int optionCount;

	
	public int getOptionCount() 
	{
		return optionCount;
	}

	public void setOptionCount(int optionCount) 
	{
		this.optionCount = optionCount;
	}

	public int getQuestionId() 
	{
		return questionId;
	}
	
	public void setQuestionId(int questionId) 
	{
		this.questionId = questionId;
	}
	
	public String getQuestion() 
	{
		return question;
	}
	
	public void setQuestion(String question) 
	{
		this.question = question;
	}
	
	public int getSurveyId() 
	{
		return surveyId;
	}
	
	public void setSurveyId(int surveyId) 
	{
		this.surveyId = surveyId;
	}
	
	

	
}
