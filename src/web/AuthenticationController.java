package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AuthenticationController")

public class AuthenticationController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	private Admin admin;
	private AdminDao adminDao;
	private User user;
	private UserDao userDao;
	private HttpSession session;
	private String userType;
	
	//connection with db will be lost after a particular time because in the whole life cycle of the application connection is established with db only once.
	/*public AuthenticationController()
	{
		adminDao = new AdminDao();
		userDao = new UserDao();
	}*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		adminDao = new AdminDao();
		userDao = new UserDao();
		
		if(request.getParameter("signup")!=null)
		{
			String name = request.getParameter("name").toString() ;
			String username = request.getParameter("username").toString()  ;
			String email= request.getParameter("email").toString()  ; 
			String password = request.getParameter("password").toString() ;
			long phone= Long.parseLong(request.getParameter("phone_no").toString()) ;
			String securityQuestion = request.getParameter("securityQuestion").toString();
			String securityAnswer= request.getParameter("securityAnswer").toString()  ;
		
			session=request.getSession();
			userType=(String)session.getAttribute("userType");
			if(userType.equals("admin"))
			{
				admin = new Admin();
				admin.setName(name);
				admin.setEmail_id(email);
				admin.setUsername(username);
				admin.setPassword(password);
				admin.setPhone_no(phone);
				admin.setSecurity_question(securityQuestion);
				admin.setSecurity_answer(securityAnswer);
		
				int i =adminDao.insertData(admin);
		
				if(i>0)
				{
					int id = adminDao.getId(username);
					session.setAttribute("username", username);
					session.setAttribute("id", id);
					session.setAttribute("message", "sign up successfully");
					response.sendRedirect("Admin.jsp");
				}
				else
				{
					session.setAttribute("message", "sign up failed because your username or email or phoneno existed.");
					response.sendRedirect("SignUp.jsp");
				}
			}
			else if(userType.equals("user"))
			{
				user = new User();
				user.setName(name);
				user.setEmail_id(email);
				user.setUsername(username);
				user.setPassword(password);
				user.setPhone_no(phone);
				user.setSecurity_question(securityQuestion);
				user.setSecurity_answer(securityAnswer);
			
				int i =userDao.insertData(user);
		
				if(i>0)
				{
					int id = userDao.getId(username);
					session.setAttribute("username", username);
					session.setAttribute("id", id);
					session.setAttribute("message", "sign up successfully");
					response.sendRedirect("User.jsp");
				}
				else
				{
					session.setAttribute("message", "sign up failed because your username or email or phoneno existed.");
					response.sendRedirect("SignUp.jsp");
				}
			}
		}
		else if(request.getParameter("login")!=null)
		{
			if(!request.getParameter("username").isEmpty() && !request.getParameter("password").isEmpty())
			{	
				String username = request.getParameter("username").toString();
				String password1 = request.getParameter("password").toString();
				String password2;
				
				session=request.getSession();
				userType=(String) session.getAttribute("userType");
				
				if(userType.equals("admin"))
				{
					password2=adminDao.getPassword(username);
					if(password2 != null)
					{
						if(password1.equals(password2))
						{
							int id = adminDao.getId(username);
							session.setAttribute("username", username);
							session.setAttribute("id", id);
							session.setAttribute("message", "login successfully");
							response.sendRedirect("Admin.jsp");
						}
						else
						{
							session.setAttribute("message", "you entered wrong password");
							response.sendRedirect("LoginAdmin.jsp");
						}
					}
					else
					{
						session.setAttribute("message", "username does not exist");
						response.sendRedirect("LoginAdmin.jsp");
					}
				}
				else if(userType.equals("user"))
				{
					password2=userDao.getPassword(username);
					if(password2 != null)
					{
						if(password1.equals(password2))
						{
							int id = userDao.getId(username);
							session.setAttribute("username", username);
							session.setAttribute("id", id);
							session.setAttribute("message", "login successfully");
							response.sendRedirect("User.jsp");
						}
						else
						{
							session.setAttribute("message", "you entered wrong password");
							response.sendRedirect("LoginUser.jsp");
						}
					}
					else
					{
						session.setAttribute("message", "username does not exist");
						response.sendRedirect("LoginUser.jsp");
					}
				}
			}
		}
		else if(request.getParameter("forgotPassword")!=null)
		{
			String username = (String) request.getParameter("username");
			String securityQuestion = (String) request.getParameter("securityQuestion");
			String securityAnswer = (String) request.getParameter("securityAnswer");
		
			session = request.getSession();
			userType = (String) session.getAttribute("userType");
			
			String[] securityQuestionAndAnswer = null;
			if(userType.equals("admin"))
			{
				securityQuestionAndAnswer = adminDao.getSecurityQuestionAndAnswer(username);
			}
			else if(userType.equals("user"))
			{
				securityQuestionAndAnswer = userDao.getSecurityQuestionAndAnswer(username);
			}
			
			if(securityQuestionAndAnswer != null )
			{
				if(securityQuestion.equals(securityQuestionAndAnswer[0]))
				{
					if(securityAnswer.equals(securityQuestionAndAnswer[1]))
					{
						session.setAttribute("tmpUsername", username);
						response.sendRedirect("ChangePassword.jsp");
					}
					else 
					{
						session.setAttribute("message", "security answer is not correct");
						response.sendRedirect("ForgotPassword.jsp");
					}
				}
				else
				{
					session.setAttribute("message", "security question is not correct");
					response.sendRedirect("ForgotPassword.jsp");
				}
			}
			else
			{
				session.setAttribute("message", "username does not exist");
				response.sendRedirect("ForgotPassword.jsp");
			}
		}
		else if(request.getParameter("change_password")!=null)
		{
			String password = request.getParameter("password").toString();
			session = request.getSession();
			userType = (String) session.getAttribute("userType");
			String username = (String) session.getAttribute("username");
			String tmpUsername = (String) session.getAttribute("tmpUsername");
			
			int i = -1;
			if(userType.equals("admin"))
			{
				if(username != null)
				{
					i = adminDao.changePassword(username, password);
					
					if(i>0)
					{
						session.setAttribute("message", "password change successfully.");
						response.sendRedirect("Admin.jsp");
					}
					else
					{
						session.setAttribute("message", "password change failed");
						response.sendRedirect("Admin.jsp");
					}
				}
				else if(tmpUsername != null)
				{
					i = adminDao.changePassword(tmpUsername, password);
					
					if(i>0)
					{
						int id = adminDao.getId(tmpUsername);
						session.setAttribute("username", tmpUsername);
						session.setAttribute("id", id);
						session.removeAttribute("tmpUsername");
						session.setAttribute("message", "password change successfully.");
						response.sendRedirect("Admin.jsp");
					}
					else
					{
						session.removeAttribute("tmpUsername");
						session.setAttribute("message", "password change failed");
						response.sendRedirect("LoginAdmin.jsp");
					}
				}
			}
			else if(userType.equals("user"))
			{
				if(username != null)
				{
					i = userDao.changePassword(username, password);
					
					if(i>0)
					{
						session.setAttribute("message", "password change successfully.");
						response.sendRedirect("User.jsp");
					}
					else
					{
						session.setAttribute("message", "password change failed.");
						response.sendRedirect("ChangePassword.jsp");
					}
				}
				else if(tmpUsername != null)
				{
					i = userDao.changePassword(tmpUsername, password);
					
					if(i>0)
					{
						int id = userDao.getId(tmpUsername);
						session.setAttribute("username", tmpUsername);
						session.setAttribute("id", id);
						session.removeAttribute("tmpUsername");
						session.setAttribute("message", "password change successfully.");
						response.sendRedirect("User.jsp");
					}
					else
					{
						session.removeAttribute("tmpUsername");
						session.setAttribute("message", "password change failed.");
						response.sendRedirect("ChangePassword.jsp");
					}
				}
			}
		}
		else if(request.getParameter("giveFeedback")!=null)
		{
			response.sendRedirect("index.jsp");
		}
		else
		{
			session = request.getSession(false);
			if(session != null)
			{
			    session.invalidate();
			    session.setMaxInactiveInterval(1);
			}
			response.sendRedirect("index.jsp");
		}
		
		//adminDao.closeConnection();
		//userDao.closeConnection();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
