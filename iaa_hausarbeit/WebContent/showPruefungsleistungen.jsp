<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm und Niels Maseberg --%>

<h2><s:text name="txtHeadingPruefungsleistungenanzeige" />  "<s:property value="pruefungsfach.getTitel()" />"</h2>
<s:form>
	<s:hidden name="selectedPruefungsfachId" value="%{pruefungsfach.id}" />

	<table cellpadding="0">
		<caption>Liste aller Prüfungsleistungen in dem gewählten Prüfungsfach</caption>
		<thead>
			<tr>
				<th><s:text name="txtPLAnzeigeName" /></th>
				<th><s:text name="txtPLAnzeigeVorname" /></th>
				<th><s:text name="txtPLAnzeigeMatrikelnummer" /></th>
				<th><s:text name="txtPLAnzeigeNote" /> 1 (<s:text name="txtPLAnzeigeErgaenzungspruefung" />)</th>
				<th><s:text name="txtPLAnzeigeNote" /> 2 (<s:text name="txtPLAnzeigeErgaenzungspruefung" />)</th>
				<th><s:text name="txtPLAnzeigeNote" /> 3 (<s:text name="txtPLAnzeigeErgaenzungspruefung" />)</th>
				<th><s:text name="txtPLAnzeigeNoteAktuell" /></th>
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
					<td><s:property value="person.getName()"/></td>
					<td><s:property value="person.getVorname()"/></td>
					<td><s:property value="matrikelnummer"/></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	
	<div class="buttons">
		<div class="button">
			<s:submit key="btnBack" action="pruefungslist" cssClass="btnBack" />
		</div>
		<div class="clear"></div>
	</div>

</s:form>