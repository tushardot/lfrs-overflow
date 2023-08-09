<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<portlet:renderURL var="renderJSPVariable">
<portlet:param name="mvcPath" value="/createuser.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="indexpage">
<portlet:param name="mvcPath" value="/index.jsp"/>
</portlet:renderURL>
<p>
	<b><liferay-ui:message key="panasonicweb.caption"/></b>
</p>


					
					
					
<aui:button type="submit" value="New User" onClick="<%=renderJSPVariable.toString()%>"></aui:button>
<aui:button type="submit" value="index" onClick="<%=indexpage.toString()%>"></aui:button>
					