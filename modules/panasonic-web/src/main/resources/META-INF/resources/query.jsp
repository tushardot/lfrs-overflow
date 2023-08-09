<%@ include file="/init.jsp" %>
<%@ page import="queries.service.model.question" %>
<%@ page import="panasonic.web.portlet.PanasonicWebPortlet" %>
<%@ page import="java.util.*" %>
<%@ page import="queries.service.service.questionLocalServiceUtil;" %>

<portlet:renderURL var="querypage">
<portlet:param name="mvcPath" value="/query.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="loginpage">
<portlet:param name="mvcPath" value="/login.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="createuserpage">
<portlet:param name="mvcPath" value="/createuser.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="quespage">
<portlet:param name="mvcPath" value="/addques.jsp"/>
</portlet:renderURL>



<portlet:actionURL name="addanswerinfo" var="addanswerActionURL"></portlet:actionURL>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>liferay overflow</title>
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
   			padding: 5px 20px;
   			width: 100%;
   			margin-left: -16px;
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
        	justify-content: center;getallqueries
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
  	
  	/* questions */
  	
  	 

        .container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 400px;
            margin: 200px auto;
        }

        h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
        }

        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }

        input[type="submit"] {
            background-color: #007bff;
            border: none;
            color: white;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

  	  .aui-hide{
  	  display: none;
  	  }
  	
    </style>
    
    <script
    src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
    integrity="sha256-pasqAKBDmFT4eHoN2ndd6lN370kFiGUFyTiUHWhU7k8="
    crossorigin="anonymous"></script>
    
</head>
<body>
    <nav class="nav">
        <ul class="menu">
			<li><img src="https://media.trustradius.com/product-logos/k2/oa/612TV5WCJ19M.PNG" width="50px"></li>
            <li class="logo"><a href="#"><b>LiferayOverflow</b></a></li>
            <li class="item"><img src=""><a href="<portlet:renderURL><portlet:param name="mvcPath" value="/landing.jsp"/></portlet:renderURL>">Home</a></li>
            <li class="item"><a href="#">About</a></li>
            <li class="item"><a href="#">Services</a></li>
			<li class=""><i class="fa-solid fa-magnifying-glass" style="color: #ffffff;"></i></li>
            <li class="item button"><a href="#">Log In</a></li>
            <aui:button type="submit" value="Ask Ques" class="item button" onClick="<%=quespage.toString()%>"></aui:button>
            <aui:button type="submit" value="Log In" class="item button" onClick="<%=loginpage.toString()%>"></aui:button>
            <aui:button type="submit" value="Sugn Up" class="item button" onClick="<%=createuserpage.toString()%>"></aui:button>
            <li class="item button secondary"><a href="#">Sign Up</a></li>
            <li class="toggle"><span class="bars"></span></li>
        </ul>
    </nav>
    
    
    <div class="container">
    <h1>Answer the Question</h1>
     <% 
     long quesId = PanasonicWebPortlet.getquesId();
     question ques = questionLocalServiceUtil.getquestion(quesId); 
     String questitle = ques.getQuesTitle();
     String quesdesc = ques.getQuesDesc();
     %>
    <aui:form method="post" action="${addanswerActionURL}">
        <label for="question" >Question:<%=questitle %></label>
        
        <p><%=quesdesc %></p>
        <aui:input cssClass="aui-hide" type="text"  name= "questionid" value= "<%=quesId %>" label=""/>
        <label for="Answer"><i class="zmdi zmdi-lock"></i></label> <aui:input
									type="textarea" name="answer" id="answer"
									placeholder="Your Answer" label=""/>
        
        <input type="submit" value="Submit Answer">
    </aui:form>
</div>
     
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"> </script>
</body>
</html>
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
    
    $(document).ready(function () {
        $(".btn-toggle").click(function () {
            var answer = $(this).prev(".answer");
            answer.slideToggle();
        });
    });
    
    
    console.log("queries"); 
    
    </script>