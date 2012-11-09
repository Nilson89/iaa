<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm und Niels Maseberg --%>

<h2><s:text name="txtHeadingPruefungsleistungenanzeige" />  "<s:property value="pruefungsfach.getTitel()" />"</h2>
<s:form>
	<s:hidden name="selectedPruefungsfachId" value="%{pruefungsfach.id}" />

	<table cellpadding="0">
		<caption><s:text name="txtCaptionPruefungsleistungenanzeige" /></caption>
		<thead>
			<tr>
				<th>&nbsp;</th>
				<th><s:text name="txtName" /></th>
				<th><s:text name="txtVorname" /></th>
				<th><s:text name="txtMatrikelnummer" /></th>
				<th><s:text name="txtNote" /> 1 (<s:text name="txtErgaenzungspruefung" />)</th>
				<th><s:text name="txtNote" /> 2 (<s:text name="txtErgaenzungspruefung" />)</th>
				<th><s:text name="txtNote" /> 3 (<s:text name="txtErgaenzungspruefung" />)</th>
				<th><s:text name="txtNoteAktuell" /></th>
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
					<td class="cell_radio">
						<s:if test="pruefungsleistungen.size >= 1">
							<s:radio name="selectedPruefungsleistungId" list="#{pruefungsleistungen.get(pruefungsleistungen.size - 1).getId():''}"/>
						</s:if>
					</td>
					<td><s:property value="person.getName()"/></td>
					<td><s:property value="person.getVorname()"/></td>
					<td><s:property value="matrikelnummer"/></td>
					<td>
						<!-- 1. Versuch -->
						<s:if test="pruefungsleistungen.size >= 1">
							<s:property value="pruefungsleistungen.get(0).getNote()"/>
							
							<s:if test="pruefungsleistungen.get(0).getErgaenzungspruefung() != null">
								(<s:property value="pruefungsleistungen.get(0).getErgaenzungspruefung().getNote()"/>)
							</s:if>
						</s:if>
					</td>
					<td>
						<!-- 2. Versuch -->
						<s:if test="pruefungsleistungen.size >= 2">
							<s:property value="pruefungsleistungen.get(1).getNote()"/>
							
							<s:if test="pruefungsleistungen.get(1).getErgaenzungspruefung() != null">
								(<s:property value="pruefungsleistungen.get(1).getErgaenzungspruefung().getNote()"/>)
							</s:if>
						</s:if>
					</td>
					<td>
						<!-- 3. Versuch -->
						<s:if test="pruefungsleistungen.size >= 3">
							<s:property value="pruefungsleistungen.get(2).getNote()"/>
							
							<s:if test="pruefungsleistungen.get(2).getErgaenzungspruefung() != null">
								(<s:property value="pruefungsleistungen.get(2).getErgaenzungspruefung().getNote()"/>)
							</s:if>
						</s:if>
					</td>
					<td>
						<s:if test="pruefungsleistungen.size >= 1">
							<s:property value="pruefungsleistungen.get(pruefungsleistungen.size - 1).getEndNote()"/>
						</s:if>
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
			<s:submit key="btnEditPruefungsleistung" action="editPruefungsleistung" cssClass="edit" />
		</div>
		<div class="button">
			<s:submit key="btnBack" action="pruefungslist" cssClass="btnBack" />
		</div>
		<div class="clear"></div>
	</div>

</s:form>