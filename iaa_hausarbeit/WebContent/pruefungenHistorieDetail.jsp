<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Niels Maseberg --%>

<h2><s:text name="txtHeadingPruefungenHistorie" /> "ToDo"</h2>

<s:form>
	<div class="form">
		<div class="field">
			<span class="label"><s:text name="txtLabelMatrikelnummer" /></span>
			
			<div class="clear"></div>
		</div>
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit key="txtSubmitPruefungenHistorie" action="pruefungenHistorieDetail" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>

<p>Hier kommen die Prüfungen</p>