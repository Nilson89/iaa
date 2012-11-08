<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Niels Maseberg --%>

<h2><s:text name="txtHeadingEditPruefungsleistung" /> "<s:property value="%{pruefungsfach.titel}" /></h2>

<s:form>
	<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />

	<div class="errorMessage">
		<s:text name="txtErrorNoPruefungsleistungSelected" />
	</div>
	
	<div class="buttons">
		<div class="button">
			<s:submit key="btnBack" action="showPruefungsleistungen" cssClass="btnBack" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>