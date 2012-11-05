<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Autor: Niels Maseberg --%>

<h2><s:text name="txtHeadingPruefungenHistorie" /> "<s:property value="pruefungsfach.getTitel()" />"</h2>

<s:form>
	<div class="form">
		<div class="field">
			<span class="label"><s:text name="txtLabelMatrikelnummer" /></span>
			<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
			<s:select headerKey="0000" headerValue="Bitte wählen..." list="matrikelnummern" name="selectedMatrikelnummer" value="selectedMatrikelnummer"/>
			<div class="clear"></div>
		</div>
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit key="txtSubmitPruefungenHistorie" action="pruefungenHistorieDetail" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>


<div class="">
	<p>Vorname: <s:property value="student.getPerson().getVorname()" /></p>
	<p>Name: <s:property value="student.getPerson().getName()" /></p>
</div>

<table cellpadding="0">
	<caption>
		Liste der Prüfungsleistungen im Prüfungsfach "<s:property value="pruefungsfach.getTitel()" />" 
		des Studenten mit der Matrikelnummer "<s:property value="selectedMatrikelnummer" />"
	</caption>
	<thead>
		<tr>
			<th>Dtum</th>
			<th>Dozent</th>
			<th>Erfassungsdatum</th>
			<th>Erfasser</th>
			<th>Versuch</th>
			<th>Typ</th>
			<th>Änderungseintrag</th>
			<th>Gültig</th>
			<th>Note</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="pruefungsleistungenList" status="rowstatus">
			<s:if test="#rowstatus.odd == true">
				<tr class="odd">
			</s:if>
			<s:else>
				<tr class="even">
			</s:else>
				<td><s:property value="datum"/></td>
				<td><s:property value="dozent.getPerson().getVorname()"/> <s:property value="dozent.getPerson().getName()"/></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</s:iterator>
	</tbody>
</table>

<s:form>
	<div class="buttons">
		<div class="button">
			<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
			<s:submit key="btnBack" action="pruefungslist" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>