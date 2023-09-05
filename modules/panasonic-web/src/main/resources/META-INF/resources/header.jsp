<%@ include file="/init.jsp" %>
<%@ page import="panasonic.web.portlet.PanasonicWebPortlet" %>
<portlet:renderURL var="loginpage">
<portlet:param name="mvcPath" value="/login.jsp"/>
</portlet:renderURL>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>liferay overflow</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"> 
    <style>
  				
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
  		202
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
  		
  		.item.button {ebar</div>
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
 #searchBar {
            display: none;
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
    
    <nav class="nav" id="header">
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
   
    
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"> </script>

