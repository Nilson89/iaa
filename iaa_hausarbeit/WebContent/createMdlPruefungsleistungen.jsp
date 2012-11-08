<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm --%>

<h2><s:text name="txtHeadingMdlPruefungsleistungsanlage" /> "<s:property value="%{pruefung.getPruefungsfach().getTitel()}" />"</h2>
<div class="textBox">
	<p><s:text name="txtAnweisungMdlPruefungsleistungsanlage" /></p>
</div>

<s:form>
	<s:hidden name="selectedPruefungsfachId" value="%{pruefung.getPruefungsfach().getId()}" />
	
	<table cellpadding="0">
		<caption>Liste aller Prüfungsleistungen in dem gewählten Prüfungsfach</caption>
		<thead>
			<tr>
				<th><s:text name="txtLabelMdlPLName" /></th>
				<th><s:text name="txtLabelMdlPLVorname" /></th>
				<th><s:text name="txtLabelMdlPLMatrikelnummer" /></th>
				<th><s:text name="txtLabelMdlPLVersuch" /></th>
				<th><s:text name="txtLabelMdlPLAktuelleNote" /></th>
				<th><s:text name="txtLabelMdlPruefungsdatum" /></th>
				<th><s:text name="txtLabelMdlPLNote" /></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="studenten" status="rowstatus">
				<s:if test="#rowstatus.odd == true">
					<tr class="odd">
				</s:if>
				<s:else>
					<tr class="even">
				</s:else>
					<td><s:property value="person.getName()"/></td>
					<td><s:property value="person.getVorname()"/></td>
					<td><s:property value="matrikelnummer"/></td>
					<td>
						<s:if test="pruefungsleistungen.size >= 1">
							<s:property value="pruefungsleistungen.get(pruefungsleistungen.size - 1).getVersuch()"/>
						</s:if>
					</td>
					<td>
						<s:if test="pruefungsleistungen.size >= 1">
							<s:property value="pruefungsleistungen.get(pruefungsleistungen.size - 1).getNote()"/>
						</s:if>
					</td>
					<td>
						<!-- Datum -->
					</td>
					<td>
						<!-- Note -->
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	
	<div class="tableDescription">
		<p><s:text name="txtNoteFuenfDescription"/></p>
		<p><s:text name="txtNoteSechsDescription"/></p>
	</div>
	
	<div class="buttons">
		<div class="button">
			<s:submit key="btnSave" action="createMdlPruefungsleistungenSave" cssClass="save" />
		</div>
		<div class="button">
			<s:submit key="btnCancel" action="pruefungslist" cssClass="cancel" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>