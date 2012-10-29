<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Niels Maseberg --%>

<h2>Übersicht Noten</h2>
<s:form>
	<div class="form">
		<div class="field">
			<span class="label">Manipel:</span>
			<s:select label="Manipel" headerKey="none" headerValue="Bitte wählen..." list="manipelList" listKey="pk" listValue="pk" name="selectedManipel" value="selectedManipel"/>
			<div class="clear"></div>
		</div>
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit value="Noten anzeigen" action="notenuebersichtDetail" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>
<p>Hier sind die Ergebnisse</p>