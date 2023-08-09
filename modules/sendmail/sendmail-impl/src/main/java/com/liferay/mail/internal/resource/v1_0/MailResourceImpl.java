package com.liferay.mail.internal.resource.v1_0;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalArticleServiceUtil;
import com.liferay.mail.dto.v1_0.Mail;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.mail.resource.v1_0.MailResource;
import com.liferay.portal.kernel.exception.PortalException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.text.View;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;


/**
 * @author me
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/mail.properties",
	scope = ServiceScope.PROTOTYPE, service = MailResource.class
)
public class MailResourceImpl extends BaseMailResourceImpl {
	
	
	@Override
	public Mail sendEmail(Mail body) throws AddressException, PortalException{
		String email = body.getEmail();
		InternetAddress fromAddress = new InternetAddress("rahulkumarroy723@gmail.com");
		InternetAddress toAddress = new InternetAddress(email);

		
		
		Long groupId = 20121L;
		JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, "temp");

		
		String content = JournalArticleLocalServiceUtil.getArticleContent(journalArticle, journalArticle.getDDMTemplateKey(), "VIEW", "en_US", null, null);
		
		
		try {
			System.out.println("post mail to " + email );
			
			MailMessage mailMessage = new MailMessage();
			mailMessage.setFrom(fromAddress);
			mailMessage.setTo(toAddress);
			mailMessage.setSubject("testing mail to send template");
			mailMessage.setBody(content);
			

			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
			System.out.println(fromAddress);
			System.out.println(toAddress);
			
			System.out.println("mail sended for testing to " + email);
			System.out.println(content);
			
         }catch(Exception e) {
			e.printStackTrace();
		}
		return body;
	}
}