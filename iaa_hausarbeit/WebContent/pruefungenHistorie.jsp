<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Niels Maseberg --%>

<h2><s:text name="txtHeadingPruefungenHistorie" /> "<s:property value="pruefungsfach.getTitel()" />"</h2>

<s:form>
	<div class="form">
		<div class="field">
			<span class="label"><s:text name="txtLabelMatrikelnummer" /></span>
			<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
			<s:select headerKey="0000" headerValue="Bitte wählen..." list="matrikelnummern" name="selectedMatrikelnummer" value="selectedMatrikelnummer"/>
			<div class="clear"></div>
		</div>
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit key="txtSubmitPruefungenHistorie" action="pruefungenHistorieDetail" cssClass="history" />
		</div>
		<div class="button">
			<s:submit key="btnBack" action="pruefungslist" cssClass="btnBack" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>