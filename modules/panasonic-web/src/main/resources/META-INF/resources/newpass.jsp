
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

<portlet:actionURL name="forgotinfo" var="forgotinfoActionURL"></portlet:actionURL>
<portlet:actionURL name="chnagepassinfo" var="changepassinfoActionURL"></portlet:actionURL>


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


        button {
            background-color: #3498db;
            color: #ffffff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 20px;
        }

        button:hover {
            background-color: #2980b9;
        }
        
        input{
        margin-top: 15px;
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
							<img src="https://st.depositphotos.com/18722762/51522/v/600/depositphotos_515228796-stock-illustration-online-registration-sign-login-account.jpg" alt="sing up image">
						</figure>
						
						
														
					</div>

					<div class="signin-form">
						
						
				       <div class="otpcontainer">
        <h1>Change Password</h1>
        <aui:form method="post" action="${changepassinfoActionURL}">
            <div class="o">
            <aui:fieldset>
            <aui:row>
				<aui:col width="100">
					<aui:input type="password" label="" name="newPassword" id="newPassword" maxlength="16" placeholder="Enter New Password"/>
				</aui:col>
			</aui:row>
			</aui:fieldset>
			
			 <aui:fieldset>
			 <aui:row>
				<aui:col width="100">
					<aui:input type="password" label="" name="confirmPassword" id="confirmPassword" maxlength="16" placeholder="Enter Confirm Passwod"/>
				</aui:col>
			</aui:row>
			</aui:fieldset>
            </div>
            <button type="submit">Chnage Password</button>
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
