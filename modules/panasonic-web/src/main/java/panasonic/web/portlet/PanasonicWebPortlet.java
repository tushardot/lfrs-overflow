package panasonic.web.portlet;

import panasonic.service.model.channel;
import panasonic.service.service.channelLocalServiceUtil;
import panasonic.service.service.persistence.channelPersistence;
import panasonic.web.constants.PanasonicWebPortletKeys;
import queries.service.model.answer;
import queries.service.model.question;
import queries.service.service.answerLocalServiceUtil;
import queries.service.service.questionLocalServiceUtil;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;
import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author me
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PanasonicWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/home.jsp",
		"javax.portlet.name=" + PanasonicWebPortletKeys.PANASONICWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PanasonicWebPortlet extends MVCPortlet {
	
	
	
	static String localuser = "";
	static long quesId;
	//Add user method
	public void addinfo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception
	{
		String userName = ParamUtil.getString(actionRequest,"username");

		channel newuser = channelLocalServiceUtil.createchannel(userName);
		
		String useremail = ParamUtil.getString(actionRequest,"email");
		String name = ParamUtil.getString(actionRequest,"name");
		String password = ParamUtil.getString(actionRequest,"pass");
		newuser.setName(name);
		newuser.setEmail(useremail);
		newuser.setPassword(password);
		channelLocalServiceUtil.addchannel(newuser);
		System.out.println(newuser);
		System.out.println("User Created successfully");
		
		InternetAddress fromAddress = new InternetAddress("rahulkumarroy723@gmail.com");
		InternetAddress toAddress = new InternetAddress(useremail);
		
		try {
			System.out.println("post mail to " + useremail );
			
			MailMessage mailMessage = new MailMessage();
			mailMessage.setFrom(fromAddress);
			mailMessage.setTo(toAddress);
			mailMessage.setSubject("Confirm new user sign-ups");
			String emailTemplate = "<!DOCTYPE html>\n" +
			        "<html>\n" +
			        "<head>\n" +
			        "    <meta charset=\"UTF-8\">\n" +
			        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
			        "    <title>Welcome to Our Community!</title>\n" +
			        "    <style>\n" +
			        "        body {\n" +
			        "            font-family: Arial, sans-serif;\n" +
			        "            margin: 0;\n" +
			        "            padding: 0;\n" +
			        "        }\n" +
			        "\n" +
			        "        .container {\n" +
			        "            width: 100%;\n" +
			        "            max-width: 600px;\n" +
			        "            margin: 0 auto;\n" +
			        "            padding: 20px;\n" +
			        "            background-color: #f5f5f5;\n" +
			        "        }\n" +
			        "\n" +
			        "        .header {\n" +
			        "            text-align: center;\n" +
			        "            padding: 40px 0;\n" +
			        "        }\n" +
			        "\n" +
			        "        .content {\n" +
			        "            padding: 30px;\n" +
			        "            background-color: #ffffff;\n" +
			        "            border-radius: 10px;\n" +
			        "            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);\n" +
			        "        }\n" +
			        "\n" +
			        "        .footer {\n" +
			        "            text-align: center;\n" +
			        "            padding: 20px 0;\n" +
			        "        }\n" +
			        "\n" +
			        "        h1, h2, h3 {\n" +
			        "            color: #333333;\n" +
			        "        }\n" +
			        "\n" +
			        "        p {\n" +
			        "            color: #555555;\n" +
			        "            line-height: 1.6;\n" +
			        "        }\n" +
			        "\n" +
			        "        .button {\n" +
			        "            display: inline-block;\n" +
			        "            padding: 10px 20px;\n" +
			        "            background-color: #3498db;\n" +
			        "            color: #ffffff;\n" +
			        "            text-decoration: none;\n" +
			        "            border-radius: 5px;\n" +
			        "        }\n" +
			        "\n" +
			        "        .image-container {\n" +
			        "            text-align: center;\n" +
			        "            margin-bottom: 20px;\n" +
			        "        }\n" +
			        "\n" +
			        "        .image-container img {\n" +
			        "            max-width: 100%;\n" +
			        "            height: auto;\n" +
			        "        }\n" +
			        "    </style>\n" +
			        "</head>\n" +
			        "<body>\n" +
			        "\n" +
			        "    <div class=\"container\">\n" +
			        "        <div class=\"header\">\n" +
			        "            <h1>Welcome to Our Community!</h1>\n" +
			        "        </div>\n" +
			        "        <div class=\"content\">\n" +
			        "            <div class=\"image-container\">\n" +
			        "                <img src=\"https://example.com/path/to/community-logo.png\" alt=\"Community Logo\">\n" +
			        "            </div>\n" +
			        "            <h2>Hello " + name +"!,</h2>\n" +
			        "            <p>Welcome to our vibrant community! We are excited to have you on board.</p>\n" +
			        "            <p>Here, you'll find a place to connect, learn, and collaborate with fellow members who share your interests.</p>\n" +
			        "            <p>Feel free to explore and engage with the community discussions, events, and resources.</p>\n" +
			        "            <p>Thank you for joining us, and we look forward to your contributions!</p>\n" +
			        "            <p>Best regards,<br>Rahul</p>\n" +
			        "            <div style=\"text-align: center;\">\n" +
			        "                <a class=\"button\" href=\"#\">Explore Community</a>\n" +
			        "            </div>\n" +
			        "        </div>\n" +
			        "        <div class=\"footer\">\n" +
			        "            <p>&copy; 2023 Our Community. All rights reserved.</p>\n" +
			        "        </div>\n" +
			        "    </div>\n" +
			        "\n" +
			        "</body>\n" +
			        "</html>";


			 
			  mailMessage.setBody( emailTemplate);
			

			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
			System.out.println(fromAddress);
			System.out.println(toAddress);
			
			System.out.println("mail sended for testing to " + useremail);
			
			
         }catch(Exception e) {
			e.printStackTrace();
		}

			}
	
	//log-in user method
	@SuppressWarnings("deprecation")
	public void loginfo(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		System.out.println("Method called");
		String user = ParamUtil.getString(actionRequest,"username");
		
		if(user.isEmpty()) {
			System.out.println("Please enter username");
			String errorMessage = "Invalid username or password.";
			actionRequest.setAttribute("errorMessage", errorMessage);
			actionResponse.setRenderParameter("mvcPath", "/META-INF/resources/login.jsp");
			return;
		}
//		System.out.println(ParamUtil.getString(actionRequest,"username"));
//		System.out.println(ParamUtil.getString(actionRequest,"password"));
		
//		channel loginuser = channelLocalServiceUtil.getchannel(user); 
//		localuser = loginuser.getUserName();
		boolean checkuser = false;
//		System.out.println(loginuser);
		
		String pass = ParamUtil.getString(actionRequest,"password");
//		String existingpass = loginuser.getPassword();
	
		checkuser = isValidUser(user,pass);
		
		if(checkuser) {
			actionResponse.setRenderParameter("mvcPath", "/META-INF/resources/landing.jsp");
		}
		else {
			String errorMessage = "Invalid username or password.";
			actionRequest.setAttribute("errorMessage", errorMessage);
			System.out.println("invalid username or password");
			actionResponse.setRenderParameter("mvcPath", "/META-INF/resources/login.jsp");
		}
				
		
		
		
		
	}
	
	// user validation
	
	
	private boolean isValidUser(String username, String password) throws PortalException {
		try {
		channel loginuser = channelLocalServiceUtil.getchannel(username); 
		String existingpass = loginuser.getPassword();
		if(password.equals(existingpass)) {
			System.out.println("true");
			localuser = loginuser.getUserName();
			return true;
		}
	
		}
		catch(Exception e){
			
		
		}
		return false;
		
		}
	
	//send otp to user for forgot password
	
	@SuppressWarnings("deprecation")
	public void forgotinfo(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException{
		try {
		String email =ParamUtil.getString(actionRequest,"email");
		System.out.println("email" + email);
		channel userlist = channelLocalServiceUtil.getbyemail(email);
		InternetAddress fromAddress = new InternetAddress("rahulkumarroy723@gmail.com");
		InternetAddress toAddress = new InternetAddress(email);
		MailMessage mailMessage = new MailMessage();
		mailMessage.setFrom(fromAddress);
		mailMessage.setTo(toAddress);
		mailMessage.setSubject("otp");
		String otp = generateOTP(4);
		userlist.setOtp(otp);
		channelLocalServiceUtil.updatechannel(userlist);
		mailMessage.setBody(getTemplate(otp));
		
        localuser = userlist.getUserName();
		mailMessage.setHTMLFormat(true);
		MailServiceUtil.sendEmail(mailMessage);
		  
		
		actionResponse.setRenderParameter("mvcPath", "/META-INF/resources/otpval.jsp");
		
		System.out.println(userlist);}
		catch(Exception e) {
			System.out.println("User not found");
			
			
			
		}
	}
	
	public void otpvalidation(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		
		
		String userotp = ParamUtil.getString(actionRequest,"otp1") + ParamUtil.getString(actionRequest,"otp2") + ParamUtil.getString(actionRequest,"otp3") +ParamUtil.getString(actionRequest,"otp4");
		
		channel user = channelLocalServiceUtil.getchannel(localuser);
		System.out.println(user);
		System.out.println(userotp);
		String otp = user.getOtp();
		
		if(otp.equals(userotp)) {
			actionResponse.setRenderParameter("mvcPath", "/META-INF/resources/newpass.jsp");
			user.setOtp("");
			channelLocalServiceUtil.updatechannel(user);
		}
		else {
			System.out.println("Incorrect OTP...");
		}
		
	}
	
	public void chnagepassinfo(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException{
		
		channel user = channelLocalServiceUtil.getchannel(localuser);
		user.setPassword(ParamUtil.getString(actionRequest,"newPassword"));
		channelLocalServiceUtil.updatechannel(user);
		System.out.println("Password Updated Successfully");
		actionResponse.setRenderParameter("mvcPath", "/META-INF/resources/login.jsp");
	}
	
	
	
	//add question method
	public void addques(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		String questitle = ParamUtil.getString(actionRequest,"title");
		String quesdesc = ParamUtil.getString(actionRequest,"desc");
		System.out.println("Title" +questitle+ "desc" + quesdesc  );
		System.out.println("Username" + localuser);
		int countques = questionLocalServiceUtil.getquestionsCount();
		System.out.println("count" + countques);
		 question newques = questionLocalServiceUtil.createquestion(countques + 1);
		 
		 newques.setQuesTitle(questitle);
		 newques.setQuesDesc(quesdesc);
		 newques.setUserName(localuser);
		 questionLocalServiceUtil.addquestion(newques);
		
   
	}
	//get questions mwthod
	public static List<question> getallqueries(){
	
		return questionLocalServiceUtil.getquestions(0, questionLocalServiceUtil.getquestionsCount());
		
	}
	
	//querypage method
	
	public  void queryinfo(ActionRequest actionRequest, ActionResponse actionResponse){
        quesId = Long.valueOf(ParamUtil.getString(actionRequest,"questionid"));
		System.out.println(ParamUtil.getString(actionRequest,"questionid"));
		System.out.println(quesId);
		actionResponse.setRenderParameter("mvcPath", "/META-INF/resources/query.jsp");
	}

	
	
	//add answer 
	public void addanswerinfo(ActionRequest actionRequest, ActionResponse actionResponse) {
		quesId = Long.valueOf(ParamUtil.getString(actionRequest,"questionid"));
		String ansdesc = ParamUtil.getString(actionRequest,"answer");
		int anscount = answerLocalServiceUtil.getanswersCount();
		answer newans = answerLocalServiceUtil.createanswer(anscount + 1);
		newans.setUserName(localuser);
		newans.setAnsDesc(ansdesc);
		newans.setQuesId(quesId);
		answerLocalServiceUtil.addanswer(newans);
		System.out.println("Answer add successfully");
		actionResponse.setRenderParameter("mvcPath", "/META-INF/resources/landing.jsp");
	}
	
	
	 //get Quesion Id 
	public static long getquesId() {
		return quesId;
		
	}
	//get answer by questionId
	public static List<answer> getansbyqid(long id){
		return answerLocalServiceUtil.getansbyquesid(id);
	}
	//get Usename
	public static String getuser() {
		return localuser;
	}
	
	
	//method for generate otp
	   public static String generateOTP(int length) {
	        String numbers = "0123456789";
	        Random random = new Random();
	        StringBuilder otpBuilder = new StringBuilder();

	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(numbers.length());
	            otpBuilder.append(numbers.charAt(index));
	        }

	        return otpBuilder.toString();
	    }
	   
	   // otp template
	   
	    public static String getTemplate(String otp) {
		        return "<!DOCTYPE html>\n" +
		                "<html>\n" +
		                "<head>\n" +
		                "    <meta charset=\"UTF-8\">\n" +
		                "    <title>OTP Email</title>\n" +
		                "    <style>\n" +
		                "        body {\n" +
		                "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
		                "            background-color: #f5f5f5;\n" +
		                "            margin: 0;\n" +
		                "            padding: 0;\n" +
		                "            box-sizing: border-box;\n" +
		                "        }\n" +
		                "        .container {\n" +
		                "            text-align: center;\n" +
		                "            padding: 30px;\n" +
		                "            background-color: #ffffff;\n" +
		                "            border-radius: 10px;\n" +
		                "            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);\n" +
		                "        }\n" +
		                "        h1 {\n" +
		                "            text-align: center;\n" +
		                "            color: #3498db;\n" +
		                "        }\n" +
		                "        p {\n" +
		                "            font-size: 18px;\n" +
		                "            line-height: 1.6;\n" +
		                "            color: #333;\n" +
		                "            margin-top: 10px;\n" +
		                "        }\n" +
		                "        .otp {\n" +
		                "            display: inline-block;\n" +
		                "            padding: 8px 20px;\n" +
		                "            background-color: #3498db;\n" +
		                "            color: #fff;\n" +
		                "            font-size: 20px;\n" +
		                "            border-radius: 5px;\n" +
		                "            margin-top: 10px;\n" +
		                "        }\n" +
		                "    </style>\n" +
		                "</head>\n" +
		                "<body>\n" +
		                "\n" +
		                "    <div class=\"container\">\n" +
		                "        <h1>Your OTP Code</h1>\n" +
		                "        <p>Hello,</p>\n" +
		                "        <p>Your OTP code for verification is: </p>\n" +
		                "        <div class=\"otp\">"+ otp+"</div>\n" +
		                "        <p>This OTP is valid for a short period of time. Please enter it on the verification page to complete the process.</p>\n" +
		                "        <p>If you didn't request this OTP, please ignore this email.</p>\n" +
		                "    </div>\n" +
		                "\n" +
		                "</body>\n" +
		                "</html>";
		    }

		

	   
	
	
}








