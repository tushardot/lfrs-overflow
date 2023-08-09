<%@ include file="/init.jsp" %>
<portlet:renderURL var="renderJSPVariable">
<portlet:param name="mvcPath" value="/createuser.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="renderforgot">
<portlet:param name="mvcPath" value="/forgotpass.jsp"/>
</portlet:renderURL>
<portlet:actionURL name="loginfo" var="loginfoActionURL"></portlet:actionURL>


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
					</div>

					<div class="signin-form">
						<h2 class="form-title">Sign in</h2>
						<aui:form method="post" action="${loginfoActionURL}" class="register-form"
							id="login-form">
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <aui:input
									type="text" name="username" id="username" placeholder="Username" label=""/>
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <aui:input
									type="password" name="password" id="password"
									placeholder="Password" label=""/>
							</div>
							<div class="form-group">
								
									<a href="<%=renderforgot.toString()%>" style="color: blue;">
						Forgot password?</a>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" />
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