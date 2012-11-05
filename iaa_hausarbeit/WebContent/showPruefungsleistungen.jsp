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
				<th><s:text name="txtPLAnzeigeMatrikelnummer" /></th>
				<th><s:text name="txtPLAnzeigeName" /></th>
				<th><s:text name="txtPLAnzeigeVorname" /></th>
				<th><s:text name="txtPLAnzeigeTitel" /></th>
				<th><s:text name="txtPLAnzeigeDatum" /></th>
				<th><s:text name="txtPLAnzeigeDozent" /></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pruefungsleistungen" status="rowstatus">
				<s:if test="#rowstatus.odd == true">
					<tr class="odd">
				</s:if>
				<s:else>
					<tr class="even">
				</s:else>
					<td class="cell_radio"><s:radio name="selectedPruefungsleistung" list="#{id:''}" theme="simple"/></td>
					<td><s:property value="student.getMatrikelnummer()"/></td>
					<td><s:property value="student.person.getName()"/></td>
					<td><s:property value="student.person.getVorname()"/></td>
					<td><s:property value="titel"/></td>
					<td><s:property value="datum"/></td>
					<td><s:property value="erfasser"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>

</s:form>