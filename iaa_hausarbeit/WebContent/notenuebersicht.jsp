<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Niels Maseberg, Sabrina Schramm --%>

<h2><s:text name="txtHeadingNotenUebersicht" /></h2>
<s:form>
	<div class="form">
		<div class="field">
			<span class="label"><s:text name="txtManipel" />:</span>
			<s:select label="Manipel" headerKey="none" headerValue="Bitte wählen..." list="manipelList" listKey="pk" listValue="pk" name="selectedManipel" value="selectedManipel"/>
			<div class="clear"></div>
		</div>
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit key="btnNotenAnzeigen" action="notenuebersichtDetail" cssClass="listTable" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>