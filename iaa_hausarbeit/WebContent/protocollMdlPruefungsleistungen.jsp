<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm und Niels Maseberg --%>

<h2><s:text name="txtHeadingProtocollMdlPruefungsleistungsanlage" /> "<s:property value="%{pruefung.getPruefungsfach().getTitel()}" />"</h2>
<s:form>
	<s:hidden name="selectedPruefungId" value="%{pruefung.getId()}" />
	<s:hidden name="selectedPruefungsfachId" value="%{pruefung.getPruefungsfach().getId()}" />
	
	<table cellpadding="0">
		<caption><s:text name="txtCaptionProtocollMdlPruefungsleistungsanlage" /></caption>
		<thead>
			<tr>
				<th><s:text name="txtLabelMdlPLName" /></th>
				<th><s:text name="txtLabelMdlPLVorname" /></th>
				<th><s:text name="txtLabelMdlPLMatrikelnummer" /></th>
				<th><s:text name="txtLabelMdlPLVersuch" /></th>
				<th><s:text name="txtLabelMdlPLNote" /></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="newPruefungsleistungenList" status="rowstatus">
				<s:if test="#rowstatus.odd == true">
					<tr class="odd">
				</s:if>
				<s:else>
					<tr class="even">
				</s:else>
					<td><s:property value="student.getPerson().getName()"/></td>
					<td><s:property value="student.getPerson().getVorname()"/></td>
					<td><s:property value="student.getMatrikelnummer()"/></td>
					<td><s:property value="versuch" /></td>
					<td><s:property value="ergaenzungspruefung.getNote()" /></td>
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
			<s:submit key="btnBackToPruefungslist" action="pruefungslist" cssClass="btnBack" />
		</div>
		<div class="clear"></div>
	</div>
	
</s:form>