<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm--%>

<h2><s:text name="txtHeadingProtocollPruefungsleistungsanlage" /> "<s:property value="%{pruefung.getPruefungsfach().getTitel()}" />"</h2>
<s:form>
	<s:hidden name="selectedPruefungId" value="%{pruefung.getId()}" />
	<s:hidden name="selectedPruefungsfachId" value="%{pruefung.getPruefungsfach().getId()}" />
	<div class="textBox">
		<p><s:text name="txtPruefungsfach"></s:text>: <s:property value="%{pruefung.getPruefungsfach().getTitel()}" /></p>
		<p><s:text name="txtPruefungsdatum"></s:text>: <s:property value="%{pruefung.getDatum()}" /></p>
		<p><s:text name="txtDozent"></s:text>: <s:property value="%{pruefung.getDozent().getPerson().getFullName()}" /></p>
		<p><s:text name="txtErfassungsdatum"></s:text>: <s:property value="%{newPruefungsleistungenList.get(newPruefungsleistungenList.size() - 1).getErgaenzungspruefung().getErfassungsdatum()}" /></p>
		<p><s:text name="txtErfasser"></s:text>: <s:property value="%{newPruefungsleistungenList.get(newPruefungsleistungenList.size() - 1).getErfasser().getPerson().getFullName()}" /></p>		
	</div>
	<table cellpadding="0">
		<caption><s:text name="txtCaptionProtocollMdlPruefungsleistungsanlage" /></caption>
		<thead>
			<tr>
				<th><s:text name="txtMatrikelnummer" /></th>
				<th><s:text name="txtName" /></th>
				<th><s:text name="txtVorname" /></th>
				<th><s:text name="txtVersuch" /></th>
				<th><s:text name="txtDatum" /></th>
				<th><s:text name="txtNote" /></th>
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
					<td><s:property value="matrikelnummer"/></td>
					<td><s:property value="person.getName()"/>
					<td><s:property value="person.getVorname()"/></td>
					<td><s:property value="pruefungsleistungen.size"/></td>
					<td><s:property value="pruefungsleistung.getNote()" /></td>
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
		<div class="button">
			<s:a href="javascript:window.print();" cssClass="print">
				<s:text name="btnPrint" />
			</s:a>
		</div>
		<div class="clear"></div>
	</div>
</s:form>