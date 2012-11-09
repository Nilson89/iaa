<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm und Niels Maseberg --%>

<h2><s:text name="txtHeadingPruefungsleistungsanlage" /> "<s:property value="%{pruefung.getPruefungsfach().getTitel()}" />"</h2>
<div class="textBox">
	<p><s:text name="txtAnweisungPruefungsleistungsanlageOben" /></p>
</div>
<s:form>
	<s:hidden name="selectedPruefungId" value="%{pruefung.getId()}" />
	<s:hidden name="selectedPruefungsfachId" value="%{pruefung.getPruefungsfach().getId()}" />
	<s:if test="studenten.size != 0">
		<table cellpadding="0">
			<caption><s:text name="txtCaptionPruefungsleistungsanlage" /> "<s:property value="%{pruefung.getPruefungsfach().getTitel()}" />"</caption>
			<thead>
				<tr>
					<th><s:text name="txtMatrikelnummer" /></th>
					<th><s:text name="txtName" /></th>
					<th><s:text name="txtVorname" /></th>
					<th><s:text name="txtVersuch" /></th>
					<th><s:text name="txtNote" /></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="studenten" status="rowstatus">
					<s:hidden name="pruefungsleistungenList(%{pruefungsleistungen.get(pruefungsleistungen.size - 1).getId()}).pruefungsleistungId" value="%{pruefungsleistungen.get(pruefungsleistungen.size - 1).getId()}" />
					<s:if test="#rowstatus.odd == true">
						<tr class="odd">
					</s:if>
					<s:else>
						<tr class="even">
					</s:else>
						<td><s:property value="matrikelnummer"/></td>
						<td><s:property value="person.getName()"/>
						<td><s:property value="person.getVorname()"/></td>
						<td>
							<s:if test="pruefungsleistungen.size != 0">
								<s:property value="%{pruefungsleistungen.get(pruefungsleistungen.size - 1).getVersuch() + 1}"/>
							</s:if>
							<s:else>
								1
							</s:else>	
						</td>
						<td><s:select name="pruefungsleistungenList(%{pruefungsleistungen.get(pruefungsleistungen.size - 1).getId()}).note" list="%{@de.nordakademie.hausarbeit.model.Note@values()}"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	<div class="textBox">
		<p><s:text name="txtAnweisungPruefungsleistungsanlageUnten" /></p>
		<p><s:text name="txtNoteFuenfDescription"/></p>
		<p><s:text name="txtNoteSechsDescription"/></p>
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit key="btnCreatePruefungsleistung" action="savePruefungsleistung" cssClass="save" />
			<s:submit key="btnCancel" action="pruefungslist" cssClass="cancel"  />
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
