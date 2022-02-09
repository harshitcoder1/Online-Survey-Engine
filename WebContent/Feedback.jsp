<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">
   <head>
      <title>Feedback</title>
      <!--meta tags -->
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      
      <script>
         addEventListener("load", function () {
         	setTimeout(hideURLbar, 0);
         }, false);
         
         function hideURLbar() {
         	window.scrollTo(0, 1);
         }
      </script>
      <!--//meta tags ends here-->
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
		var description=document.forms.giveFeedback.description.value;
		if(description=="")
		{
			alert("description should be filled out");
			document.forms.giveFeedback.description.focus();
			return false;
		}
		else if(!isNaN(description))
		{
			alert("please enter a valid description.");
			document.forms.giveFeedback.description.focus();
			return false;
		}
		
		return true;
	}
	
</script>
   </head>
   <body>
      <div class="header-outs" id="home">
         <div class="header-bar">
            <div class="container-fluid">
               <div class="hedder-up row">
                  <div class="col-lg-3 col-md-3 logo-head">
                     <h1><i><a class="navbar-brand" href="index.jsp">Online Survey system</a></i></h1>
                  </div>
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
                        <a href="LoginAdmin.jsp" class="nav-link">Admin</a>
                     </li>
                     <li class="nav-item">
                        <a href="LoginUser.jsp" class="nav-link">User</a>
                     </li>
                     <li class="nav-item">
                        <a href="AboutUs.html" target="_blank" class="nav-link">About us</a>
                     </li>
					 <li class="nav-item">
                        <a class="nav-link" href="#ContactUs">Contact Us</a>
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
						<br><br><br><br><br><br><br>
   						  <p align="center"><font size="42" color="black"><ins><i>Feedback</i></ins></font></p><br>
								<form  align="center" action="AuthenticationController" method="post" name="giveFeedback" onsubmit="return validate()">

									<table align="center" cellspacing="4" cellpadding="5" >
										<tr><td><b>Give Suggestion:</b></td><td><textarea rows="4" cols="50" placeholder="Enter your Description here" name="description" required></textarea><font size="5" color="red"><sup>*</sup></font></td></tr>
									</table><br>
								<center><input type="submit" name="giveFeedback" value="SUBMIT" style="width: 120px; height: 30px;"></center>
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

      <!--Product-about-->
      <section class="about py-lg-4 py-md-3 py-sm-3 py-3">
         <div class="container py-lg-5 py-md-5 py-sm-4 py-3">
            <h3 class="title text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">About E-Survey</h3>
            <div class="about-products-w3layouts">
               <p>Internet surveys are becoming an essential research tool for a variety of research fields, including marketing, social and official statistics research.
			   According to ESOMAR online survey research accounted for 20% of global data-collection expenditure in 2006.
			   They offer capabilities beyond those available for any other type of self-administered questionnaire.
			   Online consumer panels are also used extensively for carrying out surveys but the quality is considered inferior because the panelists are regular contributors and tend to be fatigued.
			   However, when estimating the measurement quality (defined as product of reliability and validity) using a multitrait-mutlimethod approach (MTMM), some studies found a quite 
			   reasonable quality and even that the quality of a series of questions in an online opt-in panel (Netquest) was very similar to the measurement quality for the same questions asked in the European Social Survey (ESS),which is a face-to-face survey.
               
			   Some studies have compared the quality of face-to-face surveys and/or telephone surveys with that of online surveys, 
			   for single questions, but also for more complex concepts measured with more than one question (also called Composite Scores or Index).
			   Focusing only on probability-based surveys (also for the online ones), they found overall that the face-to-face (using show-cards) and web surveys have quite similar levels of measurement quality, whereas the telephone surveys were performing worse. 
			   Other studies comparing paper-and-pencil questionnaires with web-based questionnaires showed that employees preferred online survey approaches to the paper-and-pencil format
               </p>
			   <br>
			   <p>
			   <h2>Advantages of online surveys</h2></p><br>
			   <p>
				<b>1.</b>Web surveys are faster, simpler, and cheaper.However, lower costs are not so straightforward in practice, as they are strongly interconnected to errors.
				Because response rate comparisons to other survey modes are usually not favourable for online surveys, efforts to achieve a higher response rate (e.g., with traditional solicitation methods) may substantially increase costs.<br>
				<b>2.</b> The entire data collection period is significantly shortened, as all data can be collected and processed in little more than a month.<br>
				<b>3.</b> Interaction between the respondent and the questionnaire is more dynamic compared to E-mail or paper surveys.Online surveys are also less intrusive, and they suffer less from social desirability effects.
               </p>
			</div>
         </div>
      </section>
      <!--//Product-about-->
      <!--subscribe-address-->
      <section class="subscribe">
         <div class="container-fluid">
         <div class="row">
            <div class="col-lg-6 col-md-6 map-info-right px-0">
            </div>
         </div>
		 </div>
      </section>
      <!--//subscribe-address-->
      <section class="sub-below-address py-lg-4 py-md-3 py-sm-3 py-3" id="ContactUs">
         <div class="container py-lg-5 py-md-5 py-sm-4 py-3">
            <h3 class="title clr text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">Get In Touch with Us</h3>
            <div class="icons mt-4 text-center">
               <ul>
                  <li><a href="https://www.facebook.com"><span class="fab fa-facebook-f"></span></a></li>
                  <li><a href="https://www.twitter.com"><span class="fab fa-twitter"></span></a></li>
                  <li><a href="https://www.github.com"><span class="fab fa-github"></span></a></li>
                  <li><a href="https://in.linkedin.com/"><span class="fab fa-linkedin-in"></span></a></li>
               </ul>
               <p class="my-3">
			   Subscribe to our Page and we'll contact you within next 24 hours.
               </p>
            </div>
            <div class="email-sub-agile">
               <form action="" method="post">
                  <div class="form-group sub-info-mail">
                     <input type="email" class="form-control email-sub-agile" placeholder="Enter your Email here">
                  </div>
                  <div class="text-center">
                     <button type="submit" class="btn subscrib-btnn">Subscribe</button>
                  </div>
               </form>
            </div>
         </div>
      </section>
      <!--//subscribe-->
      <!-- footer -->
      <!-- //footer -->
      </div>
   </body>
</html>