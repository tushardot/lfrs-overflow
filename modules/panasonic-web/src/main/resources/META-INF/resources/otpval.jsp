
    </form><%@ include file="/init.jsp" %>
<portlet:renderURL var="renderJSPVariable">
<portlet:param name="mvcPath" value="/createuser.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="renderlogin">
<portlet:param name="mvcPath" value="/login.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="renderforgot">
<portlet:param name="mvcPath" value="/forgotpass.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="otpvalidation" var="otpinfoActionURL"></portlet:actionURL>



<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">


<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/META-INF/resources/css/style.css">

<style>
	   
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        .otpcontainer {
            width: 100%;
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
        }

        h1 {
            color: #333333;
            margin-bottom: 20px;
        }


        .otp-input input {
          
            text-align: center;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-top: 20px;
        }
        

        button {
            background-color: #3498db;
            color: #ffffff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 50px;
        }

        button:hover {
            background-color: #2980b9;
        }
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
						
						
				       <div class="otpcontainer">
        <h1>Enter OTP</h1>
        <aui:form action="${otpinfoActionURL}" method="post">
            <div class="otp-input">
            <aui:row>
				<aui:col width="25">
					<aui:input type="text" label="" name="otp1" id="otp1" maxlength="1"/>
				</aui:col>
				<aui:col width="25">
					<aui:input type="text" label="" name="otp2" id="otp2" maxlength="1"/>
				</aui:col>
				<aui:col width="25">
					<aui:input type="text" label="" name="otp3" id="otp3" maxlength="1"/>
				</aui:col>
				<aui:col width="25">
					<aui:input type="text" label="" name="otp4" id="otp4" maxlength="1"/>
				</aui:col>
			</aui:row>
            </div>
            <button type="submit">Verify OTP</button>
        </aui:form>
    </div>

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

</body>
</html>
