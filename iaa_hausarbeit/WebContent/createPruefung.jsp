<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm --%>

<h2>Anlage einer neuen Prüfung im Fach "<s:property value="pruefungsfach.getTitel()" />"</h2>
<s:form>
	<div class="form">
		<div class="field">
			<span class="label">Datum:</span>
			<s:textfield name="pruefung.datum" label="Pruefungsdatum"/>
			<div class="clear"></div>
		</div>
		<div class="field">
			<span class="label">Dozent:</span>
			<s:select label="Dozent" headerKey="none" headerValue="Bitte wählen..." list="dozentenList" listKey="id" listValue="person.getFullName()" 
				name="selectedDozent" value="selectedDozent"/>
			<div class="clear"></div>
		</div>	
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit value="Prüfung anlegen" action="savePruefung" />
			<s:submit value="Abbrechen" action="pruefungslist" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>