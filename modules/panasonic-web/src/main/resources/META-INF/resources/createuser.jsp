<%@ include file="/init.jsp" %>
				
<portlet:renderURL var="loginpage">
<portlet:param name="mvcPath" value="/login.jsp"/>
</portlet:renderURL>				
<portlet:actionURL name="addinfo" var="addinfoActionURL"></portlet:actionURL>



<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/META-INF/resources/css/style.css">
</head>
<body>

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
						<aui:form action="${addinfoActionURL}" method="post" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <aui:input
									type="text" name="name" id="name" placeholder="Name" label=""/>
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <aui:input
									type="email" name="email" id="email" placeholder="Your Email" label=""/>
							</div>
							<div class="form-group">
								<label for="Username"><i class="zmdi zmdi-lock-outline"></i></label>
								<aui:input type="text" name="username" id="username"
									placeholder="Username" label=""/>
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <aui:input
									type="password" name="pass" id="pass" placeholder="Password" label=""/>
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<aui:input type="password" name="re-pass" id="re_pass"
									placeholder="Repeat your password" label=""/>
							</div>
							
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</aui:form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="<%=request.getContextPath()%>/META-INF/resources/images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="<%=loginpage.toString()%>" class="signup-image-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>



</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>