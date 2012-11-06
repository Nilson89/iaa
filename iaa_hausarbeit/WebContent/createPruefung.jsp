<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- Sabrina Schramm --%>

<h2><s:text name="txtHeadingPruefungsanlage" /> "<s:property value="pruefungsfach.getTitel()" />"</h2>
<div class="textBox">
	<p><s:text name="txtAnweisungPruefungsanlage" /></p>
</div>
<s:form>
	<s:hidden name="selectedPruefungsfachId" value="%{selectedPruefungsfachId}" />
	<div class="form">
		<div class="field">
			<span class="label"><s:text name="txtLabelDatum" /></span>
			<s:textfield name="pruefung.datum" label="Pruefungsdatum"/>
			<div class="clear"></div>
		</div>
		<div class="field">
			<span class="label"><s:text name="txtLabelDozent" /></span>
			
			<s:select label="Dozent" headerKey="none" headerValue="Bitte wählen..." list="dozentenList" listKey="id" listValue="person.getFullName()" 
				name="selectedDozent" value="selectedDozent"/>
			<div class="clear"></div>
		</div>	
	</div>
	<div class="buttons">
		<div class="button">
			<s:submit key="btnCreatePruefung" action="savePruefung" cssClass="save" />
			<s:submit key="btnAbbrechen" action="pruefungslist" cssClass="cancel" />
		</div>
		<div class="clear"></div>
	</div>
</s:form>