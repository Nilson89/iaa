<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm --%>

<h2><s:text name="txtHeadingPruefungsleistungsanlage" /> "<s:property value="pruefungsfach.getTitel()" />"</h2>
<div class="textBox">
	<p><s:text name="txtAnweisungPruefungsleistungsanlage" /></p>
</div>
<s:form>
	<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
	<table cellpadding="0">
		<thead>
			<tr>
				<th>&nbsp;</th>
				<th>Matrikelnummer</th>
				<th>Name</th>
				<th>Vorname</th>
				<th>Titel</th>
				<th>Datum</th>
				<th>Dozent</th>
				<th>Note</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>

	<div class="buttons">
		<div class="button">
			<s:submit key="btnCreatePruefungsleistung" action="savePruefungsleistung" />
			<s:submit key="btnAbbrechen" action="showPruefungsleistungen" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>