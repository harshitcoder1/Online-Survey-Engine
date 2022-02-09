<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">
   <head>
      <title>Change Password</title>
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
		var password=document.forms.changePassword.password.value;
		if(password.length<4 || password.length>8 )
		{
			alert("password should have 4 to 8 characters.");
			document.forms.changePassword.password.focus();
			return false;
		}
		
		var reEnterPassword=document.forms.changePassword.re_enter_password.value;
		if(reEnterPassword.length<4 || reEnterPassword.length>8 )
		{
			alert("reEnter Password should have 4 to 8 characters.");
			document.forms.changePassword.re_enter_password.focus();
			return false;
		}
		var n=password.localeCompare(reEnterPassword);
		if(n!=0)
		{
			alert("password and ReEnter Password should be same.");
			document.forms.changePassword.re_enter_password.focus();
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
               <!--<div class="hedder-up row">
                  <div class="col-lg-3 col-md-3 logo-head">
                    <i><h1><a class="navbar-brand" href="index.html"><center>Change your password</center> 	</a></h1></i>
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
                        <a class="nav-link" href="AboutUs.html" target="_blank">About Us</a>
                     </li>
					 <li class="nav-item">
                        <a class="nav-link" href="ContactUs.html">Contact Us</a>
                     </li>
                  </ul>
               </div>
            </nav>
         </div>
           
         <div class="slider text-center">
            <div class="callbacks_container">
               <ul class="rslides" id="slider4">
                  <li>
                     <div class="slider-img five-img">
                        <div class="container">
                           <br>
						   <p align="center"><font size="42" color="black"><ins><i>Change Password</i></ins></font></p><br><br><br><br><br><br>
						   <form  align="center" action="AuthenticationController" method="post" name="changePassword" onsubmit="return validate()">

								<table align="center" cellspacing="4" cellpadding="10">
								<tr><td>&nbsp &nbsp &nbsp  * <b>Enter Password:</b></td><td><input type="password" name="password" maxlength="8" required><font color="red"><sup>*</sup></font></td></tr>
								<tr><td>&nbsp &nbsp &nbsp  * <b>Re-enter Password:</b></td><td><input type="password" name="re_enter_password" maxlength="8" required><font color="red"><sup>*</sup></font></td></tr>

	</table><br>
	<center>
	<pre>             <input type="submit" name="change_password" value="Save" style="width: 120px; height: 30px;">  <input type="reset" value="Reset" style="width: 120px; height: 30px;">  </pre>
	</center>
	
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