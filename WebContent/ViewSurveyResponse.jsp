<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList,web.*"%>
    
    <%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	/*String userType=(String)session.getAttribute("userType");
	out.println(userType);*/
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("index.jsp");
	}
	else if(session.getAttribute("userType").toString().equals("user"))
	{
		response.sendRedirect("User.jsp");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">
   <head>
      <title>Survey Response Page</title>
      <!--meta tags -->
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!--//meta tags ends here-->
	  <script type="text/javascript">
	
	<%! String message; %>
	<% message=(String)session.getAttribute("message");%>
	var msg="<%= message %>";
	if(msg != "null")
	{
		alert(msg);
	}
	<% session.removeAttribute("message");%>
	
	</script>
      <!--booststrap-->
      <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
      <!--//booststrap end-->
      <!-- font-awesome icons -->
      <link href="css/fontawesome-all.min.css" rel="stylesheet" type="text/css" media="all">
      <!-- //font-awesome icons -->
      <!-- For Clients slider -->
      <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all" />
      <!--flexs slider-->
      <link href="css/JiSlider.css" rel="stylesheet">
      <!--Shoping cart-->
      <link rel="stylesheet" href="css/shop.css" type="text/css" />
      <!--//Shoping cart-->
      <!--stylesheets-->
      <link href="css/style.css" rel='stylesheet' type='text/css' media="all">
      <!--//stylesheets-->
      <link href="//fonts.googleapis.com/css?family=Sunflower:500,700" rel="stylesheet">
      <link href="//fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet">
   </head>
   <body>
	<%! SurveyDao surveyDao; 
	QuestionDao questionDao;
	OptionDao optionDao;%>
      <div class="header-outs" id="home">
         <div class="header-bar">
            <div class="container-fluid">
              <!-- <div class="hedder-up row">
                  <div class="col-lg-3 col-md-3 logo-head">
                     <i><h1><a class="navbar-brand" href="index.html">Online Survey system</a></h1></i>
                  </div>
               </div>-->
            </div>
            <nav class="navbar navbar-expand-lg navbar-light">
               <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
               <span class="navbar-toggler-icon"></span>
               </button>
               <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
                  <ul class="navbar-nav ">
                     <li class="nav-item">
                        <a class="nav-link" href="Admin.jsp">Home</a>
                     </li>
                     <li class="nav-item">
                        <a href="CreateSurvey.jsp" class="nav-link">Create Survey</a>
                     </li>
					 <li class="nav-item">
                        <a href="ChangePassword.jsp" class="nav-link">Change Password</a>
                     </li>
                     <li class="nav-item">
                        <a href="Feedback.jsp" class="nav-link">Feedback</a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="AboutUs.html" target="_blank">About Us</a>
                     </li>
					 <li class="nav-item">
                        <a class="nav-link" href="ContactUs.html">Contact Us</a>
                     </li>
                     <li class="nav-item">
                        <a href="AuthenticationController" class="nav-link">LogOut</a>
                     </li>                
                  </ul>
               </div>
            </nav>
         </div>
         <!-- Slideshow 4 -->
         <div class="slider text-center">
            <div class="callbacks_container">
               <ul class="rslides" id="slider4">
                  <li>
                     <div class="slider-img ten-img">
                        <div class="container">
                           <br><br><br>
						   <p align="center"><font size="42" color="black"><ins><i>Survey Response</i></ins></font></p><br>
						   
							 <table align="center" cellspacing="2" cellpadding="10" border="1">
								<tr><th>INDEX</th><th>SURVEY NAME</th><th>SURVEY CATEGORY</th><th>QUESTION</th><th>OPTION</th><th>PEOPLE RESPONSE</th></tr>
								<tr>

									<% int count=1;
									surveyDao = new SurveyDao();
									questionDao = new QuestionDao();
									optionDao = new OptionDao();
									ArrayList<Survey> surveyList = surveyDao.getData((int)session.getAttribute("id"));
									for(Survey survey : surveyList)
										{%>

									<td align="center" rowspan=<%=survey.getTotalOptionCount()%>><%=count++ %></td><td rowspan=<%=survey.getTotalOptionCount()%>><%=survey.getSurveyName() %></td><td rowspan=<%=survey.getTotalOptionCount()%>><%=survey.getSurveyCategory() %></td>

											<%ArrayList<Questions> questionList = questionDao.getData(survey.getSurveyId());
												int count1 = 1;
												for(Questions question : questionList)
												{%>

									<td rowspan=<%=question.getOptionCount()%>><%=count1++ %>.&nbsp<%=question.getQuestion() %></td>

											<%ArrayList<Options> optionList = optionDao.getData(question.getQuestionId());
												int count2 = 1 ;
												for(Options option : optionList)
												{%>

									<td><%=count2++%>.&nbsp<%=option.getOption() %></td><td><%=option.getAnswerCount()%></td></tr><tr>


										<%} } }%>

								</tr>

<							</table>
                                <div class="outs_more-buttn">
                                 &nbsp;
								 </div>
                           </div>
                        
                     </div>
                  </li>
               </ul>
            </div>
         </div>      
   </body>
</html>