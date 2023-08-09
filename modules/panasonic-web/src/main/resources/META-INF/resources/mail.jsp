<%@ include file="/init.jsp" %>


<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%
   String result;
   String to = "rahulkr8157@gmail.com";
   String from = "rahulkumarroy723@gmail.com";
   String host = "localhost";
   Properties properties = System.getProperties();
   properties.setProperty("mail.user", "rahulkumarroy723@gmail.com");
   properties.setProperty("mail.password", "pass");
   properties.setProperty("mail.smtp.host", host);
   properties.put("mail.smtp.socketFactor.port", "465");
   properties.put("mail.smtp.socketFactory.class",
           "javax.net.ssl.SSLSocketFactory");
   properties.put("mail.smtp.auth", "true");
   properties.put("mail.smtp.port", "465");
   Session mailSession = Session.getInstance(properties,
		   new Authenticator() {
       protected PasswordAuthentication  getPasswordAuthentication() {
       return new PasswordAuthentication(
    		   "rahulkumarroy723@gmail.com", "R@#ul987");
               }
   });
   try{
      MimeMessage message = new MimeMessage(mailSession);
      message.setFrom(new InternetAddress(from));
      message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
      message.setSubject("This is the Subject Line!");
      message.setText("This is actual message");
      Transport.send(message);
      result = "Sent message successfully....";
   }catch (MessagingException mex) {
      mex.printStackTrace();
      result = "Error: unable to send message....";
   }
%>
<html>
<body>
<center>
</center>
<p align="center">
<% 
   out.println("Result: " + result + "\n");
%>
</p>
</body>
</html>