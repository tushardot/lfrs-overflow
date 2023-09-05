<%@ include file="/init.jsp" %>
<portlet:renderURL var="loginpage">
<portlet:param name="mvcPath" value="/login.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="indexpage">
<portlet:param name="mvcPath" value="/mail.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="createuserpage">
<portlet:param name="mvcPath" value="/createuser.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="quespage">
<portlet:param name="mvcPath" value="/addques.jsp"/>
</portlet:renderURL>
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
   			 overflow: hidden;
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
  	
  	/* slider */
  	
  	 .slider-card {
        margin: 200px auto;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            max-width: 50%;
            position: relative;
        }

        .slider-container {
            position: relative;
            width: 100%;
            padding-top: 56.25%; /* 16:9 aspect ratio (9 / 16 * 100) */
            overflow: hidden;
        }

        .slide {
            display: none;
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-size: cover;
            background-position: center;
        }

        .slider-indicators {
            position: absolute;
            bottom: 10px;
            left: 50%;
            transform: translateX(-50%);
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .indicator {
            width: 12px;
            height: 12px;
            background-color: #bbb;
            border-radius: 50%;
            margin: 0 6px;
            cursor: pointer;
        }

        .active {
            background-color: #333;
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
</head>
<body>
    <nav class="nav">
        <ul class="menu">
			<li><img src="https://media.trustradius.com/product-logos/k2/oa/612TV5WCJ19M.PNG" width="50px"></li>
            <li class="logo"><a href="#"><b>LiferayOverflow</b></a></li>
            <li class="item"><img src=""><a href="#">Home</a></li>
            <li class="item"><a href="#">About</a></li>
            <li class="item"><a href="#">Services</a></li>
			<li class=""><i class="fa-solid fa-magnifying-glass" style="color: #ffffff;"></i></li>
<%--             <li class="item button"><aui:button type="submit" value="Ask Ques" class="item button" onClick="<%=quespage.toString()%>"></aui:button><li> --%>
            <li class="item button"><aui:button type="submit" value="Log In" class="item button" onClick="<%=loginpage.toString()%>"></aui:button></li>
            <li class="item button secondary"><aui:button type="submit" value="Sign Up" class="item button" onClick="<%=createuserpage.toString()%>"></aui:button></li>
            <li class="toggle"><span class="bars"></span></li>
        </ul>
    </nav>
    
    <div class="slider-card">
        <div class="slider-container">
            <div class="slide" style="background-image: url('https://img.freepik.com/free-vector/tiny-people-carrying-key-open-padlock_74855-16292.jpg?w=1800&t=st=1691663405~exp=1691664005~hmac=d159023f3eeaa32900cd4c0255dc55b3eba0362976c089492f51f33486e5aa89');"></div>
            <div class="slide" style="background-image: url('https://img.freepik.com/free-vector/data-protection-law-illustration-concept_114360-971.jpg?w=1480&t=st=1691664799~exp=1691665399~hmac=f8af147ab8cb198cc57c7c6dd6677d72bf2d2dab398eee4eeab85289875ffcbc');"></div>
            <div class="slide" style="background-image: url('https://img.freepik.com/free-vector/computer-login-concept-illustration_114360-7862.jpg?w=1480&t=st=1691664315~exp=1691664915~hmac=22594fc20d31e1007de04fcec3759e7e4f9c6404442dcf8157bd1bb1a450fe7b');"></div>
        
         <div class="slide" style="background-image: url('https://img.freepik.com/free-vector/reviews-concept-landing-page_52683-11367.jpg?w=1480&t=st=1691664383~exp=1691664983~hmac=84ecf28f6ca733f468487fa8f78aeb41ccaf1eba62e229110907bf1d5f19cfe3');"></div>
        </div>
        <div class="slider-indicators">
            <div class="indicator"></div>
            <div class="indicator"></div>
            <div class="indicator"></div>
             <div class="indicator"></div>
        </div>
    </div>
  <%--    <aui:button type="submit" value="mail" onClick="<%=indexpage.toString()%>"></aui:button>  --%>
    <script>
        let slideIndex = 0;
        showSlides(slideIndex);

        function showSlides(index) {
            let slides = document.getElementsByClassName("slide");
            let indicators = document.getElementsByClassName("indicator");
            for (let i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
                indicators[i].classList.remove("active");
            }
            slides[index].style.display = "block";
            indicators[index].classList.add("active");
            slideIndex = index;
            setTimeout(() => showSlides((slideIndex + 1) % slides.length), 2000); // Change slide every 2 seconds
        }
    </script>
</body>
</html>