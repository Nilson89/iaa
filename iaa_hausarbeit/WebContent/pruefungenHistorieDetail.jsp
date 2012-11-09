<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Autor: Niels Maseberg, Sabrina Schramm --%>

<h2><s:text name="txtHeadingPruefungenHistorie" /> "<s:property value="pruefungsfach.getTitel()" />"</h2>

<s:form>
	<div class="form">
		<div class="field">
			<span class="label"><s:text name="txtMatrikelnummer" />:</span>
			<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
			<s:select headerKey="0000" headerValue="Bitte wählen..." list="matrikelnummern" name="selectedMatrikelnummer" value="selectedMatrikelnummer"/>
			<div class="clear"></div>
		</div>
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit key="btnPruefungenHistorie" action="pruefungenHistorieDetail" cssClass="history" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>


<div class="textBox">
	<p><s:text name="txtVorname" />: <s:property value="student.getPerson().getVorname()" /></p>
	<p><s:text name="txtName" />: <s:property value="student.getPerson().getName()" /></p>
</div>

<s:if test="pruefungsleistungenList.size != 0">
	<table cellpadding="0">
		<caption> 
			<s:text name="txtCaptionPruefungenHistorieA" /> "<s:property value="pruefungsfach.getTitel()" />" 
			<s:text name="txtCaptionPruefungenHistorieB" /> "<s:property value="selectedMatrikelnummer" />"
		</caption>
		<thead>
			<tr>
				<th><s:text name="txtDatum" /></th>
				<th><s:text name="txtDozent" /></th>
				<th><s:text name="txtErfassungsdatum" /> (<s:text name="txtErgaenzungspruefung" />)</th>
				<th><s:text name="txtErfasser" /></th>
				<th><s:text name="txtVersuch" /></th>
				<th><s:text name="txtAenderungseintrag" /></th>
				<th><s:text name="txtGueltig" /></th>
				<th><s:text name="txtNote" /> (<s:text name="txtErgaenzungspruefung" />)</th>
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
						<s:if test="aenderungseintrag == true"><s:text name="txtJa" /></s:if>
						<s:else><s:text name="txtNein" /></s:else>
					</td>
					<td>
						<s:if test="gueltig == true"><s:text name="txtJa" /></s:if>
						<s:else><s:text name="txtNein" /></s:else>
					</td>
					<td>
						<s:property value="note"/>
						<s:if test="ergaenzungspruefung != null">
							 (<s:property value="ergaenzungspruefung.getNote()" />) <s:text name="txtEndnote" /><s:property value="getEndNote()"/>
						</s:if>
						<!-- TODO Endnote anzeigen -->
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	
	<div class="tableDescription">
		<p><s:text name="txtNoteFuenfDescription"/></p>
		<p><s:text name="txtNoteSechsDescription"/></p>
	</div>
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