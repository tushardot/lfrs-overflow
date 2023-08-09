<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="newcsupportweb.caption"/></b>
</p>

<portlet:renderURL var="renderJSPVariable">
<portlet:param name="mvcPath" value="/META-INF/resources/second.jsp"/>
</portlet:renderURL>



<aui:button type="submit" value="Customer Support" onClick="<%=renderJSPVariable.toString()%>"></aui:button>
