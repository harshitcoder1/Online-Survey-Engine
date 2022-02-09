package web;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SurveyController")
public class SurveyController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   
	private Survey survey;
	private SurveyDao surveyDao;
	private Questions question;
	private Options option;
	private QuestionDao questionDao;
	private OptionDao optionDao;
	private UserResponse userResponse;
	private UserResponseDao userResponseDao;
	
	/*public SurveyController()
	{
		survey = new Survey();
		surveyDao = new SurveyDao();
		question = new Questions();
		questionDao = new QuestionDao();
		option = new Options();
		optionDao = new OptionDao();
		userResponse = new UserResponse();
		userResponseDao = new UserResponseDao();
	}*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		survey = new Survey();
		surveyDao = new SurveyDao();
		question = new Questions();
		questionDao = new QuestionDao();
		option = new Options();
		optionDao = new OptionDao();
		userResponse = new UserResponse();
		userResponseDao = new UserResponseDao();

		HttpSession session = request.getSession();
		int adminId;
		String surveyName;
		String description;
		String surveyCategory;
		java.sql.Date dateOfCreation;
		int surveyId;
		int i;
		
		if(request.getParameter("createSurvey") != null)
		{
			surveyName = request.getParameter("surveyName");
			description = request.getParameter("description");
			adminId = (int)session.getAttribute("id");
			surveyCategory = request.getParameter("surveyCategory");
			long millis = System.currentTimeMillis();  
	        dateOfCreation = new java.sql.Date(millis);  
	        
	        survey.setSurveyName(surveyName);
	        survey.setAdminId(adminId);
	        survey.setDateOfCreation(dateOfCreation);
	        survey.setDescription(description);
	        survey.setSurveyCategory(surveyCategory);
	        
	        i = surveyDao.insertData(survey);
	        
	        if(i>0)
	        {
	        	surveyId = surveyDao.getId(surveyName, adminId);
	        	session.setAttribute("surveyId", surveyId);
	        	response.sendRedirect("Question.jsp");
	        }
	        else
	        {
	        	session.setAttribute("message", "survey can not created because survey with this name already existed.");
	        	response.sendRedirect("CreateSurvey.jsp");
	        }
		}
		else if(request.getParameter("addQuestion") != null)
		{
			surveyId = (int) session.getAttribute("surveyId");
			question.setQuestion(request.getParameter("question").toString());
			question.setSurveyId(surveyId);
			
			i = questionDao.insertData(question);
			
			if(i>0)
			{
				surveyDao.updateQuestionCount(surveyId);
				
				option.setQuestionId(questionDao.getQuestionId(question));
				option.setOption(request.getParameter("optionA").toString());
				optionDao.insertData(option);
				surveyDao.updateTotalOptionCount(surveyId);
				questionDao.updateOptionCount(option.getQuestionId());
				
				option.setOption(request.getParameter("optionB").toString());
				optionDao.insertData(option);
				surveyDao.updateTotalOptionCount(surveyId);
				questionDao.updateOptionCount(option.getQuestionId());
				
				if(request.getParameter("optionC")!=null && !request.getParameter("optionC").toString().isEmpty())
				{
					option.setOption(request.getParameter("optionC"));
					optionDao.insertData(option);
					surveyDao.updateTotalOptionCount(surveyId);
					questionDao.updateOptionCount(option.getQuestionId());
				}
				if(request.getParameter("optionD")!=null && !request.getParameter("optionD").toString().isEmpty())
				{
					option.setOption(request.getParameter("optionD"));
					optionDao.insertData(option);
					surveyDao.updateTotalOptionCount(surveyId);
					questionDao.updateOptionCount(option.getQuestionId());
				}
				if(request.getParameter("optionE")!=null && !request.getParameter("optionE").toString().isEmpty())
				{
					option.setOption(request.getParameter("optionE"));
					optionDao.insertData(option);
					surveyDao.updateTotalOptionCount(surveyId);
					questionDao.updateOptionCount(option.getQuestionId());
				}
				response.sendRedirect("Question.jsp");
			}
			else
			{
				session.setAttribute("message", "you have allready added this question in this survey.");
				response.sendRedirect("Question.jsp");
			}
		}
		else if(request.getParameter("saveQuestions") != null)
		{
			surveyId = (int) session.getAttribute("surveyId");
			question.setQuestion(request.getParameter("question").toString());
			question.setSurveyId(surveyId);
			
			i = questionDao.insertData(question);
			
			if(i>0)
			{
				surveyDao.updateQuestionCount(surveyId);
				
				option.setQuestionId(questionDao.getQuestionId(question));
				option.setOption(request.getParameter("optionA").toString());
				optionDao.insertData(option);
				surveyDao.updateTotalOptionCount(surveyId);
				questionDao.updateOptionCount(option.getQuestionId());
				
				option.setOption(request.getParameter("optionB").toString());
				optionDao.insertData(option);
				surveyDao.updateTotalOptionCount(surveyId);
				questionDao.updateOptionCount(option.getQuestionId());
				
				if(request.getParameter("optionC")!=null && !request.getParameter("optionC").toString().isEmpty())
				{
					option.setOption(request.getParameter("optionC"));
					optionDao.insertData(option);
					surveyDao.updateTotalOptionCount(surveyId);
					questionDao.updateOptionCount(option.getQuestionId());
				}
				if(request.getParameter("optionD")!=null && !request.getParameter("optionD").toString().isEmpty())
				{
					option.setOption(request.getParameter("optionD"));
					optionDao.insertData(option);
					surveyDao.updateTotalOptionCount(surveyId);
					questionDao.updateOptionCount(option.getQuestionId());
				}
				if(request.getParameter("optionE")!=null && !request.getParameter("optionE").toString().isEmpty())
				{
					option.setOption(request.getParameter("optionE"));
					optionDao.insertData(option);
					surveyDao.updateTotalOptionCount(surveyId);
					questionDao.updateOptionCount(option.getQuestionId());
				}
				session.setAttribute("message","survey is created.");
				session.removeAttribute("surveyId");
				response.sendRedirect("Admin.jsp");
			}
			else
			{
				session.setAttribute("message", "you have allready added this question in this survey.");
				response.sendRedirect("Question.jsp");
			}
		}
		else if(request.getParameter("userResponse") != null)
		{
			 String radioName;
			 int questionId;
			 int optionId;
			 int count=0;
			 surveyId = Integer.parseInt(request.getParameter("surveyId"));
			 userResponse.setUserId((int)session.getAttribute("id"));
			 ArrayList<Questions> questions = questionDao.getData(surveyId);
			 
			 for(Questions question : questions)
			 {
				 questionId = question.getQuestionId();
				 radioName = "radio"+questionId;
				 if(request.getParameter(radioName)!=null)
				 {
					 optionId = Integer.parseInt(request.getParameter(radioName));
					 userResponse.setQuestionId(questionId);
					 userResponse.setSelectedOptionId(optionId);
				 	 i=userResponseDao.insertData(userResponse);
					 if(i>0)
					 {
						 optionDao.updateAnswerCount(optionId);
						 count=1;
					 }
					 else
					 {
						 count=-2;
					 }
				 }
				 else
				 {
					 count=-1;
					 break;
				 }
			 }
			 if(count==1)
			 {
				 session.setAttribute("message", "your response successfully saved.");
				 response.sendRedirect("User.jsp");
			 }
			 else if(count==-1)
			 {
				 session.setAttribute("message", "please give the answer of all questions.");
				 response.sendRedirect("GiveSurvey.jsp?surveyId="+surveyId);
			 }
			 else if(count==-2)
			 {
				 session.setAttribute("message", "You can not give this survey because you have already given this survey.");
				 response.sendRedirect("User.jsp");
			 }
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
