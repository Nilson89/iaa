<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Niels Maseberg --%>

<h2>Übersicht Noten</h2>
<s:form>
	<div class="form">
		<div class="field">
			<span class="label">Manipel:</span>
			<s:select label="Manipel" headerKey="none" headerValue="Bitte wählen..." list="manipelList" listKey="pk" listValue="pk" name="selectedManipel" value="selectedManipel"/>
			<div class="clear"></div>
		</div>
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit value="Noten anzeigen" action="notenuebersichtDetail" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>

<s:if test="noten.size != 0">
	<table>
		<caption>Liste aller aktuellen Noten eines Manipel</caption>
		<thead>
			<tr>
				<th>Matrikelnummer</th>
				<th>Name</th>
				<th>Vorname</th>
				<th>Prüfungsfach</th>
				<th>Versuch</th>
				<th>Aktuelle Note</th>
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
						<s:property value="note" />
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</s:if>
<s:else>
	<div class="errorMessage">
		<s:text name="txtNoNotenFound" />
	</div>
</s:else>

