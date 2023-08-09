<%@ include file="/init.jsp" %>
<portlet:renderURL var="renderJSPVariable">
<portlet:param name="mvcPath" value="/createuser.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="renderlogin">
<portlet:param name="mvcPath" value="/login.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="renderforgot">
<portlet:param name="mvcPath" value="/forgotpass.jsp"/>
</portlet:renderURL>
<portlet:actionURL name="forgotinfo" var="forgotinfoActionURL"></portlet:actionURL>


<portlet:renderURL var="renderpass">
<portlet:param name="mvcPath" value="/newpass.jsp"/>
</portlet:renderURL>

<%@ page import="panasonic.web.portlet.PanasonicWebPortlet" %>
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

<style>
	
</style>
</head>
<body>

	<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.flaticon.com%2Ffree-icon%2Fuser_149071&psig=AOvVaw1xmffJ8KwTwhe9ROXM9PMe&ust=1691132500627000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCJCYqtH1v4ADFQAAAAAdAAAAABAE" alt="sing up image">
						</figure>
						
						<a href="<%=renderJSPVariable.toString()%>" class="signup-image-link">
						<p>New User!</p>Create an
							account</a>
							
							<a href="<%=renderlogin.toString()%>" class="signup-image-link">I am already
							member</a>
					</div>
							
							

					<div class="signin-form">
						<h2 class="form-title">Forgot Password</h2>
						<p>Forgot your account's password? Enter your email address and we we'll send you an otp through which you can reset your password.</p>
						<aui:form method="post" action="${forgotinfoActionURL}" class="register-form"
							id="login-form">
						
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <aui:input
									type="email" name="email" id="email"
									placeholder="email" label=""/>
							</div>
							<div class="form-group">
								
							
							</div>
							<div class="form-group form-button">
								<input type="submit" name="getotp" id="getotp"
									class="form-submit" value="Get OTP" />
							</div>
						</aui:form>
						<div class="social-login">
							<span class="social-label">Or login with</span>
							<ul class="socials">
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-facebook"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-twitter"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-google"></i></a></li>
							</ul>
						</div>
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