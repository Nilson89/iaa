<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm --%>

<h2><s:text name="txtHeadingPruefungsleistungsanlage" /> "<s:property value="pruefungsfach.getTitel()" />"</h2>
<div class="textBox">
	<p><s:text name="txtAnweisungPruefungsleistungsanlageOben" /></p>
</div>
<s:form>
	<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
	<s:hidden name="selectedPruefungId" value="%{selectedPruefungId}" />
	<table cellpadding="0">
		<caption>Anlage neuer Prüfungsleistungen im Prüfungsfach "<s:property value="pruefungsfach.getTitel()" />"</caption>
		<thead>
			<tr>
				<th><s:text name="txtPLMatrikelnummer" /></th>
				<th><s:text name="txtPLName" /></th>
				<th><s:text name="txtPLVorname" /></th>
				<th><s:text name="txtPLVersuch" /></th>
				<th><s:text name="txtPLNote" /></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="studenten" status="rowstatus">
				<s:if test="#rowstatus.odd == true">
					<tr class="odd">
				</s:if>
				<s:else>
					<tr class="even">
				</s:else>
					<td><s:property value="matrikelnummer"/></td>
					<td><s:property value="person.getName()"/>
					<td><s:property value="person.getVorname()"/></td>
					<td><s:property value="pruefungsleistungen.size"/></td>
					<td><s:select name="pruefungsleistung.note" list="%{@de.nordakademie.hausarbeit.model.Note@values()}" label="Colour"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<div class="textBox">
		<p><s:text name="txtAnweisungPruefungsleistungsanlageUnten" /></p>
		<p><s:text name="txtNoteFuenfDescription"/></p>
		<p><s:text name="txtNoteSechsDescription"/></p>
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit key="btnCreatePruefungsleistung" action="savePruefungsleistung" />
			<s:submit key="btnAbbrechen" action="showPruefungsleistungen" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>