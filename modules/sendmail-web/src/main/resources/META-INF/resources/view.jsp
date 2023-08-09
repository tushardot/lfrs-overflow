<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="sendmailweb.caption"/></b>
</p>

<portlet:renderURL var="second">
<portlet:param name="mvcPath" value="/META-INF/resources/second.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="myprofile">
<portlet:param name="mvcPath" value="/META-INF/resources/myprofile.jsp"/>
</portlet:renderURL>

<aui:button type="submit" value="Test Mail API" onClick="<%=second.toString()%>"></aui:button>
<aui:button type="submit" value="My Profile" onClick="<%=myprofile.toString()%>"></aui:button>