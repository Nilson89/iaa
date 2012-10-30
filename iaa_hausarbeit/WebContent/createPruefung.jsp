<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm --%>

<h2>Anlage einer neuen Prüfung</h2>
<s:form>
	<div class="form">
		<div class="field">
			<span class="label">Datum:</span>
			<s:textfield name="pruefung.datum" label="Pruefungsdatum"/>
			<div class="clear"></div>
		</div>
		<div class="field">
			<span class="label">Dozent:</span>
			<s:textfield name="pruefung.dozent" label="Pruefungsdozent"/>
			<div class="clear"></div>
		</div>		
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit value="Prüfung anlegen" action="pruefungslist" />
			<s:submit value="Abbrechen" action="pruefungslist" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>