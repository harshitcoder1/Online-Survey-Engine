<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">
   <head>
      <title>Forget Password</title>
      <!--meta tags -->
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!--//meta tags ends here-->
      <!--booststrap-->
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
		var username=document.forms.forgotPassword.username.value;
		if(username=="")
		{
			alert("name should be filled out");
			document.forms.forgotPassword.username.focus();
			return false;
		}
		else if(!isNaN(username))
		{
			alert("please enter a valid username.");
			document.forms.forgotPassword.username.focus();
			return false;
		} 
		
		var securityQuestion=document.forms.forgotPassword.securityQuestion.value;
		if(securityQuestion == "select here")
		{
			alert("please select a security question.");
			document.forms.forgotPassword.securityQuestion.focus();
			return false;
		}
		
		var securityAnswer=document.forms.forgotPassword.securityAnswer.value;
		if(securityAnswer == "")
		{
			alert("please enter a security answer.");
			document.forms.forgotPassword.securityAnswer.focus();
			return false;
		}
		else if(!isNaN(securityAnswer))
		{
			alert("please enter a valid security answer.");
			document.forms.forgotPassword.securityAnswer.focus();
			return false;
		} 
		
		return true;
	}
		
</script>
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
              <!-- <div class="hedder-up row">
                  <div class="col-lg-3 col-md-3 logo-head">
                    <i><h1><a class="navbar-brand" href="index.html">Forget password</a></h1></i>
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
                        <a class="nav-link" href="LoginAdmin.jsp">Admin</a>
                     </li>
						<li class="nav-item">
                        <a class="nav-link" href="LoginUser.jsp">User</a>
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
						<li class="nav-item" >
                        <a class="nav-link" href="SignUp.jsp">SignUp</a>
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
                     <div class="slider-img six-img">
                        <div class="container">
                           <br><br>
						    <p align="center"><font size="42" color="black"><ins><i>Forget Password</i></ins></font></p><br><br>
						   <form  action="AuthenticationController" method="post" name="forgotPassword" onsubmit="return validate()">

							<table align="center" cellspacing="4" cellpadding="10">
									<tr><td>&nbsp &nbsp <b>Username:</b></td><td><input type="text" placeholder="Enter your Username" name="username" required style="width: 200px;"><font color="red"><sup>*</sup></font></td></tr>
									<tr><td>&nbsp &nbsp <b>Security Question:</b></td><td><select name="securityQuestion" style="width: 200px;">
																														<option >select here</option>
																														<option >What is your pet name ?</option>
																														<option >What is your hobby ?</option>
																														<option >What is your passion ?</option>
																														<option >What is your favourite book ? </option>
	 								   																					<option >What is your favourite Movie ?</option>
	 								   																					<option >What is your favourite Color ?</option>
																														</select><font color="red"><sup>*</sup></font></td></tr>
									<tr><td>&nbsp &nbsp <b>Security Ans:</b></td><td><input type="text"placeholder="Enter your Answer" name="securityAnswer" required style="width: 200px;"><font color="red"><sup>*</sup></font></td></tr>
							</table><br><br>
									<center><pre>      <input type="submit" name="forgotPassword" value="Submit" style="width: 120px; height: 30px;">       <input type="reset" value="Reset" style="width: 120px; height: 30px;">  </pre></center>
							</form>

											
                                <div class="outs_more-buttn">
                                 &nbsp;
								 </div>
                           </div>
                        </div>
                     </div>
                  </li>
               </ul>
            </div>
         </div>
   </body>
</html>