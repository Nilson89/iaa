<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Niels Maseberg, Sabrina Schramm --%>

<h2><s:text name="txtHeadingPruefungslist" /> "<s:property value="pruefungsfach.getTitel()" />"</h2>
<s:form>
	<div class="buttons">
		<div class="button">
			<s:hidden name="selectedPruefungsfachId" value="%{pruefungsfach.id}" />
			<s:submit key="btnCreatePruefung" action="createPruefung" cssClass="add" />
			<s:submit key="btnAnzeigePruefungsleistungen" action="showPruefungsleistungen" cssClass="listTable" />
			<s:submit key="btnPruefungenHistorie" action="pruefungenHistorie" cssClass="history" />
		</div>
		<div class="clear"></div>
	</div>
	
	<!-- TODO: Tabelle nur anzeigen, wenn auch Prüfungen in diesem Prüfungsfach existieren -->
	
	<table cellpadding="0">
		<caption><s:text name="txtCaptionPruefungslist" /> "<s:property value="pruefungsfach.getTitel()" />"</caption>
		<thead>
			<tr>
				<th>&nbsp;</th>
				<th><s:text name="txtDatum" /></th>
				<th><s:text name="txtDozent" /></th>
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
	<div class="textBox">
		<p><s:text name="txtPruefungslistAnweisungPruefungsleistungsanlage" /></p>
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit key="btnCreatePl" action="createPruefungsleistungen" cssClass="add" />
			<s:submit key="btnCreateMdlPl" action="createMdlPruefungsleistungen" cssClass="add" />
		</div>
		<div class="clear"></div>
	</div>
	
	<div class="buttons">
		<div class="button">
			<s:submit key="btnBack" action="index" cssClass="btnBack" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>