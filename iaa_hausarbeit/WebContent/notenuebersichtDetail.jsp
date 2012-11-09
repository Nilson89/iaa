<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Niels Maseberg, Sabrina Schramm --%>

<h2><s:text name="txtHeadingNotenUebersicht" /></h2>
<s:form>
	<div class="form">
		<div class="field">
			<span class="label"><s:text name="txtManipel" />:</span>
			<s:select label="Manipel" headerKey="none" headerValue="Bitte wählen..." list="manipelList" listKey="pk" listValue="pk" name="selectedManipel" value="selectedManipel"/>
			<div class="clear"></div>
		</div>
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit key="btnNotenAnzeigen" action="notenuebersichtDetail" cssClass="listTable" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>

<s:if test="noten.size != 0">
	<table>
		<caption><s:text name="txtCaptionNotenUebersicht" /></caption>
		<thead>
			<tr>
				<th><s:text name="txtMatrikelnummer" /></th>
				<th><s:text name="txtName" /></th>
				<th><s:text name="txtVorname" /></th>
				<th><s:text name="txtPruefungsfach" /></th>
				<th><s:text name="txtVersuch" /></th>
				<th><s:text name="txtAktuelleNote" /></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="noten" status="rowstatus">
				<s:if test="#rowstatus.odd == true">
					<tr class="odd">
				</s:if>
				<s:else>
					<tr class="even">
				</s:else>
					<td><s:property value="student.getMatrikelnummer()"/></td>
					<td><s:property value="student.getPerson().getName()"/></td>
					<td><s:property value="student.getPerson().getVorname()"/></td>
					<td><s:property value="pruefung.getPruefungsfach().getTitel()"/></td>
					<td><s:property value="versuch"/></td>
					<td>
						<s:property value="getEndNote()" />
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
		<s:text name="txtNoNotenFound" />
	</div>
</s:else>

