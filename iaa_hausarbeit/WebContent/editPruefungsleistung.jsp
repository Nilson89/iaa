<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Niels Maseberg --%>

<h2><s:text name="txtHeadingEditPruefungsleistung" /> "ToDo"</h2>

<s:form>
	<s:hidden name="selectedPruefungsleistungId" value="%{selectedPruefungsleistungId}" />
	<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
	
	<div class="buttons">
		<div class="button">
			<s:submit key="btnBack" action="showPruefungsleistungen" cssClass="btnBack" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>