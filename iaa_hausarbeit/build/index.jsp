<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h2>Übersicht Prüfungsfächer</h2>
<s:form>
	<table cellpadding="0">
		<caption>Liste aller Prüfungsfächer inklusive Studienrichtung und Jahrgang</caption>
		<thead>
			<tr>
				<th>&nbsp;</th>
				<th>Studienrichtung</th>
				<th>Titel</th>
				<th>Jahrgang</th>
				<th>Beschreibung</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pruefungsfaecher" status="rowstatus">
				<s:if test="#rowstatus.odd == true">
					<tr class="odd">
				</s:if>
				<s:else>
					<tr class="even">
				</s:else>
					<td class="cell_radio"><s:radio name="selectedPruefungsfachId" list="#{id:''}" theme="simple"/></td>
					<td><s:property value="manipelstudienrichtung"/></td>
					<td><s:property value="titel"/></td>
					<td><s:property value="manipeljahrgang"/></td>
					<td><s:property value="beschreibung"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<div class="buttons">
		<div class="button">
			<s:submit value="Prüfungen anzeigen" action="Pruefungslist" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>