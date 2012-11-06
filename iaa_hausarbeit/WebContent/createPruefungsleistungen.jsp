<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm --%>

<h2><s:text name="txtHeadingPruefungsleistungsanlage" /> "<s:property value="pruefungsfach.getTitel()" />"</h2>
<div class="textBox">
	<p><s:text name="txtAnweisungPruefungsleistungsanlageOben" /></p>
</div>
<s:form>
	<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
	<table cellpadding="0">
		<caption>Anlage neuer Prüfungsleistungen im Prüfungsfach "<s:property value="pruefungsfach.getTitel()" />"</caption>
		<thead>
			<tr>
				<th>&nbsp;</th>
				<th><s:text name="txtPLMatrikelnummer" /></th>
				<th><s:text name="txtPLName" /></th>
				<th><s:text name="txtPLVorname" /></th>
				<th><s:text name="txtPLManipel" /></th>
				<th><s:text name="txtPLVersuch" /></th>
				<th><s:text name="txtPLNote" /></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pruefungsleistung" status="rowstatus">
				<s:if test="#rowstatus.odd == true">
					<tr class="odd">
				</s:if>
				<s:else>
					<tr class="even">
				</s:else>
					<td class="cell_radio"><s:radio name="selectedPruefungId" list="#{id:''}" theme="simple"/></td>
					<td><s:property value="student.getMatrikelnummer()"/></td>
					<td><s:property value="student.getPerson().getName()"/> <s:property value="dozent.getPerson().getName()"/></td>
					<td><s:property value="student.getPerson().getVorname()"/></td>
					<td><s:property value="student.getManipel()"/> <s:property value="dozent.getPerson().getName()"/></td>
					<td><s:property value="versuch"/></td>
					<td><s:select label="Note" headerKey="none" headerValue="Bitte wählen..." list="notenList" listKey="id" listValue="note.getNote()" 
				name="selectedNote" value="selectedNote"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<div class="textBox">
		<p><s:text name="txtAnweisungPruefungsleistungsanlageUntenA" /></p>
		<p><s:text name="txtAnweisungPruefungsleistungsanlageUntenB" /></p>
		<p><s:text name="txtAnweisungPruefungsleistungsanlageUntenC" /></p>
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit key="btnCreatePruefungsleistung" action="savePruefungsleistung" />
			<s:submit key="btnAbbrechen" action="showPruefungsleistungen" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>