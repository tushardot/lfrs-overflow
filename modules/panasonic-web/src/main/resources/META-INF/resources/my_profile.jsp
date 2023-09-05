<%@ include file="/init.jsp" %>
<%@include file="/header.jsp" %>
<%@ page import="panasonic.web.portlet.PanasonicWebPortlet" %>
<portlet:renderURL var="myProfileJsp">
<portlet:param name="mvcPath" value="/my_profile.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="quespage">
<portlet:param name="mvcPath" value="/addques.jsp"/>
</portlet:renderURL>
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

</style>

<p><h1>Hello</h1></p>
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

















