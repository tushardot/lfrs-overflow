package customer.support.web.portlet;

import customer.support.web.constants.CustomerSupportWebPortletKeys;

import com.liferay.customer.support.model.support;
import com.liferay.customer.support.service.supportLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author me
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CustomerSupportWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CustomerSupportWebPortletKeys.CUSTOMERSUPPORTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CustomerSupportWebPortlet extends MVCPortlet {
	
	public support addinfo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		
//		 DateFormat myFormatObj = DateTimeFormat.ofPattern("dd/MM/yyyy"); 
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		String claim=ParamUtil.getString(actionRequest,"claim");
		String query=ParamUtil.getString(actionRequest,"query");
		String suggestioncomplaint=ParamUtil.getString(actionRequest,"Suggestioncomplaints");
		String BU=ParamUtil.getString(actionRequest,"bu");
		String channel=ParamUtil.getString(actionRequest,"channel");
		long invoiceNumber=ParamUtil.getLong(actionRequest,"invoicenumber");
		Date invoiceDate=ParamUtil.getDate(actionRequest,"invoicedate",formatter);
		long itemValueInvoice=ParamUtil.getLong(actionRequest,"itemvalue");
		long itemValueYou=ParamUtil.getLong(actionRequest,"itemvalueyou");
		long claimValue=ParamUtil.getLong(actionRequest,"claimvalue");
		String detailClaim=ParamUtil.getString(actionRequest,"detailclaim");
		String querybox=ParamUtil.getString(actionRequest,"querytextbox");
		String scBox=ParamUtil.getString(actionRequest,"sctextbox");
		
		System.out.println(claim + query+ suggestioncomplaint+ BU+ channel+ invoiceNumber+ invoiceDate+ itemValueInvoice+ itemValueYou+ claimValue+ detailClaim + querybox+ scBox);
		
		
		return supportLocalServiceUtil.createsupportinfo(claim, query, suggestioncomplaint, BU, channel, invoiceNumber, invoiceDate, itemValueInvoice, itemValueYou, claimValue, detailClaim, querybox, scBox);
		
	}
}