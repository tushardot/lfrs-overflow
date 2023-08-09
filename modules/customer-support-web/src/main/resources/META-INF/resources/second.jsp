<%@ include file="/init.jsp" %>
				
<portlet:actionURL name="addinfo" var="addinfoActionURL"></portlet:actionURL>
<aui:form name="fm" action="${addinfoActionURL}" method="post" >
	

			<aui:row>
				<aui:col width="33">
					<aui:select name="claim" label="Claim" >
            <aui:option selected="true" value="Short Supply">Short Supply</aui:option>
            <aui:option selected="true" value="ALL">Damage Item</aui:option>
            <aui:option selected="true" value="Rate Difference">Rate Difference</aui:option>
            <aui:option selected="true" value="Discount Difference">Discount Difference</aui:option>
            <aui:option selected="true" value="Incorrect CD">Incorrect CD</aui:option>
            <aui:option selected="true" value="Replacement Claim">Replacement Claim</aui:option>
            <aui:option selected="true" value="Tax Error">Tax Error</aui:option>
            <aui:option selected="true" value="Others">Others</aui:option>
</aui:select>
				</aui:col>
				<aui:col width="33">
					<aui:select name="query"  label="QUERY" >
            <aui:option selected="true" value="Discount Related">Discount Related</aui:option>
            <aui:option selected="true" value="Tax Related">Tax Related</aui:option>
            <aui:option selected="true" value="Price Related">Price Related</aui:option>
            <aui:option selected="true" value="Accounts Related">Accounts Related</aui:option>
            <aui:option selected="true" value="Wrong Pay Term">Wrong Pay Term</aui:option>
            <aui:option selected="true" value="Delay Delivery">Delay Delivery</aui:option>
            <aui:option selected="true" value="Others">Others</aui:option>
</aui:select>
				</aui:col>
				
				<aui:col width="33">
<aui:select name="Suggestioncomplaints"  label="Suggestion/Complaints" >
            <aui:option selected="true" value="Marketing Activity">Marketing Activity</aui:option>
            <aui:option selected="true" value="Promotion">Promotion</aui:option>
            <aui:option selected="true" value="Pricing">Pricing</aui:option>
            <aui:option selected="true" value="Employee Related">Employee Related</aui:option>
            <aui:option selected="true" value="Delivery Related">Delivery Related</aui:option>
            <aui:option selected="true" value="Quality Related">Quality Related</aui:option>
            <aui:option selected="true" value="Others">Others</aui:option> 	   	
</aui:select>
				</aui:col>
			</aui:row>
		
	
		
	
		
		
			<aui:row>
				<aui:col width="33">
				  <aui:select name="bu"  label="Select BU from LOV" >
            <aui:option selected="true" value="Power">Power</aui:option>
            <aui:option selected="true" value="LT">LT</aui:option>
            <aui:option selected="true" value="IAQ">IAQ</aui:option>
        </aui:select>
          <aui:select name="channel"  label="Select Channel from LOV" >
            <aui:option selected="true" value="Trade">Trade</aui:option>
            <aui:option selected="true" value="Project">Project</aui:option>
        </aui:select>
					<aui:input label="Invoice Number" name="invoicenumber" type="text" />
					<aui:input label="Invoice Date" name="invoicedate" type="Date" />
					<aui:input label="Item value as per Invoice" name="itemvalue" type="text" />
					<aui:input label="Value as per you" name="itemvalueyou" type="text" />
					<aui:input label="Value of claim" name="claimvalue" type="text" />
					<aui:input label="Details of Claim" name="detailclaim" type="text" />
				</aui:col>
				<aui:col width="33">
					<aui:input label="Query Text Box" name="querytextbox" type="textarea" />
				</aui:col>
				
				<aui:col width="33">
                    <aui:input label="Suggestion/Complaint text box" name="sctextbox" type="textarea" />
				</aui:col>
			</aui:row>
		


	<aui:button-row>
		<aui:button name="submitButton" type="submit" value="Submit"></aui:button>
	</aui:button-row>
</aui:form>
<img src = "/home/me/Desktop/mountains-g3a1fc96e4_1280.jpg" alt = "Image" />
