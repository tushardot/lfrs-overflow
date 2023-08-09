<%@ include file="/init.jsp" %>

<input id="myName" placeholder="Enter Email" name="email" type="email"/>
<button onClick="myFun(event)">Send Email</button>   

<Script>
async function myFun(event){
	console.log("Hello");
	event.preventDefault();
	const data=document.getElementById("myName").value;
	console.log(data);
	const obj = { 
			Email: data
	};
	console.log(obj);
	const abc = await fetch('http://localhost:8080/o/sendmail/v1.0/mail',{
		method:"POST",
		headers:{
			 Authorization: "Basic " + btoa("test@liferay.com:test"),
			 'Content-Type':"application/json"
		},
	body:JSON.stringify(obj)
	
	});
	const jsonData = await abc.json();
    console.log(jsonData);
}

</Script>