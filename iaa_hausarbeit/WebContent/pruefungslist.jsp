<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Niels Maseberg, Sabrina Schramm --%>

<h2><s:text name="txtHeadingPruefungslist" /> "<s:property value="pruefungsfach.getTitel()" />"</h2>
<s:form>
	<div class="buttons">
		<div class="button">
			<s:hidden name="selectedPruefungsfachId" value="%{pruefungsfach.id}" />
			<s:submit key="btnCreatePruefung" action="createPruefung" />
			<s:submit key="btnAnzeigePruefungsleistungen" action="showPruefungsleistungen" />
			<s:submit key="btnPruefungenHistorie" action="pruefungenHistorie" />
		</div>
		<div class="clear"></div>
	</div>
	
	<!-- TODO: Tabelle nur anzeigen, wenn auch Prüfungen in diesem Prüfungsfach existieren -->
	
	<table cellpadding="0">
		<caption>Liste aller Prüfungen im Prüfungsfach "<s:property value="pruefungsfach.getTitel()" />"</caption>
		<thead>
			<tr>
				<th>&nbsp;</th>
				<th><s:text name="txtPruefungslistDatum" /></th>
				<th><s:text name="txtPruefungslistDozent" /></th>
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
	
	<div class="buttons">
		<div class="button">
			<s:submit key="btnCreatePl" action="createPruefungsleistungen" />
			<s:submit key="btnCreateMdlPl" action="createMdlPruefungsleistungen" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>