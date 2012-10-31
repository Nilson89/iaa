<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Niels Maseberg, Sabrina Schramm --%>

<h2>Übersicht Prüfungen aus Prüfungsfach "<s:property value="pruefungsfach.getTitel()" />"</h2>
<s:form>
	<div class="buttons">
		<div class="button">
			<s:url id="createPruefungUrl" action="createPruefung">
				<s:param name="selectedPruefungsfachId"><s:property value="pruefungsfach.getId()" /></s:param>
			</s:url>
			<a href="${createPruefungUrl}"><s:text name="btnCreatePruefung" /></a>
			
			<s:url id="pruefungenHistorieActionUrl" action="pruefungenHistorie">
				<s:param name="selectedPruefungsfachId"><s:property value="pruefungsfach.getId()" /></s:param>
			</s:url>
			<a href="${pruefungenHistorieActionUrl}"><s:text name="btnPruefungenHistorie" /></a>
		</div>
		<div class="clear"></div>
	</div>
	<table cellpadding="0">
		<caption>Liste aller Prüfungen im Prüfungsfach "<s:property value="pruefungsfach.getTitel()" />"</caption>
		<thead>
			<tr>
				<th>&nbsp;</th>
				<th>Datum</th>
				<th>Dozent</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pruefungen" status="rowstatus">
				<s:if test="#rowstatus.odd == true">
					<tr class="odd">
				</s:if>
				<s:else>
					<tr class="even">
				</s:else>
					<td class="cell_radio"><s:radio name="selectedPruefungId" list="#{id:''}" theme="simple"/></td>
					<td><s:property value="datum"/></td>
					<td><s:property value="dozent.getPerson().getVorname()"/> <s:property value="dozent.getPerson().getName()"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	
</s:form>