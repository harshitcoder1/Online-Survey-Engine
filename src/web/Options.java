package web;

public class Options 
{
	private int optionId;
	private String option;
	private int questionId ;
	private int answerCount ;
	
	public int getOptionId() 
	{
		return optionId;
	}
	
	public void setOptionId(int optionId)
	{
		this.optionId = optionId;
	}
	
	public String getOption() 
	{
		return option;
	}
	
	public void setOption(String option) 
	{
		this.option = option;
	}
	
	public int getQuestionId()
	{
		return questionId;
	}
	
	public void setQuestionId(int questionId)
	{
		this.questionId = questionId;
	}
	
	public int getAnswerCount() 
	{
		return answerCount;
	}
	
	public void setAnswerCount(int answerCount) 
	{
		this.answerCount = answerCount;
	}
	
}
