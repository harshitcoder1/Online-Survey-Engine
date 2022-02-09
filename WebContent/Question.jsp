<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	String userType=(String)session.getAttribute("userType");
	out.println(userType);
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
      <title>Question Page</title>
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
		var question=document.forms.question.question.value;
		if(question=="")
		{
			alert("question should be filled out");
			document.forms.question.question.focus();
			return false;
		}
		else if(!isNaN(question))
		{
			alert("please enter a valid question.");
			document.forms.question.question.focus();
			return false;
		}
		
		var optionA=document.forms.question.optionA.value;
		if(optionA=="")
		{
			alert("optionA should be filled out");
			document.forms.question.optionA.focus();
			return false;
		}
		
		var optionB=document.forms.question.optionB.value;
		if(optionB=="")
		{
			alert("optionB should be filled out");
			document.forms.question.optionB.focus();
			return false;
		}
		
		var optionD=document.forms.question.optionD.value;
		if(optionD!="")
		{
			var optionC=document.forms.question.optionC.value;
			if(optionC=="")
			{
				alert("Before optionD , optionC must be filled out");
				document.forms.question.optionC.focus();
				return false;
			}
		}
		
		var optionE=document.forms.question.optionE.value;
		if(optionE!="")
		{
			var optionD=document.forms.question.optionD.value;
			if(optionD!="")
			{
				var optionC=document.forms.question.optionC.value;
				if(optionC=="")
				{
					alert("Before optionD and optionE, optionC must be filled out");
					document.forms.question.optionC.focus();
					return false;
				}
			}
			else 
			{
				alert("Before optionE, optionD and optionC must be filled out");
				document.forms.question.optionD.focus();
				return false;
			}		
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
            </div>
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
                        <a class="nav-link" href="AuthenticationController">LogOut</a>
                     </li>
					 <li class="nav-item">
                        <a class="nav-link" href="AboutUs.html">About Us</a>
                     </li>
					 <li class="nav-item">
                        <a class="nav-link" href="ContactUs.html">Contact Us</a>
                     </li>
                  </ul>
               </div>
            </nav>-->
           
         </div>	 
         <!-- Slideshow 4 -->
         <div class="slider text-center">
            <div class="callbacks_container">
               <ul class="rslides" id="slider4">
                  <li>
                     <div class="slider-img nine-img">
                        <div class="container">
						<br>
   						  <p align="center"><font size="42" color="white"><ins><i>Questions</i></ins></font></p><br>
								<form  align="center" action="SurveyController" method="get" name="question" onsubmit="return validate()">

								<table align="center" cellspacing="4" cellpadding="10">
										<tr><td> <b><font color="white">Enter Question:</font></b></td><td><input type="text" placeholder="Enter your Question" name="question" style="width: 200px; height: 30px;" required><font size="5" color="red"><sup>*</sup></font></td></tr>
										<tr><td> <b><font color="white">Enter OptionA:</font></b></td><td><input type="text" placeholder="Enter Option A" name="optionA" style="width: 200px; height: 30px;" required><font size="5" color="red"><sup>*</sup></font></td></tr>
										<tr><td> <b><font color="white">Enter OptionB:</font></b></td><td><input type="text" placeholder="Enter Option B" name="optionB" style="width: 200px; height: 30px;" required><font size="5" color="red"><sup>*</sup></font></td></tr>
										<tr><td> <b><font color="white">Enter OptionC:</font></b></td><td><input type="text" placeholder="Enter Option C" name="optionC" style="width: 200px; height: 30px;" ></td></tr>
										<tr><td> <b><font color="white">Enter OptionD:</font></b></td><td><input type="text" placeholder="Enter Option D" name="optionD" style="width: 200px; height: 30px;" ></td></tr>
										<tr><td> <b><font color="white">Enter OptionE:</font></b></td><td><input type="text" placeholder="Enter Option E" name="optionE" style="width: 200px; height: 30px;" ></td></tr>

								</table><br>
								<center><pre>       <input type="submit" name="addQuestion" value="Add Question" style="width: 120px; height: 30px;">      <input type="submit" name="saveQuestions" value="Save Questions" style="width: 120px; height: 30px;"></pre></center>
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