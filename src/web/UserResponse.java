package web;

public class UserResponse 
{
	private int responseId;
	private int userId;
	private int questionId;
	private int selectedOptionId;
	
	public int getResponseId() 
	{
		return responseId;
	}
	
	public void setResponseId(int responseId)
	{
		this.responseId = responseId;
	}
	
	public int getUserId() 
	{
		return userId;
	}
	
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}
	
	public int getQuestionId()
	{
		return questionId;
	}
	
	public void setQuestionId(int questionId)
	{
		this.questionId = questionId;
	}
	
	public int getSelectedOptionId() 
	{
		return selectedOptionId;
	}
	
	public void setSelectedOptionId(int selectedOptionId) 
	{
		this.selectedOptionId = selectedOptionId;
	}
}
