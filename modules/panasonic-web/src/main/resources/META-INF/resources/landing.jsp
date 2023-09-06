<%@ include file="/init.jsp" %>
<%@ page import="queries.service.model.question" %>
<%@ page import="queries.service.model.answer" %>
<%@ page import="panasonic.web.portlet.PanasonicWebPortlet" %>
<%@ page import="java.util.*" %>


<portlet:actionURL name="queryinfo" var="queryActionURL"></portlet:actionURL>

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


<portlet:renderURL var="myProfileJsp">
<portlet:param name="mvcPath" value="/my_profile.jsp"/>
</portlet:renderURL>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>liferay overflow</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
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
  			position: fixed;
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
  		margin-left: 10px;
  	* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
}

.container-landing {
    max-width: 800px;
    margin: 20px auto;
    padding: 20px;
}

.questions {
    display: grid;
    gap: 20px;
}

.question-card {
    border: 1px solid #ddd;
    background-color: #fff;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.question-card h2 {
    margin-bottom: 10px;
}

.btn-toggle {
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    padding: 5px 10px;
    cursor: pointer;
    transition: background-color 0.3s ease-in-out;
}

.btn-toggle:hover {
    background-color: #0056b3;
}

.answer {
    margin-top: 10px;
    padding: 10px;
    border: 1px solid #eee;
    border-radius: 5px;
    background-color: #f9f9f9;
 
}


  .user-info {
   
    right: 10px;
   
}

 .aui-hide{
 display: none;
 }
   
    .post-by {
    		width: 150px;
    		
    		margin-left: 550px;
            background-color: #e0e0e0;
            padding: 2px 5px;
            font-size: 12px;
            border-radius: 3px;
        }
        
        .ask-by {
    		width: 150px;
    		
    	
            background-color: #e0e0e0;
            padding: 2px 5px;
            font-size: 12px;
            border-radius: 3px;
        }
        /*welcome card  */
    
    
    .welcome-card {
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            padding: 30px;
            width: 80%;
            max-width: 800px;
            text-align: center;
            margin: 100px auto;
            margin-bottom: 0px;
        }
        .user-name {
            font-size: 28px;
            font-weight: bold;
            margin-bottom: 10px;
            color: #2c3e50; /* Dark blue color */
        }
        .message {
            font-size: 18px;
            color: #34495e; /* Slightly lighter blue color */
            margin-bottom: 20px;
        }
        
        .user-name1{
            color: #2c3e50;
        }
        

        .container-sidebar {
            margin-top: 100px;
            float: left;
            position: fixed;
        }

        .sidebar {
            width: 300px;
            background-color: #333;
            color: #fff;
            padding: 20px;
            box-shadow: 2px 0 10px rgba(0, 0, 0, 0.2);
        }

        

        .sidebar-title {
            font-size: 2rem;
            margin-bottom: 20px;
            color: #ff6f61;
        }

        .sidebar-section {
            margin-bottom: 30px;
        }

        .sidebar-section a {
            text-decoration: none;
            color: inherit;
            align-items: center;
        }

        .sidebar-section a:hover {
            color: #ff6f61;
        }

        .sidebar-icon {
            font-size: 2rem;
            margin-right: 10px;
        }

  

        h2 {
            font-size: 1.8rem;
            margin-bottom: 5px;
        }

        p {
            font-size: 1.1rem;
            line-height: 1.6;
        }

        .content {
      float: left;
      margin-left: 460px;
        }

        /* Icons */
        .fa-globe-americas {
            color: #ff6f61;
        }

  	  .all-div{
  	  max-width : 80%;
  	  margin : 0px auto;
  	  }
  	  
  	  
  	   #searchBar {
            display: none;
        }

        /* Style for the search bar */
        #searchInput {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
    #searchResultsContainer {
            display: none;
            position: fixed;
            top: 100px;
            right: 400px;
            width: 300px;
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 4px;
            overflow-y: auto;
            max-height: 300px;
        }

        /* Style for the search results */
        #searchResults {
            padding: 10px;
        }
         .resultItem {
            cursor: pointer;
            padding: 8px;
            border-bottom: 1px solid #ccc;
        }

        .resultItem:hover {
            background-color: #f2f2f2;
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
            <div id="searchBar">
        <input type="text" id="searchInput" placeholder="Search...">
        <button type="submit" value="Search"  onClick="performSearch()">Search</button>
         </div>
			<li class=""><i class="fa-solid fa-magnifying-glass" style="color: #ffffff;"  onclick="toggleSearchBar()" ></i></li>
			
   
			<%-- <li class="item button"><aui:button type="submit" value="Ask Question" onClick="<%=quespage.toString()%>"></aui:button></li> --%>
            <li class="item button secondary"><aui:button type="submit" value="Log out" class="item button" onClick="<%=loginpage.toString()%>"></aui:button></li>
            <li class="toggle"><span class="bars"></span></li>
        </ul>
    </nav>
   <div class = "all-div">
    <div class="container-sidebar">
        <div class="sidebar">
            <div class="sidebar-title">Awesome Sidebar</div>
            <div class="sidebar-section your-contribution">
                <a href="<%=myProfileJsp.toString()%>">
                    <div class="sidebar-icon"><i class="fas fa-pencil-alt"></i></div>
                    <div class="sidebar-content">
                        <h2>Your Contribution</h2>
                        <p>Share your ideas and make an impact.</p>
                    </div>
                </a>
            </div>
            <div class="sidebar-section public">
                <a href="#">
                    <div class="sidebar-icon"><i class="fas fa-globe-americas"></i></div>
                     <div class="sidebar-content">
                        <h2>Public</h2>
                        <p>Explore public content from our community.</p>
                    </div>
                </a>
            </div>	
        </div>

       
    </div>
    
    
    <% String usern = PanasonicWebPortlet.getuser(); %>
    <div class = "content">
   <div class="welcome-card">
    <div class="user-name">Welcome, <%=usern %>!</div>
    <div class="message">Get ready to dive into a world of knowledge, collaboration, and problem-solving. Our Lioferay Overflow is your gateway to an expansive community of experts and learners.</div>
    <aui:button  type="submit" value="Ask Question" onClick="<%=quespage.toString()%>"></aui:button>
</div>
     
     	
     	
     <div class="container-landing">
     
     <div class="card" style="width: 18rem;">
   		
</div>
        <h1>Questions and Answers</h1>
        <div class="questions">
    <% List<question>  queries = PanasonicWebPortlet.getallqueries();
   
    long id;
    System.out.println(queries);
    for (question ques : queries){
    	String title = ques.getQuesTitle();
    	String desc = ques.getQuesDesc();
        String username = ques.getUserName();	
        id = ques.getQuesId();
        List<answer> ans = PanasonicWebPortlet.getansbyqid(id);
        System.out.println(ans);
    %>

           <aui:form method="post" action="${queryActionURL}"> 
            <div class="question-card">
             <div class="user-info">
                    <span class="ask-by">asked by: <h5 class="user-name1"> <%=username%></h5></span> 
                </div>
                <div class="question">
               
                    <h2><%= title %> </h2>
                    <p> <%=desc %>  </p>
                </div>
                <% if(ans.isEmpty()){
                	System.out.println("not found");
                	%>
                
                <div class="answer">
                    <p>No replies yet.....</p>
                </div>
                <% } 
                else{
                	for(answer ans1 : ans){
                		%>
                		<div class="answer">
                        <p><%=ans1.getAnsDesc() %></p>
                        <div class="post-by">Posted by:<h5 class="user-name1"><%=ans1.getUserName() %></h5></div>
                    </div>
                    
                    <% 
                	}
                }
                %>
                <aui:input cssClass="aui-hide" type="text"  name= "questionid" value= "<%=id %>" label=""/>
                
               
          <aui:button type="submit" value="Post Answer" class="item button"></aui:button>
            </div>
            </aui:form>
            <!-- Add more question cards here as needed -->
            
   
     
    <% } %>
       </div>
    </div>
    </div>
    </div>
     <div id="searchResultsContainer">
        <div id="searchResults">
            <!-- Search results will be displayed here -->
        </div>
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
    console.log(<%=queries%>)
    
    const data =  <%=queries%>;
    console.log(typeof data);
    const new1 = [];
    console.log(typeof new1);
     function toggleSearchBar() {
            const searchBar = document.getElementById('searchBar');
            searchBar.style.display = (searchBar.style.display === 'block') ? 'none' : 'block';
        }

        function performSearch() {
            // Implement search functionality here
            const searchInput = document.getElementById('searchInput').value;
            const results = [];
            for (const item of data) {
            	
                 if (item.quesDesc.toLowerCase().includes(searchInput)) {
                    results.push(item);
                    console.log(item.quesDesc);
                } 
            }
            
            
          
             displayResults(results);  
          
        }
        
        function displayResults(results){
        	console.log("function called");
        	console.log(results.length);
        	const resultsContainer = document.getElementById('searchResults');
        	  resultsContainer.innerHTML = ''; 
            if (results.length === 0) {
                resultsContainer.innerHTML = "No results found.";
                console.log("No results found")
            }
            else {
            	
            	for (const result of results){
            		console.log(" results found")
            		
            		 var quesid = result.quesId;
            		 console.log(quesid);
            		const resultItem = document.createElement('div');
            		resultItem.classList.add('resultItem');
            	 resultItem.textContent = result.quesDesc;
            	 console.log(resultItem);
            	 console.log(result);
            	/*  resultItem.addEventListener('click', "<portlet:renderURL  var="answerURL">
                         <portlet:param name="questionId" value="/query.jsp?quesId=quesid" />
                             </portlet:renderURL>");
                 }); */
            	 <% //PanasonicWebPortlet.newId(quesid);
            	// long quesid = Long.parseLong(request.getAttribute("quesid").toString());
            	 //System.out.println(quesid);%>
                 resultsContainer.appendChild(resultItem);
                 console.log(resultsContainer);
            	}
            }
        }
        /* function displayResults(results) {
            const resultsContainer = document.getElementById("searchResults");
            resultsContainer.innerHTML = ""; // Clear previous results

            if (results.length === 0) {
                resultsContainer.innerHTML = "No results found.";
                console.log("No results found")
            } else {
                const ul = document.createElement("ul");
                for (const result of results) {
                    const li = document.createElement("li");
                    li.textContent = result.quesDesc;
                    console.log("this is result");
                    console.log(result.quesDesc);
                    ul.appendChild(li);
                }
                resultsContainer.appendChild(ul);
            }
        } */
        document.getElementById("searchInput").addEventListener("input", performSearch);
        searchResultsContainer.style.display = 'block';
    </script>