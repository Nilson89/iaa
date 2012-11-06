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


<div class="textBox">
	<p>Vorname: <s:property value="student.getPerson().getVorname()" /></p>
	<p>Name: <s:property value="student.getPerson().getName()" /></p>
</div>

<s:if test="pruefungsleistungenList.size != 0">
	<table cellpadding="0">
		<caption>
			Liste der Prüfungsleistungen im Prüfungsfach "<s:property value="pruefungsfach.getTitel()" />" 
			des Studenten mit der Matrikelnummer "<s:property value="selectedMatrikelnummer" />"
		</caption>
		<thead>
			<tr>
				<th>Datum</th>
				<th>Dozent</th>
				<th>Erfassungsdatum (Ergänzungsprüfung)</th>
				<th>Erfasser</th>
				<th>Versuch</th>
				<th>Änderungseintrag</th>
				<th>Gültig</th>
				<th>Note (Ergänzungsprüfung)</th>
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
					<td><s:property value="pruefung.getDatum()"/></td>
					<td><s:property value="pruefung.getDozent().getPerson().getVorname()" /> <s:property value="pruefung.getDozent().getPerson().getName()" /></td>
					<td>
						<s:property value="erfassungsdatum"/>
						<s:if test="ergaenzungspruefung != null">
							 (<s:property value="ergaenzungspruefung.getErfassungsdatum()" />)
						</s:if>
					</td>
					<td><s:property value="erfasser.getPerson().getVorname()"/> <s:property value="erfasser.getPerson().getName()"/></td>
					<td><s:property value="versuch"/></td>
					<td>
						<s:if test="aenderungseintrag == true">Ja</s:if>
						<s:else>Nein</s:else>
					</td>
					<td>
						<s:if test="gueltig == true">Ja</s:if>
						<s:else>Nein</s:else>
					</td>
					<td>
						<s:property value="note"/>
						<s:if test="ergaenzungspruefung != null">
							 (<s:property value="ergaenzungspruefung.getNote()" />) Endnote: <s:property value="getEndNote()"/>
						</s:if>
						<!-- TODO Endnote anzeigen -->
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</s:if>
<s:else>
	<div class="errorMessage">
		<s:text name="txtNoPruefungsleistungenFound" />
	</div>
</s:else>

<s:form>
	<div class="buttons">
		<div class="button">
			<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
			<s:submit key="btnBack" action="pruefungslist" cssClass="btnBack" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>