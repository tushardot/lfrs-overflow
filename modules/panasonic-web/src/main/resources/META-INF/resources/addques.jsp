<%@ include file="/init.jsp" %>

<portlet:actionURL name="addques" var="addquesActionURL"></portlet:actionURL>
<portlet:renderURL var="loginpage">
<portlet:param name="mvcPath" value="/login.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="createuserpage">
<portlet:param name="mvcPath" value="/createuser.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="quespage">
<portlet:param name="mvcPath" value="/addques.jsp"/>
</portlet:renderURL>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/META-INF/resources/css/style.css">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Question Form</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"> 
    
	 <style>
    	*{
    		box-sizing: border-box;
    		padding: 0;
    		margin: 0;
  		}
  		
  		.toggle{
			margin-bottom: 15px;
  		}
  		
  		 body {
   			 font-family: sans-serif;
  		}
  				
  		.nav ul{
  			background: #1c395e;
   			padding: 0px 20px;
   			width: 100%;
   			margin-left: -16px;
   			margin-top: -16px;
  		}
  		
  		.nav li{
  			list-style: none;
  		}
  		
  		.nav a{
    		color: white;
    		text-decoration: none;
  		}
  		
  		.nav a:hover {
    		text-decoration: underline;
  		}
  		
  		.logo a:hover {
   	 		text-decoration: none;
  		}
  		
  		.logo a, .toggle a {
    		font-size: 20px;
  		}
  		
  		.button.secondary {
    		border-bottom: 1px #444 solid;
  		}
  			
  		.menu li{
   			font-size: 22px;
    		padding: 15px 5px;
    		white-space: nowrap;
  		}
  		
  		/* Mobile menu */
  		.menu {
    		display: flex;    
    		flex-wrap: wrap;
    		justify-content: space-between;
    		align-items: center;		
  		}
  		
  		.toggle {
    		order: 1;
  		}
  		
  		.item.button {
    		order: 2;
  		}
  					
  		.item {
    		width: 100%;
    		text-align: center;
    		order: 3;
    		display: none;
  		}
  		
  		.item.active {
    		display: block;
  		}
  
  		/* Navbar Toggle */
  
  		.toggle {
    		cursor:pointer;
  		}
  		
  		.bars {
    		background: #999;
    		display: inline-block;
    		height: 2px;
    		position: relative;
    		transition: background .2s ease-out;
    		width: 18px;
  		}
  		
  		.bars:before,
  		.bars:after {
   			background: #999;
    		content: '';
    		display: block;
    		height: 100%;
    		position: absolute;
    		transition: all .2s ease-out;
    		width: 100%;
  		}
  		
  		.bars:before {
    		top: 5px;
  		}
  		
  		.bars:after {
    		top: -5px;
  		}
  		
  		/* Tablet menu */
  		
  		@media all and (min-width: 592px) {
    	
    	.menu {
        	justify-content: center;
    	}
  
    	.logo {
        	flex: 1;
    	}
  
    	.item.button {
        	width: auto;
        	order: 1;
        	display: block;
    	}
    	
    	.toggle {
        	order: 2;
    	}
    	
    	.button.secondary {
        	border: 0;
    	}
    	
    	.button a {
        	padding: 7.5px 15px;
        	background: teal;
        	border: 1px #006d6d solid;
        	border-radius: 5px;
    	}
    	
    	.button.secondary a {
        	background: transparent;    
    	}
    	
    	.button a:hover {
        	text-decoration: none;
        	transition:all .25s;
    	}
    	
    	.button:not(.secondary) a:hover {
        	background: #006d6d;
        	border-color: #005959;
    	}
    	
    	.button.secondary a:hover {
        	color: #ddd;
    	}
    	
    	
  	}
  	
  	/* Desktop menu */
  		@media all and (min-width: 1100px) {
  		
    	.item {
        	display: block;
        	width: auto;
    	}

	    .toggle {
        	display: none;
    	}
    	
    	.logo {
        	order: 0;
    	}
    	
    	.item {
        	order: 1;
    	}
    	
    	.button {
        	order: 2;
    	}
    	
    	.menu li {
        	padding: 15px 10px;
    	}
    	
    	.menu li.button {
        	padding-right: 0;
    	}
  	}
    </style>
    
    <script
    src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
    integrity="sha256-pasqAKBDmFT4eHoN2ndd6lN370kFiGUFyTiUHWhU7k8="
    crossorigin="anonymous"></script>
    <script>
    $(function() {
    $(".toggle").on("click", function() {
        if ($(".item").hasClass("active")) {
            $(".item").removeClass("active");
        } else {
            $(".item").addClass("active");
        }
    });
});
    </script>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container-question {
            max-width: 600px;
            margin: 200px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        textarea {
            resize: vertical;
        }
        input[type="submit"] {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<nav class="nav">
        <ul class="menu">
			<li><img src="https://media.trustradius.com/product-logos/k2/oa/612TV5WCJ19M.PNG" width="50px"></li>
            <li class="logo"><a href="#"><b>LiferayOverflow</b></a></li>
            <li class="item"><img src=""><a href="<portlet:renderURL><portlet:param name="mvcPath" value="/landing.jsp"/></portlet:renderURL>">Home</a></li>
            <li class="item"><a href="#">About</a></li>
            <li class="item"><a href="#">Services</a></li>
			<li class=""><i class="fa-solid fa-magnifying-glass" style="color: #ffffff;"></i></li>
			<%-- <li class="item button"><aui:button type="submit" value="Ask Question" onClick="<%=quespage.toString()%>"></aui:button></li> --%>
            <li class="item button secondary"><aui:button type="submit" value="Log out" class="item button" onClick="<%=loginpage.toString()%>"></aui:button></li>
            <li class="toggle"><span class="bars"></span></li>
        </ul>
    </nav>
    
    <div class="container-question">
        <h1>Ask a Question</h1>
        <aui:form method="post" action="${addquesActionURL}">
            
            	<div class="form-group">
            	    <aui:input type="text" name="title" id="title" placeholder="Question Title:" label=""/>
				</div>
				
				<div class="form-group">
					<aui:input type="textarea" name="desc" id="desc" placeholder="Question Description:" label=""/>
				</div>
							
				<div class="form-group">
            		<input type="submit" value="Submit">
        		</aui:form>
	</div>
</body>
</html>
