<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
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
      <title>Create Survey</title>
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
	
	function validate()
	{
		var surveyName=document.forms.createSurvey.surveyName.value;
		if(surveyName=="")
		{
			alert("surveyName should be filled out");
			document.forms.createSurvey.surveyName.focus();
			return false;
		}
		else if(!isNaN(surveyName))
		{
			alert("please enter a valid surveyName.");
			document.forms.createSurvey.surveyName.focus();
			return false;
		}
		
		var surveyCategory=document.forms.createSurvey.surveyCategory.value;
		if(surveyCategory=="select here")
		{
			alert("please select a survey category.");
			document.forms.createSurvey.surveyCategory.focus();
			return false;
		}
		
		var description=document.forms.createSurvey.description.value;
		if(description=="")
		{
			alert("description should be filled out");
			document.forms.createSurvey.description.focus();
			return false;
		}
		else if(!isNaN(description))
		{
			alert("please enter a valid description.");
			document.forms.createSurvey.description.focus();
			return false;
		}
		
		return true;
	}
	
</script>
	  <!--bootstrap start here-->
      <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
      <!--//booststrap end-->
      <!-- font-awesome icons -->
      <link href="css/fontawesome-all.min.css" rel="stylesheet" type="text/css" media="all">
      <!-- //font-awesome icons -->
      <!-- For Clients slider -->
      <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all" />
      <!--flexs slider-->
      <link href="css/JiSlider.css" rel="stylesheet">
      <!--stylesheets-->
      <link href="css/style.css" rel='stylesheet' type='text/css' media="all">
      <!--//stylesheets-->
      <link href="//fonts.googleapis.com/css?family=Sunflower:500,700" rel="stylesheet">
      <link href="//fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet">
   </head>
   <body >
      <div class="header-outs" id="home">
         <div class="header-bar">
            <div class="container-fluid">
               <!--<div class="hedder-up row">
                  <div class="col-lg-3 col-md-3 logo-head">
                    <i><h1><a class="navbar-brand" href="index.html">Sign Up</a></h1></i>
                  </div>
            </div>-->
			<nav class="navbar navbar-expand-lg navbar-light">
               <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
               <span class="navbar-toggler-icon"></span>
               </button>
			   <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
                  <ul class="navbar-nav ">
                     <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Home</a>
                     </li>
					 <li class="nav-item">
                        <a class="nav-link" href="ViewSurveyResponse.jsp">View Survey</a>
                     </li>
						<li class="nav-item">
                        <a class="nav-link" href="ChangePassword.jsp">Change Password</a>
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
                        <a class="nav-link" href="AuthenticationController">LogOut</a>
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
                     <div class="slider-img eight-img">
                        <div class="container">
						<br>
   						  <p align="center"><font size="42" color="black"><ins><i>Create Survey</i></ins></font></p><br>
								<form  align="center" action="SurveyController" method="post" name="createSurvey" onsubmit="return validate()">

									<table align="center" cellspacing="4" cellpadding="5" >
										<tr><td> <b>Enter Survey Name:</b></td><td><input type="text" placeholder="Enter Survey Name" name="surveyName" style="width: 200px;" required><font size="5" color="red"><sup>*</sup></font></td></tr>
										<tr><td> <b>Survey Category:</b></td><td><select name="surveyCategory">
																											<option >select here</option>
																											<option >Product Survey</option>
																											<option >College Survey</option>
																											<option >School Survey</option>
																											<option >Company Survey</option>
																											<option >Place Survey</option>
																											<option >Service Survey</option>
																											<option >Political Survey</option>
																											</select><font size="5" color="red"><sup>*</sup></font></td></tr>
										<tr><td><b>Enter Survey Description:</b></td><td><textarea rows="4" cols="50" placeholder="Enter your Description here" name="description" required></textarea><font size="5" color="red"><sup>*</sup></font></td></tr>
									</table><br>
								<center><input type="submit" name="createSurvey" value="Next" style="width: 120px; height: 30px;"></center>
								</form>

											
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