<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form>
	<table>
		<tr>
			<th>&nbsp;</th>
			<th>Studienrichtung</th>
			<th>Titel</th>
			<th>Jahrgang</th>
			<th>Beschreibung</th>
		</tr>
		<s:iterator value="pruefungsfaecher">
			<tr>
				<td><s:radio name="selectedPruefungsfachId" list="#{id:''}" theme="simple"/></td>
				<td><s:property value="manipel.pk.studienrichtung"/></td>
				<td><s:property value="titel"/></td>
				<td><s:property value="manipel.pk.jahrgang"/></td>
				<td><s:property value="beschreibung"/></td>
			</tr>
		</s:iterator>
	</table>
</s:form>