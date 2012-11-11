<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%-- Sabrina Schramm und Niels Maseberg --%>

<h2><s:text name="txtHeadingMdlPruefungsleistungsanlage" /> "<s:property value="%{pruefung.getPruefungsfach().getTitel()}" />"</h2>
<div class="textBox">
	<p><s:text name="txtAnweisungMdlPruefungsleistungsanlage" /></p>
</div>

<s:form>
	<s:hidden name="selectedPruefungId" value="%{pruefung.getId()}" />
	<s:hidden name="selectedPruefungsfachId" value="%{pruefung.getPruefungsfach().getId()}" />
	
	<s:if test="studenten.size != 0">
		<table cellpadding="0">
			<caption><s:text name="txtCaptionMdlPruefungsleistungsanlage" /></caption>
			<thead>
				<tr>
					<th><s:text name="txtName" /></th>
					<th><s:text name="txtVorname" /></th>
					<th><s:text name="txtMatrikelnummer" /></th>
					<th><s:text name="txtVersuch" /></th>
					<th><s:text name="txtAktuelleNote" /></th>
					<th><s:text name="txtPruefungsdatum" /></th>
					<th><s:text name="txtNote" /></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="studenten" status="rowstatus">
					<s:hidden name="ergaenzungspruefungenList(%{pruefungsleistungen.get(pruefungsleistungen.size - 1).getId()}).pruefungsleistungId" value="%{pruefungsleistungen.get(pruefungsleistungen.size - 1).getId()}" />
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
							<sj:datepicker id="datum" name="ergaenzungspruefungenList(%{pruefungsleistungen.get(pruefungsleistungen.size - 1).getId()}).datum"  value="%{new java.util.Date()}" timepicker="false" displayFormat="dd.mm.yy" readonly="true" />
						</td>
						<td>
							<s:select name="ergaenzungspruefungenList(%{pruefungsleistungen.get(pruefungsleistungen.size - 1).getId()}).note" list="%{@de.nordakademie.hausarbeit.model.Note@values()}"/>
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
				<s:submit key="btnCancel" action="pruefungslist" cssClass="cancel" />
			</div>
			<div class="button">
				<s:submit key="btnSave" action="createMdlPruefungsleistungenSave" cssClass="save" />
			</div>
			<div class="clear"></div>
		</div>
	</s:if>
	<s:else>
		<div class="buttons">
			<div class="button">
				<s:submit key="btnBack" action="pruefungslist" cssClass="btnBack" />
			</div>
			<div class="clear"></div>
		</div>
	</s:else>
</s:form>