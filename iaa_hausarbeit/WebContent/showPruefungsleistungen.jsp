<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm --%>

<h2><s:text name="txtHeadingPruefungsleistungenanzeige" />  "<s:property value="pruefungsfach.getTitel()" />"</h2>
<s:form>
	<table cellpadding="0">
		<caption>Liste aller Prüfungsleistungen in dem gewählten Prüfungsfach</caption>
		<thead>
			<tr>
				<th>&nbsp;</th>
				<th>Matrikelnummer</th>
				<th>Name</th>
				<th>Vorname</th>
				<th>Titel</th>
				<th>Datum</th>
				<th>Dozent</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>

</s:form>