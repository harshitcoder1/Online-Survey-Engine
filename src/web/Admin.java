package web;

public class Admin 
{
	private int id ;
	private String name ;
	private String username ;
	private String password ;
	private String email_id ;
	private long phone_no ;
	private String security_question ;
	private String security_answer ;
	
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id=id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getEmail_id() 
	{
		return email_id;
	}

	public void setEmail_id(String email_id) 
	{
		this.email_id = email_id;
	}

	public long getPhone_no() 
	{
		return phone_no;
	}

	public void setPhone_no(long phone_no) 
	{
		this.phone_no = phone_no;
	}

	public String getSecurity_question() 
	{
		return security_question;
	}

	public void setSecurity_question(String security_question) 
	{
		this.security_question = security_question;
	}

	public String getSecurity_answer() 
	{
		return security_answer;
	}

	public void setSecurity_answer(String security_answer) 
	{
		this.security_answer = security_answer;
	}
}
