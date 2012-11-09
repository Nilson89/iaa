<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%-- Sabrina Schramm --%>

<h2><s:text name="txtHeadingPruefungsleistungsanlageError" /></h2>

<s:form>
	<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
	
	<div class="errorMessage">
		<s:text name="error.no.pruefung.selected.extended" />
	</div>

	<div class="buttons">
		<div class="button">
			<s:submit key="btnBack" action="pruefungslist" cssClass="btnBack" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>