<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Niels Maseberg, Sabrina Schramm --%>

<h2><s:text name="txtHeadingIndex" /></h2>
<s:form>
	<table cellpadding="0">
		<caption><s:text name="txtCaptionIndex" /></caption>
		<thead>
			<tr>
				<th>&nbsp;</th>
				<th><s:text name="txtIndexStudienrichtung" /></th>
				<th><s:text name="txtTitel" /></th>
				<th><s:text name="txtIndexJahrgang" /></th>
				<th><s:text name="txtIndexBeschreibung" /></th>
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
					<td><s:property value="manipel.getPk().getStudienrichtung()"/></td>
					<td><s:property value="titel"/></td>
					<td><s:property value="manipel.getPk().getJahrgang()"/></td>
					<td><s:property value="beschreibung"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<div class="buttons">
		<div class="button">
			<s:submit key="btnPrüfungenAnzeigen" action="pruefungslist" cssClass="listTable"  />
		</div>
		<div class="clear"></div>
	</div>
</s:form>